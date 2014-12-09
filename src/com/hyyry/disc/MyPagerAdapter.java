package com.hyyry.disc;

import com.hyyry.objects.Field;
import com.hyyry.objects.Game;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class MyPagerAdapter extends FragmentPagerAdapter {//SmartFragmentStatePagerAdapter { //FragmentPagerAdapter on orginelli mut smart on kai tehokkaampi?
    private static int NUM_ITEMS;
    public static Field field;

    public MyPagerAdapter(FragmentManager fragmentManager) {
    	super(fragmentManager);
    	field = Game.field;
    	NUM_ITEMS = field.getLength() + 1; //TODO t‰nne voi heitt‰‰ yhen lis‰‰ ni saa viimesen sivun
        
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
    	if (position == NUM_ITEMS-1) {
    		//TODO T‰nne fragmentti mill‰ saa tallennettuu ja tulostettuu!
    		GameEnd myFragment = new GameEnd();
    		return myFragment;
    	}
    	else
    		return FirstFragment.newInstance(position);
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
    	if (position == NUM_ITEMS-1)
    		return "GAME OVER";
        return "Hole " + (position + 1);
    }

}
