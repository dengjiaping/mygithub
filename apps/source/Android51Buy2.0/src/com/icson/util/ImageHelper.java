package com.icson.util;

import java.io.ByteArrayOutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;

public class ImageHelper {

	private static final String LOG_TAG = ImageHelper.class.getName();

	private static BitmapFactory.Options opt;
	
//	static private volatile HashMap<Integer, Bitmap> mBitmapHash = new HashMap<Integer, Bitmap>();
	static private volatile SparseArray<Bitmap> mBitmapHash = new SparseArray<Bitmap>();

	public static Bitmap getCacheBitmap(int id) {
		Bitmap bitmap = mBitmapHash.get(id);

		if (null != bitmap)
			return bitmap;

		bitmap = getResBitmap(IcsonApplication.app, id);

		if (bitmap != null) {
			synchronized (ImageHelper.class) {
				mBitmapHash.put(id, bitmap);
			}
		}

		return bitmap;
	}

	/**
	 * 获取图片资源
	 * 
	 * @param context
	 *            上下文
	 * @param resId
	 *            资源id
	 * @return 图片
	 */
	public static Bitmap getResBitmap(Context context, int resId) {
		Bitmap bm = null;
		try {
			if(null == opt)
			{
				 opt = new BitmapFactory.Options();
				 opt.inPreferredConfig = Bitmap.Config.RGB_565;
				 opt.inPurgeable = true;  
				 opt.inInputShareable = true;
			}
			bm = BitmapFactory.decodeResource(context.getResources(), resId, opt);
		} catch (OutOfMemoryError ex) {
			Log.e(LOG_TAG, "getResBitmap|"+ ToolUtil.getStackTraceString(ex));
			System.gc();
			bm = null;
		}
		return bm;
	}

	/**
	 * 等比缩小给定的图片
	 * 
	 * @param bitmap
	 *            需要缩小的图片
	 * @param maxsize
	 *            缩小后的最大值
	 * @return 缩小后的图片
	 */
	public static Bitmap resizeBitmap(Bitmap bitmap, int maxsize, boolean bRecycle) {
		if (maxsize <= 0 || bitmap == null || bitmap.isRecycled()) {
			return null;
		}
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		float temp = 0;
		if (((float) maxsize / (float) height) > (((float) maxsize) / (float) width)) {
			temp = (((float) maxsize) / (float) width);
		} else {
			temp = ((float) maxsize / (float) height);
		}
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(temp, temp);
		// matrix.postRotate(45);
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
		if(bRecycle)
			bitmap.recycle();
		return resizedBitmap;
	}

	/**
	 * 等比缩小给定的图片文件
	 * 
	 * @param file_name
	 *            需要缩小的图片全路径
	 * @param maxsize
	 *            缩小后的最大值
	 * @return 缩小后的图片
	 */
/*	public static Bitmap resizeBitmap(String file_name, int maxsize) {
		int s = 1;
		if (file_name == null || file_name.length() <= 0 || maxsize <= 0) {
			return null;
		}
		try {
			InputStream in = null;
			BitmapFactory.Options opt = new BitmapFactory.Options();
			opt.inJustDecodeBounds = true;
			in = FileHelper.getInputStream(file_name);
			BitmapFactory.decodeStream(in, null, opt);
			opt.inPreferredConfig = Bitmap.Config.RGB_565;
			try {
				in.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			while ((opt.outWidth / (s + 1) > maxsize) || (opt.outHeight / (s + 1) > maxsize)) {
				s++;
			}
			opt.inJustDecodeBounds = false;
			opt.inSampleSize = s;
			in = FileHelper.getInputStream(file_name);
			Bitmap b = BitmapFactory.decodeStream(in, null, opt);
			try {
				in.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if (b == null) {
				return null;
			}
			return resizeBitmap(b, maxsize);
		} catch (Exception ex) {
			Log.e(LOG_TAG, "resizeBitmap|" + ToolUtil.getStackTraceString(ex));
			return null;
		}
	}*/

	/**
	 * 获得圆角图片
	 * 
	 * @param bitmap
	 *            原始图片
	 * @param roundPx
	 *            圆角
	 * @return 圆角后的图片
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
		if (bitmap == null) {
			return null;
		}
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		if (!bitmap.isRecycled()) {
			bitmap.recycle();
		}
		return output;
	}

	/**
	 * bitmap 转换图片为 byte[]
	 * 
	 * @param bm
	 * @return
	 */
	public static byte[] Bitmap2Bytes(Bitmap bm, int quality) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.PNG, quality, baos);
		return baos.toByteArray();
	}

	public static byte[] Bitmap2Bytes(Bitmap bm) {
		return Bitmap2Bytes(bm, 100);
	}

	/**
	 * 字节转换成图片
	 * 
	 * @param b
	 * @return
	 */
	public static Bitmap Bytes2Bitmap(byte[] b) {
		if (b != null && b.length != 0) {
			return BitmapFactory.decodeByteArray(b, 0, b.length);
		} else {
			return null;
		}
	}

	/**
	 * 旋转图片
	 * 
	 * @param bm
	 *            需要旋转的图片
	 * @param degrees
	 *            度数
	 * @return 旋转后的图片
	 */
	public static Bitmap rotateBitmap(Bitmap bm, float degrees) {
		Bitmap returnBm;
		int w = bm.getWidth();
		int h = bm.getHeight();

		Matrix matrix = new Matrix();
		matrix.postRotate(degrees);
		returnBm = Bitmap.createBitmap(bm, 0, 0, w, h, matrix, true);
		return returnBm;
	}

	public static Bitmap drawableToBitmap(Drawable drawable) {

		Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
		drawable.draw(canvas);
		return bitmap;
	}

	public static Drawable bitmapToDrawable(Bitmap bitmap) {
		return new BitmapDrawable(bitmap);
	}
}
