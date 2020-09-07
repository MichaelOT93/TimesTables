package com.example.timestables;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView numList;

    public void generateTimesTable (int timesTableNumber){

        ArrayList<String> numbers = new ArrayList<String>();

        for (int j = 1; j <= 10; j++){
            numbers.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);

        numList.setAdapter(arrayAdapter);

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar numberBar = (SeekBar) findViewById(R.id.numberBar);
        numList = findViewById(R.id.answerList);

        numberBar.setMax(20);
        numberBar.setProgress(10);

        generateTimesTable(10);





        numberBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTableNumber;

                if(i < min){
                    timesTableNumber = min;
                    numberBar.setProgress(min);
                } else {
                    timesTableNumber = i;
                }


                generateTimesTable(timesTableNumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}