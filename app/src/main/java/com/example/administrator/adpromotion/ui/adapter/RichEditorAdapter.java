package com.example.administrator.adpromotion.ui.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.model.EContent;
import com.example.administrator.adpromotion.ui.TextEditorActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.valuesfeng.picker.Picker;
import io.valuesfeng.picker.engine.GlideEngine;

/**
 * Created by Administrator on 2018/4/25.
 */

public class RichEditorAdapter extends RecyclerView.Adapter<RichEditorAdapter.ViewHolder> {


    private final Activity context;
    private final ArrayList<EContent> datas;
    private Dialog dialog;
    private static final int REQUEST_CODE_EDIT_TXT = 1005;//编辑文本
    private static final int REQUEST_CODE_CHOOSE_ITEM_IMG = 1002;//更改item图片
    private int curClickItemIndex = 0;//当前点击的item
    public RichEditorAdapter(Activity context, ArrayList<EContent> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final EContent eContent = datas.get(position);
        if(position == 0){
            holder.ivItemUp.setVisibility(View.GONE);
        }else if(position == datas.size() - 1){
            holder.ivItemDown.setVisibility(View.GONE);
        }

        //设置内容
        holder.tvItemDesc.setText(TextUtils.isEmpty(eContent.getContent()) ? context.getString(R.string.rich_click_add_txt): eContent.getContent());
        if (TextUtils.isEmpty(eContent.getUrl())) {
            holder.ivItemPic.setImageResource(R.mipmap.img);
        } else {
            Glide.with(context)
                    .load(eContent.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.mipmap.img)
                    .error(R.mipmap.img)
                    .into(holder.ivItemPic);
        }
        holder.tvItemDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curClickItemIndex = position;
                toTxtEditorPage(position);
            }
        });
        //设置图片
        holder.ivItemPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curClickItemIndex = position;
                toChoiseItemPic();
            }
        });

    }
    /**
     * 更换item的图片
     */
    private void toChoiseItemPic() {
        Picker.from(context)
                .count(1)
                .enableCamera(true)
                .setEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE_ITEM_IMG);
    }

    private void toTxtEditorPage(int position) {
        Intent intent = new Intent(context, TextEditorActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("eContent", datas.get(position));
        intent.putExtras(bundle);
        context.startActivityForResult(intent,REQUEST_CODE_EDIT_TXT);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    /**
     * 获取当前单击的item的下标
     *
     * @return
     */
    public int getCurClickItemIndex() {
        return curClickItemIndex;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_additem_add)
        ImageView ivAdditemAdd;
        @BindView(R.id.iv_additem_txt)
        ImageView ivAdditemTxt;
        @BindView(R.id.iv_additem_img)
        ImageView ivAdditemImg;
        @BindView(R.id.iv_additem_video)
        ImageView ivAdditemVideo;
        @BindView(R.id.ll_additem_addarea)
        LinearLayout llAdditemAddarea;
        @BindView(R.id.iv_item_delete)
        ImageView ivItemDelete;
        @BindView(R.id.iv_item_up)
        ImageView ivItemUp;
        @BindView(R.id.iv_item_down)
        ImageView ivItemDown;
        @BindView(R.id.iv_item_pic)
        ImageView ivItemPic;
        @BindView(R.id.tv_item_desc)
        TextView tvItemDesc;
        @BindView(R.id.ll)
        LinearLayout ll;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
