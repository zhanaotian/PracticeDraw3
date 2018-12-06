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
 * getOffsetForAdvance(CharSequence text, int start, int end, int contextStart, int contextEnd,
 * boolean isRtl, float advance)
 * 给出一个位置的像素值，计算出文字中最接近这个位置的字符偏移量（即第几个字符最接近这个坐标）。
 *
 * text 是要测量的文字；
 * start end 是文字的起始和结束坐标；
 * contextStart contextEnd 是上下文的起始和结束坐标；
 * isRtl 是文字方向；advance
 * 是给出的位置的像素值。填入参数，对应的字符偏移量将作为返回值返回。
 */
public class Sample23GetOffsetForAdvanceView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  String text = "Hello HenCoder";
  private static final int offsetX = 100;
  private static final int offsetY = 200;

  public Sample23GetOffsetForAdvanceView(Context context) {
    super(context);
  }

  public Sample23GetOffsetForAdvanceView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample23GetOffsetForAdvanceView(Context context, @Nullable AttributeSet attrs,
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
      int offset = paint.getOffsetForAdvance(text, 0, length, 0, length, false, 30);
      float advance = paint.getRunAdvance(text, 0, length, 0, length, false, offset);
      canvas.drawText(text, offsetX, offsetY, paint);
      canvas.drawLine(offsetX + advance, offsetY - 50, offsetX + advance, offsetY + 10, paint);
    }
  }
}
