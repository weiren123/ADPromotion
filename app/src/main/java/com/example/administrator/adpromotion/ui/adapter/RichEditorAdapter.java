package com.example.administrator.adpromotion.ui.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.widget.BottomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/25.
 */

public class RichEditorAdapter extends RecyclerView.Adapter<RichEditorAdapter.ViewHolder> {


    private final Activity context;
    private final ArrayList<Object> datas;
    private Dialog dialog;

    public RichEditorAdapter(Activity context, ArrayList<Object> datas) {
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
        if(position == 0){
            holder.ivItemUp.setVisibility(View.GONE);
        }else if(position == datas.size() - 1){
            holder.ivItemDown.setVisibility(View.GONE);
        }

        holder.tvItemDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTxtEditorPage(position);
            }
        });
    }

    private void toTxtEditorPage(int position) {
        dialog = new BottomDialog(context);
        dialog.setContentView(R.layout.activity_txteditor);
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        dialog.getWindow().setLayout(width,
                height );
        dialog.show();
//        final EditText edContent = (EditText)dialog.findViewById(R.id.ed_content);
    }

    @Override
    public int getItemCount() {
        return 1;
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
