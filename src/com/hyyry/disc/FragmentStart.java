package com.hyyry.disc;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class FragmentStart extends Fragment implements OnClickListener {
	//Fragment fragment;
	Button button1, button2, button3;
	
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.start_fragment, container, false);
		
		button1 = (Button)rootView.findViewById(R.id.btn1);
		button2 = (Button)rootView.findViewById(R.id.btn2);
		button3 = (Button)rootView.findViewById(R.id.btn3);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		
		TextView abc = (TextView)rootView.findViewById(R.id.debug_teksti);
		
		abc.setText(Field.fields.size() + " | " + Player.players.size());
		
		
		return rootView;
		
	}

		@Override
		public void onClick(View v) {
			Fragment newFragment;

			if (v == button1) {
				newFragment = new FragmentNewCourse();
			}
			else if (v == button2) {
				newFragment = new FragmentNewPlayer();
			}
			else {
				newFragment = new FragmentNewPlayer();
			}
			
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			//transaction.replace(R.id.myFragment, newFragment);
			transaction.replace(R.id.container, newFragment);
			transaction.addToBackStack(null); //Back nappi toimimaan
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
			transaction.commit();
			
		}

}
