package com.hyyry.disc;

import com.hyyry.objects.Game;
import com.hyyry.objects.Player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentGame extends Fragment {
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//Log.e("com.hyyry.disc", "NYT VITTU");
		View rootView = inflater.inflate(R.layout.viewpager, container, false);
		
		//Tehd‰‰n kaikille pelaajille uudet taulukot johon laitetaan tulokset.
		for (int i = 0; i < Game.players.size(); i++) {
    		Player player = Game.players.get(i);
    		player.setNewGame(Game.field.getLength());
    	}
		
		ViewPager vpPager = (ViewPager)rootView.findViewById(R.id.pager);
		MyPagerAdapter adapterViewPager = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
		
		return rootView;
		
	}
	/*
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//N‰ill‰ saa listan toimimaan!!
		setContentView(R.layout.viewpager);
		ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
		MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
		

		
	}*/

}
