package jks.vue;

import static jks.vinterface.GVars_Interface.mainInterface;

import java.util.ArrayList;

import jks.vinterface.ToRender;
import jks.vinterface.overlay.OverlayModel; 

public abstract class AVue_Model 
{

	public ArrayList<ToRender> toRender = new ArrayList<ToRender>(); 
	
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
