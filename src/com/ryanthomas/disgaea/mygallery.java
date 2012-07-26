package com.ryanthomas.disgaea;

/**
 * Created by IntelliJ IDEA.
 * User: Ryan
 * Date: 2/18/12
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Gallery;

public class mygallery extends Gallery {

	public mygallery(Context context, AttributeSet attrs)
	{
		super(context, attrs);

	}


	private boolean isScrollingLeft(MotionEvent e1, MotionEvent e2){
		return e2.getX() > e1.getX();
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
		int kEvent;
		if(isScrollingLeft(e1, e2)){ //Check if scrolling left
			kEvent = KeyEvent.KEYCODE_DPAD_LEFT;
		}
		else{ //Otherwise scrolling right
			kEvent = KeyEvent.KEYCODE_DPAD_RIGHT;
		}
		onKeyDown(kEvent, null);
		return true;
	}

}

