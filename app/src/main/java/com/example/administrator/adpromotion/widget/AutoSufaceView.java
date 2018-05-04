package com.example.administrator.adpromotion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2018/5/4.
 */

public class AutoSufaceView extends SurfaceView implements Runnable, SurfaceHolder.Callback {
    private Boolean mIsDrawing;//子线程标志位。
    private Canvas mCanvas; //用于绘图的canvas
    private SurfaceHolder holder;
    private Path mPath;

    public AutoSufaceView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        holder = getHolder();//对SurfaceHolder进行初始化
        holder.addCallback(this);//并注册一个Surfolder的回调方法
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
        mPath = new Path();
    }

    //View创建
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    //View改变
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    //View销毁
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        synchronized (this) {
            mIsDrawing = false;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        while (mIsDrawing) {

            draw();

        }
        long end = System.currentTimeMillis();

        if (end - start < 100) {

            try {
                Thread.sleep(100 - (end - start));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    private void draw() {


        try {
            Paint paint = new Paint();

            mCanvas = holder.lockCanvas(); //获取当前的canvas对象，需要注意的是，我们获取的仍然是上次的canvas对象，如果需要
            //之前的图都将保留，如果需要擦除，可以在绘制之前，调用canvas.color()来执行清屏
            mCanvas.drawColor(Color.WHITE);
            if (mPath != null) {
                mCanvas.drawPath(mPath, paint);
            }
        } catch (Exception e) {

        } finally {
            try{
            holder.unlockCanvasAndPost(mCanvas);//最后要将画布内容提交，要将这个方法放入到final中，保证内容每次都可以提交。
            }catch (Exception e){

            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                break;

            case MotionEvent.ACTION_MOVE:

                mPath.lineTo(event.getX(), event.getY());
                break;
            default:
                break;
        }
        return true;
    }
}
