package com.example.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Note> notes;
    CustomAdapterNotes custom_Adapter;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.ListView);
        helper = new DatabaseHelper(this);
        notes = helper.getNotes();
        notes = new ArrayList<>();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);

                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        notes = helper.getNotes();
        custom_Adapter = new CustomAdapterNotes(this, notes);
        lv.setAdapter(custom_Adapter);

    }
}
