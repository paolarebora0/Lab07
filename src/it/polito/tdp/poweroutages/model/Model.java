package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {

	private PowerOutageDAO podao;
	
	private NercIdMap nercIdMap;
	private List<Nerc> nercList;
	
	private List<PowerOutageEvent> eventList;
	private List<PowerOutageEvent> eventListFiltered;
	
	private List<PowerOutageEvent> solution;
	private int maxAffectedPeople;
	
	public Model() {
		podao = new PowerOutageDAO();
		
		nercIdMap = new NercIdMap();
		nercList = podao.getNercList(nercIdMap);
		eventList = podao.getPowerOutageEventsList(nercIdMap);
		
	}
	
	
	
	public List<PowerOutageEvent> getWorstCase(int maxNumberOfYears, int maxHoursOfOutage, Nerc nerc) {
		
		solution = new ArrayList<PowerOutageEvent>();
		maxAffectedPeople = 0;
		
		eventListFiltered = new ArrayList<PowerOutageEvent>();
		for(PowerOutageEvent event: eventList) {
			
			if(event.getNerc().equals(nerc)) {
				eventListFiltered.add(event);
			}
		}
		
		eventListFiltered.sort(new Comparator<PowerOutageEvent>() {

			@Override
			public int compare(PowerOutageEvent o1, PowerOutageEvent o2) {
				
				return o1.getOutageStart().compareTo(o2.getOutageStart());
			}			
		});
		
		System.out.println("Event list filtered: "+eventListFiltered);
		
		recursive(new ArrayList<PowerOutageEvent>(), maxNumberOfYears,maxHoursOfOutage);
		
		
		return solution;
	}
	
	private void recursive(ArrayList<PowerOutageEvent> arrayList, int maxNumberOfYears, int maxHoursOfOutage) {
		// TODO Auto-generated method stub
		
	}



	public List<Nerc> getNercList() {
		return this.nercList;
	}

}
