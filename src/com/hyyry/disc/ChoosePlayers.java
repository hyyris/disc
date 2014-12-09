package com.hyyry.disc;

import com.hyyry.database.PLayerDAO;
import com.hyyry.objects.Game;
import com.hyyry.objects.Player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ChoosePlayers extends Fragment implements OnClickListener {
	
	private PLayerDAO dao;
	private ListView listView1;
	private ArrayAdapter<Player> adapter;
	Button button1, button2;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.choose_players, container, false);

		
		dao = new PLayerDAO(getActivity());
		
		//Lista toimimaan
		listView1 = (ListView)rootView.findViewById(R.id.list);
		//adapter = new ArrayAdapter<Player>(getActivity(), android.R.layout.simple_list_item_1, dao.getPlayers());
		adapter = new AdapterPlayersList(getActivity(), dao.getPlayers()); //TÄMÄ!
		listView1.setAdapter(adapter);
		//listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); // Voi valita useemman
		
		button1 = (Button)rootView.findViewById(R.id.button_less);
		button2 = (Button)rootView.findViewById(R.id.btnCancel);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
		Game.players.clear(); //kaiken varalta. En jaksa miettii, mut sais kai kaadettuu ku rämppäis oikein ilman tätä...
		
		return rootView;
	}
	
	
	
	@Override
	public void onClick(View v) {
		Fragment newFragment;
		
		if (v == button1) {
			newFragment = new FragmentNewPlayer();
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			//transaction.replace(R.id.myFragment, newFragment);
			transaction.replace(R.id.container, newFragment);
			transaction.addToBackStack(null); //Back nappi toimimaan
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN); //Turha, mut näitä voi hyödyntää myöhemmin
			transaction.commit();
			
		}
		else { //Play
			newFragment = new FragmentGame();
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.replace(R.id.container, newFragment);
			transaction.addToBackStack(null); //Back nappi toimimaan
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			transaction.commit();
			
			//Player.gamePlayers saa haettuu peliin osallistuvat pelaajat
			//Toast.makeText(getActivity(), "Valitut " + Player.gamePlayers.toString(), Toast.LENGTH_LONG).show();
		}

    }

}
