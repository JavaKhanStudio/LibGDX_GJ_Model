package jks.vinterface.overlay;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import jks.vinterface.controlling.ControllableInterface;

public abstract class OverlayModel extends Window implements ControllableInterface
{
	
	public OverlayModel(String title, Skin skin) 
	{super(title, skin);}
	
	public abstract void destroy() ;
	public abstract boolean disableMainClickAction() ;

}
