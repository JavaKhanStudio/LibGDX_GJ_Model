package jks.personnage;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class FloatingName extends Actor
{
    private final String text;
    private final long animationDuration;
 
    private BitmapFont font = new BitmapFont();
 
    public FloatingName(String text, long animationDuration) 
    {
        this.text = text;
        this.animationDuration = animationDuration;
    }
}
