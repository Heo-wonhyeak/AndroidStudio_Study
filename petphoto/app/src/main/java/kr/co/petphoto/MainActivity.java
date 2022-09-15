package kr.co.petphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 전역변수 선언 - 9개 위젯에 대응할 위젯 변수 선언
    TextView text1 , text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rDog,rCat,rRabbit;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 홈화면 Icon 설정
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        // 홈 제목 설정
        setTitle("애완동물 사진 보기 App");

        //위젯을 변수에 대입
        text1 = findViewById(R.id.Text1);
        chkAgree = findViewById(R.id.ChkAgree);
        rGroup1 = findViewById(R.id.Rgroup1);
        rDog = findViewById(R.id.RDog);
        rCat = findViewById(R.id.RCat);
        rRabbit = findViewById(R.id.RRabbit);

        text2 = findViewById(R.id.Text2);
        btnOK = findViewById(R.id.BtnOK);
        imgPet = findViewById(R.id.ImgPet);

        //시작함 체크박스의 체크가 변경되면 ..
        // 체크박스를 체크/언체크할 때 동작하는 리스너 정의
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //체크될 경우 위젯이 보이도록
                if (chkAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                //해제시 위젯이 보이지 않도록
                else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
//                if(rDog.isChecked() == true) {
//                    
//                } else if (rCat.isChecked() == true) {
//                    
//                } else if (rRabbit.isChecked() == true) {
//                    
//                } else {
//                    Toast.makeText(MainActivity.this, "한가지를 선택해주세요", Toast.LENGTH_SHORT).show();
//                }
                
                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RDog:
                        imgPet.setImageResource(R.drawable.dog1);
                        break;
                    case R.id.RCat:
                        imgPet.setImageResource(R.drawable.cat1);
                        break;
                    case R.id.RRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "한가지 선택해주세요", Toast.LENGTH_SHORT).show();


                }
            }
        });







    }
}