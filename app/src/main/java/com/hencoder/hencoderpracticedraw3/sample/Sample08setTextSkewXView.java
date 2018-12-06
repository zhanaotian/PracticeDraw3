package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * setTextSkewX(float skewX)
 * 设置文字横向错切角度。其实就是文字倾斜度的啦。
 */
public class Sample08SetTextSkewXView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  String text = "Hello HenCoder";

  public Sample08SetTextSkewXView(Context context) {
    super(context);
  }

  public Sample08SetTextSkewXView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample08SetTextSkewXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setTextSize(60);

    paint.setTextSkewX(-0.5f);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawText(text, 50, 100, paint);
  }
}
