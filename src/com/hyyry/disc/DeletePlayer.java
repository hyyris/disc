package com.hyyry.disc;

import com.hyyry.database.PLayerDAO;
import com.hyyry.objects.Player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DeletePlayer extends Fragment implements OnClickListener, OnItemClickListener {

	private Button btn1;
	private PLayerDAO dao;
	private ArrayAdapter<Player> adapter;
	private ListView listView1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.delete, container, false);
		
		dao = new PLayerDAO(getActivity());
		
		btn1 = (Button)rootView.findViewById(R.id.btnCancel);
		btn1.setOnClickListener(this);
		
		//Lista toimimaan
		listView1 = (ListView)rootView.findViewById(R.id.list);
		adapter = new ArrayAdapter<Player>(getActivity(), android.R.layout.simple_list_item_1, dao.getPlayers());
		listView1.setAdapter(adapter);
		
		listView1.setOnItemClickListener(this);
		//listView1.setOnItemClickListener((android.widget.AdapterView.OnItemClickListener)this);
		
		return rootView;
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		Player pelaaja = dao.getPlayers().get(position);
		dao.getPlayers().remove(pelaaja);
		dao.deletePlayer(pelaaja.getID());
		adapter = new ArrayAdapter<Player>(getActivity(), android.R.layout.simple_list_item_1, dao.getPlayers());
		listView1.setAdapter(adapter);
		getActivity().getSupportFragmentManager().popBackStackImmediate(); //Lähtee pois...
		
	}
	
	@Override
    public void onClick(View v) {   
		getActivity().getSupportFragmentManager().popBackStackImmediate(); //ei luo uutta vaan hyppää backstäckiin eli löytä sinne mistä kutsuttiin


    }
}
