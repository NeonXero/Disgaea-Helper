package com.ryanthomas.disgaea;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


public class MyExpandableListAdapter extends BaseExpandableListAdapter {
	// Sample data set.  children[i] contains the children (String[]) for groups[i].
	private Context mContext;
	String TAG = "RyanDisgaea/ ";
	private String[] groups = { "Storyline and Special", "Humanoids", "Monsters" };
	private String[][] children = {
			{ "Adell","Rozalin","Tink","Hanako","Taro","Yukimaru","Etna","Flonne","Laharl","Axel","Fubuki","Kurtis" },
			{ "Male Fighter","Lady Fighter","Skull","Girl Mage","Ninja","Kunoichi","Majin","Knight","Sinner","Geomancer","Samurai","Gunner","Thief","Healer","Archer","Beastmaster","Rune Knight" },
			{ "Spirit","Undead","Succubus","Felynn","Dragon","Prinny","Orc","Winged","Aqua Demon","Flora Beast","Mystic Beast","Marionette","Holy Dragon","Wood Golem","Rifle Demon","Dragon Zombie","Roc" },

	};

	public Object getChild(int groupPosition, int childPosition) {
		return children[groupPosition][childPosition];
	}

	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	public int getChildrenCount(int groupPosition) {
		return children[groupPosition].length;
	}

	public TextView getGenericView() {
		// Layout parameters for the ExpandableListView
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT, 64);

		TextView textView = new TextView(mContext);
		textView.setLayoutParams(lp);
		// Center the text vertically
		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		// Set the text starting position
		textView.setPadding(36, 0, 0, 0);
		return textView;
	}

	public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
							 View convertView, ViewGroup parent) {
		TextView textView = getGenericView();
		textView.setText(getChild(groupPosition, childPosition).toString());
		return textView;
	}

	public Object getGroup(int groupPosition) {
		return groups[groupPosition];
	}

	public int getGroupCount() {
		return groups.length;
	}

	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
							 ViewGroup parent) {
		TextView textView = getGenericView();
		textView.setText(getGroup(groupPosition).toString());
		return textView;
	}

	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	public boolean hasStableIds() {
		return true;
	}

}