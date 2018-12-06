package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw3.Utils;

/**
 * setLetterSpacing(float letterSpacing)
 * 设置字符间距。默认值是 0。
 */
public class Sample22GetLetterSpacingView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  String text = "Hello HenCoder";

  public Sample22GetLetterSpacingView(Context context) {
    super(context);
  }

  public Sample22GetLetterSpacingView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample22GetLetterSpacingView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setTextSize(Utils.dp2px(15));
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawText(text, 0, 200, paint);
    paint.setLetterSpacing(2f);
    canvas.drawText(text, 0, 200 + paint.getFontSpacing(), paint);
  }
}
