package com.hyyry.disc;

import com.hyyry.database.FieldDAO;
import com.hyyry.database.PLayerDAO;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.AdapterView;
import android.os.Bundle;

public class MainActivity extends FragmentActivity { //extendas ennen pelkk‰‰ Activity'‰
	private PLayerDAO dao;
	private FieldDAO dao2;
	private MyPagerAdapter adapterViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		/*
		//N‰ill‰ saa listan toimimaan!!
		setContentView(R.layout.viewpager);
		ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
		*/
		 
		
		dao = new PLayerDAO(this);
		dao2 = new FieldDAO(this);
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		FragmentStart myFragment = new FragmentStart();
		
		ft.add(R.id.myFragment, myFragment);
		ft.commit();

		
	}

}
