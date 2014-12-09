package com.hyyry.disc;

import com.hyyry.database.FieldDAO;
import com.hyyry.objects.Field;
import com.hyyry.objects.Game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class ChooseCourse extends Fragment implements OnItemClickListener {
	
	private FieldDAO dao;
	private ArrayAdapter<Field> adapter;
	private ListView listView1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.choose_course, container, false);
		
		dao = new FieldDAO(getActivity());
		
		//Lista toimimaan
		listView1 = (ListView)rootView.findViewById(R.id.list);
		adapter = new ArrayAdapter<Field>(getActivity(), android.R.layout.simple_list_item_1, dao.getFields());
		listView1.setAdapter(adapter);
		
		listView1.setOnItemClickListener(this);
		
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		//Olion saaminen klikin perusteella
		Field course = dao.getFields().get(position);
		
		Game.field = course; //Asetetaan kenttä jolla pelataan
		Toast.makeText(getActivity(), "Valitsit radan: " + Game.field.getName(), Toast.LENGTH_LONG).show();
		
		Fragment newFragment = new ChoosePlayers();
		FragmentTransaction transaction = getFragmentManager().beginTransaction();
		//transaction.replace(R.id.myFragment, newFragment);
		transaction.replace(R.id.container, newFragment);
		transaction.addToBackStack(null); //Back nappi toimimaan
		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
		transaction.commit();
		
	}

}
