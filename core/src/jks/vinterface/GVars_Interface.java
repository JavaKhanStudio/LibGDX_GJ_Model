package jks.vinterface;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import jks.personnage.ScoreLabel;
import jks.tools.Vector2Int;
import jks.vinterface.controlling.ControllableInterface;
import jks.vinterface.controlling.Utils_Controllable;
import jks.vinterface.overlay.OverlayPause;
import jks.vue.Utils_View;

public class GVars_Interface implements Runnable 
{

	public static Skin baseSkin;
	public static Stage mainInterface;
	public static Table interaction;
	
	public static Vector2Int cursorPos ; 
	
	public static ControllableInterface currentControllable;
	public static ArrayList<ArrayList<Button>> buttonMap ;
	
	public static Table bottomScore ; 
	
	public static TextureRegionDrawable scoreRegion ;
	public static TextureRegionDrawable deathRegion ;

	
	public static void init() 
	{
//		baseSkin = Init_UI.loadSkin();
		baseSkin = new Skin(Gdx.files.internal("skin/freezing-ui.json"));
		mainInterface = new Stage();
		Gdx.input.setInputProcessor(mainInterface);
		
		scoreRegion = Utils_Interface.buildDrawingRegionTexture("ui/score.png") ;		
		deathRegion = Utils_Interface.buildDrawingRegionTexture("ui/death.png") ;
		
		bottomScore = new Table() ; 
		bottomScore.setWidth(Gdx.graphics.getWidth() * width);
		bottomScore.setHeight(Gdx.graphics.getHeight() * height);
		bottomScore.setPosition(
				(Gdx.graphics.getWidth() - bottomScore.getWidth())/2, 
				bottomScore.getHeight()/8);
		ScoreLabel.buttonSize = bottomScore.getHeight()/3f ; 
		
		mainInterface.addActor(bottomScore);
	}

	private static float width = 0.7f; 
	private static float height = 0.12f ; 
	
	public static void reset()
	{
		mainInterface = new Stage();
		resetInterface();
		Gdx.input.setInputProcessor(mainInterface);
	}

	@Override
	public void run() {
		init();
	}
	
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