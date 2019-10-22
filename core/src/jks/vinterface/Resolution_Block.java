package jks.vinterface;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Graphics.Monitor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.utils.Align;
import com.kotcrab.vis.ui.widget.VisCheckBox;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;

import jks.vars.GVars_Heart;

public class Resolution_Block extends VisTable
{

	VisLabel graphicLabel,resolutionLabel,fpsLabel ;
	VisLabel leftDecalX , rightDecalX ; 
	VisCheckBox vSynchCheckBox ; 
	VisCheckBox fullScreenCheckBox ;
	SelectBox<String> selectBox_Resolution ; 
	SelectBox<String> selectBox_FPS ;
	
	HashMap<String,DisplayMode> displayMap ;
	ArrayList<String> displayList ;
	
	Cell<VisLabel> leftDecalXCell, rightDecalXCell ; 
	
	public Resolution_Block()
	{		
//		this.setLayoutEnabled(false);
		leftDecalX = new VisLabel("    ") ; rightDecalX = new VisLabel("    ") ;
		graphicLabel = new VisLabel("Graphics") ;
		graphicLabel.setAlignment(Align.center);
		resolutionLabel = new VisLabel("Resolution:") ; 
		fpsLabel = new VisLabel("Frame Per Sec:") ; 
		

		selectBox_Resolution = buildResolutionBox() ; 	
		selectBox_FPS = buildFpsBox() ;
		
		vSynchCheckBox = new VisCheckBox("Is VSynch") ; 
		fullScreenCheckBox = new VisCheckBox("Full screen") ; 
		fullScreenCheckBox.addListener(new InputListener()
		{		
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
			{return true ;}
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{
				setMaxResolution(fullScreenCheckBox.isChecked()) ;
			}

		}) ; 
		
		VisTextButton apply = new VisTextButton("Apply") ;
		apply.addListener(new InputListener()
		{		
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
			{return true ;}
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{applyNewResolution() ;}
		}) ; 
		
		this.add(graphicLabel).colspan(4) ;
		this.row() ; 
		
		leftDecalXCell = this.add(leftDecalX) ; 
		this.add(resolutionLabel).align(Align.left).expandX() ; 
		this.add(selectBox_Resolution).align(Align.right) ;
		rightDecalXCell = this.add(rightDecalX) ; 
		this.row() ; 
		
		this.add() ; 
		this.add(fpsLabel).align(Align.left) ; 
		this.add(selectBox_FPS).align(Align.right).expandX() ;
		this.row() ;
		
		this.add() ; 
		this.add(fullScreenCheckBox).colspan(2).align(Align.left).expandX() ; 
		this.add() ; 
		this.row() ;
		
		this.add() ; 
		this.add(vSynchCheckBox).colspan(2).align(Align.left).expandX() ; 
		this.add() ; 
		this.row() ;
		
		this.add(apply).colspan(4).align(Align.center) ; 
	}
	
	public SelectBox<String> buildResolutionBox() 
	{
		buildDisplayList() ; 
		SelectBox<String> selectBox = new SelectBox<String>(GVars_UI.baseSkin);
		String[] resolutions = new String[displayMap.size()];
		
		int a = 0; 
		for(String value : displayList)
		{resolutions[a++] = value ;}
		
		selectBox.setItems(resolutions);
		
		return selectBox ;
	}
	
	public SelectBox<String> buildFpsBox() 
	{
		SelectBox<String> returning = new SelectBox<String>(GVars_UI.baseSkin);
		
		String[] fpsChoice = new String[2];
		fpsChoice[0] = "30" ; fpsChoice[1] = "60" ; 
		returning.setItems(fpsChoice);
		
		return returning ; 
	}
	
	private void setMaxResolution(boolean settingMax) 
	{
		if(settingMax)
		{
			selectBox_Resolution.setSelectedIndex(selectBox_Resolution.getItems().size - 1);
			selectBox_Resolution.setDisabled(true);
		}
		else
		{
			selectBox_Resolution.setDisabled(false);
		}
		
	}
	
	public void applyNewResolution()
	{
		String resolution = selectBox_Resolution.getSelected() ;
		int width = Integer.parseInt(resolution.substring(0, resolution.indexOf("x"))) ; 
		int height = Integer.parseInt(resolution.substring(resolution.indexOf("x") + 1,resolution.length())) ; 
		
		Gdx.graphics.setVSync(vSynchCheckBox.isChecked());
		Monitor currMonitor = Gdx.graphics.getMonitor();
		
		if(fullScreenCheckBox.isChecked())
		{	
			
			DisplayMode displayMode = Gdx.graphics.getDisplayMode(currMonitor);
			System.out.println(displayMode);
			if(!Gdx.graphics.setFullscreenMode(displayMode)) 
			{}	
		}
		else
		{
			Gdx.graphics.setWindowedMode(width, height);
			Lwjgl3Graphics g = (Lwjgl3Graphics) Gdx.graphics;
			DisplayMode mode = g.getDisplayMode();
			Lwjgl3Window window = g.getWindow();
	        window.setPosition(mode.width / 2 - g.getWidth() / 2, mode.height / 2 - g.getHeight() / 2);	
		}

		GVars_UI.resize();
		GVars_Heart.vue.resize(width, height);
	
	}
	
	public void buildDisplayList()
	{
		DisplayMode[] modes = Lwjgl3ApplicationConfiguration.getDisplayModes();
		displayMap = new HashMap<String,DisplayMode>() ;
		displayList = new ArrayList<>() ;
		
		for(DisplayMode mode : modes)
		{
			if(mode.width >= 800 
					&& mode.refreshRate == 60)
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
	
	public void resize()
	{
		float decalX = this.getWidth()/40 ;
		leftDecalXCell.minWidth(decalX) ;
		rightDecalXCell.minWidth(decalX) ; 
		
		graphicLabel.setStyle(GVars_UI.labelStyle_Title) ; 
		
		vSynchCheckBox.getLabel().getStyle().font = GVars_UI.font_Main ; 
		fullScreenCheckBox.getLabel().getStyle().font = GVars_UI.font_Main ; 
		selectBox_Resolution.getStyle().font = GVars_UI.font_Main ; 
		selectBox_FPS.getStyle().font = GVars_UI.font_Main ;
		
//		graphicLabel.setHeight(height);
		
	}
	
//	VisCheckBox vSynchCheckBox ; 
//	VisCheckBox fullScreenCheckBox ;
//	SelectBox<String> selectBox_Resolution ; 
//	SelectBox<String> selectBox_FPS ;
//	
//	HashMap<String,DisplayMode> displayMap ;
//	ArrayList<String> displayList ;
}