package com.example.administrator.adpromotion.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.Window;

import com.example.administrator.adpromotion.R;

/**
 * Created by Administrator on 2018/4/22.
 */

public class BottomDialog extends Dialog {
    public BottomDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0xFFFFFF));
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.mystyle);
    }
}
