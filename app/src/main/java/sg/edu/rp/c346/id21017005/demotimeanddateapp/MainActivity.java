package sg.edu.rp.c346.id21017005.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    // (i) declare the variables
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (ii) Bind the variables to their respective UI elements
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate =  findViewById(R.id.disDate);
        btnDisplayTime = findViewById(R.id.disTime);
        tvDisplay = findViewById(R.id.textView2);
        btnReset = findViewById(R.id.btnReset);

        // (iii) Select what happens when you click on the buttons
        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();
                String timeMsg = "Time is "+ hour +" : "+ minute;
                tp.setIs24HourView(true);
                tvDisplay.setText(timeMsg);
                Log.d("timeMsg", timeMsg);

            }

        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                int day = dp.getDayOfMonth();
                int month = dp.getMonth()+1;
                int year = dp.getYear();
                String dateMsg = "Date is "+day+" / "+month+" / "+year;
                tvDisplay.setText(dateMsg);
                Log.d("dateMsg", dateMsg);
                tvDisplay.setText("Date is " + day + " / " + month + " / " + year);

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                dp.updateDate(2020,0,1);
                tp.setCurrentMinute(00);
                tp.setCurrentHour(00);
            }
        });



    }
}