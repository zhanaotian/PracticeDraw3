package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.Locale;

/**
 * setTextLocale(Locale locale) / setTextLocales(LocaleList locales)
 * 设置绘制所用的 Locale
 */
public class Sample18SetTextLocaleView extends View {
  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private String text = "雨骨底条今直算账";

  public Sample18SetTextLocaleView(Context context) {
    super(context);
  }

  public Sample18SetTextLocaleView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample18SetTextLocaleView(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    paint.setTextSize(60);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //中文
    paint.setTextLocale(Locale.CHINA);
    canvas.drawText(text, 0, 150, paint);
    //繁体中文
    paint.setTextLocale(Locale.TAIWAN);
    canvas.drawText(text, 0, 150 + paint.getFontSpacing(), paint);
    //日语
    paint.setTextLocale(Locale.JAPAN);
    canvas.drawText(text, 0, 150 + paint.getFontSpacing() * 2, paint);
  }
}
