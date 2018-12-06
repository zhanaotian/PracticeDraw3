package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw3.R;
import com.hencoder.hencoderpracticedraw3.Utils;

/**
 * 图文混排
 */
public class Sample20ImgAndText extends View {
  private static final String TAG = "Sample20ImgAndText";
  //图片的宽度
  private static final float IMAGE_WIDTH = Utils.dp2px(120);
  //图片的高度
  private static final float IMAGE_OFFSET = Utils.dp2px(80);

  Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  Bitmap bitmap;
  Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
  String text =
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean justo sem, sollicitudin in maximus a, vulputate id magna. Nulla non quam a massa sollicitudin commodo fermentum et est. Suspendisse potenti. Praesent dolor dui, dignissim quis tellus tincidunt, porttitor vulputate nisl. Aenean tempus lobortis finibus. Quisque nec nisl laoreet, placerat metus sit amet, consectetur est. Donec nec quam tortor. Aenean aliquet dui in enim venenatis, sed luctus ipsum maximus. Nam feugiat nisi rhoncus lacus facilisis pellentesque nec vitae lorem. Donec et risus eu ligula dapibus lobortis vel vulputate turpis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In porttitor, risus aliquam rutrum finibus, ex mi ultricies arcu, quis ornare lectus tortor nec metus. Donec ultricies metus at magna cursus congue. Nam eu sem eget enim pretium venenatis. Duis nibh ligula, lacinia ac nisi vestibulum, vulputate lacinia tortor.";
  float[] cutWidth = new float[1];

  public Sample20ImgAndText(Context context) {
    super(context);
  }

  public Sample20ImgAndText(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Sample20ImgAndText(Context context, @Nullable AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    bitmap = getAvatar((int) Utils.dp2px(120));
    paint.setTextSize(Utils.dp2px(15));
    paint.getFontMetrics(fontMetrics);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //绘制图片
    canvas.drawBitmap(bitmap, getWidth() - IMAGE_WIDTH, IMAGE_OFFSET, paint);
    //绘制文字
    //获取文字长度
    int length = text.length();
    //获取文字的最高顶端
    float verticalOffset = -fontMetrics.top;
    for (int start = 0; start < length; ) {
      int maxWidth;
      //字体顶部位置
      float textTop = verticalOffset + fontMetrics.top;
      //字体底部位置
      float textBottom = verticalOffset + fontMetrics.bottom;
      if (textTop > IMAGE_OFFSET && textTop < IMAGE_OFFSET + IMAGE_WIDTH
          || textBottom > IMAGE_OFFSET && textBottom < IMAGE_OFFSET + IMAGE_WIDTH) {
        maxWidth = (int) (getWidth() - IMAGE_WIDTH);
      } else {
        maxWidth = getWidth();
      }
      int count = paint.breakText(text, start, length, true, maxWidth, cutWidth);
      canvas.drawText(text, start, start + count, 0, verticalOffset, paint);
      start += count;
      verticalOffset += paint.getFontSpacing();
    }
  }

  Bitmap getAvatar(int width) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), R.drawable.avatar_rengwuxian, options);
    options.inJustDecodeBounds = false;
    options.inDensity = options.outWidth;
    options.inTargetDensity = width;
    return BitmapFactory.decodeResource(getResources(), R.drawable.avatar_rengwuxian, options);
  }
}
