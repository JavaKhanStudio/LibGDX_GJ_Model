package jks.vinterface.controlling;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

import jks.tools.Vector2Int;
import jks.vinterface.GVars_Interface;

public interface ControllableInterface 
{
	public ArrayList<ArrayList<Button>> mapInterface() ;
	
	public default Vector2Int startAt()
	{return new Vector2Int() ;}
	
	public default void activateInterfaceControle()
	{GVars_Interface.activedInterface(this) ;}
	
	public default ControllableInterface getClosingLink()
	{return null ;}
	
	public ControllableInterface currentControllable = null;
}
