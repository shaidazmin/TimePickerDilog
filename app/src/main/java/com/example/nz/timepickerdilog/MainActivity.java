package com.example.nz.timepickerdilog;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);

        Click click = new Click();
        button.setOnClickListener(click);
    }

    class  Click implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            final TimePicker timePicker = new TimePicker(MainActivity.this);
            final int hour = timePicker.getCurrentHour();
            int min = timePicker.getCurrentMinute();

            timePickerDialog = new TimePickerDialog(MainActivity.this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            Toast.makeText(MainActivity.this,hourOfDay+" : "+minute,Toast.LENGTH_SHORT).show();
                        }
                    },hour,min,true);
            timePickerDialog.show();

        }
    }
}
