package kr.co.dataexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("데이터 전달 결과");

        Intent intent = getIntent();

        String[] imageNames = intent.getStringArrayExtra("ImageName");
        int[] voteCounts = intent.getIntArrayExtra("VoteCount");

        TextView[] tvs = new TextView[9];
        RatingBar[] rbars = new RatingBar[9];

        Integer[] tvId = {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        Integer[] rbarId = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

        for(int i=0; i< 9; i++) {

            tvs[i] = findViewById(tvId[i]);
            rbars[i] = findViewById(rbarId[i]);
        }

        for(int i=0; i<9; i++) {
            tvs[i].setText(imageNames[i]);
            rbars[i].setRating((float)voteCounts[i]);
        }

        ImageView imageView = findViewById(R.id.FavoriteIMG);

        Integer[] drawable = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,
                R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};

        int favorite = -1;
        String imageName = "";
        for(int i=0; i<imageNames.length; i++) {
            if(favorite < voteCounts[i]) {
                favorite = voteCounts[i];
                imageName = imageNames[i];
                imageView.setImageResource(drawable[i]);
            }
        }


        TextView textView = findViewById(R.id.FavoriteName);
        textView.setText(imageName+" 득표 : "+favorite);


        Button btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}