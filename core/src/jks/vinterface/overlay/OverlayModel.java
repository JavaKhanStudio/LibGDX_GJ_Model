package jks.vinterface.overlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import jks.vinterface.Index_Interface;
import jks.vinterface.Utils_TexturesAcess;
import jks.vinterface.controlling.ControllableInterface;

public abstract class OverlayModel extends Table implements ControllableInterface
{
	
	Color backgroundColor ; 
	Texture texture ; 
	
	public OverlayModel(Skin skin) 
	{
		super(skin);
		texture = Utils_TexturesAcess.getTexture(Index_Interface.empty) ; 
		backgroundColor = new Color(0, 0, 0, 0.5f) ; 
//		this.setMovable(false);
		this.setTouchable(Touchable.childrenOnly);
	}
	
	@Override
	protected void drawBackground (Batch batch, float parentAlpha, float x, float y) {
		batch.setColor(backgroundColor);
		batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public abstract void destroy() ;
	public abstract boolean disableMainClickAction() ;

}