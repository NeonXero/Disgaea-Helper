package com.ryanthomas.disgaea;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Ryan
 * Date: 2/22/12
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageAdapter extends BaseAdapter {
	int mGalleryItemBackground;
	private Context mContext;
	String TAG = "RyanDisgaea/ ";

	HashMap<String, Bitmap> map;
	Handler myhandler;
	//Success and error conditions for the message
	final static int MESSAGE_SUCCESS = 1;
	final static int MESSAGE_FAILURE = 0;


	Integer[] mImageIds = {
			com.ryanthomas.disgaea.R.drawable.dis1,
			com.ryanthomas.disgaea.R.drawable.disafternoon,
			com.ryanthomas.disgaea.R.drawable.disds,
			com.ryanthomas.disgaea.R.drawable.dis2,
			com.ryanthomas.disgaea.R.drawable.disdhd,//darker days
			com.ryanthomas.disgaea.R.drawable.dis3,
			com.ryanthomas.disgaea.R.drawable.disabofde,//absence not in NA 6
			com.ryanthomas.disgaea.R.drawable.dis4
	};

	public ImageAdapter(Context c, Integer[] ids) {
		mContext = c;
		TypedArray attr = mContext.obtainStyledAttributes(com.ryanthomas.disgaea.R.styleable.HelloGallery);
		mGalleryItemBackground = attr.getResourceId(
				com.ryanthomas.disgaea.R.styleable.HelloGallery_android_galleryItemBackground, 0);

		map = new HashMap<String, Bitmap>();

		myhandler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				switch(msg.what){
					case MESSAGE_FAILURE:
						break;
					case MESSAGE_SUCCESS:
						map.put(""+msg.arg1,((Bitmap)msg.obj));
						notifyDataSetChanged();
						break;
				}
				super.handleMessage(msg);
			}
		};
		attr.recycle();
	}

	public int getCount() {
		return mImageIds.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = new ImageView(mContext);
			//((ImageView) convertView).setScaleType(ImageView.ScaleType.FIT_XY);
			//((ImageView) convertView).setMaxWidth(120);
			((ImageView) convertView).setBackgroundResource(mGalleryItemBackground);
		}

		Bitmap datImage = getImage(position);
		((ImageView) convertView).setImageBitmap(datImage);

		return convertView;
	}

	public Bitmap getImage(final int pos) {

		if (map!=null) {
			if (map.get(""+pos)!=null) {
				return map.get(""+pos);
			}
			else {
				new Thread(){
					@Override
					public void run() {
						Message msg = Message.obtain();
						Bitmap theImage = BitmapFactory.decodeResource(mContext.getResources(),mImageIds[pos]);
						if (theImage != null) {
							msg.what = MESSAGE_SUCCESS;
							msg.obj = theImage;
							msg.arg1 = pos;
						}
						else {
							msg.what = MESSAGE_FAILURE;
						}
						myhandler.sendMessage(msg);

					}
				}.start();

				return null;
			}
		}
		else {
			Toast.makeText(mContext,"Images empty",Toast.LENGTH_SHORT).show();
			return null;
		}
	}
}
