/**
 * Copyright (C) 2013 Tencent Inc.
 * All rights reserved, for internal usage only.
 * 
 * Project: 51Buy
 * FileName: ShortcutView.java
 * 
 * Description: 
 * Author: lorenchen (lorenchen@tencent.com)
 * Created: Jun 13, 2013
 */

package com.icson.lib.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;

import com.icson.R;

public class ShortcutView extends UiBase implements OnClickListener {
	/**
	 * onShortcutSelectListener
	 * @author lorenchen
	 *
	 */
	public interface onShotcutSelectListner {
		/**
		 * onShortcutSelect
		 * @param nIndex
		 */
		public abstract void onShortcutSelect(int nIndex);
	}
	
	/**
	 * Constructor of ShortcutView
	 * @param context
	 * @param attrs
	 */
	public ShortcutView(Context context, AttributeSet attrs) {
		super(context, attrs, R.layout.view_shortcut);
	}
	
	public void setTheme(boolean bNightMode) {
		mSlotmachine.setImageResource(bNightMode ? R.drawable.slot_night : R.drawable.slot_daytime);
		mViewOrders.setImageResource(bNightMode ? R.drawable.orders_night : R.drawable.orders_daytime);
		mRecharge.setImageResource(bNightMode ? R.drawable.recharge_night : R.drawable.recharge_daytime);
		mCollect.setImageResource(bNightMode ? R.drawable.lottery_night : R.drawable.lottery_daytime);
	}
	
	public void setOnShortcutSelectListener(onShotcutSelectListner listener) {
		mListener = listener;
	}
	
	public void setRechargePromoIcon(boolean isVisible) {
		setRechargePromoIcon(null, isVisible);
	}
	
	public void setRechargePromoIcon(Bitmap aBitmap, boolean isVisible) {
		if(null == aBitmap || false == isVisible) {
			mRechargePromoIcon.setVisibility(View.GONE);
			return;
		}
		
		mRechargePromoIcon.setVisibility(View.VISIBLE);
		mRechargePromoIcon.setImageBitmap(aBitmap);
	}
	
	@Override
	public void onClick(View v) {
		if( null == mListener )
			return ;
		
		switch( v.getId() ) {
		case R.id.shortcut_slotmachine:
			mListener.onShortcutSelect(0);
			break;
		case R.id.shortcut_orders:
			mListener.onShortcutSelect(1);
			break;
		case R.id.shortcut_collect:
			mListener.onShortcutSelect(2);
			break;
		case R.id.shortcut_recharge:
			mListener.onShortcutSelect(3);
			break;
		}
	}
	
	/**
	 * initialize the instance.
	 */
	@Override
	protected void onInit(Context context) {
		// Get children components.
		mSlotmachine = (ImageView)findViewById(R.id.shortcut_slotmachine);
		mSlotmachine.setOnClickListener(this);
		mViewOrders = (ImageView)findViewById(R.id.shortcut_orders);
		mViewOrders.setOnClickListener(this);
		mRecharge = (ImageView)findViewById(R.id.shortcut_recharge);
		mRecharge.setOnClickListener(this);
		mCollect = (ImageView)findViewById(R.id.shortcut_collect);
		mCollect.setOnClickListener(this);
		mRechargePromoIcon = (ImageView) findViewById(R.id.shortcut_recharge_promo_icon);
	}
	
	
	private ImageView mSlotmachine;
	private ImageView mViewOrders;
	private ImageView mRecharge;
	private ImageView mCollect;
	private ImageView mRechargePromoIcon;
	private onShotcutSelectListner mListener;
}
