package com.example.administrator.adpromotion.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.ui.FirstActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/18.
 */

public class FirsrAdapter extends RecyclerView.Adapter<FirsrAdapter.ViewHolder> {


    private final FirstBean firstbean;
    private final FirstActivity context;


    public FirsrAdapter(FirstActivity firstActivity, FirstBean firstBean) {
        this.firstbean = firstBean;
        this.context = firstActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_userinfo_list, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(firstbean.getBody().get(position).getUsername());
            holder.textView3.setText(firstbean.getBody().get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return firstbean.getBody().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView5)
        ImageView imageView5;
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.textView3)
        TextView textView3;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
