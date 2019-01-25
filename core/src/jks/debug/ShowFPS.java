package jks.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import jks.vinterface.GVars_Interface;
import jks.vinterface.ToRender;
import jks.vinterface.font.GVars_Font;

public class ShowFPS implements ToRender 
{
	Label fpsLabel ; 
	float decal ;
	public ShowFPS()
	{
		decal = Gdx.graphics.getWidth()/10 ;
		fpsLabel = new Label("", GVars_Interface.baseSkin);
		fpsLabel.setStyle(new LabelStyle(GVars_Font.font24,Color.BLACK));
//		fpsLabel.setFontScale(3.5f);
		fpsLabel.setPosition(decal * 1.5f, Gdx.graphics.getHeight() - decal);
		GVars_Interface.mainInterface.addActor(fpsLabel);
	}
	
	@Override
	public void render()
	{fpsLabel.setText(Integer.toString(Gdx.graphics.getFramesPerSecond()));}
}
