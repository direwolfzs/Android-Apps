package com.example.sitetracker;

import java.util.ArrayList;
import java.util.List;

public class Linkage {
//fields
	private List<Website> websites;
	
	//constructor
	public Linkage(){
		websites = new ArrayList<Website>(0);
	}//end constructor
	
	//accessor
	public List<Website> getWebsites(){
		return websites;
	}
	
	//add a website to the list
	
	public void addWebsite(Website w){
		websites.add(w);
		
	}
	
	//total number of websites
	public int getNumOfWebsites(){
		int total = 0;
		for (int d = 0; d < websites.size(); d++)
		{
				total++;
			}
		return total;

	}
	
	//get an individual website
	public Website getWebsite(int i){
		return websites.get(i);
	
	}
	
	//get the websites
	public int getNumWebsites(){
		return websites.size();
	
	}
}
