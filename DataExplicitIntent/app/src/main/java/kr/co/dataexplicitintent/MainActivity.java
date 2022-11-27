package kr.co.dataexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("Intent 데이터 전달");

        // 그림을 클릭할때 마다 투표수 증가
        final int[] voteCount = new int[9];
        for(int i=0; i<9; i++) {
            voteCount[i] =0;
        }

        //이미지 뷰 위젯을 저장할 9개짜리 배열 선언
        ImageView[] imageViews = new ImageView[9];

        // 이미지뷰 위젯의 id를 저장할 배열 선언
        Integer[] imageId = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9};

        //그림의 이름을 저장할 9개짜리 배열 선언
        final String[] imageName ={"독서하는 소녀","꽃장식 소녀","부채를 든 소녀","옆모습 소녀","지친 소녀","테라스의 두 소녀","피아노 치는 소녀"
                                    ,"피아노치는 소녀들","의자에 앉은 소녀"};

        /*
             각 이미지 뷰에대한 클릭 이벤트 리스너 생성
             이미지를 클릭하면 각 이미지의 투표수가 증가하도록 설정
             해당 이미지 이름과 누적된 투표수를 토스트 메시지로 보여줌
         */

        for(int i=0; i<imageId.length; i++) {
            final int index;
            index = i;

            imageViews[index] = findViewById(imageId[index]);
            imageViews[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imageName[index]+" 투표수 : "+voteCount[index]
                            , Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnFinish = findViewById(R.id.btnResult);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);

                intent.putExtra("ImageName",imageName);
                intent.putExtra("VoteCount",voteCount);

                startActivity(intent);
            }
        });

    }
}