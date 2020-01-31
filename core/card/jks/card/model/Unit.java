package jks.card.model;

import java.util.HashMap;
import java.util.Map;

public class Unit 
{

	String name ;
	Player refUnit; 
	Map<Enum_Ressource, Integer> values ; 
	
	public Unit()
	{
		values = new HashMap<Enum_Ressource, Integer>() ; 
		for(Enum_Ressource ressource : Enum_Ressource.values())
		{
			values.put(ressource, 0) ; 
		}
	}
	
	public Unit(Player player)
	{
		super() ; 
		refUnit = player ; 
	}
	
	public void setRessource(Enum_Ressource ressource, int value)
	{
		values.put(ressource,value) ; 
	}
	
	public void affectRessource(Enum_Ressource ressource, int power)
	{
		int current = values.get(ressource) ; 
		current += power ; 
		values.put(ressource, current) ; 
	}
	
}
