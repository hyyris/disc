package com.hyyry.disc;

import com.hyyry.objects.Field;
import com.hyyry.objects.Game;
import com.hyyry.objects.Player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GamePlayer extends Fragment implements OnClickListener {
	
	Button btnLess, btnMore;
	TextView playerTxt, score;
	private Player player;
	private int position = 0;
	//private int pelaajaJarjestysNro;
	
	//private ReplaceListener mListener; //Tää on vaan loppuu varten... SIIRRÄ

	
	public GamePlayer(Player player, int position) {
		this.player = player;
		this.position = position;
		//Alustetaan taulu jossa on pelin tulokset, koska sitä ei tehä missään muualla
		//this.player.setNewGame(Game.field.getLength()); //tarviiko plussaa yks??
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.player_controls, container, false); //tärkeä tämä, jee!
		
		btnLess = (Button)rootView.findViewById(R.id.button_less);
		btnMore = (Button)rootView.findViewById(R.id.button_more);
		
		playerTxt = (TextView)rootView.findViewById(R.id.name);
		score = (TextView)rootView.findViewById(R.id.score);

		Log.i("com.hyyry.disc", "position: " + position);
		score.setText(player.getScore(position) + "");
		playerTxt.setText(player.getName());
		//score.setText(5+"");
		//playerTxt.setText("PELAAJA");
		
		btnLess.setOnClickListener(this);
		btnMore.setOnClickListener(this);

		/*
		mListener = (ReplaceListener) this.getParentFragment(); //Poista ajan kanssa!
		
		Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("pelaaja", pelaajaJarjestysNro);
		mListener.onReplace(args);
		*/
		return rootView;
	}
	
	@Override
    public void onClick(View v) {
		int scoreValue = Integer.parseInt(score.getText().toString());
		
		if ((v == btnLess) && (scoreValue > 0)) {
			scoreValue--;
			score.setText(scoreValue+"");
			player.setScore(position, scoreValue);
		}
		else if (v == btnMore) {
			scoreValue++;
			score.setText(scoreValue+"");
			player.setScore(position, scoreValue);
		}
		else {
			
		}
        

    }
}
