package it.polito.tdp.poweroutages.model;

import java.util.HashMap;
import java.util.Map;

public class NercIdMap {

	private Map<Integer, Nerc> map;
	
	public NercIdMap() {
		this.map = new HashMap<Integer, Nerc>();
	}
	
	public Nerc get(int id) {
		return map.get(id);
	}
	
	public Nerc get(Nerc nerc) {
		
		Nerc old = map.get(nerc.getId());
		if(old == null) {
			map.put(nerc.getId(), nerc);
			return nerc;
		} else {
			return old;
		}
		
	}
	
	public void put(int id, Nerc object) {
		map.put(id, object);
	}
	
}
