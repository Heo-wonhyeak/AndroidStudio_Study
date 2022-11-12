package kr.co.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        String[] values = {"apple","watermelon","melon","kiwi","orange","strawberry","pear","banana"
                            ,"yaja","tangerine","cherry","coconut","grape","pineapple","papaya","wartermelon"
                            ,"durian","plum","persimmon","peach","grapefruit"};

        // 어댑터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,values);

        //리스트 뷰에 어댑터 설정
        setListAdapter(adapter);

    }

    //리스트 뷰 클릭시 호출됨
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //각 과일 이름 획득
        String item = (String)getListAdapter().getItem(position);
        Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
    }
}