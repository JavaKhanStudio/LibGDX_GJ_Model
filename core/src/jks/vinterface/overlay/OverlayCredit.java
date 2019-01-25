package jks.vinterface.overlay;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import jks.vars.GVars_Heart;
import jks.vinterface.GVars_Interface;
import jks.vinterface.Index_Interface;
import jks.vinterface.Utils_Interface;
import jks.vinterface.controlling.ControllableInterface;
import jks.vue.Utils_View;

public class OverlayCredit extends OverlayModel
{

	ImageButton retour ;
	
	public OverlayCredit() 
	{
		super("Pause Button" , GVars_Interface.baseSkin) ;
		
		Image fond = new Image(Index_Interface.credit) ; 
		fond.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		retour = new ImageButton(Index_Interface.pauseRetour);
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
			
		retour.setSize(Gdx.graphics.getWidth() / 7.5f, Gdx.graphics.getHeight() / 9.5f);
		retour.setPosition(Gdx.graphics.getWidth() / 2 - retour.getWidth() * 1.55f, Gdx.graphics.getHeight() / 4.8f);
		
		this.setLayoutEnabled(false);
		this.setFillParent(true);
		this.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		this.addActor(fond) ; 
		this.addActor(retour);
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
}
