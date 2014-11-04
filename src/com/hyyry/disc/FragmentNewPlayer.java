package com.hyyry.disc;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FragmentNewPlayer extends Fragment implements OnClickListener {

	Button btn1;
	EditText name;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.newplayer_fragment, container, false);
		
		btn1 = (Button)rootView.findViewById(R.id.btnSave);
		btn1.setOnClickListener(this);
		
		name = (EditText)rootView.findViewById(R.id.nimi);
		
		return rootView;
	}
	
	@Override
    public void onClick(View v) {   
		//Tallentaa
		String nimi = name.getText().toString();
		
		if (nimi.length() > 0) {
			Player player = new Player();
			player.setName(nimi);
			Player.addPlayer(player);
		}
		else {
			//TODO joku ilmotus ettei tallenneta ku ei oo nimee
		}
		
		
		Fragment newFragment = new FragmentStart();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		//transaction.replace(R.id.myFragment, newFragment);
		transaction.replace(R.id.container, newFragment);
		//transaction.addToBackStack(null); //Back nappi toimimaan
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
		transaction.commit();

    }

}
