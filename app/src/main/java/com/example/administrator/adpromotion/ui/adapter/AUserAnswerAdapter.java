package com.example.administrator.adpromotion.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.model.SUserAnswerBean;

/**
 * Created by Administrator on 2018/4/23.
 */

public class AUserAnswerAdapter extends RecyclerView.Adapter<AUserAnswerAdapter.ViewHolder> {

    private final SUserAnswerBean sUserAnswerBean;

    public AUserAnswerAdapter(SUserAnswerBean sUserAnswerBean) {
        this.sUserAnswerBean =sUserAnswerBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_layout_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(sUserAnswerBean.getBody()!=null){
            return sUserAnswerBean.getBody().size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
