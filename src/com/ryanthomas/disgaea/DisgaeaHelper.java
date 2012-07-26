package com.ryanthomas.disgaea;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

public class DisgaeaHelper extends Activity implements OnClickListener {
	
	String TAG = "RyanDisgaea/ ";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ryanthomas.disgaea.R.layout.home);

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

		mygallery gallery = (mygallery) findViewById(R.id.thisgallery);
		ImageAdapter bossAdapter = new ImageAdapter(DisgaeaHelper.this,mImageIds);

		gallery.setAdapter(bossAdapter);

		gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position, long id) {

				//Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
				Intent intent;
				switch (position) {
					case 0: //Hour of Darkness PS2
						Toast.makeText(getApplicationContext(), "WIP", Toast.LENGTH_SHORT).show();
						//intent = new Intent(DisgaeaHelper.this, HourOfDarkness.class);
						//startActivity(intent);
						break;
					case 1: //Afternoon of Darkness, PSP
						Toast.makeText(getApplicationContext(), "WIP", Toast.LENGTH_SHORT).show();
						break;
					case 2: //Disgaea DS
						Toast.makeText(getApplicationContext(), "WIP", Toast.LENGTH_SHORT).show();
						break;
					case 3: //Cursed Memories PS2
						intent = new Intent(DisgaeaHelper.this, CursedMemories.class);
						startActivity(intent);
						break;
					case 4: //Dark Hero Days PSP
						Toast.makeText(getApplicationContext(), "WIP", Toast.LENGTH_SHORT).show();
						break;
					case 5: // Disgaea 3 Ps3
						Toast.makeText(getApplicationContext(), "WIP", Toast.LENGTH_SHORT).show();
						break;
					case 6: //Absense of Detention Vita
						Toast.makeText(getApplicationContext(), "WIP", Toast.LENGTH_SHORT).show();
						break;
					case 7: // Disgaea 4 PS3
						Toast.makeText(getApplicationContext(), "WIP", Toast.LENGTH_SHORT).show();
						break;
				}
			}

		});
	}

	public void onClick(View view) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}