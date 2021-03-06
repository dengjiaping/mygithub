package com.yy.android.gamenews.ui.common;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

public abstract class ImageAdapter<E> extends BaseAdapter {

	private SwitchImageLoader mImageLoader = SwitchImageLoader.getInstance();
	// private DisplayImageOptions options;
	protected ArrayList<E> mDataSource;
	protected LayoutInflater mInflater;

	private Context mContext;

	public ImageAdapter(Context context) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
	}

	public Context getContext() {
		return mContext;
	}

	public void setDataSource(ArrayList<E> dataSource) {
		mDataSource = dataSource;

		if (dataSource == null) {
			notifyDataSetInvalidated();
		} else {
			notifyDataSetChanged();
		}
	}

	public ArrayList<E> getDataSource() {
		return mDataSource;
	}

	@Override
	public int getCount() {
		return mDataSource == null ? 0 : mDataSource.size();
	}

	@Override
	public E getItem(int position) {
		if (mDataSource == null || position < 0
				|| position >= mDataSource.size()) {
			return null;
		}
		return mDataSource.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	protected void displayImage(String url, ImageView view) {
		mImageLoader.displayImage(url, view);
	}

	protected void displayImage(String url, ImageView view,
			DisplayImageOptions options) {
		mImageLoader.displayImage(url, view, options);
	}

	/**
	 * To pause heavy data loading task for adapter to improve the performance
	 * if list view is doing UI operation like scrolling
	 */
	public void pause() {
		mImageLoader.pause();
	}

	/**
	 * Resume data loading when you finish UI operation
	 */
	public void resume() {
		mImageLoader.resume();
	}
}
