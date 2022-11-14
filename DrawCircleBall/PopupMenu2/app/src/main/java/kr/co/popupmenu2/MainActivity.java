package kr.co.popupmenu2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View button) {
        PopupMenu popupMenu = new PopupMenu(this,button);
        popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(getApplicationContext(),"클릭된 팝업 메뉴: "+menuItem.getTitle(),Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        popupMenu.show();
    }
}