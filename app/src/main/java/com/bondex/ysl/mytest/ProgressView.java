package com.bondex.ysl.mytest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * date: 2018/11/9
 * Author: ysl
 * description:
 */
public class ProgressView extends View {


    /**
     * 进度条最大值，默认为100
     */
    private int maxValue = 100;

    private  Paint firstPaint;
    private Paint secondPaint;
    private Paint textPaint;

    private float textSize = 60;
    private float circleWidth = 10;
    float currentValue = 70;
    float alphaAngle = 0;


    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context,attrs);
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context,attrs);
    }


    private void init(Context context,AttributeSet attrs){

        firstPaint =  new Paint();
        secondPaint = new Paint();
        textPaint = new Paint();

        int smallCircleColor = 0;
        int bigCircleColor = 0;
        int textColor = 0;

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs,R.styleable.ProgressView,0,0);

        int n =ta.getIndexCount();

        for (int i = 0; i < n; ++i){

            int attr = ta.getIndex(i);
            switch (attr){

                case R.styleable.ProgressView_smallCircleColor:

                    smallCircleColor = ta.getColor(attr,Color.WHITE);
                    break;
                case R.styleable.ProgressView_bigCircleColor:

                    bigCircleColor = ta.getColor(attr,getResources().getColor(R.color.colorPrimary));
                    break;
                case R.styleable.ProgressView_textColor:

                    textColor = ta.getColor(attr,getResources().getColor(R.color.colorPrimary));
                    break;

                case R.styleable.ProgressView_circleWidth:

                    circleWidth =  ta.getFloat(attr,10);
                    break;
                case R.styleable.ProgressView_textSize:

                    textSize = ta.getFloat(attr,60);
                    break;
            }


        }




        firstPaint.setColor(smallCircleColor);
        secondPaint.setColor(bigCircleColor);
        textPaint.setColor(textColor);

        textPaint.setTextSize(textSize);
        textPaint.setTextAlign(Paint.Align.CENTER);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int center = this.getWidth()/2;
        int radius = center - (int)(circleWidth/2);

        drawCircle(canvas,center,radius);
        drawText(canvas,center, (int) currentValue);
    }


    private void drawCircle(Canvas canvas,int center,int radius){


        RectF rectF = new RectF(center-radius,center-radius,center+radius,center+radius);
        alphaAngle = currentValue * 360.0f / maxValue * 1.0f;
        canvas.drawArc(rectF,-90,alphaAngle,false,secondPaint);

        canvas.drawCircle(center,center,radius-circleWidth,firstPaint);
    }


    private void drawText(Canvas canvas,int center,int currentValue){

        Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();

        int baseline = center + (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom; // 计算文字的基线,方法见http://blog.csdn.net/harvic880925/article/details/50423762

        canvas.drawText(currentValue+"%",center,baseline,textPaint);
    }


}
