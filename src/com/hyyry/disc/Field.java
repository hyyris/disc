package com.hyyry.disc;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;

public class Field {

	private int ID;
	private String name = "";
	private List<Integer> holes = new ArrayList<Integer>();
	
	public static List<Field> fields = new ArrayList<Field>();
	
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
	
	public void setName(String name) {
		this.name = name;
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
	
}
