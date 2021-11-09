package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.assignment1.model.TeamInterface;
import com.example.assignment1.model.TeamModel;

public class MainActivity3 extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        list = findViewById(R.id.Teamslist);
        fillListDynamicly();


    }
    public  void fillListDynamicly(){
        TeamModel tm = new TeamModel();
        TeamInterface ti = tm.getModel();
        String[] teams = ti.getTeams();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, teams);
        list.setAdapter(adapter);
    }

}