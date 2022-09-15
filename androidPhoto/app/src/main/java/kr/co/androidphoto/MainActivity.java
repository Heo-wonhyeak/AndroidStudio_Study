package kr.co.androidphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    Switch switchStart;
    RadioGroup rGroup;
    RadioButton rVer1,rVer2,rVer3;
    ImageView imageView;
    Button btnClose,btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("안드로이드버전확인");

        switchStart = findViewById(R.id.SwitchStart);
        text1 = findViewById(R.id.Text1);
        rGroup = findViewById(R.id.RGroup);
        rVer1 = findViewById(R.id.RVer1);
        rVer2 = findViewById(R.id.RVer2);
        rVer3 = findViewById(R.id.RVer3);
        imageView = findViewById(R.id.ImageView);
        btnClose = findViewById(R.id.BtnClose);
        btnReset = findViewById(R.id.BtnReset);

        switchStart.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    text1.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    text1.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chkId) {

                if(chkId == R.id.RVer1) {
                    imageView.setImageResource(R.drawable.q10);
                } else if(chkId == R.id.RVer2) {
                    imageView.setImageResource(R.drawable.r11);
                } else if(chkId == R.id.RVer3) {
                    imageView.setImageResource(R.drawable.s12);
                }

            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rGroup.clearCheck();
                imageView.setImageResource(0);
            }
        });


    }
}