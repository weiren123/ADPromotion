package com.example.administrator.adpromotion.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.component.ImagesLoader;
import com.example.administrator.adpromotion.model.FirstBean;
import com.example.administrator.adpromotion.model.api.Apis;
import com.example.administrator.adpromotion.ui.FirstActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/18.
 */

public class FirsrAdapter extends RecyclerView.Adapter<FirsrAdapter.ViewHolder> {


    private final FirstBean firstbean;
    private final FirstActivity context;

    private OnItemClickListener mOnItemClickListener;//声明接口

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

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
    public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.textView4.setText(firstbean.getBody().get(position).getUsername());
            holder.textView7.setText(firstbean.getBody().get(position).getAge());
        String avatar = firstbean.getBody().get(position).getAvatar();
        String headerimg = Apis.HOST+"static/image/"+avatar+".jpg";
        ImagesLoader.loadRoundImg(context, headerimg,holder.imageView2);

//        Bitmap bg = BitmapFactory.decodeResource(context.getResources(),R.mipmap.login_bg);
//        int size = Math.min(bg.getWidth(), bg.getHeight());
//        ByteArrayOutputStream dataByte = new ByteArrayOutputStream();
//        bg.compress(Bitmap.CompressFormat.JPEG, 100, dataByte);
//        BitmapFactory.Options opts = new BitmapFactory.Options();
//        opts.inSampleSize = size;
//        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
//        holder.imageView5.setImageBitmap(bg);
//        Bitmap result = BitmapFactory.decodeByteArray(dataByte.toByteArray(),0, dataByte.size(), opts);
//        holder.imageView5.setImageBitmap(result);

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
        return firstbean.getBody().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView2)
        ImageView imageView2;
        @BindView(R.id.textView4)
        TextView textView4;
        @BindView(R.id.textView7)
        TextView textView7;
        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;
        @BindView(R.id.textView9)
        TextView textView9;
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
