package com.apham.multi_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    int currentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer happySound = MediaPlayer.create(this, R.raw.cheering);
        Button playHappySound = (Button) this.findViewById(R.id.play_happy);
        playHappySound.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                happySound.start();
            }
        });

        final MediaPlayer sadSound = MediaPlayer.create(this, R.raw.crying);
        Button playSadSound = (Button) this.findViewById(R.id.play_sad);
        playSadSound.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                sadSound.start();
            }
        });


        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l){

                if(currentItem==position){
                    return;
                }
                else if(position==1){
                    Intent intent= new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent= new Intent(MainActivity.this, Email_Tabs.class);
                    startActivity(intent);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(R.layout.spinner_item);
        mySpinner.setAdapter(myAdapter);

    }
}
