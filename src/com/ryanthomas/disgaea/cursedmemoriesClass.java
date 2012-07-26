package com.ryanthomas.disgaea;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

public class cursedmemoriesClass extends ExpandableListActivity {

	ExpandableListAdapter mAdapter;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		// Set up our adapter
		mAdapter = new MyExpandableListAdapter();
		setListAdapter(mAdapter);
    }

	/**
	 * A simple adapter which maintains an ArrayList of photo resource Ids.
	 * Each photo is displayed as an image. This adapter supports clearing the
	 * list of photos and adding a new photo.
	 *
	 */
	public class MyExpandableListAdapter extends BaseExpandableListAdapter {
		// Sample data set.  children[i] contains the children (String[]) for groups[i].
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

			TextView textView = new TextView(cursedmemoriesClass.this);
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
}