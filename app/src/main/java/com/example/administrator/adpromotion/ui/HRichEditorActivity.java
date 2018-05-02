package com.example.administrator.adpromotion.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.base.BaseActivity;
import com.example.administrator.adpromotion.base.contract.HRichContract;
import com.example.administrator.adpromotion.model.EContent;
import com.example.administrator.adpromotion.presenter.HRichPresenter;
import com.example.administrator.adpromotion.ui.adapter.RichEditorAdapter;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.valuesfeng.picker.Picker;
import io.valuesfeng.picker.engine.GlideEngine;
import io.valuesfeng.picker.utils.PicturePickerUtils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class HRichEditorActivity extends BaseActivity<HRichPresenter> implements HRichContract.View {

    @BindView(R.id.tv_public_title)
    TextView tvPublicTitle;
    @BindView(R.id.iv_richeditor_bg)
    ImageView ivRicheditorBg;
    @BindView(R.id.tv_richeditor_title)
    TextView tvRicheditorTitle;
    @BindView(R.id.tv_richeditor_changebg)
    TextView tvRicheditorChangebg;
    @BindView(R.id.rv_itemlist)
    RecyclerView rvItemlist;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_submit)
    ImageView ivSubmit;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<EContent> datas;
    private RichEditorAdapter adapter;
    private TextView tvArtTitle;
    private ImageView ivArtBGImg;
    private EContent eContent;
    private static final int REQUEST_CODE_EDIT_TXT = 1005;//编辑文本
    private static final int REQUEST_CODE_CHOOSE_ITEM_IMG = 1002;//更改item图片
    private static final int REQUEST_CODE_CHOOSE_BG = 1001;//选择背景
    private MultipartBody.Part filePart;
    private List<String> result;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_hrich_editor;
    }

    @Override
    protected void initData() {
        mPresenter.initHRichData();

        setListener();

    }

    private void setListener() {

        ivRicheditorBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picker.from(HRichEditorActivity.this)
                        .count(1)
                        .enableCamera(true)
                        .setEngine(new GlideEngine())
                        .forResult(REQUEST_CODE_CHOOSE_BG);
            }
        });
        tvRicheditorTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ivSubmit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                File file = new File(result.get(0).toString());
                if(!file.exists()){
                    file.mkdir();
                }
                RequestBody requestFile =
                        RequestBody.create(MediaType.parse("multipart/form-data"), file);
                filePart = MultipartBody.Part.createFormData("photo", file.getName(),requestFile);

                mPresenter.uploadImg(filePart);
            }
        });
    }

    @Override
    protected void initInject() {
        getActivityComponten().inject(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_EDIT_TXT && resultCode == REQUEST_CODE_EDIT_TXT) {//编辑文字
            EContent eContent = (EContent) data.getSerializableExtra("eContent");
            datas.get(adapter.getCurClickItemIndex()).setContent(eContent.getContent());
            datas.get(adapter.getCurClickItemIndex()).setStyle(eContent.getStyle());
            adapter.notifyDataSetChanged();
        } else if (requestCode == REQUEST_CODE_CHOOSE_ITEM_IMG && resultCode == RESULT_OK) {//选择item的图片
//            result = PicturePickerUtils.obtainResult(data);
            ContentResolver contentResolver = getContentResolver();
            result = PicturePickerUtils.obtainResult(contentResolver, data);

            Logger.e("Image:"+result.get(0));
            datas.get(adapter.getCurClickItemIndex()).setUrl(PicturePickerUtils.obtainResult(data).get(0).toString());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showHRichList() {
        linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {//禁止滑动
                return false;
            }
        };
        rvItemlist.setLayoutManager(linearLayoutManager);

        rvItemlist.setItemAnimator(new DefaultItemAnimator());
        eContent = new EContent();
        datas = new ArrayList<EContent>();
        datas.add(eContent);
//        rvItemList.setHasFixedSize(true);//最重要的这句，不然recycleview不显示
        adapter = new RichEditorAdapter(this, datas);
        rvItemlist.setAdapter(adapter);
    }
}
