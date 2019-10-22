package jks.vinterface;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;

import jks.tools.Vector2Int;
import jks.vinterface.controlling.Controllable_Interface;
import jks.vinterface.controlling.Utils_Controllable;
import jks.vinterface.overlay.OverlayPause;
import jks.vue.Utils_View;

public class GVars_UI implements Runnable 
{

	public static Skin baseSkin;
	public static Stage mainUi;
	public static Table interaction;
	
	public static Vector2Int cursorPos ; 
	
	public static Controllable_Interface currentControllable;
	public static ArrayList<ArrayList<Button>> buttonMap ;
	
	public static Table bottomScore ; 
	
	public static FreeTypeFontGenerator generator ;
	public static FreeTypeFontGenerator generator2 ;
	public static FreeTypeFontParameter parameter ;
	public static BitmapFont font_Title ; 
	public static BitmapFont font_Main ; 
	public static BitmapFont fontont_Second ; 
	
	public static LabelStyle labelStyle_Title ;
	public static LabelStyle labelStyle_Second ; 

	public static void init() 
	{
		baseSkin = new Skin(Gdx.files.internal("ui/skins/basic/uiskin.json"));
		VisUI.load(GVars_UI.baseSkin);
		mainUi = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(mainUi);
		
		prebuild() ; 
		resize() ;	
	}
	
	public static void prebuild()
	{
		generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/fonts/OptimusPrinceps.ttf"));
		generator2 = new FreeTypeFontGenerator(Gdx.files.internal("ui/fonts/GeosansLight.ttf"));
		parameter = new FreeTypeFontParameter();
		
		labelStyle_Title = new LabelStyle(baseSkin.get("default", LabelStyle.class)) ; 
		labelStyle_Second = new LabelStyle(baseSkin.get("default", LabelStyle.class)) ;
	}
	
	public static void resize()
	{
		parameter.size = (int) (Gdx.graphics.getWidth()/fontTitleSizeDivide) ;
		font_Title = generator.generateFont(parameter);
		
		parameter.size = (int) (Gdx.graphics.getWidth()/fontBasicSizeDivide) ;
		font_Main = generator.generateFont(parameter);
		fontont_Second = generator2.generateFont(parameter);
		font_Main.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
	
		labelStyle_Title.font = font_Title ; 
		labelStyle_Second.font = fontont_Second ; 
	}

	private static float fontTitleSizeDivide = 30 ; 
	private static float fontBasicSizeDivide = 40 ; 
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
	
	public static void activedInterface(Controllable_Interface newInterface)
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
		event1.setType(InputEvent.Type.touchUp);
		buttonMap.get(cursorPos.x).get(cursorPos.y).fire(event1);
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