package kr.co.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] title = {"한산(2022)" ,"비상선언(2021)","탑건(1994)","미니언즈2(2014)","헤어질결심(2019)","외계+인(2022)",
            "엘비스(1999)","풀타임(2001)","어거스트러쉬(2004)","비긴어게인(2009)"};

    Integer[] images = {
            R.drawable.movie1,
            R.drawable.movie6,
            R.drawable.movie4,
            R.drawable.movie2,
            R.drawable.movie7,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5,
            R.drawable.movie3,
            R.drawable.movie2,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomList adapter = new CustomList(MainActivity.this);
        listView = findViewById(R.id.List);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getBaseContext(),title[+position],Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context) {
            super(context, R.layout.listitem, title);
            this.context = context;
        }


        // 반환하는 뷰를 사용하여 항목을 표시함
        @Override
        public View getView(int position, @Nullable View convertView,ViewGroup parent) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            View rowImage = layoutInflater.inflate(R.layout.listitem,null,true);
            ImageView imageView = rowImage.findViewById(R.id.image);
            TextView title1 = rowImage.findViewById(R.id.title);
            TextView rating = rowImage.findViewById(R.id.rating);
            TextView genre = rowImage.findViewById(R.id.genre);
            TextView year = rowImage.findViewById(R.id.year);

            title1.setText(title[position]);
            imageView.setImageResource(images[position]);
            rating.setText("4.0"+position);
            genre.setText("Drama");
            year.setText(2000+position+"");


            return rowImage;
        }
    }
}