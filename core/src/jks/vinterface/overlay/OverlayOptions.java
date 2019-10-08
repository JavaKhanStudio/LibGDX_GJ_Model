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
import com.kotcrab.vis.ui.widget.VisCheckBox;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;

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
	VisTable prefBloc ; 
	VisTable languageBloc ;
	
	HashMap<String,DisplayMode> displayMap ;
	ArrayList<String> displayList ; 
	
	String frames = Index_Interface.frame_GraySmoke ;
	
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
		mainTable.setBackground(Utils_TexturesAcess.buildDrawingRegionTexture(frames));
		
		graphicBloc = buildGraphicsBloc(); 
		graphicBloc.setBackground(Utils_TexturesAcess.buildDrawingRegionTexture(frames));
		
		soundBloc = buildSoundsBloc() ; 
		soundBloc.setBackground(Utils_TexturesAcess.buildDrawingRegionTexture(frames));
		
		prefBloc = buildSoundsBloc() ; 
		prefBloc.setBackground(Utils_TexturesAcess.buildDrawingRegionTexture(frames));
		
		languageBloc = buildSoundsBloc() ; 
		languageBloc.setBackground(Utils_TexturesAcess.buildDrawingRegionTexture(frames));
		
		mainTable.addActor(graphicBloc);
		mainTable.addActor(soundBloc);
		mainTable.addActor(prefBloc);
		resize() ; 
		
		this.addActor(mainTable);
		this.addActor(retour);
	}
	
	float widthPercent = 4f/5 ;
	float heightPercent = 3.5f/5 ;
	
	public void resize() 
	{
		float sizebuttonX = Gdx.graphics.getWidth() / 7.5f ;
		float decalSideX = Gdx.graphics.getWidth() / 23f ;
		float size_Main_Width = Gdx.graphics.getWidth() - (decalSideX * 2) - sizebuttonX * 1.5f ; 
		float size_Main_Height = Gdx.graphics.getHeight() * heightPercent ; 
		float decalY = size_Main_Height / 20f ;
		
		
		mainTable.setWidth(size_Main_Width);
		mainTable.setHeight(size_Main_Height);
		mainTable.setPosition((Gdx.graphics.getWidth() - size_Main_Width)/2, (Gdx.graphics.getHeight() - size_Main_Height)/2);
		
		float bloc_Width = (size_Main_Width/2) - (decalSideX * 1.5f) ; 
		float bloc_Height = (size_Main_Height/2) - (decalY * 1.5f) ; 
		
		graphicBloc.setWidth(bloc_Width);
		graphicBloc.setHeight(bloc_Height);
		graphicBloc.setPosition(decalSideX, graphicBloc.getHeight() + decalY * 2);
		
		soundBloc.setWidth(bloc_Width);
		soundBloc.setHeight(bloc_Height);
		soundBloc.setPosition((decalSideX * 2) + bloc_Width, graphicBloc.getHeight() + decalY * 2);
	
		prefBloc.setWidth(bloc_Width);
		prefBloc.setHeight(bloc_Height);
		prefBloc.setPosition(decalSideX, decalY);
		
		languageBloc.setWidth(bloc_Width);
		languageBloc.setHeight(bloc_Height);
		languageBloc.setPosition(decalSideX, decalY);
		
		retour.setSize(sizebuttonX, Gdx.graphics.getHeight() / 9.0f);
		retour.setPosition(0, Gdx.graphics.getHeight() / 3.8f);
		
		this.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public VisTable buildGraphicsBloc()
	{
		VisTable table = new VisTable() ;
		
		VisLabel graphics = new VisLabel("Graphics") ;
		graphics.setAlignment(Align.center);
		

		final SelectBox<String> selectBox_Resolution = buildResolutionBox() ; 	
		final SelectBox<String> selectBox_FPS = new SelectBox<String>(GVars_Ui.baseSkin);
		VisCheckBox vSynchCheckBox = new VisCheckBox("Is VSynch") ; 
		VisTextButton apply = new VisTextButton("Apply") ;
		
		table.add(graphics).colspan(2) ;
		table.row() ; 
		table.add(new VisLabel("Resolution:")).align(Align.left) ; 
		table.add(selectBox_Resolution).align(Align.left) ;
		table.row() ; 
		table.add(new VisLabel("Frame Per Sec:")).align(Align.left) ; 
		table.add(selectBox_FPS).align(Align.left) ;
		table.row() ;
		table.add(vSynchCheckBox).colspan(2).align(Align.left) ; 
		table.row() ;
		table.add(apply).colspan(2).align(Align.center) ; 
		
		return table ; 
	}
	
	private SelectBox<String> buildResolutionBox() 
	{
		buildDisplayList() ; 
		SelectBox<String> selectBox = new SelectBox<String>(GVars_Ui.baseSkin);
		String[] resolutions = new String[displayMap.size()];
		
		int a = 0; 
		for(String value : displayList)
		{resolutions[a++] = value ;}
		
		selectBox.setItems(resolutions);
		
		return selectBox ;
	}

	public VisTable buildSoundsBloc()
	{
		VisTable table = new VisTable() ;
		return table ; 
	}
	
	public VisTable buildPerfBloc()
	{
		VisTable table = new VisTable() ;
		return table ; 
	}
	
	public VisTable buildLanguageBloc()
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