package kr.co.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Objects;

// ViewPager와 데이터를 연결하는 어댑터 클래스
public class MyPageAdapter extends PagerAdapter {

    Context context;
    int[] images;
    LayoutInflater layoutInflater;

    public MyPageAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // 전체 페이지 수를 반환
    @Override
    public int getCount() {
        return images.length;
    }

    // 특정 페이지 뷰가 특정 키 객체와 연관되는지 여부 체크하는 메서드
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    // 항목을 표시하는 이미지 뷰를 생성하여 반환함
    // position에 해당하는 페이지 뷰를 생성하여 반환함
    // 페이지 식별을 위한 Object 객체를 반환함
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item, container,false);
        ImageView imageView = itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        //컨테이너(뷰그룹)에 뷰를 추가함. 컨테이너는 Null 이 되면 안됨
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
