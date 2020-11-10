package com.lunodzo.meetinglite;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MeetingList extends AppCompatActivity {
    ListView meetList;
    String[] meetingNames = {"Meeting One", "Meeting Two", "Meeting Three", "Meeting Four", "Meeting Five"};
    String[] dateMeet = {"2020-04-11", "2020-04-11", "2020-04-11", "2020-04-11", "2020-04-11"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_list);
        meetList = findViewById(R.id.meetingList);

        ArrayAdapter adapterView = new ArrayAdapter<String>(this, R.layout.layout_list_data, meetingNames);
        meetList.setAdapter(adapterView);
    }
}