package kr.co.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //탭호스트 변수 생성
        TabHost tabHost = getTabHost();

        //탭 스펙 생성
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("TAG1").setIndicator("강아지");
        // 탭 스펙에 내용을 연결함 - 강아지
        tabSpec1.setContent(R.id.imageView1);
        //탭을 탭호스트에 부착
        tabHost.addTab(tabSpec1);

        //탭 스펙 생성
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("고양이");
        // 탭 스펙에 내용을 연결함
        tabSpec2.setContent(R.id.imageView2);
        //탭을 탭호스트에 부착
        tabHost.addTab(tabSpec2);

        //탭 스펙 생성
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("TAG3").setIndicator("토끼");
        // 탭 스펙에 내용을 연결함
        tabSpec3.setContent(R.id.imageView3);
        //탭을 탭호스트에 부착
        tabHost.addTab(tabSpec3);

        //탭 스펙 생성
        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("TAG4").setIndicator("말");
        // 탭 스펙에 내용을 연결함 - 강아지
        tabSpec4.setContent(R.id.imageView4);
        //탭을 탭호스트에 부착
        tabHost.addTab(tabSpec4);

        tabHost.setCurrentTab(0);
    }
}