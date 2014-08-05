package com.tencent.djcity.login;

import com.tencent.djcity.util.AppUtils;
import com.tencent.djcity.util.Config;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseResp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class WechatLogin {
	private static Activity mActivity;
	private static OnWXLoginResponseListener mOnWXLoginResponseListener;
	private static WXLoginResponseReceiver mWXLoginResponseReceiver;
	
	public static void setOnWXLoginResponseListener(OnWXLoginResponseListener listener, Activity pActivity) {
		if(null == mWXLoginResponseReceiver){
			mWXLoginResponseReceiver = new WXLoginResponseReceiver();
		}
		mOnWXLoginResponseListener = listener;
		if(pActivity != null) {
			if(mActivity == pActivity) { //??��?????activity, 说�??已�??为�?????activity注�??�?�??????????注�??
				
			} else { //�???????activity
				if(mActivity != null) { //�????空�??说�??已�??为�??�?�?activity注�??�?�????注�?????�?�?activity,???注�??�????activity
					mActivity.unregisterReceiver(mWXLoginResponseReceiver);
				} else { //???�?�?activity 为空�?说�??没�??为任�?activity注�??�?�???��?�注???
					
				}
				
				// 注�??receiver
				IntentFilter filter = new IntentFilter();
				filter.addAction(Config.BROADCAST_FROM_WXLOGIN);
				pActivity.registerReceiver(mWXLoginResponseReceiver, filter, Config.SLEF_BROADCAST_PERMISSION,null);
			} 
		}
		
		mActivity = pActivity;
	}
	
	public static void unset(Activity activity) {
		if(activity != null) {
			if(activity != mActivity) {
				return;
			}
			if(mActivity != null) {
				mActivity.unregisterReceiver(mWXLoginResponseReceiver);
			}
			mWXLoginResponseReceiver = null;
			mOnWXLoginResponseListener = null;
			mActivity = null;
		}
	}
	
	
	private static class WXLoginResponseReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			int nErrCode = intent.getIntExtra("errCode", ConstantsAPI.COMMAND_UNKNOWN);
			int nType = intent.getIntExtra("type", -1);
			String strCode = intent.getStringExtra("code");
			String strState = intent.getStringExtra("state"); 
			
			if(nType == ConstantsAPI.COMMAND_SENDAUTH)
			{
				if(nErrCode == BaseResp.ErrCode.ERR_OK)
				{
					mOnWXLoginResponseListener.OnWXLoginResponse(strCode, strState);
				}
				else
				{
					AppUtils.informWXLoginResult(mActivity,nErrCode);
				}
			}
		}
	}
	
	public interface OnWXLoginResponseListener {
		void OnWXLoginResponse(String code, String state);
	}

}
