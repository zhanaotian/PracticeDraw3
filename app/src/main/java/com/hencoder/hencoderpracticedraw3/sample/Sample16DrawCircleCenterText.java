package com.hencoder.hencoderpracticedraw3.sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw3.Utils;

/**
 * 绘制圆环，并将文字居中
 */
public class Sample16DrawCircleCenterText extends View {
  private String mText = "aBgd";
  private static final float RING_WIDTH = Utils.dp2px(20);
  private static final float RADIUS = Utils.dp2px(100);
  private static final int CIRCLE_COLOR = Color.parseColor("#90A4AE");
  private static final int HIGHLIGHT_COLOR = Color.parseColor("#FF4081");
  private static final int baseLineX = 0;
  private Rect mRect = new Rect();
  Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

  public Sample16DrawCircleCenterText(Context context) {
    super(context);
  }

  public Sample16DrawCircleCenterText(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample16DrawCircleCenterText(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    //设置类型
    mPaint.setStyle(Paint.Style.STROKE);
    //设置线宽
    mPaint.setStrokeWidth(RING_WIDTH);
    //设置颜色
    mPaint.setColor(CIRCLE_COLOR);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //绘制环
    canvas.drawCircle(getWidth() / 2, getHeight() / 2, RADIUS, mPaint);
    //设置颜色
    mPaint.setColor(HIGHLIGHT_COLOR);
    //设置线条形状
    mPaint.setStrokeCap(Paint.Cap.ROUND);
    //绘制进度条
    canvas.drawArc(
        getWidth() / 2 - RADIUS,
        getHeight() / 2 - RADIUS,
        getWidth() / 2 + RADIUS,
        getHeight() / 2 + RADIUS,
        -90, 225,
        false, mPaint);
    ////设置文字大小
    //mTextPaint.setTextSize(Utils.dp2px(50));
    ////设置文字居中
    //mTextPaint.setTextAlign(Paint.Align.CENTER);
    ////设置颜色
    //mTextPaint.setColor(HIGHLIGHT_COLOR);
    ////获取文字的显示范围
    //mTextPaint.getTextBounds(mText, 0, mText.length(), mRect);
    ////缺点：做动画时，文字会上下跳动；适用于固定内容。
    ////获取偏移
    //int offsetY = (mRect.top + mRect.bottom) / 2;
    ////绘制文字
    //canvas.drawText(mText, getWidth() / 2, getHeight() / 2 - offsetY, mTextPaint);
    //获取Paint 的 FontMetrics
    //Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
    //int baseLineY = getHeight() / 2;
    ///**
    // * top线Y坐标 = baseline线的y坐标 + fontMetric.top；
    // * ascent线Y坐标 = baseline线的y坐标 + fontMetric.ascent；
    // * descent线Y坐标 = baseline线的y坐标 + fontMetric.descent；
    // * bottom线Y坐标 = baseline线的y坐标 + fontMetric.bottom；
    // */
    //float top = baseLineY + fontMetrics.top;
    //float ascent = baseLineY + fontMetrics.ascent;
    //float descent = baseLineY + fontMetrics.descent;
    //float bottom = baseLineY + fontMetrics.bottom;
    ////缺点：当内容固定时，文字看起来可能没有居中，比如：aaaaaa；当内容变化时，文字不会跳动。
    ////获取偏移
    //float offsetY = (fontMetrics.ascent + fontMetrics.descent) / 2;
    ////绘制文字
    //canvas.drawText(mText, getWidth() / 2, getHeight() / 2 - offsetY, mTextPaint);
    ////设置线宽
    //mPaint.setStrokeWidth(Utils.dp2px(1));
    ////设置颜色
    //mPaint.setColor(Color.RED);
    ////绘制 baseline 线
    //canvas.drawLine(0, baseLineY, getWidth(), baseLineY, mPaint);
    ////设置颜色
    //mPaint.setColor(Color.BLUE);
    ////绘制 top 线
    //canvas.drawLine(0, top, getWidth(), top, mPaint);
    ////设置颜色
    //mPaint.setColor(Color.GREEN);
    ////绘制 ascent 线
    //canvas.drawLine(0, ascent, getWidth(), ascent, mPaint);
    ////设置颜色
    //mPaint.setColor(Color.YELLOW);
    ////绘制 descent 线
    //canvas.drawLine(0, descent, getWidth(), descent, mPaint);
    ////设置颜色
    //mPaint.setColor(Color.BLACK);
    ////绘制 bottom 线
    //canvas.drawLine(0, bottom, getWidth(), bottom, mPaint);
    //文字靠左边(当文字上下行之间出现巨大的大小差异时，就会出现问题)
    //先绘制大字
    mTextPaint.setTextAlign(Paint.Align.LEFT);
    mTextPaint.setTextSize(Utils.dp2px(50));
    mTextPaint.getTextBounds(mText, 0, mText.length(), mRect);
    canvas.drawText(mText, -mRect.left, 200, mTextPaint);
    //然后绘制小字
    mTextPaint.setTextSize(Utils.dp2px(5));
    canvas.drawText(mText, 0, 200 + mTextPaint.getFontSpacing(), mTextPaint);
  }
}
