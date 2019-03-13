package com.cyclepathy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Events extends DrawerActivity {

    Button addEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     addEvent = (Button) findViewById(R.id.addEventButton);
     addEvent.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View view){
             startActivity(new Intent(getApplicationContext(),AddEvent.class));
         }
     });

    }


}
