package jks.vue;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;

import jks.vinterface.GVars_Interface;
import jks.vinterface.ToRender;
import jks.vinterface.overlay.OverlayModel;
import static jks.vinterface.GVars_Interface.* ; 

public abstract class AVue_Model 
{

	public ArrayList<ToRender> toRender ; 
	
	public OverlayModel overlay ; 
	public AView_Model_Filter filter ; 
	
	public abstract void init() ;
	public abstract void destroy() ;
	public abstract void restart() ; 
	
	public abstract void update (float delta) ;
	public abstract void render () ;
	
	
	public void clear()
	{
		
	}
	
	public void renderBeforeInterface()
	{
		for (ToRender rende : toRender) 
			rende.render();
		

		if (filter != null) 
			filter.draw();
		
	}
	
	public void drawInterface()
	{
		mainInterface.draw() ;
		
			
	}

	
}
