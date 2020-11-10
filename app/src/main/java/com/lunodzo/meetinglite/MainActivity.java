package com.lunodzo.meetinglite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cardClicked(View view) {
        if (view.getId() == R.id.searchDate) {
            Intent searchIntent = new Intent(getApplicationContext(), MeetingList.class);
            startActivity(searchIntent);
        } else if (view.getId() == R.id.setMeeting) {
            Intent setIntent = new Intent(getApplicationContext(), SetMeeting.class);
            startActivity(setIntent);
        } else if (view.getId() == R.id.viewAll) {
            Intent meetingIntent = new Intent(getApplicationContext(), MeetingList.class);
            startActivity(meetingIntent);
        }
    }
}