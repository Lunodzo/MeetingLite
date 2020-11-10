package com.lunodzo.meetinglite;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SetMeeting extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    String meetingName;
    String meetingDetails;
    String meetingDateTime;

    int mYear, mMonth, mDay, hour, minute;
    int myYear, myMonth, myDay, myHour, myMinute;

    EditText dateTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_meeting);
        EditText name = findViewById(R.id.meetingName);
        EditText details = findViewById(R.id.meetingDescription);
        dateTime = findViewById(R.id.meetingDateTime);
        Button btnSubmit = findViewById(R.id.meetingSubmit);


        dateTime.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR); // current year
                mMonth = c.get(Calendar.MONTH); // current month
                mDay = c.get(Calendar.DAY_OF_MONTH); // current day

                DatePickerDialog datePickerDialog = new DatePickerDialog(SetMeeting.this, SetMeeting.this, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        btnSubmit.setOnClickListener(v -> {
            meetingName = name.getText().toString();
            meetingDetails = details.getText().toString();
            meetingDateTime = dateTime.getText().toString();
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myYear = year;
        myDay = dayOfMonth;
        myMonth = month;
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(SetMeeting.this, SetMeeting.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        myHour = hourOfDay;
        myMinute = minute;
        dateTime.setText(myYear + "/" +
                +(myMonth + 1) + "/" +
                +myDay + " " +
                +myHour + ":" +
                +myMinute);

//        2020-11-11 01:06:23
    }
}