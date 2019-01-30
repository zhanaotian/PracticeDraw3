package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw3.Utils;

/**
 * FontMetircs getFontMetrics()
 * 获取 Paint 的 FontMetrics。
 */
public class Sample14GetFontMetricsView extends View {
  private Paint.FontMetrics fontMetrics;
  Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
  Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
  String[] texts = { "A", "a", "J", "j", "Â", "â" };
  float yOffset;

  public Sample14GetFontMetricsView(Context context) {
    super(context);
  }

  public Sample14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample14GetFontMetricsView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint1.setStyle(Paint.Style.STROKE);
    paint1.setStrokeWidth(20);
    paint1.setColor(Color.parseColor("#E91E63"));
    paint2.setTextSize(160);
    fontMetrics = paint2.getFontMetrics();
    yOffset = -(fontMetrics.ascent + fontMetrics.descent) / 2 + 200;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    /**
     * top线Y坐标 = baseline线的y坐标 + fontMetric.top；
     * ascent线Y坐标 = baseline线的y坐标 + fontMetric.ascent；
     * descent线Y坐标 = baseline线的y坐标 + fontMetric.descent；
     * bottom线Y坐标 = baseline线的y坐标 + fontMetric.bottom；
     */
    float top = yOffset + fontMetrics.top;
    float ascent = yOffset + fontMetrics.ascent;
    float descent = yOffset + fontMetrics.descent;
    float bottom = yOffset + fontMetrics.bottom;
    //设置线宽
    paint2.setStrokeWidth(Utils.dp2px(1));
    //设置颜色
    paint2.setColor(Color.RED);
    //绘制 baseline 线
    canvas.drawLine(0, yOffset, getWidth(), yOffset, paint2);
    //设置颜色
    paint2.setColor(Color.BLUE);
    //绘制 top 线
    canvas.drawLine(0, top, getWidth(), top, paint2);
    //设置颜色
    paint2.setColor(Color.GREEN);
    //绘制 ascent 线
    canvas.drawLine(0, ascent, getWidth(), ascent, paint2);
    //设置颜色
    paint2.setColor(Color.YELLOW);
    //绘制 descent 线
    canvas.drawLine(0, descent, getWidth(), descent, paint2);
    //设置颜色
    paint2.setColor(Color.BLACK);
    //绘制 bottom 线
    canvas.drawLine(0, bottom, getWidth(), bottom, paint2);

    canvas.drawText(texts[0], 100, yOffset, paint2);
    canvas.drawText(texts[1], 200, yOffset, paint2);
    canvas.drawText(texts[2], 300, yOffset, paint2);
    canvas.drawText(texts[3], 400, yOffset, paint2);
    canvas.drawText(texts[4], 500, yOffset, paint2);
    canvas.drawText(texts[5], 600, yOffset, paint2);
  }
}
