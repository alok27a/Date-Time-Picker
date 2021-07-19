package com.alok.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView dateView;
    private TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateView = findViewById(R.id.dateView);
        timeView = findViewById(R.id.timeView);
    }

    public void dateClick(View view) {

        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DAY = calendar.get(Calendar.DATE);
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dateString = dayOfMonth + "/" + month + "/" + year;
                dateView.setText(dateString);
            }
        }, YEAR, MONTH, DAY);
        dialog.show();

    }

    public void timeClick(View view) {
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);
        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR, hour);
                calendar1.set(Calendar.MINUTE, minute);
                String dateText = DateFormat.format("h:mm a", calendar1).toString();
                timeView.setText(dateText);
            }
        }, HOUR, MINUTE, is24HourFormat);

        timePickerDialog.show();
    }
}