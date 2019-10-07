package jks.vinterface.overlay;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.utils.Align;
import com.kotcrab.vis.ui.widget.VisLabel;
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
	VisTable graphicBloc ; 
	VisTable soundBloc ; 
	
	HashMap<String,DisplayMode> displayMap ;
	ArrayList<String> displayList ; 
	
	public OverlayOptions() 
	{
		super(GVars_Ui.baseSkin) ;
		this.setLayoutEnabled(false);
			
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
			
		mainTable = new VisTable() ;
		mainTable.setTouchable(Touchable.childrenOnly);
		mainTable.setBackground(Utils_TexturesAcess.buildDrawingRegionTexture(Index_Interface.empty));
		graphicBloc = buildGraphicsBloc(); 
		soundBloc = buildSoundsBloc() ; 
		
		mainTable.addActor(graphicBloc);
		mainTable.addActor(soundBloc);
		resize() ; 
		
		this.addActor(mainTable);
		this.addActor(retour);
	}
	
	float widthPercent = 4f/5 ;
	float heightPercent = 3.5f/5 ;
	
	public void resize() 
	{
		float sizeWidth = Gdx.graphics.getWidth() * widthPercent ; 
		float sizeHeight = Gdx.graphics.getHeight() * heightPercent ; 
		
		mainTable.setWidth(sizeWidth);
		mainTable.setHeight(sizeHeight);
		mainTable.setPosition((Gdx.graphics.getWidth() - sizeWidth)/2, (Gdx.graphics.getHeight() - sizeHeight)/2);
		
		retour.setSize(Gdx.graphics.getWidth() / 7.5f, Gdx.graphics.getHeight() / 9.0f);
		retour.setPosition(0, Gdx.graphics.getHeight() / 3.8f);
		
		this.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public VisTable buildGraphicsBloc()
	{
		VisTable table = new VisTable() ;
		
		VisLabel graphics = new VisLabel("Graphics") ;
		graphics.setAlignment(Align.center);
		
		buildDisplayList() ; 
		
		final SelectBox<String> selectBox = new SelectBox<String>(GVars_Ui.baseSkin);
		String[] resolutions = new String[displayMap.size()];
		
		int a = 0; 
		for(String value : displayList)
		{resolutions[a++] = value ;}
		
		selectBox.setItems(resolutions);
		
		table.add(graphics).colspan(2) ;
		table.row() ; 
		table.add(new VisLabel("Resolution:")) ; 
		table.add(selectBox) ;
		
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
	
	public void buildDisplayList()
	{
		DisplayMode[] modes = Lwjgl3ApplicationConfiguration.getDisplayModes();
		displayMap = new HashMap<String,DisplayMode>() ;
		displayList = new ArrayList<>() ;
		
		for(DisplayMode mode : modes)
		{
			if(mode.width >= 800 
					&& mode.refreshRate == 60
					)
			{
				float ratio = (float)mode.width/(float)mode.height ; 
				if(ratio < 1.778 && ratio > 1.7)
				{
					String displaySize = mode.width + "x" + mode.height ; 
					displayMap.put(displaySize, mode) ; 
					displayList.add(displaySize) ;
				}	
			}
		} 
	}
	
	@Override
	public Vector2Int startAt()
	{return new Vector2Int(0,0);}
}

/*
	float xPosition = Gdx.graphics.getWidth() * 0.28f;
	float yposition = Gdx.graphics.getHeight() / 2.8f;
 */