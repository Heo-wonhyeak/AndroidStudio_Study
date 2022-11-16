package kr.co.customdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_sub extends AppCompatActivity implements View.OnClickListener{

    EditText userName,password;
    Button login,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClick(View view) {
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);

        View view1 = View.inflate(MainActivity_sub.this,R.layout.customer_dialog,null);

        AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity_sub.this);

        dig.setTitle("로그인창");
        dig.setView(view1);

        dig.show();

        login = findViewById(R.id.login);
        cancel = findViewById(R.id.cancel);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().equals("")) {
                    Toast.makeText(MainActivity_sub.this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if(password.getText().equals("")) {
                    Toast.makeText(MainActivity_sub.this, "비밀번호를입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}