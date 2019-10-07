package jks.vinterface;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Utils_TexturesAcess
{

	public static TextureRegionDrawable buildDrawingRegionTexture(String texturePath)
	{
	    TextureRegion TextureRegion = new TextureRegion(Index_Interface.manager.get(texturePath, Texture.class));
	    return new TextureRegionDrawable(TextureRegion);
	}

	public static Texture getTexture(String texturePath)
	{
		return (Index_Interface.manager.get(texturePath, Texture.class));
	}
	
	
}