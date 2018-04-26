package com.example.administrator.adpromotion.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.adpromotion.R;
import com.example.administrator.adpromotion.component.GlobalField;
import com.example.administrator.adpromotion.model.EContent;
import com.example.administrator.adpromotion.widget.MyCheckBox;
import com.example.administrator.adpromotion.widget.MyRadioButton;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextEditorActivity extends Activity {

    @BindView(R.id.mcb_font_option_border)
    MyCheckBox cbFontBold;
    @BindView(R.id.mcb_font_option_inter)
    MyCheckBox cbFontInter;
    @BindView(R.id.mcb_font_option_line)
    MyCheckBox cbFontLine;
    @BindView(R.id.ll_txteditor_style_area)
    LinearLayout llFontBoldArea;
    @BindView(R.id.mrb_font_option_add)
    MyRadioButton mrbFontOptionAdd;
    @BindView(R.id.mrb_font_option_normal)
    MyRadioButton mrbFontOptionNormal;
    @BindView(R.id.mrb_font_option_sub)
    MyRadioButton mrbFontOptionSub;
    @BindView(R.id.rg_font_option_a)
    RadioGroup rgFontSize;
    @BindView(R.id.ll_font_option_a)
    LinearLayout llFontSizeArea;
    @BindView(R.id.mrb_font_option_left)
    MyRadioButton mrbFontOptionLeft;
    @BindView(R.id.mrb_font_option_center)
    MyRadioButton mrbFontOptionCenter;
    @BindView(R.id.mrb_font_option_right)
    MyRadioButton mrbFontOptionRight;
    @BindView(R.id.rg_font_option_center)
    RadioGroup rgFontAlign;
    @BindView(R.id.ll_font_option_center)
    LinearLayout llFontAlignArea;
    @BindView(R.id.mrb_font_option_black)
    MyRadioButton mrbFontOptionBlack;
    @BindView(R.id.mrb_font_option_gray)
    MyRadioButton mrbFontOptionGray;
    @BindView(R.id.mrb_font_option_white)
    MyRadioButton mrbFontOptionWhite;
    @BindView(R.id.mrb_font_option_blackgray)
    MyRadioButton mrbFontOptionBlackgray;
    @BindView(R.id.mrb_font_option_blue)
    MyRadioButton mrbFontOptionBlue;
    @BindView(R.id.mrb_font_option_green)
    MyRadioButton mrbFontOptionGreen;
    @BindView(R.id.mrb_font_option_red)
    MyRadioButton mrbFontOptionRed;
    @BindView(R.id.mrb_font_option_violet)
    MyRadioButton mrbFontOptionViolet;
    @BindView(R.id.mrb_font_option_yellow)
    MyRadioButton mrbFontOptionYellow;
    @BindView(R.id.rg_font_option_color)
    RadioGroup rgFontColor;
    @BindView(R.id.ll_font_option_color)
    LinearLayout llFontColorArea;
    @BindView(R.id.tv_txteditor_addlinked)
    TextView tvAddLinked;
    @BindView(R.id.iv_font_option_b)
    MyRadioButton rbFontBold;
    @BindView(R.id.iv_font_option_a)
    MyRadioButton rbFontSize;
    @BindView(R.id.iv_font_option_center)
    MyRadioButton rbFontAlign;
    @BindView(R.id.iv_font_option_color)
    MyRadioButton rbFontColor;
    @BindView(R.id.rg_font_option_b)
    RadioGroup rgFontBold;
    @BindView(R.id.ll_font_option_area)
    LinearLayout llFontControl;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.et_txteditor_content)
    EditText etContent;
    @BindView(R.id.activity_txteditor)
    RelativeLayout activityTxteditor;
    private static final int REQUEST_CODE_EDIT_TXT = 1005;//编辑文本

    private boolean isBold;//是否选中了加粗
    private boolean isInter;//是否选中了斜体
    private EContent eContent;
    private String style = "";
    private String content = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txteditor);
        ButterKnife.bind(this);
        //把activity作为Dialog从底部弹出
        showDialog2Activity();
        setListener();
        eContent = (EContent) getIntent().getSerializableExtra("eContent");
        echoStyle();
    }
    /**
     * 确定按钮
     *
     * @param view
     */
    public void onSubmit(View view) {
        getData();
        Intent data = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("eContent", eContent);
        data.putExtras(bundle);
        this.setResult(REQUEST_CODE_EDIT_TXT, data);
        this.finish();
    }
    private void setListener() {
        rbFontSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llFontSizeArea.setVisibility(View.VISIBLE);
                llFontBoldArea.setVisibility(View.GONE);
                llFontAlignArea.setVisibility(View.GONE);
                llFontColorArea.setVisibility(View.GONE);
            }
        });
        rbFontBold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llFontSizeArea.setVisibility(View.GONE);
                llFontBoldArea.setVisibility(View.VISIBLE);
                llFontAlignArea.setVisibility(View.GONE);
                llFontColorArea.setVisibility(View.GONE);
            }
        });
        rbFontAlign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llFontSizeArea.setVisibility(View.GONE);
                llFontBoldArea.setVisibility(View.GONE);
                llFontAlignArea.setVisibility(View.VISIBLE);
                llFontColorArea.setVisibility(View.GONE);
            }
        });
        rbFontColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llFontSizeArea.setVisibility(View.GONE);
                llFontBoldArea.setVisibility(View.GONE);
                llFontAlignArea.setVisibility(View.GONE);
                llFontColorArea.setVisibility(View.VISIBLE);
            }
        });
        llFontControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rgFontBold.clearCheck();
                llFontSizeArea.setVisibility(View.GONE);
                llFontBoldArea.setVisibility(View.GONE);
                llFontAlignArea.setVisibility(View.GONE);
                llFontColorArea.setVisibility(View.GONE);
            }
        });
//
        setTextSizeListener();
        setTextAlginListener();
        setTextStyleListener();
        setTextColorListener();
    }
    /**
     * 设置字体颜色选择监听
     */
    private void setTextColorListener() {
        findViewById(R.id.mrb_font_option_black).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_BLACK);
            }
        });
        findViewById(R.id.mrb_font_option_gray).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_GRAY);
            }
        });
        findViewById(R.id.mrb_font_option_blackgray).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_BLACKGRAY);
            }
        });
        findViewById(R.id.mrb_font_option_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_BLUE);
            }
        });
        findViewById(R.id.mrb_font_option_green).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_GREEN);
            }
        });
        findViewById(R.id.mrb_font_option_yellow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_YELLOW);
            }
        });
        findViewById(R.id.mrb_font_option_violet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_VOILET);
            }
        });
        findViewById(R.id.mrb_font_option_white).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_WHITE);
            }
        });
        findViewById(R.id.mrb_font_option_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etContent.setTextColor(GlobalField.FontColor.COLOR_RED);
            }
        });
    }

    /**
     * 设置字体对齐监听
     */
    private void setTextAlginListener() {
        findViewById(R.id.mrb_font_option_left).setOnClickListener(new View.OnClickListener() {//居左显示
            @Override
            public void onClick(View v) {
                etContent.setGravity(Gravity.START);
            }
        });
        findViewById(R.id.mrb_font_option_center).setOnClickListener(new View.OnClickListener() {//居中显示
            @Override
            public void onClick(View v) {
                etContent.setGravity(Gravity.CENTER_HORIZONTAL);
            }
        });
        findViewById(R.id.mrb_font_option_right).setOnClickListener(new View.OnClickListener() {//居右显示
            @Override
            public void onClick(View v) {
                etContent.setGravity(Gravity.RIGHT);
            }
        });
    }

    /**
     * 设置字体加粗、斜线、下划线监听
     */
    private void setTextStyleListener() {
        findViewById(R.id.mcb_font_option_border).setOnClickListener(new View.OnClickListener() {//加粗
            @Override
            public void onClick(View v) {
                isBold = !isBold;
                if (((MyCheckBox) v).isChecked()) {
                    if (isInter) {
                        etContent.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                    } else {
                        etContent.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                } else {
                    if (isInter) {
                        etContent.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                    } else {
                        etContent.setTypeface(Typeface.DEFAULT);
                    }
                }
            }
        });
        findViewById(R.id.mcb_font_option_inter).setOnClickListener(new View.OnClickListener() {//斜体
            @Override
            public void onClick(View v) {
                isInter = !isInter;
                if (((MyCheckBox) v).isChecked()) {
                    if (isBold) {
                        etContent.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                    } else {
                        etContent.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                    }
                } else {
                    if (isBold) {
                        etContent.setTypeface(Typeface.DEFAULT_BOLD);
                    } else {
                        etContent.setTypeface(Typeface.DEFAULT);
                    }
                }
            }
        });
        findViewById(R.id.mcb_font_option_line).setOnClickListener(new View.OnClickListener() {//下划线
            @Override
            public void onClick(View v) {
                if (((MyCheckBox) v).isChecked()) {
                    etContent.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                } else {
                    etContent.getPaint().setFlags(0);
//                    etContent.setTypeface(Typeface.DEFAULT);
                }
                etContent.setText(etContent.getText().toString());
                etContent.setSelection(etContent.getText().toString().length());
            }
        });
    }

    /**
     * 设置字体大小的监听
     */
    private void setTextSizeListener() {
        findViewById(R.id.mrb_font_option_add).setOnClickListener(new View.OnClickListener() {//字体增大
            @Override
            public void onClick(View v) {
                if (((MyRadioButton) v).isChecked()) {
                    etContent.setTextSize(GlobalField.FontSize.SIZE_18);
                } else {
                    etContent.setTextSize(GlobalField.FontSize.SIZE_16);
                }
            }
        });
        findViewById(R.id.mrb_font_option_normal).setOnClickListener(new View.OnClickListener() {//正常字体
            @Override
            public void onClick(View v) {
                etContent.setTextSize(GlobalField.FontSize.SIZE_16);
            }
        });
        findViewById(R.id.mrb_font_option_sub).setOnClickListener(new View.OnClickListener() {//小号字体
            @Override
            public void onClick(View v) {
                if (((MyRadioButton) v).isChecked()) {
                    etContent.setTextSize(GlobalField.FontSize.SIZE_14);
                } else {
                    etContent.setTextSize(GlobalField.FontSize.SIZE_16);
                }
            }
        });
    }

    /**
     * 回显样式
     */
    private void echoStyle() {
//        if (!TextUtils.isEmpty(eContent.getContent())) {
//            String content = eContent.getContent();
//            if (content.contains("<br/><a href=")) {//回显需要去掉链接
//                content = content.substring(0, content.indexOf("<br/><a href="));
//            }
//            etContent.setText(content);
//            etContent.setSelection(content.length());
//        }
        if (!TextUtils.isEmpty(eContent.getStyle())) {
            String style = eContent.getStyle();
            setFontBold(style);//回显字体加粗方式
            setFontAlign(style);//回显字体对齐方式
            setFontSize(style);//回显字体大小
            setFontColor(style);//回显字体颜色
        }


    }
    /**
     * 回显字体加粗方式
     *
     * @param style
     */
    private void setFontBold(String style) {
        if (style.contains(GlobalField.FontBold.KEY_STYLE_BOLD) && style.contains(GlobalField.FontBold.KEY_STYLE_ITALIC)) {//加粗和斜体
            etContent.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
            cbFontBold.setChecked(true);
            cbFontInter.setChecked(true);
            isBold = true;
            isInter = true;
        } else if (style.contains(GlobalField.FontBold.KEY_STYLE_BOLD)) {//只用加粗
            isBold = true;
            etContent.setTypeface(Typeface.DEFAULT_BOLD);
            cbFontBold.setChecked(true);
        } else if (style.contains(GlobalField.FontBold.KEY_STYLE_ITALIC)) {//只用斜体
            isInter = true;
            cbFontInter.setChecked(true);
            etContent.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        }

        if (style.contains(GlobalField.FontBold.KEY_STYLE_UNDERLINE)) {
            cbFontLine.setChecked(true);
            etContent.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        }
    }

    /**
     * 回显字体对齐方式
     *
     * @param style
     */
    private void setFontAlign(String style) {
        if (style.contains(GlobalField.FontAlign.KEY_ALIGN_CENTER)) {
            etContent.setGravity(Gravity.CENTER_HORIZONTAL);
            rgFontAlign.check(R.id.mrb_font_option_center);
        } else if (style.contains(GlobalField.FontAlign.KEY_ALIGN_RIGHT)) {
            etContent.setGravity(Gravity.RIGHT);
            rgFontAlign.check(R.id.mrb_font_option_right);
        } else {
            rgFontAlign.check(R.id.mrb_font_option_left);
            etContent.setGravity(Gravity.LEFT);
        }
    }

    /**
     * 回显字体大小
     *
     * @param style
     */
    private void setFontSize(String style) {
        if (style.contains(GlobalField.FontSize.KEY_SIZE_18)) {
            etContent.setTextSize(GlobalField.FontSize.SIZE_18);
            rgFontSize.check(R.id.mrb_font_option_add);
        } else if (style.contains(GlobalField.FontSize.KEY_SIZE_14)) {
            etContent.setTextSize(GlobalField.FontSize.SIZE_14);
            rgFontSize.check(R.id.mrb_font_option_sub);
        } else {
            etContent.setTextSize(GlobalField.FontSize.SIZE_16);
            rgFontSize.check(R.id.mrb_font_option_normal);
        }
    }

    /**
     * 回显字体颜色
     *
     * @param style
     */
    private void setFontColor(String style) {
        if (style.contains(GlobalField.FontColor.KEY_COLOR_GRAY)) {//灰色
            etContent.setTextColor(GlobalField.FontColor.COLOR_GRAY);
            rgFontColor.check(R.id.mrb_font_option_gray);
        } else if (style.contains(GlobalField.FontColor.KEY_COLOR_BLACKGRAY)) {//深蓝色
            etContent.setTextColor(GlobalField.FontColor.COLOR_BLACKGRAY);
            rgFontColor.check(R.id.mrb_font_option_blackgray);
        } else if (style.contains(GlobalField.FontColor.KEY_COLOR_WHITE)) {//白色
            etContent.setTextColor(GlobalField.FontColor.COLOR_WHITE);
            rgFontColor.check(R.id.mrb_font_option_white);
        } else if (style.contains(GlobalField.FontColor.KEY_COLOR_BLUE)) {//蓝色
            etContent.setTextColor(GlobalField.FontColor.COLOR_BLUE);
            rgFontColor.check(R.id.mrb_font_option_blue);
        } else if (style.contains(GlobalField.FontColor.KEY_COLOR_GREEN)) {//绿色
            etContent.setTextColor(GlobalField.FontColor.COLOR_GREEN);
            rgFontColor.check(R.id.mrb_font_option_green);
        } else if (style.contains(GlobalField.FontColor.KEY_COLOR_YELLOW)) {//黄色
            etContent.setTextColor(GlobalField.FontColor.COLOR_YELLOW);
            rgFontColor.check(R.id.mrb_font_option_yellow);
        } else if (style.contains(GlobalField.FontColor.KEY_COLOR_VOILET)) {//紫色
            etContent.setTextColor(GlobalField.FontColor.COLOR_VOILET);
            rgFontColor.check(R.id.mrb_font_option_violet);
        } else if (style.contains(GlobalField.FontColor.KEY_COLOR_RED)) {//红色
            etContent.setTextColor(GlobalField.FontColor.COLOR_RED);
            rgFontColor.check(R.id.mrb_font_option_red);
        } else {
            etContent.setTextColor(GlobalField.FontColor.COLOR_BLACK);
            rgFontColor.check(R.id.mrb_font_option_black);//黑色
        }
    }

    /**
     * 获取数据
     */
    private void getData() {
        style = "";
        content = etContent.getText().toString().trim();
        Logger.e("getData: " + content);
//        if (linkContent != null && !TextUtils.isEmpty(linkContent.getLink())) {
//            content = content + "<br/><a href=\"" + linkContent.getLink() + "\">" + linkContent.getTitle() + "</a><br/>";
//        }

        int checkedId = rgFontSize.getCheckedRadioButtonId();
        if (checkedId == R.id.mrb_font_option_add) {
            style += GlobalField.FontSize.KEY_SIZE_18;
        } else if (checkedId == R.id.mrb_font_option_normal) {
            style += GlobalField.FontSize.KEY_SIZE_16;
        } else if (checkedId == R.id.mrb_font_option_sub) {
            style += GlobalField.FontSize.KEY_SIZE_14;
        }
        int checkedIdCetner = rgFontAlign.getCheckedRadioButtonId();
        if (checkedIdCetner == R.id.mrb_font_option_center) {
            style += GlobalField.FontAlign.KEY_ALIGN_CENTER;
        } else if (checkedIdCetner == R.id.mrb_font_option_right) {
            style += GlobalField.FontAlign.KEY_ALIGN_RIGHT;
        } else if (checkedIdCetner == R.id.mrb_font_option_left) {
            style += GlobalField.FontAlign.KEY_ALIGN_LEFT;
        }
        if (cbFontBold.isChecked()) {
            style += GlobalField.FontBold.KEY_STYLE_BOLD;//加粗
        }
        if (cbFontInter.isChecked()) {
            style += GlobalField.FontBold.KEY_STYLE_ITALIC;//斜体
        }
        if (cbFontLine.isChecked()) {
            style += GlobalField.FontBold.KEY_STYLE_UNDERLINE;//下划线
        }
        int checkedIdColor = rgFontColor.getCheckedRadioButtonId();
        if (checkedIdColor == R.id.mrb_font_option_black) {
            style += GlobalField.FontColor.KEY_COLOR_BLACK;
        } else if (checkedIdColor == R.id.mrb_font_option_gray) {
            style += GlobalField.FontColor.KEY_COLOR_GRAY;
        } else if (checkedIdColor == R.id.mrb_font_option_blackgray) {
            style += GlobalField.FontColor.KEY_COLOR_BLACKGRAY;
        } else if (checkedIdColor == R.id.mrb_font_option_blue) {
            style += GlobalField.FontColor.KEY_COLOR_BLUE;
        } else if (checkedIdColor == R.id.mrb_font_option_green) {
            style += GlobalField.FontColor.KEY_COLOR_GREEN;
        } else if (checkedIdColor == R.id.mrb_font_option_yellow) {
            style += GlobalField.FontColor.KEY_COLOR_YELLOW;
        } else if (checkedIdColor == R.id.mrb_font_option_violet) {
            style += GlobalField.FontColor.KEY_COLOR_VOILET;
        } else if (checkedIdColor == R.id.mrb_font_option_white) {
            style += GlobalField.FontColor.KEY_COLOR_WHITE;
        } else if (checkedIdColor == R.id.mrb_font_option_red) {
            style += GlobalField.FontColor.KEY_COLOR_RED;
        }
        Logger.e("getData: " + content + "\n" + style);
        eContent.setContent(content);
        eContent.setStyle(style);
    }
    private void showDialog2Activity() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        getWindow().setLayout(width,
                height / 2);

        getWindow().setBackgroundDrawable(new ColorDrawable(0xFFFFFF));
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setWindowAnimations(R.style.mystyle);
    }
}
