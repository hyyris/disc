package com.hyyry.disc;

import com.hyyry.database.PLayerDAO;
import com.hyyry.objects.Player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentNewPlayer extends Fragment implements OnClickListener, OnItemClickListener {

	private Button btn1, btn2;
	private EditText name;
	private PLayerDAO dao;
	private ArrayAdapter<Player> adapter;
	private ListView listView1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.newplayer_fragment, container, false);
		
		//dao = new PLayerDAO(getActivity());
		
		btn1 = (Button)rootView.findViewById(R.id.btnSave);
		btn1.setOnClickListener(this);
		btn2 = (Button)rootView.findViewById(R.id.btnRemove);
		btn2.setOnClickListener(this);
		
		name = (EditText)rootView.findViewById(R.id.nimi);
		
		//Lista toimimaan
		//listView1 = (ListView)rootView.findViewById(R.id.list);
		//adapter = new ArrayAdapter<Player>(getActivity(), android.R.layout.simple_list_item_1, dao.getPlayers());
		//listView1.setAdapter(adapter);
		
		//listView1.setOnItemClickListener(this);
		//listView1.setOnItemClickListener((android.widget.AdapterView.OnItemClickListener)this);
		
		return rootView;
	}
	
	@Override
    public void onClick(View v) {   
		//Tallennus
		if (v == btn1) {
			//Tallentaa
			String nimi = name.getText().toString();
			
			if (nimi.length() > 0) {
				Player player = new Player();
				player.setName(nimi);
				Player.addPlayer(player);
				
				dao.createPlayer(nimi);
			}
			else {
				Toast.makeText(getActivity(), "Player name can't be empty", Toast.LENGTH_LONG).show();
			}
		}
		else {
			//Log.i("com.hyyry.disc", "Ollaan sentää oikeilla teillä");
			Fragment newFragment = new DeletePlayer();
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.replace(R.id.container, newFragment);
			//transaction.replace(R.id.container, newFragment);
			transaction.addToBackStack(null); //Back nappi toimimaan
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
			transaction.commit();
			
		}
		//TODO siirrä iffin sisään ni voi jumittaa jos ei anneta nimee
		//getActivity().getSupportFragmentManager().popBackStackImmediate(); //ei luo uutta vaan hyppää backstäckiin eli löytä sinne mistä kutsuttiin
		/*
		Fragment newFragment = new FragmentStart();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		//transaction.replace(R.id.myFragment, newFragment);
		transaction.replace(R.id.container, newFragment);
		//transaction.addToBackStack(null); //Back nappi toimimaan
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
		transaction.commit();
		*/

    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		Player pelaaja = dao.getPlayers().get(position);
		dao.getPlayers().remove(pelaaja);
		dao.deletePlayer(pelaaja.getID());
		adapter = new ArrayAdapter<Player>(getActivity(), android.R.layout.simple_list_item_1, dao.getPlayers());
		listView1.setAdapter(adapter);
		
	}

}
