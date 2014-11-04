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

public class FragmentNewCourse extends Fragment implements OnClickListener {
	
	Button btn1, btn2, btn3;
	EditText name;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.newcourse_fragment, container, false);
		
		btn1 = (Button)rootView.findViewById(R.id.btnSaveC);
		btn2 = (Button)rootView.findViewById(R.id.btn1);
		btn3 = (Button)rootView.findViewById(R.id.btn2);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
		name = (EditText)rootView.findViewById(R.id.nimi);
		
		Field.setHolesCount(0); //Resettaa countin jotta ei jatketa siitä mihin viimeks jäätiin
		Field.resetHelperHole(); //Resettaa staattiset holet jotta niitä voi käyttää uudestaan
		
		return rootView;
	}

	@Override
    public void onClick(View v) {
		
		if (v == btn1) {
			//TODO seivaus... alempi on perjaatteessa seivaus!
			String nimi = name.getText().toString();
			
			if ((Field.getHolesCount() > 0) && (nimi.length() > 0)) {
				Field field = new Field();
				field.setHoles(Field.helperHoles);
				field.setName(nimi);
				Field.addField(field);
			}
			else {
				//TODO ilmotus ettei tallenneta ku ei oo mitään tallennettavaa
			}
			
			
			Fragment newFragment = new FragmentStart();
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			//transaction.replace(R.id.myFragment, newFragment);
			transaction.replace(R.id.container, newFragment);
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
			transaction.commit();
			
		}
		else if (v == btn2) {
			Fragment newFragment = new FragmentHole();
			FragmentTransaction transaction = getFragmentManager().beginTransaction();
			transaction.add(R.id.holesList, newFragment);
			
			Field.removeHelper.add(newFragment);
			
			//transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); //Turha, mut näitä voi hyödyntää myöhemmin
			transaction.commit();
		}
		else {
			if (Field.removeHelper.size() < 1)
				return;
			else {
				Field.removeOne();
				Fragment newFragment = Field.removeHelper.get(Field.removeHelper.size()-1);
				Field.removeHelper.remove(Field.removeHelper.size()-1);
				getFragmentManager().beginTransaction().remove(newFragment).commit();
			}
			
		}
        
	}
	
}
