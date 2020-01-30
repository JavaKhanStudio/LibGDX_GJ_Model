package jks.card.model;

import java.util.List;

public class PlayCard 
{

	Unit unit ; 
	// Play first, play in sequence. 
	public void playCard(Card card, List<Unit> targets)
	{
		unit.energy = unit.energy - card.cost ;
		for(Effect effect : card.self) 
		{
			
		}
		
		for(Effect effect : card.self) 
		{
			
		}
		
		for(Effect effect : card.self) 
		{
			
		}
	}
	
	
	public void affectUnit(Unit unit, Enum_Effect effect, int power) 
	{
		
	}
	
	
	
}