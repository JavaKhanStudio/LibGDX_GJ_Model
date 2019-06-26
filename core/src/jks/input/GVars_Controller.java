package jks.input;

import java.util.HashMap;

import com.badlogic.gdx.controllers.Controller;

import jks.personnage.index.SIW_Data;

public class GVars_Controller 
{
	public static HashMap<Controller,Player_Inputs> playerList ; 
	public static Player_Inputs pcPlayer ; 
	
	public static void init()
	{
		playerList = new HashMap<Controller,Player_Inputs>() ; 
	}
	
	public static Player_Inputs getPlayer(Controller controller)
	{return playerList.get(controller) ;}
	
	
	
	public static void act(float delta)
	{
		for(Player_Inputs player : playerList.values())
		{player.act(delta);}
	}
}
