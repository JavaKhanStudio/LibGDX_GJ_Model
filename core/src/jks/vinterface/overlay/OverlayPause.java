package jks.vinterface.overlay;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import jks.tools.Vector2Int;
import jks.vars.GVars_Heart;
import jks.vinterface.GVars_Ui;
import jks.vue.models.Vue_Enter;

public class OverlayPause extends OverlayModel
{

	ImageButton retour ;
	ImageButton quitter ; 
	
	public OverlayPause() 
	{
		super("Pause Button" , GVars_Ui.baseSkin) ;
		
//		Image fond = new Image(Index_Interface.menuPause) ; 
		Image fond = new Image(new Texture(Gdx.files.internal("ui/pause/" + "pauseMenu.png"),true));
		fond.setSize(Gdx.graphics.getWidth()/1.5f, Gdx.graphics.getHeight()/1.25f);
		fond.setPosition(Gdx.graphics.getWidth()/2 - fond.getWidth()/2, Gdx.graphics.getHeight()/2 - fond.getHeight()/2);
//		Image coupeSonLibelle = new Image(Index_Interface.libelleCoupeSon) ; 
		//coupeSonLibelle.setSize(Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/10.5f);
		
		float xPosition = Gdx.graphics.getWidth() * 0.28f;
		float yposition = Gdx.graphics.getHeight() / 2.8f;
//		coupeSonLibelle.setPosition(xPosition, yposition);
		
		retour = new ImageButton(GVars_Ui.baseSkin);
		retour.addListener(new InputListener()
		{
			@Override
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {
				GVars_Heart.togglePauseMenu();
				return true;
	        }
		}) ;
		
		quitter = new ImageButton(GVars_Ui.baseSkin);
		quitter.addListener(new InputListener()
		{
			@Override
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {
				GVars_Heart.changeVue(new Vue_Enter(), true);
				return true;
	        }
		}) ;

		float decalY = Gdx.graphics.getHeight() / 8.8f ;
		
		retour.setSize(Gdx.graphics.getWidth() / 7.5f, Gdx.graphics.getHeight() / 9.0f);
		quitter.setSize(retour.getWidth(), retour.getHeight());
		
		retour.setPosition(Gdx.graphics.getWidth() / 2 - retour.getWidth() / 2, Gdx.graphics.getHeight() / 2.8f);
		quitter.setPosition(retour.getX(), retour.getY() - decalY);
		
		this.setLayoutEnabled(false);
		this.setFillParent(true);
		this.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		this.addActor(fond) ; 
//		this.addActor(coupeSonLibelle);
		this.addActor(retour);
		this.addActor(quitter);
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
		buttonList.add(quitter) ;
		buttonList.add(retour) ;
		returningList.add(buttonList) ; 
		return returningList;
	}
	
	@Override
	public Vector2Int startAt()
	{return new Vector2Int(0,1) ;}
}
