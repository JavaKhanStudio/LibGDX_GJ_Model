package jks.card.model.card;

import jks.card.model.Enum_Ressource;
import jks.card.model.Player;
import jks.card.model.Unit;

public enum Enum_Action 
{

	AFFECT_RESSOURCE,
	SUMMON_CREATURE
	; 
	
	
	public boolean activate(Player caster, Unit target, int power, Object joker)
	{
		switch(this)
		{
			case AFFECT_RESSOURCE :
			{
				Enum_Ressource ressource = (Enum_Ressource)joker ;
				target.affectRessource(ressource, power);
				return true ;
			}
			case SUMMON_CREATURE :
			{
				
				return true ;
			}
		}
		return false ; 
	}
	
}
