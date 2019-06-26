package jks.physic;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import jks.personnage.PhysicSpriteHeroes;
import jks.personnage.Weapon_AXE;
import jks.physic.objects.PhysicSpriteHp;
import jks.personnage.PhysicSpriteEnnemy;
import jks.vars.GVars_Game;

public class MyContactListener implements ContactListener
{

	
	@Override
	public void beginContact(Contact contact) 
	{
		Object objectA = contact.getFixtureA().getUserData() ; 
		Object objectB = contact.getFixtureB().getUserData() ; 
		Enum_FictureType typeFictureA = Enum_FictureType.findIntence(objectA) ; 
		Enum_FictureType typeFictureB = Enum_FictureType.findIntence(objectB) ; 
		
		if(typeFictureA == Enum_FictureType.PLAYER)
			checkForPlayer((PhysicSpriteHeroes)objectA, objectB, typeFictureB) ;
		else if(typeFictureA == Enum_FictureType.AXE)
			contactWithaxe((Weapon_AXE)objectA,objectB,typeFictureB) ;
		
		if(typeFictureB == Enum_FictureType.PLAYER)
			checkForPlayer((PhysicSpriteHeroes)objectB, objectA, typeFictureA) ;
		else if(typeFictureB == Enum_FictureType.AXE)
			contactWithaxe((Weapon_AXE)objectB,objectA,typeFictureA) ;
	}
	
	private static final float POWER_LVL = 10 * FVars_Physic.PPM; 
	
	private void contactWithaxe(Weapon_AXE axe, Object object, Enum_FictureType ficture) 
	{
		if(ficture == Enum_FictureType.ENNEMY)
		{
			((PhysicSpriteEnnemy) object).getHurt();
			axe.addOneKill() ; 
		} 
		else if(ficture == Enum_FictureType.PLAYER)
		{
			PhysicSpriteHeroes refHero = ((PhysicSpriteHeroes) object) ; 
			((PhysicSpriteHeroes) object).body.applyForceToCenter(refHero.body.getPosition().sub(axe.bodyAxe.getPosition()).scl(POWER_LVL), true);
		}
		
	}


	public void checkForPlayer(PhysicSpriteHeroes player, Object targetObject, Enum_FictureType targetType)
	{
		if(targetType == Enum_FictureType.ENNEMY)
		{
			player.getHurt(player) ; 
			return ;
		}
		if(targetType == Enum_FictureType.HEALING)
		{
			if(player.tryHealing())
			{
				PhysicSpriteHp relative = ((PhysicSpriteHp)targetObject) ; 
				 GVars_Game.toBeDestroy_Body.add(relative.body) ;
				 GVars_Game.hpStack.remove(relative) ; 
			}
			
			return ; 
		}
		if(targetType == Enum_FictureType.CANOE)
		{
			forcePlayerDown(player) ; 
		}
		
		
		checkForDown(player) ;
	}
	
	public void checkForDown(PhysicSpriteHeroes perso)
	{perso.checkForGround = true ; }
	
	public void forcePlayerDown(PhysicSpriteHeroes perso)
	{perso.resetJump(); }

	@Override
	public void endContact(Contact contact) 
	{

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) 
	{

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) 
	{
//		System.out.println("test");
	}

}
