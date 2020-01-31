package jks.card.model.card;

import java.util.List;

import jks.card.model.Enum_Ressource;
import jks.card.model.Player;

public class Effect 
{
	Enum_Action effect;
	List<List<Condition>> condition ;
	boolean positive ;
	
	int power ;
	Enum_Ressource affectedBy ;
	
	public boolean checkIfActive(Player caster, Player target)
	{
		if(condition.size() == 0)
			return true ; 
		
		boolean isActive = false ; 
		for(List<Condition> eachCondition: condition)
		{
			isActive = false ;
			for(Condition oneMustBeTrue : eachCondition)
				isActive = isActive || oneMustBeTrue.check(caster,target) ; 
			
			if(!isActive)
				return false ; 
		}
		
		return isActive ; 
	}
	
}
