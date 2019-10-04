package jks.vinterface;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import jks.tools.Vector2Int;
import jks.vinterface.controlling.ControllableInterface;
import jks.vinterface.controlling.Utils_Controllable;
import jks.vinterface.overlay.OverlayPause;
import jks.vue.Utils_View;

public class GVars_Ui implements Runnable 
{

	public static Skin baseSkin;
	public static Stage mainUi;
	public static Table interaction;
	
	public static Vector2Int cursorPos ; 
	
	public static ControllableInterface currentControllable;
	public static ArrayList<ArrayList<Button>> buttonMap ;
	
	public static Table bottomScore ; 

	public static void init() 
	{
		baseSkin = new Skin(Gdx.files.internal("skins/uis/basic/uiskin.json"));
		
		mainUi = new Stage();
		Gdx.input.setInputProcessor(mainUi);
	}

	private static float width = 0.7f; 
	private static float height = 0.12f ; 
	
	public static void reset()
	{
		mainUi = new Stage();
		Gdx.input.setInputProcessor(mainUi);
	}

	@Override
	public void run() 
	{init();}
	
	public static void setPause(boolean setPause) 
	{
		if(setPause) 
		{
			Utils_View.setOverlay(new OverlayPause());
		}
		else
		{
			Utils_View.removeCurrentOverlay() ;
			Utils_View.removeFilter() ;
		}
	}
	
	public static void activedInterface(ControllableInterface newInterface)
	{
		currentControllable = newInterface ;
		buttonMap = newInterface.mapInterface() ; 
		cursorPos = newInterface.startAt() ;
		Button currentButton = Utils_Controllable.getCurrentButton() ;
		currentButton.getClickListener().enter(null, 0, 0, -1, null) ;
	}

	public static void selectButton()
	{
		InputEvent event1 = new InputEvent();
		event1.setType(InputEvent.Type.touchDown);
		buttonMap.get(cursorPos.x).get(cursorPos.y).fire(event1);
		System.out.println("nothing");
	}
	
	public static void resetInterface()
	{
		if(currentControllable == null) return ;
		
		currentControllable = currentControllable.getClosingLink() ;
		if(currentControllable != null)
		{
			activedInterface(currentControllable) ;
		}
		else
		{
			buttonMap = null ; 
			cursorPos = null ; 
		}
	
	}

}