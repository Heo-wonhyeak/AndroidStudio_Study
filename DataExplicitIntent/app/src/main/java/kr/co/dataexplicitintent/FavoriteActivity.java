package kr.co.dataexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        setTitle("가장 좋아하는 명화는?");

        Intent intent = getIntent();

        String[] imageNames = intent.getStringArrayExtra("ImageName");
        int[] voteCounts = intent.getIntArrayExtra("VoteCount");
        ImageView imageView = findViewById(R.id.FavoriteIMG);

        Integer[] drawable = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,
                    R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};

        int favorite = 0;
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

    }
}