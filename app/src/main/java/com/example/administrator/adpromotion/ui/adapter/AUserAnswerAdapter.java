package com.example.administrator.adpromotion.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.model.SUserAnswerBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/23.
 */

public class AUserAnswerAdapter extends RecyclerView.Adapter<AUserAnswerAdapter.ViewHolder> {

    private final SUserAnswerBean sUserAnswerBean;


    public AUserAnswerAdapter(SUserAnswerBean sUserAnswerBean) {
        this.sUserAnswerBean = sUserAnswerBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_layout_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvContent.setText(sUserAnswerBean.getBody().get(position).getContent());
        holder.tvCreatTime.setText(sUserAnswerBean.getBody().get(position).getCreate_time());
    }

    @Override
    public int getItemCount() {
        if (sUserAnswerBean.getBody() != null) {
            return sUserAnswerBean.getBody().size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ans_img)
        ImageView ansImg;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_creat_time)
        TextView tvCreatTime;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
