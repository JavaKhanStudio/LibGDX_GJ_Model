package jks.vinterface;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import jks.vinterface.overlay.OverlayOptions;
import jks.vinterface.overlay.ReplayAction;
import jks.vue.Utils_View;

public class SmoothSideSelect extends Table implements ReplayAction
{

	Float baseSpeed = 0.4f ;
	float baseAlpha = 0.7f ;
	float sizeX ; 
	float sizeY ;
	float decalX ;
	float decalY ;
	float topPosY ;
	
	ArrayList<Table> list ;
	int index = 0; 
	Integer movingBy = 0; 
	
	float enterSpeed = 0.34f; 
	float enterspeedDelayIncrement = 0.12f ; 
	float leavingSpeed = 0.2f ; 
	float leavingSpeedDelayIncrement = 0.05f ; 
	
	ReplayAction ref ;
	 
	public SmoothSideSelect()
	{
		resize() ;
		ref = this ; 
		this.setLayoutEnabled(false);
		list = new ArrayList<>() ; 
		
		Button jouer = buildButton("Jouer") ; 
		jouer.addListener(new InputListener()
		{
			boolean onFocus ; 
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{return true ;}
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{
				if(onFocus)
				{
					System.out.println("Must be implement " + button + " " + pointer) ;
				}
			}
			
			public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) 
			{onFocus = false ;}
			
			public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor)
			{onFocus = true ;}
			
		}) ;
		
		Button options = buildButton("Options") ;
		options.addListener(new InputListener()
		{
			boolean onFocus ; 
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{return true ;}
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{
				if(onFocus)
				{
					exitScene();
					Utils_View.setOverlay(new OverlayOptions(ref));
				}
			}
			
			public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) 
			{onFocus = false ;}
			
			public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor)
			{onFocus = true ;}
			
		}) ;
		
		Button credits = buildButton("Credits") ;
		credits.addListener(new InputListener()
		{
			boolean onFocus ; 
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{return true ;}
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{

				if(onFocus)
				{
					System.out.println("Must be implement " + button + " " + pointer) ;
				}
			}
			
			public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) 
			{onFocus = false ;}
			
			public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor)
			{onFocus = true ;}
			
		}) ;
		
		Button quitter = buildButton("Quit") ;
		quitter.addListener(new InputListener()
		{
			boolean onFocus ; 
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{return true ;}
			
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{

				if(onFocus)
				{
					System.exit(0);
				}
			}
			
			public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) 
			{onFocus = false ;}
			
			public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor)
			{onFocus = true ;}
			
		}) ;
		
	}

	public void resize() 
	{
		this.setWidth(Gdx.graphics.getWidth()/4);
		this.setHeight(Gdx.graphics.getHeight());
		decalX = Gdx.graphics.getWidth()/15 ;
		sizeX = 300 ;
		sizeY = 40 ; 
		topPosY = Gdx.graphics.getHeight()/2.5f ;
		movingBy = 10 ; 
		baseSpeed = 0.3f ;
		decalY = 0 ;
	}
	
	public Button buildButton(String text)
	{
		Table table = new Table(); 
		table.setLayoutEnabled(false);
		
		Label.LabelStyle labelStyle = new Label.LabelStyle();
	    labelStyle.font = GVars_Ui.mainFont;
	    
		Label textLabel = new Label(text, labelStyle) ;
		textLabel.setTouchable(Touchable.disabled);
		Button textButton = new Button(GVars_Ui.baseSkin);
		textButton.setColor(0, 0, 0, 0.0f);
		float positionX = -sizeX ; 
		float positionY = topPosY - (sizeY * index) - (decalY * index) ;
		
		table.add(textButton) ;
		table.add(textLabel) ;
		textLabel.setAlignment(Align.left);
		
		table.setBounds(positionX, positionY, sizeX, sizeY);
		textButton.setBounds(0, 0, sizeX, sizeY);
		textLabel.setBounds(0, 0, sizeX, sizeY);
		
		textButton.addListener(new InputListener()
		{		
			public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor)
			{
				textLabel.clearActions();
				textLabel.addAction(buildSelectSequence(movingBy,0)) ; 
				textButton.clearActions();
				textButton.addAction(buildAlpha(baseAlpha));
			}

			public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) 
			{
				textLabel.clearActions();
				textLabel.addAction(buildDeselectSequence(0,0)) ;
				textButton.clearActions();
				textButton.addAction(buildAlpha(0));
			}
		}) ; 
	
		index ++ ;
		list.add(table) ;
		this.add(table) ;
		return textButton ; 
	}
	
	public void enterScene()
	{
		for(int a = 0 ; a < list.size() ; a++)
		{
			MoveToAction action1 = new MoveToAction();
		    action1.setPosition(decalX, topPosY - (sizeY * a) - (decalY * a));
		    action1.setDuration(enterSpeed);
		    
		    DelayAction delay = new DelayAction(a * (enterspeedDelayIncrement)) ; 
		    
		    SequenceAction sequence = new SequenceAction();
		    sequence.addAction(delay);
		    sequence.addAction(action1);
		   
		    
		    list.get(a).addAction(sequence);
		}

	}
	
	public void exitScene()
	{
//		for(int a = list.size() - 1 ; a >= 0 ; a--)
//		{
//			MoveToAction action1 = new MoveToAction();
//		    action1.setPosition(-sizeX, topPosY - (sizeY * a) - (decalY * a));
//		    action1.setDuration(leavingSpeed);
//		    
//		    DelayAction delay = new DelayAction((list.size() - (a + 1)) * (leavingSpeedDelayIncrement)) ; 
//		    
//		    SequenceAction sequence = new SequenceAction();
//		    sequence.addAction(delay);
//		    sequence.addAction(action1);
//		    
//		    list.get(a).addAction(sequence);
//		}
		
		for(int a = 0 ;  a < list.size() ; a++)
		{
			MoveToAction action1 = new MoveToAction();
		    action1.setPosition(-sizeX, topPosY - (sizeY * a) - (decalY * a));
		    action1.setDuration(leavingSpeed);
		    
		    DelayAction delay = new DelayAction(a * (leavingSpeedDelayIncrement)) ; 
		    
		    SequenceAction sequence = new SequenceAction();
		    sequence.addAction(delay);
		    sequence.addAction(action1);
		    
		    list.get(a).addAction(sequence);
		}
	}
	 
	
	public SequenceAction buildSelectSequence(int positionX, int positionY)
	{
		MoveToAction action1 = new MoveToAction();
	    action1.setPosition(positionX, positionY);
	    action1.setDuration(baseSpeed);
	        
	    SequenceAction sequence = new SequenceAction();
	    
	    sequence.addAction(action1);
	    
	    return sequence ; 
	}
	
	public Action buildAlpha(float a)
	{
		AlphaAction alpha = new AlphaAction() ; 
		alpha.setAlpha(a);
		alpha.setDuration(baseSpeed);
		return alpha ;
	}
	
	public SequenceAction buildDeselectSequence(int positionX, int positionY)
	{
		MoveToAction action1 = new MoveToAction();
		action1.setPosition(positionX, positionY);
	    action1.setDuration(baseSpeed);
	    
	    SequenceAction sequence = new SequenceAction();

	    sequence.addAction(action1);
	    
	    return sequence ; 
	}

}