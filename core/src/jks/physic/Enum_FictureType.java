package jks.physic;

import jks.personnage.PhysicSpriteHeroes;
import jks.personnage.Weapon_AXE;
import jks.physic.objects.PhysicSpriteHp;
import jks.personnage.PhysicSpriteEnnemy;

public enum Enum_FictureType 
{
	AXE,
	ENNEMY,
	PLAYER,
	HEALING,
	CANOE,
	NONE,
	
	;
	
	
	public static Enum_FictureType findIntence(Object target)
	{
		if(null == target)
			return NONE ; 
		
		if(target instanceof PhysicSpriteHeroes)
			return PLAYER ;
		if(target instanceof PhysicSpriteEnnemy)
			return ENNEMY ; 
		if(target instanceof Weapon_AXE)
			return AXE ; 
		if(target instanceof PhysicSpriteHp)
			return HEALING ; 
		if("CANOE".equals(target.toString()))
			return CANOE ; 
		
		
		System.out.println(target);
		System.out.println("IMPOSSIBLE DE TROUVER INTANCE!");
		return NONE ; 
	}
	
}
