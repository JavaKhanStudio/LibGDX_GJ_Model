package jks.parralax;

import java.util.ArrayList;

import jks.tools2d.parallax.pages.Parallax_Model;

public class ColdNightModel
{

	public static ArrayList<Parallax_Model> buildPages() 
	{
		ArrayList<Parallax_Model> returningList = new ArrayList<Parallax_Model>() ; 
		
		Parallax_Model cloudsTop0 = new Parallax_Model() ; 
		cloudsTop0.region_Name = "clouds" ;
		cloudsTop0.sizeRatio = 0.5f ;
		cloudsTop0.region_Position = 0 ; 
		cloudsTop0.speed = 0.5f ;
		cloudsTop0.movementSpeedX = .01f ; 
		cloudsTop0.movementSpeedY = .01f ; 
		cloudsTop0.pad_Y_Ratio = 1.8f ;
		cloudsTop0.pad_X_Ratio = .1f ; 
		
		Parallax_Model cloudsTop1 = new Parallax_Model() ; 
		cloudsTop1.region_Name = "clouds" ;
		cloudsTop1.sizeRatio = 0.5f ;
		cloudsTop1.region_Position = 1 ; 
		cloudsTop1.speed = 0.5f ;
		cloudsTop1.movementSpeedX = .01f ; 
		cloudsTop1.movementSpeedY = .01f ; 
		cloudsTop1.pad_Y_Ratio = 1.4f ;
		cloudsTop1.pad_X_Ratio = .50f ; 
		
		Parallax_Model cloudsTop2 = new Parallax_Model() ; 
		cloudsTop2.region_Name = "clouds" ;
		cloudsTop2.sizeRatio = 0.5f ;
		cloudsTop2.region_Position = 0 ; 
		cloudsTop2.speed = 0.5f ;
		cloudsTop2.movementSpeedX = .01f ; 
		cloudsTop2.movementSpeedY = .01f ; 
		cloudsTop2.pad_Y_Ratio = 1.2f ;
		cloudsTop2.pad_X_Ratio = .20f ; 
		
		Parallax_Model clouds0 = new Parallax_Model() ; 
		clouds0.region_Name = "clouds" ;
		clouds0.sizeRatio = 0.5f ;
		clouds0.region_Position = 0 ; 
		clouds0.speed = 0.5f ;
		clouds0.movementSpeedX = .01f ; 
		clouds0.movementSpeedY = .01f ; 
		clouds0.pad_Y_Ratio = .70f ;
		
		Parallax_Model clouds1 = new Parallax_Model() ; 
		clouds1.region_Name = "clouds" ;
		clouds1.sizeRatio = 0.5f ;
		clouds1.region_Position = 1 ; 
		clouds1.speed = 0.5f ;
		clouds1.movementSpeedX = .01f ; 
		clouds1.movementSpeedY = .01f ; 
		clouds1.pad_Y_Ratio = .70f ;
		
		Parallax_Model rocks = new Parallax_Model() ; 
		rocks.region_Name = "rocks" ; 
		rocks.sizeRatio = 0.5f ;
		rocks.region_Position = 0 ; 
		rocks.movementSpeedX = .005f ; 
		rocks.movementSpeedY = .006f ; 
		rocks.pad_Y_Ratio = .40f ; 
		
		Parallax_Model ground0 = new Parallax_Model() ; 
		ground0.region_Name = "ground" ; 
		ground0.sizeRatio = 0.27f ;
		ground0.region_Position = 1 ; 
		ground0.movementSpeedX = .008f ; 
		ground0.movementSpeedY = .006f ; 
		ground0.pad_Y_Ratio = .38f ; 
		
		Parallax_Model ground1 = new Parallax_Model() ; 
		ground1.region_Name = "ground" ; 
		ground1.sizeRatio = 0.32f ;
		ground1.region_Position = 2 ; 
		ground1.movementSpeedX = .0105f ; 
		ground1.movementSpeedY = .006f ; 
		ground1.pad_Y_Ratio = .35f ; 
		
		Parallax_Model ground2 = new Parallax_Model() ; 
		ground2.region_Name = "ground" ; 
		ground2.sizeRatio = 0.40f ;
		ground2.region_Position = 1 ; 
		ground2.movementSpeedX = .0135f ; 
		ground2.movementSpeedY = .006f ; 
		ground2.pad_Y_Ratio = .30f ; 

		Parallax_Model ground3 = new Parallax_Model() ; 
		ground3.region_Name = "ground" ; 
		ground3.sizeRatio = 0.45f ;
		ground3.region_Position = 0 ; 
		ground3.movementSpeedX = .015f ; 
		ground3.movementSpeedY = .006f ; 
		ground3.pad_Y_Ratio = .25f ; 
		
		Parallax_Model ground4 = new Parallax_Model() ; 
		ground4.region_Name = "ground" ; 
		ground4.sizeRatio = 0.6f ;
		ground4.region_Position = 1 ; 
		ground4.movementSpeedX = .020f ; 
		ground4.movementSpeedY = .006f ; 
		ground4.pad_Y_Ratio = .20f ; 
		
		Parallax_Model ground5 = new Parallax_Model() ; 
		ground5.region_Name = "ground" ; 
		ground5.sizeRatio = 0.6f ;
		ground5.region_Position = 2 ; 
		ground5.movementSpeedX = .024f ; 
		ground5.movementSpeedY = .006f ; 
		ground5.pad_Y_Ratio = .20f ; 
		
		Parallax_Model water = new Parallax_Model() ; 
		water.region_Name = "waterDark" ; 
		water.sizeRatio = 0.7f ;
		water.region_Position = 0 ; 
		water.movementSpeedX = .04f ; 
		water.movementSpeedY = .006f ; 
		water.pad_Y_Ratio = .08f ; 
		water.speed = -0.4f ;
		
		returningList.add(cloudsTop0) ; 
		returningList.add(cloudsTop1) ; 
		returningList.add(cloudsTop2) ; 
		returningList.add(clouds0) ; 
		returningList.add(clouds1) ; 
		returningList.add(rocks) ;
		returningList.add(ground0) ; 
		returningList.add(ground1) ; 
		returningList.add(ground2) ; 
		returningList.add(ground3) ; 
		returningList.add(ground4) ; 
		returningList.add(ground5) ; 
		returningList.add(water) ;
	
		return returningList ; 
	}
	
	public static ArrayList<Parallax_Model> buildSecondPages() 
	{
		ArrayList<Parallax_Model> returningList = new ArrayList<Parallax_Model>() ; 
		
		Parallax_Model water1 = new Parallax_Model() ; 
		water1.region_Name = "waterDark" ; 
		water1.sizeRatio = 0.7f ;
		water1.region_Position = 0 ; 
		water1.movementSpeedX = .044f ; 
		water1.movementSpeedY = .006f ; 
		water1.pad_X_Ratio = .20f ; 
		water1.pad_Y_Ratio = .10f ; 
		water1.speed = -.8f ;
		
		Parallax_Model water2 = new Parallax_Model() ; 
		water2.region_Name = "waterDark" ; 
		water2.sizeRatio = 0.7f ;
		water2.region_Position = 0 ; 
		water2.movementSpeedX = .048f ; 
		water2.movementSpeedY = .006f ; 
		water2.pad_X_Ratio = .30f ; 
		water2.pad_Y_Ratio = .00f ; 
		water2.speed = -0.4f ;
		
		Parallax_Model cloudsTop0 = new Parallax_Model() ; 
		cloudsTop0.region_Name = "clouds" ;
		cloudsTop0.sizeRatio = 0.5f ;
		cloudsTop0.region_Position = 0 ; 
		cloudsTop0.speed = 0.5f ;
		cloudsTop0.movementSpeedX = .01f ; 
		cloudsTop0.movementSpeedY = .01f ; 
		cloudsTop0.pad_Y_Ratio = 1.6f ;
		cloudsTop0.pad_X_Ratio = .70f ; 
		
		Parallax_Model cloudsTop1 = new Parallax_Model() ; 
		cloudsTop1.region_Name = "clouds" ;
		cloudsTop1.sizeRatio = 0.5f ;
		cloudsTop1.region_Position = 0 ; 
		cloudsTop1.speed = 0.5f ;
		cloudsTop1.movementSpeedX = .01f ; 
		cloudsTop1.movementSpeedY = .01f ; 
		cloudsTop1.pad_Y_Ratio = 1.3f ;
		cloudsTop1.pad_X_Ratio = .50f ; 
		
		Parallax_Model cloudsTop2 = new Parallax_Model() ; 
		cloudsTop2.region_Name = "clouds" ;
		cloudsTop2.sizeRatio = 0.5f ;
		cloudsTop2.region_Position = 0 ; 
		cloudsTop2.speed = 0.5f ;
		cloudsTop2.movementSpeedX = .01f ; 
		cloudsTop2.movementSpeedY = .01f ; 
		cloudsTop2.pad_Y_Ratio = 1.1f ;
		cloudsTop2.pad_X_Ratio = .20f ; 
		
		returningList.add(cloudsTop0) ; 
		returningList.add(cloudsTop1) ; 
		returningList.add(cloudsTop2) ; 
		returningList.add(water1) ;
		returningList.add(water2) ;
		
		return returningList ; 
	}

}
