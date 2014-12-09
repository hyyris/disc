package com.hyyry.disc;

import com.hyyry.database.PLayerDAO;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameEnd extends Fragment implements OnClickListener {

	Button button1, button2;
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.end_game, container, false);
		
		button1 = (Button)rootView.findViewById(R.id.btn1);
		button2 = (Button)rootView.findViewById(R.id.btn2);
		//button3 = (Button)rootView.findViewById(R.id.btn3);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		//button3.setOnClickListener(this);
		
		return rootView;
	}

		@Override
		public void onClick(View v) {
			//Fragment newFragment;

			if (v == button1) {
				
			}
			else if (v == button2) {
				
			}
			else {
			}
			
		}
}
