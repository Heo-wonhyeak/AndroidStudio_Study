package kr.co.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = new String[200];
        for(int i=0; i<100; i++) {
            data[i] = "ezen #" + (i+1);
        }

        RecyclerView recyclerView = findViewById(R.id.rView);
        int columns = 3;

        //배치관리자를 격자 배치 관리자로 함
        recyclerView.setLayoutManager(new GridLayoutManager(this,columns));
        adapter = new MyRecyclerViewAdapter(this,data);
        adapter.setClickListener(this);
        // 어댑터 연결
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("리사이클러뷰","item: " + adapter.getItem(position));
    }
}