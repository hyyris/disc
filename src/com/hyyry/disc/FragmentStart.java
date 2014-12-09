package com.hyyry.disc;

import com.hyyry.database.PLayerDAO;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentStart extends Fragment implements OnClickListener {
	//Fragment fragment;
	Button button1, button2, button3;
	private PLayerDAO dao;
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.start_fragment, container, false);
		
		dao = new PLayerDAO(getActivity());
		
		button1 = (Button)rootView.findViewById(R.id.btn1);
		button2 = (Button)rootView.findViewById(R.id.btn2);
		button3 = (Button)rootView.findViewById(R.id.btn3);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		
		return rootView;
		
	}

		@Override
		public void onClick(View v) {
			Fragment newFragment;

			if (v == button1) {
				newFragment = new FragmentNewCourse();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.container, newFragment);
				transaction.addToBackStack(null); //Back nappi toimimaan
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.commit();
				
			}
			else if (v == button2) {
				newFragment = new FragmentNewPlayer();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.container, newFragment);
				transaction.addToBackStack(null); //Back nappi toimimaan
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN); //Turha, mut näitä voi hyödyntää myöhemmin
				transaction.commit();
			}
			else {
				//newFragment = new ChoosePlayers();
				newFragment = new ChooseCourse();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.container, newFragment);
				transaction.addToBackStack(null); //Back nappi toimimaan
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN); //Turha, mut näitä voi hyödyntää myöhemmin
				transaction.commit();
			}
			/*
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			//transaction.replace(R.id.myFragment, newFragment);
			transaction.replace(R.id.container, newFragment);
			transaction.addToBackStack(null); //Back nappi toimimaan
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
			transaction.commit();*/
			
		}

}
