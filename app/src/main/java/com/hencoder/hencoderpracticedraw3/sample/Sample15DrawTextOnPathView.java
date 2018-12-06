package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 沿着一条 path 来绘制文字
 */
public class Sample15DrawTextOnPathView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Path mPath = new Path();
  String text = "Hello HenCoder";

  public Sample15DrawTextOnPathView(Context context) {
    super(context);
  }

  public Sample15DrawTextOnPathView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample15DrawTextOnPathView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setTextSize(60);
    mPath.addRect(100, 100, 300, 300, Path.Direction.CW);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawPath(mPath, paint);
    canvas.drawTextOnPath(text, mPath, 0, 0, paint);
  }
}
