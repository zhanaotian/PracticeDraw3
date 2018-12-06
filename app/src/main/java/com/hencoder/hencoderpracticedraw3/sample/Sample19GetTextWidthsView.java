package com.hencoder.hencoderpracticedraw3.sample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * getTextWidths(String text, float[] widths)
 * 获取字符串中每个字符的宽度，并把结果填入参数 widths。
 * 这相当于 measureText() 的一个快捷方法，它的计算等价于对字符串中的每个字符分别调用  measureText() ，并把它们的计算结果分别填入 widths 的不同元素。
 */
public class Sample19GetTextWidthsView extends View {
  private static final String TAG = "Sample19getTextWidthsView";
  private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private String mText = "阿萨德开了个店；了sk乌asdasdad尔拉升adasdasdadasdasdasdasdas等级分类";
  float[] widths = new float[mText.length()];

  public Sample19GetTextWidthsView(Context context) {
    super(context);
  }

  public Sample19GetTextWidthsView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample19GetTextWidthsView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setTextSize(60);
  }

  @SuppressLint("LongLogTag") @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    float width = 0;
    paint.getTextWidths(mText, widths);
    for (int i = 0; i < mText.length(); i++) {
      width += widths[i];
    }
    canvas.drawText(mText, 0, 200, paint);
    if (width > getWidth()) {
      canvas.drawText(mText, 0, 200 + paint.getFontSpacing(), paint);
    }
  }
}
