package jks.parralax;

import com.badlogic.gdx.assets.AssetManager;

import jks.tools2d.parallax.heart.Parallax_Heart;

public class GVars_Parralax 
{
	public static void init()
	{
		Parallax_Heart.init(40, new AssetManager());
	    Parallax_Heart.topSquarePercent = 0.0f ; 
	    Parallax_Heart.parallaxMainPage.setDrawingHeight(2.2f);
	}
}
