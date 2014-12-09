package com.hyyry.disc;


import com.hyyry.objects.Field;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FragmentHole extends Fragment implements OnClickListener {
	
	Button btnLess, btnMore;
	TextView holeNro, par;
	
	private ReplaceListener mListener; //Tää on vaan loppuu varten... SIIRRÄ
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.hole_fragment, container, false); //tärkeä tämä, jee!
		
		btnLess = (Button)rootView.findViewById(R.id.btnLess);
		btnMore = (Button)rootView.findViewById(R.id.btnMore);
		
		holeNro = (TextView)rootView.findViewById(R.id.holeNr);
		par = (TextView)rootView.findViewById(R.id.par);
		
		par.setText("1");
		
		
		Field.addOne();
		holeNro.setText(Field.getHolesCount()+"");
		
		int holeNroValue = Integer.parseInt(holeNro.getText().toString());
		Field.setHelperHole((holeNroValue-1), 1);
		
		btnLess.setOnClickListener(this);
		btnMore.setOnClickListener(this);
	   
		 mListener = (ReplaceListener) this.getParentFragment(); //Poista ajan kanssa!
		
		return rootView;
	}
	
	@Override
    public void onClick(View v) {
		int parValue = Integer.parseInt(par.getText().toString());
		int holeNroValue = Integer.parseInt(holeNro.getText().toString());
		
		if ((v == btnLess) && (parValue > 0)) {
			parValue--;
			par.setText(parValue+"");
			
			Field.setHelperHole((holeNroValue-1), parValue);
		}
		else if (v == btnMore) {
			parValue++;
			par.setText(parValue+"");
			
			Field.setHelperHole((holeNroValue-1), parValue);
		}
		else {
			
		}
        

    }

}
