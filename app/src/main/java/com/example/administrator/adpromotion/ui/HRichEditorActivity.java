package com.example.administrator.adpromotion.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.ui.adapter.RichEditorAdapter;

import java.util.ArrayList;

public class HRichEditorActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Object> datas;
    private RichEditorAdapter adapter;
    private TextView tvArtTitle;
    private ImageView ivArtBGImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hrich_editor);
        initView();
    }
    /**
     * 初始化视图
     */
    private void initView() {
        /**
         * 初始化RecyclerView
         */
        RecyclerView rvItemList = (RecyclerView) findViewById(R.id.rv_itemlist);

        linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {//禁止滑动
                return false;
            }
        };
        rvItemList.setLayoutManager(linearLayoutManager);

        rvItemList.setItemAnimator(new DefaultItemAnimator());
        datas = new ArrayList<>();

//        rvItemList.setHasFixedSize(true);//最重要的这句，不然recycleview不显示
        adapter = new RichEditorAdapter(this, datas);
        rvItemList.setAdapter(adapter);

//        adapter.setOnDownUpChangeListener(new RichEditorAdapter.OnDownUpChangeListener() {
//            @Override
//            public void onDown(final View view, int postion) {
//                swapDown(postion);
//            }
//
//            @Override
//            public void onUp(View view, int postion) {
//                swapUp(postion);
//            }
//
//            @Override
//            public void onDrop(View view, int postion) {
//                dropItem(postion);
//            }
//        });
//        adapter.setOnChoiseVideoListener(new RichEditorAdapter.OnChoiseVideoListener() {
//            @Override
//            public void onStart() {
//                getVideo();
//            }
//        });
//        adapter.setOnItemClickListener(new RichEditorAdapter.OnItemClickListener() {
//            @Override
//            public void onClick(String itemType, int index) {
//                EContent eContent = new EContent();
//                switch (itemType) {
//                    case ItemType.IMG:
//                        eContent.setType(ItemType.IMG);
//                        break;
//                    case ItemType.VIDEO:
//                        eContent.setType(ItemType.VIDEO);
//                        break;
//                    case ItemType.TXT:
//                        eContent.setType(ItemType.TXT);
//                        break;
//                }
//                datas.add(index, eContent);
//                adapter.notifyDataSetChanged();
//            }
//        });

        //创建SimpleItemTouchHelperCallback
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter, rvItemList);
//        //用Callback构造ItemtouchHelper
//        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
//        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
//        touchHelper.attachToRecyclerView(rvItemList);

        /**
         * 初始化文章标题
         */
        tvArtTitle = (TextView) findViewById(R.id.tv_richeditor_title);
        /**
         * 初始化封面图片
         */
        ivArtBGImg = (ImageView) findViewById(R.id.iv_richeditor_bg);
    }
}
