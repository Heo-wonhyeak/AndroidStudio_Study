package kr.co.datetimeapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    RadioButton rdoDate, rdoTime;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView ymd,TVHour,TVMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        rdoDate = findViewById(R.id.rdoDate);
        rdoTime = findViewById(R.id.rdoTime);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        ymd = findViewById(R.id.ymd);
        TVHour = findViewById(R.id.TVHour);
        TVMinute = findViewById(R.id.TVMinute);

        chronometer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                rdoDate.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);

                return false;
            }
        });

        rdoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        ymd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ymd.setText(datePicker.getYear()+"년"+(datePicker.getMonth()+1)+"월"+datePicker.getDayOfMonth());
                TVHour.setText("  "+timePicker.getCurrentHour()+"시  ");
                TVMinute.setText(timePicker.getCurrentMinute()+"분 예약됨");

                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                rdoDate.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);



                return false;
            }
        });

    }
}