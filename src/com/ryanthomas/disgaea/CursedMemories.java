package com.ryanthomas.disgaea;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.TitleProvider;

public class CursedMemories extends Activity {


	private class MyViewPagerAdapter extends PagerAdapter implements TitleProvider,
			ExpandableListView.OnChildClickListener {

		private String[] classGroups = {"Storyline and Special", "Humanoids", "Monsters"};
		private String[][] classChildren = {
				{"Adell", "Rozalin", "Tink", "Hanako", "Taro", "Yukimaru", "Etna", "Flonne", "Laharl", "Axel",
						"Fubuki", "Kurtis"},
				{"Male Fighter", "Lady Fighter", "Skull", "Girl Mage", "Ninja", "Kunoichi", "Majin", "Knight",
						"Sinner", "Geomancer", "Samurai", "Gunner", "Thief", "Healer", "Archer", "Beastmaster",
						"Rune Knight"},
				{"Spirit", "Undead", "Succubus", "Felynn", "Dragon", "Prinny", "Orc", "Winged", "Aqua Demon",
						"Flora Beast", "Mystic Beast", "Marionette", "Holy Dragon", "Wood Golem", "Rifle Demon",
						"Dragon Zombie", "Roc"},

		};
		private String[] itemGroups = {"Sword", "Fist", "Axe"};
		private String[][] itemChildren = {
				{"Little sword", "Big sword"},
				{"Left hand", "Right hand"},
				{"Chop chop", "Swing swing"},
		};

		@Override
		public void destroyItem(View collection, int position, Object view) {
			((ViewPager) collection).removeView((View) view);
		}


		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return 4; // Number of pages usually set with .length() or .size()
		}

		@Override
		public Object instantiateItem(View collection, int position) {
			final LayoutInflater inflater = (LayoutInflater) CursedMemories.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


			TextView tv = new TextView(CursedMemories.this);
			switch (position) {
				case 0: // Full ExpandableList code here
					View v = inflater.inflate(R.layout.left_page, null, false);
					ExpandableListView elv1 = (ExpandableListView) v.findViewById(R.id.expandlist);

					if (true) { // if the size of the data source is greater than 0 do the following
						elv1.setOnChildClickListener(this);
						CursedMemories.this.mAdapter = new BaseExpandableListAdapter() {

							@Override
							public Object getChild(int groupPosition, int childPosition) {
								return classChildren[groupPosition][childPosition];
							}

							@Override
							public long getChildId(int groupPosition, int childPosition) {
								return childPosition;
							}

							@Override
							public int getChildrenCount(int groupPosition) {
								return classChildren[groupPosition].length;
							}

							@Override
							public View getChildView(int groupPosition,
													 int childPosition, boolean isLastChild,
													 View convertView, ViewGroup parent) {
								View v = inflater.inflate(R.layout.twolinelistitem,
										null, false);
								TextView tv = (TextView) v
										.findViewById(R.id.simple_expandable_list_item_2_text1);
								tv.setText(getChild(groupPosition, childPosition).toString());
								return v;
							}

							@Override
							public Object getGroup(int groupPosition) {
								return classGroups[groupPosition];
							}

							@Override
							public int getGroupCount() {
								return classGroups.length;
							}

							@Override
							public long getGroupId(int groupPosition) {
								return groupPosition;
							}

							@Override
							public View getGroupView(int groupPosition,
													 boolean isExpanded, View convertView,
													 ViewGroup parent) {
								View v = inflater.inflate(R.layout.twolinelistitem,
										parent, false);
								TextView tv = (TextView) v
										.findViewById(R.id.simple_expandable_list_item_2_text1);
								tv.setText(getGroup(groupPosition).toString());
								return v;
							}

							@Override
							public boolean hasStableIds() {
								return false;
							}

							@Override
							public boolean isChildSelectable(int groupPosition,
															 int childPosition) {
								return true;
							}
						};
						elv1.setAdapter(CursedMemories.this.mAdapter);

						((ViewPager) collection).addView(v, 0);
						return v;
					}

				case 3:
					View v4 = inflater.inflate(R.layout.far_right, null, false);
					ExpandableListView elv4 = (ExpandableListView) v4.findViewById(R.id.expandlistItem);
					if (true) { // if the size of the data source is greater than 0 do the following
						elv4.setOnChildClickListener(this);
						CursedMemories.this.mAdapter = new BaseExpandableListAdapter() {

							@Override
							public Object getChild(int groupPosition, int childPosition) {
								return itemChildren[groupPosition][childPosition];
							}

							@Override
							public long getChildId(int groupPosition, int childPosition) {
								return childPosition;
							}

							@Override
							public int getChildrenCount(int groupPosition) {
								return itemChildren[groupPosition].length;
							}

							@Override
							public View getChildView(int groupPosition,
													 int childPosition, boolean isLastChild,
													 View convertView, ViewGroup parent) {
								View v = inflater.inflate(R.layout.twolinelistitem,
										null, false);
								TextView tv = (TextView) v
										.findViewById(R.id.simple_expandable_list_item_2_text1);
								tv.setText(getChild(groupPosition, childPosition).toString());
								return v;
							}

							@Override
							public Object getGroup(int groupPosition) {
								return itemGroups[groupPosition];
							}

							@Override
							public int getGroupCount() {
								return itemGroups.length;
							}

							@Override
							public long getGroupId(int groupPosition) {
								return groupPosition;
							}

							@Override
							public View getGroupView(int groupPosition,
													 boolean isExpanded, View convertView,
													 ViewGroup parent) {
								View v = inflater.inflate(R.layout.twolinelistitem,
										parent, false);
								TextView tv = (TextView) v
										.findViewById(R.id.simple_expandable_list_item_2_text1);
								tv.setText(getGroup(groupPosition).toString());
								return v;
							}

							@Override
							public boolean hasStableIds() {
								return false;
							}

							@Override
							public boolean isChildSelectable(int groupPosition,
															 int childPosition) {
								return true;
							}
						};
						elv4.setAdapter(CursedMemories.this.mAdapter);

						((ViewPager) collection).addView(v4, 0);
						return v4;
					}
			}
			return collection;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}

		@Override
		public String getTitle(int position) {
			switch (position) {
				case 0:
					return "Classes";
				case 1:
					return "Skills";
				case 2:
					return "Specialists";
				case 3:
					return "Items";
			}
			return Integer.toString(position);
		}

		@Override
		public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition,
									int childPosition, long id) {
			//Toast.makeText(getApplicationContext(),"Group: " + groupPosition + " Child: " + childPosition,
			// Toast.LENGTH_SHORT).show();
			String item = null;
			int page = 0;
			if ((String) mAdapter.getChild(0, 0) == ("Adell")) {
				page = 1; //Classes
			} else if ((String) mAdapter.getChild(0, 0) == ("Little sword")) {
				page = 4; //Items
			}

			switch (page) {
				case 1: //Case = Class page
					switch (groupPosition) {
						case 0: // = Story and special
							switch (childPosition) {
								case 0:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									//Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
									showIt(item, "Starting character\nAlways unlocked\nClass: Demon Hunter");
									break;
								case 1:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Starting character\nAlways unlocked\nClass: Zenon\'s Child");
									break;
								case 2:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by finishing episode 2-2\nClass: Dirty Frog");
									break;
								case 3:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by finishing episode 4-4\nClass: Adell\'s Sister");
									break;
								case 4:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by finishing episode 5-4\nClass: Rozy\'s Slave");
									break;
								case 5:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by finishing episode 7-2\nClass: Kunoichi");
									break;
								case 6:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by finishing episode 9-4\nClass: Beauty Queen");
									break;
								case 7:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by first passing the bill \'I want to fight an overlord\'. Then enter the map \'Overlord\'s Descent\'. If you win this fight. Flonne joins your party.\nClass: Fallen Angel");
									break;
								case 8:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by first getting Flonne in your party. Then you must pass the bill to have Adell become a senator. Next pass the bill to have Flonne summon Laharl. If you can win the resulting battle, Laharl becomes a member of your party!\nClass: Overlord");
									break;
								case 9:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by opening the Land of Carnage.\nNote: Axel only usable during chapters where he is not part of the story (3,9,10,11, after 13-4)\nNote 2: Only usable in Land of Carnage\nClass: Dark Hero");
									break;
								case 10:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by opening Land of Carnage. \nNote: Once Fubiki\'s story is complete (post episode 13-3) he becomes available.\nNote2: Only usable in Land of Carnage\nClass: Ninja Master");
									break;
								case 11:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Unlocked by opening Land of Carnage. \nNote: Only usable in Land of Carnage\nClass: Defender");
									break;
							}
							break; //story end
						case 1: // = Humanoids
							switch (childPosition) {
								case 0:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Fighter, no level requirement\nWarrior, level 10\nDestroyer, " +
											"level 20\nGladiator, level 40\nWarlord, level 80\nBattle Master, " +
											"level 160");
									break;
								case 2:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Red Skull, no level requirement\nGreen Skull, " +
											"no level requirement\nBlue Skull, no level requirement\nStar Skull, " +
											"level 20\nPrism Skull, level 60\nGalaxy Skull, level 160");
									break;
							}
							break; //humanoid end
						case 2: // = Monsters
							switch (childPosition) {
								case 0:
									item = (String) mAdapter.getChild(groupPosition, childPosition);
									showIt(item, "Ghost, no level requirement\nBoggart, level 10\nSpectere, " +
											"level 20\nWraith, level 40\nFiend, level 80\nPhantom, level 160");
									break;
							}
							break;//monster end
					}
					break; //end class page
				case 4: //item page
					Toast.makeText(getApplicationContext(), "Page itemz", Toast.LENGTH_SHORT).show();
					break;
			}
			return true;
		}
	}

	public void showIt(String title, String message) {
		new AlertDialog.Builder(this)
				.setTitle(title)
				.setMessage(message)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				})
				.show();
	}

	public ExpandableListAdapter mAdapter;

	private MyViewPagerAdapter myAdapter;
	private ViewPager myPager;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.cursed_memories);

		myAdapter = new MyViewPagerAdapter();
		myPager = (ViewPager) findViewById(R.id.pager);
		myPager.setAdapter(myAdapter);
		myPager.setCurrentItem(0);
		TitlePageIndicator titleIndicator = (TitlePageIndicator) findViewById(R.id.indicator);
		titleIndicator.setViewPager(myPager);
	}
}