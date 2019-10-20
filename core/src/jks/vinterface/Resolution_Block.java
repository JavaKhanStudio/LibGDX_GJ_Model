package jks.vinterface;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Graphics.Monitor;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.utils.Align;
import com.kotcrab.vis.ui.widget.VisCheckBox;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;

import jks.vars.GVars_Heart;

public class Resolution_Block extends VisTable
{

	VisCheckBox vSynchCheckBox ; 
	VisCheckBox fullScreenCheckBox ;
	SelectBox<String> selectBox_Resolution ; 
	SelectBox<String> selectBox_FPS ;
	
	HashMap<String,DisplayMode> displayMap ;
	ArrayList<String> displayList ;
	
	public Resolution_Block()
	{		
		VisLabel graphics = new VisLabel("Graphics") ;
		graphics.setAlignment(Align.center);
		

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
		
		this.add(graphics).colspan(2) ;
		this.row() ; 
		this.add(new VisLabel("Resolution:")).align(Align.left) ; 
		this.add(selectBox_Resolution).align(Align.right) ;
		this.row() ; 
		this.add(new VisLabel("Frame Per Sec:")).align(Align.left) ; 
		this.add(selectBox_FPS).align(Align.right) ;
		this.row() ;
		this.add(fullScreenCheckBox).colspan(2).align(Align.left) ; 
		this.row() ;
		this.add(vSynchCheckBox).colspan(2).align(Align.left) ; 
		this.row() ;
		this.add(apply).colspan(2).align(Align.center) ; 
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
	        var mode = g.getDisplayMode();
	        var window = g.getWindow();
	        window.setPosition(mode.width / 2 - g.getWidth() / 2, mode.height / 2 - g.getHeight() / 2);	
		}

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
}