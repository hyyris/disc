package com.hyyry.disc;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	
	//Fragment fragment;
	//Button button1, button2, button3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		
		FragmentStart myFragment = new FragmentStart();
		
		ft.add(R.id.myFragment, myFragment);
		ft.commit();
		
	}
	
	public void onClickSavePlayer(View v) {
		//TODO seivaus
		
		Fragment newFragment = new FragmentStart();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		//transaction.replace(R.id.myFragment, newFragment);
		transaction.replace(R.id.container, newFragment);
		//transaction.addToBackStack(null); //Back nappi toimimaan
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
		transaction.commit();
		
		
	}

}
