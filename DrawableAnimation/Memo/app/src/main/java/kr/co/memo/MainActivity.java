package kr.co.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    String FILENAME ="";
    EditText filename, memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filename = findViewById(R.id.fileName);
        memo = findViewById(R.id.memo);

        Button btnWrite = findViewById(R.id.write);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FILENAME = filename.getText().toString();
                try {
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(memo.getText().toString().getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnRead = findViewById(R.id.read);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FILENAME = filename.getText().toString();

                FileInputStream fis = null;
                try {
                    fis = openFileInput(FILENAME);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    memo.setText(new String(buffer));
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        Button btnDelete = findViewById(R.id.delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FILENAME = filename.getText().toString();
                deleteFile(FILENAME);
                memo.setText("");
            }
        });
    }
}