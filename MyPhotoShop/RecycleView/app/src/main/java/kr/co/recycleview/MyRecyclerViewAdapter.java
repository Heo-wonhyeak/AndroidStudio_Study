package kr.co.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    MyRecyclerViewAdapter(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //view를 생성하고
        // 이것을 넣은 viewHolder 객체를 생성하여 반환함
        View view = mInflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    // ViewHolder 에 새로운 데이터 바인딩 함
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myTextView.setText(mData[position]);
    }

    //전체 갯수 반환
    @Override
    public int getItemCount() {
        return mData.length;
    }

    public String getItem(int id) {
        return mData[id];
    }

    //항목 뷰를 저장하는 클래스임
    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // 항목 뷰 안의 텍스트 뷰
            myTextView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mClickListener != null) {
                mClickListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}
