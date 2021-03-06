package com.game.chiendh.iqtestforfun;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;

public class EveryoneActivity extends FragmentActivity {

	private static final int NUM_PAGES = 39;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
	private String prefName = "pfAnswer";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_everyone);
		
		mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When changing pages, reset the action bar actions since they are dependent
                // on which page is currently active. An alternative approach is to have each
                // fragment expose actions itself (rather than the activity exposing actions),
                // but for simplicity, the activity provides the actions in this sample.
                invalidateOptionsMenu();
            }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_everyone, menu);
		menu.findItem(R.id.action_previous).setEnabled(mPager.getCurrentItem() > 0);

        // Add either a "next" or "finish" button to the action bar, depending on which page
        // is currently selected.
        MenuItem item = menu.add(Menu.NONE, R.id.action_next, Menu.NONE,
                (mPager.getCurrentItem() == mPagerAdapter.getCount() - 1)
                        ? R.string.action_finish
                        : R.string.action_next);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        return true;
	}
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case android.R.id.home:
	                // Navigate "up" the demo structure to the launchpad activity.
	                // See http://developer.android.com/design/patterns/navigation.html for more.
	                NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
	                return true;

	            case R.id.action_previous:
	                // Go to the previous step in the wizard. If there is no previous step,
	                // setCurrentItem will do nothing.
	                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
	                return true;

	            case R.id.action_next:
	                // Advance to the next step in the wizard. If there is no next step, setCurrentItem
	                // will do nothing.
	                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
	                return true;
	                
	        }

	        return super.onOptionsItemSelected(item);
	    }
	 
	 CheckBox cb;
	 
	 public void nextQuesstion(int ans){
		 if(mPagerAdapter.getCount() - 1 > mPager.getCurrentItem()){
			 mPager.setCurrentItem(mPager.getCurrentItem() + 1);
			 savePref(""+mPager.getCurrentItem(), ans);
		 }
			 
	 }
	 
	 private void savePref(String qNumber, int answer){
		 SharedPreferences pre = getSharedPreferences(prefName, MODE_PRIVATE);
		 SharedPreferences.Editor editor = pre.edit();
		 editor.putInt(qNumber, answer);
		 editor.commit();
		 
	 }
	 private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
	        public ScreenSlidePagerAdapter(FragmentManager fm) {
	            super(fm);
	        }

	        @Override
	        public Fragment getItem(int position) {
	        	SharedPreferences pre = getSharedPreferences(prefName, MODE_PRIVATE);
	        	SharedPreferences.Editor ed = pre.edit();
	        	ed.clear();
	            return ScreenSlidePageFragment.create(position, EveryoneActivity.this);
	        }

	        @Override
	        public int getCount() {
	            return NUM_PAGES;
	        }
	    }



//	@Override
//	public void onClick(View v) {
//		if(v.equals(R.id.imgAwA)){
//			mPager.setCurrentItem(mPager.getCurrentItem() + 1);
//		}
//		
//	}

}
