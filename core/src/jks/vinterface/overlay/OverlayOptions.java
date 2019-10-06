package jks.vinterface.overlay;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class OverlayOptions extends OverlayModel
{

	public OverlayOptions(String title, Skin skin) {
		super(title, skin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ArrayList<Button>> mapInterface() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean disableMainClickAction() {
		// TODO Auto-generated method stub
		return false;
	}

}
