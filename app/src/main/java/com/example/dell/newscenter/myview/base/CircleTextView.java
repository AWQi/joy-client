package com.example.dell.newscenter.myview.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;


public class CircleTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint mPaint;
    public CircleTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    //xml创建TextCircleView调用这个构造函数
    public CircleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init();
    }
    //new TextCircleView调用这个构造函数
    public CircleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
    /**
     * 初始化画笔
     */
    public void init()
    {
        mPaint = new Paint();
    }
    /**
     * 调用onDraw绘制边框
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        //创建一个RectF，用来限定绘制圆弧的范围
        RectF rectf = new RectF();
        //设置画笔的颜色
        mPaint.setColor(Color.BLACK);
        //设置画笔的样式，空心
        mPaint.setStyle(Paint.Style.STROKE);
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置画得一个半径，然后比较长和宽，以最大的值来确定长方形的长宽，确定半径
        int r = getMeasuredWidth() > getMeasuredHeight() ? getMeasuredWidth() : getMeasuredHeight();
        //如果设置的padding不一样绘制出来的是椭圆形。绘制的时候考虑padding
        //Log.i("边界", "宽度"+getMeasuredWidth()+"高度"+getMeasuredHeight()+"getPaddingLeft()"+getPaddingLeft()+"getPaddingTop"+getPaddingTop()+"getPaddingRight(): "+getPaddingRight()+"getPaddingBottom()"+getPaddingBottom());
        //当padding都为0的时候，绘制出来的就是RectF限定的区域就是一个正方形
        rectf.set(getPaddingLeft(),getPaddingTop(),r-getPaddingRight(),r-getPaddingBottom());
        //绘制圆弧
        canvas.drawArc(rectf,0,360,false,mPaint);
    }
}