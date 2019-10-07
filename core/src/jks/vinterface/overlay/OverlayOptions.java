package jks.vinterface.overlay;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.kotcrab.vis.ui.widget.VisTable;

import jks.tools.Vector2Int;
import jks.vinterface.GVars_Ui;
import jks.vinterface.Index_Interface;
import jks.vinterface.Utils_TexturesAcess;
import jks.vue.Utils_View;

public class OverlayOptions extends OverlayModel
{

	ImageButton retour ;
	
	VisTable mainTable ; 
	
	public OverlayOptions() 
	{
		super(GVars_Ui.baseSkin) ;
		
			
		retour = new ImageButton(Utils_TexturesAcess.buildDrawingRegionTexture(Index_Interface.pauseMenus_Back));
		retour.addListener(new InputListener()
		{
			@Override
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {
				Utils_View.removeCurrentOverlay() ;
				Utils_View.removeFilter() ;
				return true;
	        }
		}) ;
		
		buildGraphicsBloc() ; 
		float decalY = Gdx.graphics.getHeight() / 8.8f ;
		
		retour.setSize(Gdx.graphics.getWidth() / 7.5f, Gdx.graphics.getHeight() / 9.0f);
		
		
		retour.setPosition(Gdx.graphics.getWidth() / 2 - retour.getWidth() / 2, Gdx.graphics.getHeight() / 2.8f);
		
		
		this.setLayoutEnabled(false);
		this.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		this.addActor(retour);
	}
	
	float widthPercent = 4f/5 ;
	float heightPercent = 3.5f/5 ;
	
	public void resize() {
		float sizeWidth = Gdx.graphics.getWidth() * widthPercent ; 
		float sizeHeight = Gdx.graphics.getHeight() * heightPercent ; 
		
		mainTable.setWidth(sizeWidth);
		mainTable.setHeight(sizeHeight);
		mainTable.setPosition((Gdx.graphics.getWidth() - sizeWidth)/2, (Gdx.graphics.getHeight() - sizeHeight)/2);
	}
	
	public VisTable buildGraphicsBloc()
	{
		DisplayMode[] modes = Lwjgl3ApplicationConfiguration.getDisplayModes();
		for(DisplayMode mode : modes)
		{
			System.out.println(mode);
		}
		
		VisTable table = new VisTable() ;
		
//		VisLabel graphics = new VisLabel("Graphics", "Title") ;
//		graphics.setAlignment(Align.center);
//		
//		table.add(graphics).colspan(2) ;
//		table.row() ; 
//		table.add(new VisLabel("Resolution:")) ; 
		
		return table ; 
	}
	
	public VisTable buildSoundsBloc()
	{
		VisTable table = new VisTable() ;
		return table ; 
	}

	@Override
	public void destroy() 
	{this.remove() ;}

	@Override
	public boolean disableMainClickAction() 
	{return true;}

	@Override
	public ArrayList<ArrayList<Button>> mapInterface() 
	{
		ArrayList<ArrayList<Button>> returningList = new ArrayList<ArrayList<Button>>(); 
		ArrayList<Button> buttonList = new ArrayList<>() ;
		buttonList.add(retour) ;
		returningList.add(buttonList) ; 
		return returningList;
	}
	
	@Override
	public Vector2Int startAt()
	{return new Vector2Int(0,0);}
}

/*
	float xPosition = Gdx.graphics.getWidth() * 0.28f;
	float yposition = Gdx.graphics.getHeight() / 2.8f;
 */