package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw3.Utils;

/**
 * getRunAdvance(CharSequence text, int start, int end, int contextStart, int contextEnd, boolean  isRtl, int offset)
 *  对于一段文字，计算出某个字符处光标的 x 坐标
 *  start end 是文字的起始和结束坐标；
 *  contextStart contextEnd 是上下文的起始和结束坐标；
 *  isRtl 是文字的方向；
 *  offset 是字数的偏移，即计算第几个字符处的光标。
 */
public class Sample21GetRunAdvanceView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  String text = "Hello HenCoder";
  private static final int offsetX = 100;
  private static final int offsetY = 200;

  public Sample21GetRunAdvanceView(Context context) {
    super(context);
  }

  public Sample21GetRunAdvanceView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample21GetRunAdvanceView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setTextSize(Utils.dp2px(15));
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    int length = text.length();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      //获取光标的x坐标
      float advance = paint.getRunAdvance(text, 0, length, 0, length, false, length - 1);
      canvas.drawText(text, offsetX, offsetY, paint);
      canvas.drawLine(offsetX + advance, offsetY - 50, offsetX + advance, offsetY + 10, paint);
    }
  }
}
