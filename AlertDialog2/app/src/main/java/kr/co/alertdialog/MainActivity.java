package kr.co.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvName,tvEmail;
    Button button;
    EditText dlgEdtName,dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("다이어로그");

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = View.inflate(MainActivity.this,R.layout.dialog,null);
                //대화상자 생성 (빌더 객체 생성)
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                //용도에 따른 설정
                //제목 설정
                dig.setTitle("사용자 정보 입력");
                //아이콘 설정
                dig.setIcon(R.drawable.ic_menu_allfriends);
                dig.setView(dialogView);

                dlgEdtEmail = dialogView.findViewById(R.id.dlgEdit2);
                dlgEdtName = dialogView.findViewById(R.id.dlgEdit1);

                dlgEdtName.setText(tvName.getText().toString());
                dlgEdtEmail.setText(tvEmail.getText().toString());

                //대화상자의 ok버튼 설정
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText());
                    }
                });
                //대화상자의 cancle 버튼 설정
                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);

                        //토스트가 화면의 임의 위치에 나타내기
                        Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                        int xOffset = (int)(Math.random()*display.getWidth());
                        int yOffset = (int)(Math.random()*display.getHeight());

                        toast.setGravity(Gravity.TOP | Gravity.LEFT , xOffset,yOffset);

                        toastView = View.inflate(MainActivity.this,R.layout.toast,null);

                        toastText = toastView.findViewById(R.id.toastText);
                        toastText.setText("취소했습니다");

                        toast.setView(toastView);
                        toast.show();
                    }
                });

                // 다이어 로그 보여주기
                dig.show();
            }
        });

    }
}