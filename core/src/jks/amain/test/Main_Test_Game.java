package jks.amain.test;

import jks.amain.Main_Game;
import jks.vars.GVars_Heart;
import jks.vue.models.Vue_Game;

public class Main_Test_Game extends Main_Game
{

	@Override
	public void create () 
	{
		GVars_Heart.init();
		GVars_Heart.changeVue(new Vue_Game(),true) ; 
	}
}
