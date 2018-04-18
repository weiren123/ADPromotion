package com.example.administrator.adpromotion.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.ui.FirstActivity;

/**
 * Created by Administrator on 2018/4/18.
 */

public class FirsrAdapter extends RecyclerView.Adapter<FirsrAdapter.ViewHolder> {


    private final FirstBean firstbean;
    private final FirstActivity context;

    public FirsrAdapter(FirstActivity firstActivity, FirstBean firstBean) {
        this.firstbean =firstBean;
        this.context = firstActivity;
    }

    @Override
    public FirsrAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.first_userinfo_list,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FirsrAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return firstbean.getBody().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
