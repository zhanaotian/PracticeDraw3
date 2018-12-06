package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 增加了上下文和RTL支持的drawText 用来绘制用于互相影响的文字（比如：阿拉伯文字）
 */
public class Sample17DrawTextRunView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  char[] text1 = new char[] { 'i', 'l', 'o', 'v', 'e', 'y', 'o', 'u' };

  public Sample17DrawTextRunView(Context context) {
    super(context);
  }

  public Sample17DrawTextRunView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample17DrawTextRunView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setTextSize(60);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      canvas.drawTextRun(text1, 0, text1.length, 0, text1.length, 0f, 200f, false, paint);
    }
  }
}
