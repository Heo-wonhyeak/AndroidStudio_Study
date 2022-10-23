package kr.co.datatimeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

/*
    다음과 같이 수정하시오
      1. 예약 시작을 없애고 크로노미터를 클릭하면 동작하게 하시오
      2. 예약 완료 버튼을 없애고 대신 화면 하단의 연도를 길게 클릭시 완료되게 하시오
      3. 캘린더 뷰 대신에 데이트피커를 사용하여 날짜를 설정하시오
      4. 크로노미터 클릭하기 전 라디오버튼, 데이트피커, 타임피커가 안보이게 설정
        -> 클릭시 버튼 나타나게
        -> 완료시 다시 안보이게
 */

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart,btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calendarView;
    TimePicker timePicker;
    TextView hour,minute,ymd;
    int SYear,SMonth,SDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간예약");

        btnStart =findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        chronometer = findViewById(R.id.chronometer);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        calendarView = findViewById(R.id.calenderView);
        timePicker = findViewById(R.id.timePicker);
        hour = findViewById(R.id.TVHour);
        minute = findViewById(R.id.TVMinute);
        ymd = findViewById(R.id.ymd);

        calendarView.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
            }
        });

        //예약 완료시 시간을 가져옴
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                hour.setText("  "+timePicker.getCurrentHour()+"시  ");
                minute.setText(timePicker.getCurrentMinute()+"분 예약됨");
                ymd.setText(SYear+"년"+SMonth+"월"+SDay+"일");


                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                SYear = year;
                SMonth = month;
                SDay = day;
            }
        });
    }
}