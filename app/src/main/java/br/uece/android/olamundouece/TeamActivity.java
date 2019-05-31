package br.uece.android.olamundouece;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TeamActivity extends AppCompatActivity {

    String[] teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        teamList = getResources().getStringArray(R.array.team_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, teamList);

        ListView listview = (ListView) findViewById(R.id.ListViewTeam);

        listview.setAdapter(adapter);

    }
}
