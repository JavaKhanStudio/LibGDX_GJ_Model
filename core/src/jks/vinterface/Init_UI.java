package jks.vinterface;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;

import jks.vinterface.font.GVars_Font;

public class Init_UI 
{
	
	public static Skin loadSkin () 
	{
		Skin skin = new Skin();
		
		Pixmap pixmap = new Pixmap(10, 10, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		
		skin.add("default", new BitmapFont());
		skin.add("white", new Texture(pixmap));
		
		GVars_Font.initFont() ;
		skin.add("default", GVars_Font.font12);
		skin.add("defaultBig", GVars_Font.font24);
		
		ButtonStyle buttonStyle = new ButtonStyle();
		buttonStyle.up = skin.newDrawable(Utils_TexturesAcess.buildDrawingRegionTexture("interface/buttonIcon.png"), Color.DARK_GRAY);

		CheckBoxStyle checkBox = new CheckBoxStyle() ;
		checkBox.checkboxOn = skin.newDrawable(Utils_TexturesAcess.buildDrawingRegionTexture("general/icon/checkbox_fill_teach.png"));
		checkBox.checkboxOff = skin.newDrawable(Utils_TexturesAcess.buildDrawingRegionTexture("general/icon/checkbox_empty.png"));
		checkBox.font = skin.getFont("default");
		
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable(Utils_TexturesAcess.buildDrawingRegionTexture("interface/buttonIcon.png"), Color.DARK_GRAY);
		textButtonStyle.font = skin.getFont("default");
		

		textButtonStyle = new TextButtonStyle(textButtonStyle);
		textButtonStyle.checked = skin.newDrawable("white", new Color(0x5287ccff));
		
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = skin.getFont("default");
				

		ProgressBarStyle progressBarStyle = new ProgressBarStyle();
		progressBarStyle.background = skin.newDrawable("white", new Color(0.25f, 0.25f, 0.25f, 0.66f));
		progressBarStyle.background.setMinHeight(15);
		progressBarStyle.knobBefore = skin.newDrawable("white", Color.CLEAR);
		progressBarStyle.knobBefore.setMinHeight(15);
		progressBarStyle.knobAfter = skin.newDrawable("white", new Color(1, 0, 0, 0.66f));
		progressBarStyle.knobAfter.setMinHeight(15);
				
		WindowStyle windowStyle = new WindowStyle() ;
		windowStyle.background = skin.newDrawable("white", new Color(0.25f, 0.25f, 0.25f, 0.66f));
		windowStyle.titleFont = skin.getFont("default");
		
		
		skin.add("default", checkBox);
		skin.add("default", textButtonStyle);
		skin.add("default", buttonStyle);
		skin.add("toggle", textButtonStyle);
		skin.add("default", labelStyle);
		skin.add("default-horizontal", progressBarStyle);
		skin.add("default", windowStyle);
		
		return skin ; 
	}
	
}