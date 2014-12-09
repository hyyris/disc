package com.hyyry.disc;

import com.hyyry.objects.Game;
import com.hyyry.objects.Player;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class FirstFragment extends Fragment implements ReplaceListener {
    
    private String title; //positionilla haettu baari
    private int page;
    private ReplaceListener mListener;
	
	// newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page) {
    	FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("position", page);
        //args.putString("title", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    	
    }
    
    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("position");
        //title = getArguments().getString("title");
        Log.wtf("com.hyyry.disc", "2-onCreate " + page);
    }

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//mListener = (ReplaceListener) this.getParentFragment();
        LinearLayout ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setId(10000); //onko joku pointti? ...ainakin et voi viitata suoraan tonnilla et mihin laitetaan asioita
        
        //if(title.equalsIgnoreCase("viimenen"))
       // 	Log.w("com.hyyry.disc", "VIIMENEN TOIMII");
        if (getChildFragmentManager().findFragmentByTag("initialTag") == null) {
        	createPlayers(ll);
        }
        
        return ll;
		
	}
	
    private View createPlayers(LinearLayout view) {
    	//TODO otsikko kentät Pelaaja: | Par etc
    	FragmentTransaction transaction;
    	GamePlayer iif;
    	//Log.w("com.hyyry.disc", "Kierros: " + page);
    	
    	for (int i = 0; i < Game.players.size(); i++) {
    		//Log.i("com.hyyry.disc","LOOP-DA-DIIDAA:" + i);
    		iif = new GamePlayer(Game.players.get(i), getArguments().getInt("position"));
    		
    		transaction = getChildFragmentManager().beginTransaction();
    		transaction.add(view.getId(), iif, "initialTag");
    		transaction.commit();
    		
    	}
    	
    	return view;
    }
    
    // Turha koska ei käytetä ReplaceListener iä..
    // required because it seems the getChildFragmentManager only "sees"
    // containers in the View of the parent Fragment.   
    @Override
    public void onReplace(Bundle args) {
    	Log.wtf("com.hyyry.disc", "TULLAANKO TÄNNE KOSKAAN? FirstFragment.onReplace");
    	/*
        if (getChildFragmentManager().findFragmentByTag("afterTag") == null) {
        	//TODO otsikko kentät Pelaaja: | Par etc
        	FragmentTransaction transaction;
        	GamePlayer iif;
        	for (int i = 0; i < Game.players.size(); i++) {
        		//Log.i("com.hyyry.disc","LOOP-DA-DIIDAA:" + i);
        		iif = new GamePlayer(Game.players.get(i), getArguments().getInt("position"));
        		transaction = getChildFragmentManager().beginTransaction();
        		transaction.replace(10000, iif, "afterTag");
        		transaction.commit();
        		
        	}
        	
        }*/
    }
	
}
