package jks.vinterface;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import jks.sounds.GVars_AudioManager;
import jks.tools.Vector2Int;
import jks.vars.GVars_Heart;
import jks.vinterface.controlling.ControllableInterface;
import jks.vue.models.Vue_Game;

public class Page_Main extends Table implements ControllableInterface
{
	TextureRegion upRegion ;
	TextureRegion downRegion ;
	BitmapFont buttonFont ;
		
	int screenWidth ;
	int screenHeight ;
	
	int buttonSizeX ;
	int buttonSizeY ;
	
	float buttonX ;
	float buttonY ;
	float decalY ; 
	float decalX ; 
		
	public ImageButton start ;
	public ImageButton credit ;
	public ImageButton quit ;   	

	public Image logo ;
	
	public Page_Main()
	{
		init() ; 
		resize(); 
		buildEvents() ;
		

		this.add(start) ;
		this.add(credit) ;
		this.add(quit) ;
		this.add(logo); 
//		GVars_Interface.mainInterface.addActor(start);
//		GVars_Interface.mainInterface.addActor(credit);
//		GVars_Interface.mainInterface.addActor(quit);
		
		GVars_Ui.activedInterface(this);
	}
	
	private void init()
	{
		start = new ImageButton(Index_Interface.mainMenus_PlayButton) ; 
		credit = new ImageButton(Index_Interface.mainMenus_CreditButton) ; 
		quit =  new ImageButton(Index_Interface.mainMenus_Quit) ;	
		logo = new Image(Index_Interface.mainMenus_Logo) ;
	}

	private void resize() 
	{
		this.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.defaults().space(25);
		this.setFillParent(true) ;
		this.setTransform(false);
		buttonX = Gdx.graphics.getWidth()/8.5f ;
		buttonY = Gdx.graphics.getWidth()/9.5f ;
		decalY = 0 ;
		decalX = buttonX * 0.8f ;
		
		start.setSize(buttonX, buttonY);
		start.setPosition(Gdx.graphics.getWidth() - buttonX - decalX, (buttonY + decalY) * 1f );
			
		credit.setSize(buttonX, buttonY);
		credit.setPosition(Gdx.graphics.getWidth() - buttonX - decalX, (buttonY + decalY) * 1f );
		
		quit.setSize(buttonX, buttonY);
		quit.setPosition(Gdx.graphics.getWidth() - buttonX - decalX, (buttonY + decalY) * 0f );
		
		logo.setSize(Gdx.graphics.getWidth()/4.5f, Gdx.graphics.getHeight()/4.5f);
		logo.setPosition(Gdx.graphics.getWidth() - logo.getWidth() -  decalX/3, Gdx.graphics.getHeight() - logo.getHeight() - decalX/3);
		
	}
	
	Button buildButton (String text, boolean toggle)
	{
		Button button = new Button(GVars_Ui.baseSkin);
		button.setSize(buttonX, buttonY);
		button.pad(buttonY,buttonX,buttonY,buttonX);
		button.setClip(true);
		
		Label label = new Label(text,GVars_Ui.baseSkin);
		
		label.setAlignment(Align.bottomRight);
		button.add(label);

		return button;
	}
	
	
	private void buildEvents() 
	{
		start.addListener(new InputListener()
		{
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {	
				GVars_AudioManager.StopAndDisposeMusic(); 
				GVars_Heart.changeVue(new Vue_Game(),true);
				return true;
			}
		
		});
		
		
		quit.addListener(new InputListener()
		{
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {
				System.exit(0);
				return true;
			}
		});
	}

	@Override
	public ArrayList<ArrayList<Button>> mapInterface() 
	{
		ArrayList<ArrayList<Button>> returningList = new ArrayList<ArrayList<Button>>(); 
		ArrayList<Button> buttonList = new ArrayList<>() ;
		buttonList.add(quit) ;
		buttonList.add(start) ;
		returningList.add(buttonList) ; 
		return returningList;
	}
	
	@Override
	public Vector2Int startAt()
	{return new Vector2Int(0,1) ;}
}
