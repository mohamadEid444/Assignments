package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment1.model.FootballTeam;
import com.google.gson.Gson;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment1.model.TeamInterface;
import com.example.assignment1.model.TeamModel;


public class MainActivity2 extends AppCompatActivity {
    private Spinner spin;
    private EditText edtNum;
    private EditText edtCountry;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spin = findViewById(R.id.spinner);
        edtNum = findViewById(R.id.edtNum);
        edtCountry = findViewById(R.id.edtCountry);

        populateSpinner();
        runLogo();
    }

    public void runLogo(){
        final ImageView img1 = findViewById(R.id.img1);
        final ImageView img2 = findViewById(R.id.img2);
        final  ImageView img3 = findViewById(R.id.img3);
        final ImageView img4 = findViewById(R.id.img4);
        final EditText tx = findViewById(R.id.edtCountry);

      final Handler handler = new Handler();
       handler.post(new Runnable() {
           @Override
           public void run() {
            //switch between team logos while running the handler
               if(running){

                   img1.setVisibility(View.VISIBLE);
                   img1.setVisibility(View.GONE);
                   img2.setVisibility(View.VISIBLE);
                   img2.setVisibility(View.GONE);
                   img3.setVisibility(View.VISIBLE);
                   img3.setVisibility(View.GONE);
                   img4.setVisibility(View.VISIBLE);
                   img4.setVisibility(View.GONE);


               }

             handler.postDelayed(this,3000);
           }
       });
    }
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

    }
    public void populateSpinner() {
        TeamModel tm = new TeamModel();
        TeamInterface ti = tm.getModel();
        String[] teams = ti.getTeams();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, teams);

        spin.setAdapter(adapter);
    }

    public void btnSaveClick(View view) {
        String spinVal = spin.getSelectedItem().toString();
        String edtNumVal = edtNum.getText().toString();
        String edtCoVal = edtCountry.getText().toString();


        if (!spinVal.equals("") && !edtNumVal.equals("") && !edtCoVal.equals("")){
            FootballTeam team = new FootballTeam(spinVal,edtCoVal,Integer.parseInt(edtNumVal));
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = pref.edit();
            Gson gson = new Gson();
            String teamInfo = gson.toJson(team);
            editor.putString("info",teamInfo);
            editor.commit();
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();


    }

    public void btnStopClick(View view) {
        running=false;
        ImageView img1 = findViewById(R.id.img1);
        img1.setVisibility(View.VISIBLE);
    }

    public void btnStartClick(View view) {
        running = true;
    }
}