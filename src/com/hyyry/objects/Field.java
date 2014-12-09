package com.hyyry.objects;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;


public class Field {

	private int ID;
	private String name = "";
	private List<Integer> holes = new ArrayList<Integer>();
	private boolean selected;
	
	public static List<Field> fields = new ArrayList<Field>(); //Kaikki kent‰t
	//public static Field gameField = new Field(); //Kentt‰ jolla pelataan
	
	public static List<Integer> helperHoles = new ArrayList<Integer>();
	public static List<Fragment> removeHelper = new ArrayList<Fragment>();
	private static int holesCount;
	
	public Field() {
		setID();
	}
	
	public static void addField(Field field) {
		//TODO kirjottaa SQL‰‰n
		fields.add(field);
	}
	
	public boolean isSelected() {
		    return selected;
	}
	
	public void setSelected(boolean selected) {
	    this.selected = selected;
	}
		 
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	private void setID() {
		this.ID = 0; //this.ID = tietokantakontrolleri.nextFree();
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void setHoles(List<Integer> holes) {
		this.holes.addAll(holes);
		
	}
	
	public List<Integer> getHoles() {
		return this.holes;
		
	}
	
	public void setPar(int hole, int par) {
		if (hole >= this.holes.size())
			this.holes.add(par);
		else
			this.holes.set(hole, par);
		
	}
	
	public int getPar(int hole) {
		return this.holes.get(hole);
	}
	
	public int getLength() {
		return this.holes.size();
	}
	
	public void addHole(int par) {
		this.holes.add(par);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	
	/* ====== helpperi list‰tty  =====*/
	
	public static void setHolesCount(int i) {
		holesCount = i;
	}
	
	public static int getHolesCount() {
		return holesCount;
	}
	
	public static void addOne() {
		holesCount++;
	}
	
	public static void removeOne() {
		helperHoles.remove(helperHoles.size()-1);
		holesCount--;
	}
	
	public static void setHelperHole(int hole, int par) {
		if (hole >= helperHoles.size())
			helperHoles.add(par);
		else
			helperHoles.set(hole, par);
		
	}
	
	public static void resetHelperHole() {
		helperHoles.clear();
	}
	
	/* ================== muutos int <-> String ==================== */
	
	public String getHolesString() {
		String holesString = "";
		for (int i = 0; i < holes.size(); i++) {
			holesString += holes.get(i) + " ";
			
		}
		
		return holesString;
	}
	
	public void setHoles(String lista) {
		String[] taulukko = lista.split(" ");
		for (int i = 0; i < taulukko.length; i++) {
			this.setPar(i, Integer.parseInt(taulukko[i])); //Alkaa nollasta, onko ongelma???
			//System.out.println(taulukko[i]);
		}
	}
	
}
