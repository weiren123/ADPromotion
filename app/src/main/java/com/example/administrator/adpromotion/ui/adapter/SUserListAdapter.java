package com.example.administrator.adpromotion.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.model.SUserListBean;
import com.example.administrator.adpromotion.ui.comment.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/21.
 */

public class SUserListAdapter extends RecyclerView.Adapter<SUserListAdapter.ViewHolder> {

    private final SUserListBean sUserListBean;

    private OnItemClickListener mOnItemClickListener;//声明接口

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
    public SUserListAdapter(SUserListBean sUserListBean) {
        this.sUserListBean = sUserListBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_userinfo_list, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.textView10.setText(sUserListBean.getBody().get(position).getTitle());

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return sUserListBean.getBody().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView2)
        ImageView imageView2;
        @BindView(R.id.textView4)
        TextView textView4;
        @BindView(R.id.textView7)
        TextView textView7;
        @BindView(R.id.textView9)
        TextView textView9;
        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;
        @BindView(R.id.textView10)
        TextView textView10;
        @BindView(R.id.imageView5)
        ImageView imageView5;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
