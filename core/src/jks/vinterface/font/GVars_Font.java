package jks.vinterface.font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import jks.vars.FVars_Heart;

public class GVars_Font 
{
	public static BitmapFont font12 ;
	public static BitmapFont font24 ;
	
	public static FreeTypeFontGenerator ftfg ; 
	public static final float baseSize = 0.40f ;
	
	public static void initFont()
	{
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Calibri.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		
		parameter.size = (int)(baseSize * Gdx.graphics.getWidth()/FVars_Heart.screenXModel);
		font12 = generator.generateFont(parameter); // font size 12 pixels
		
		parameter.size = (int)(3 * baseSize * Gdx.graphics.getWidth()/FVars_Heart.screenXModel);
		font24 = generator.generateFont(parameter); // font size 12 pixels
		
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
	}
	
}
