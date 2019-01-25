package jks.sounds;

import static jks.sounds.GVars_Audio.*;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.MathUtils;

import jks.debug.GVars_Debug;

public class GVars_AudioManager 
{	
	private static ArrayList<Sound> jumpingSounds;
	private static ArrayList<Sound> heroLandingSounds;
	private static ArrayList<Sound> heroDeathSounds;

	private static Sound runningSound;
	private static Sound itemPickupSound;
	private static Sound touchingground;

	private static FileHandle fileHandleToDarkForestMusic = Gdx.files.internal("musics/Music_ForetNoire.wav");
	private static FileHandle fileHandleToDarkForestEnemyMusic = Gdx.files.internal("musics/Music_ForetNoire_Ennemy.wav");
	private static FileHandle fileHandleToDarkForestAmbiance = Gdx.files.internal("sounds/Amb_DarkForest_Loop.wav");
	
	private static FileHandle fileHandleToMenuHouseMusic = Gdx.files.internal("musics/Music_Menu.wav");
	
	private static FileHandle FH_Clairiere_Music = Gdx.files.internal("musics/Music_Clairiere.wav");
	private static FileHandle FH_Clairiere_Ambiance = Gdx.files.internal("sounds/Amb_Glade_Loop.wav");
	
	private static FileHandle FH_ClairWood_Music = Gdx.files.internal("musics/Music_ForetClaire.wav");
	private static FileHandle FH_ClairWood_Ambiance = Gdx.files.internal("sounds/Amb_LiteForest_Loop.wav");

	private static Music currentlyRunningMusic;
	private static Music currentlyRunningMusicSecondary;
	private static Music currentlyRunningAmbiance;

	public static void init() 
	{
		PreLoadAllSounds();
	}

	private static void PreLoadAllSounds()
	{
		jumpingSounds = new ArrayList<>();
		jumpingSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_Jump_01.wav")));
		jumpingSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_Jump_02.wav")));
		jumpingSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_Jump_03.wav")));

		runningSound = Gdx.audio.newSound(Gdx.files.internal("sounds/Player_Run_Loop.wav"));

		itemPickupSound = Gdx.audio.newSound(Gdx.files.internal("sounds/Item_Pickup.wav"));

		heroLandingSounds = new ArrayList<>();
		heroLandingSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_Land_01.wav")));
		heroLandingSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_Land_02.wav")));
		heroLandingSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_Land_03.wav")));

		heroDeathSounds = new ArrayList<>();
		heroDeathSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_FallDeath_01.wav")));
		heroDeathSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_FallDeath_02.wav")));
		heroDeathSounds.add(Gdx.audio.newSound(Gdx.files.internal("sounds/Player_FallDeath_03.wav")));
	}

	public static void PlaySound(Enum_Sounds whichOne) 
	{
		if(GVars_Audio.muted)
			return ;
		
		if(GVars_Debug.soundDebug)
			System.out.println("Trying to play sound : " + whichOne);
		
		switch (whichOne) 
		{
			case Jumping:
				int randomizedIndex = MathUtils.random.nextInt(jumpingSounds.size());
				runningSound.stop();
				jumpingSounds.get(randomizedIndex).play(volume);
				break;
	
			case Running:
				runningSound.stop();
				runningSound.loop(volume * volumeFootStep, 1.1f, 0) ;
				break;
	
			case Idlling:
				runningSound.stop();
				break;
				
			case itemPickup:
				itemPickupSound.play(volume);
				break;
				
			case heroLanding:
				int randomizedIndex2 = MathUtils.random.nextInt(heroLandingSounds.size());
				if(touchingground != null)
					touchingground.stop();
				touchingground = heroLandingSounds.get(randomizedIndex2);
				touchingground.play(volume) ;
				break;
				
			case HeroDeath:
				int randomizedIndex3 = MathUtils.random.nextInt(heroDeathSounds.size());
				heroDeathSounds.get(randomizedIndex3).play(volume);
				break;
				
			default:
				System.out.println("Unknown Sound requested in PlaySound : " + whichOne);
				break;
		}
	}

	public static void PlayMusic(Enum_Music whichOne) 
	{
		if(GVars_Audio.muted)
			return ;

		if(GVars_Debug.soundDebug)
			System.out.println("Trying to play Music : " + whichOne);
		
		switch (whichOne) 
		{
			case DarkForest:
				if (currentlyRunningMusic == null) 
				{
					currentlyRunningMusic = Gdx.audio.newMusic(fileHandleToDarkForestMusic);
					currentlyRunningMusic.setLooping(true);
					currentlyRunningMusic.play();
				}
				if (currentlyRunningAmbiance == null) 
				{
					currentlyRunningAmbiance = Gdx.audio.newMusic(fileHandleToDarkForestAmbiance);
					currentlyRunningAmbiance.setLooping(true);
					currentlyRunningAmbiance.play();
				}
	
				if (currentlyRunningMusicSecondary == null) 
				{
					currentlyRunningMusicSecondary = Gdx.audio.newMusic(fileHandleToDarkForestEnemyMusic);
					currentlyRunningMusicSecondary.setLooping(true);
					currentlyRunningMusicSecondary.play();
				}
	
				break;
			
			case Glade : 
				if (currentlyRunningMusic == null) 
				{
					currentlyRunningMusic = Gdx.audio.newMusic(FH_Clairiere_Music);
					currentlyRunningMusic.setLooping(true);
					currentlyRunningMusic.play();
				}
				if (currentlyRunningAmbiance == null) 
				{
					currentlyRunningAmbiance = Gdx.audio.newMusic(FH_Clairiere_Ambiance);
					currentlyRunningAmbiance.setLooping(true);
					currentlyRunningAmbiance.play();
				}
				break ; 
				
			case ClaireWood : 
				if (currentlyRunningMusic == null) 
				{
					currentlyRunningMusic = Gdx.audio.newMusic(FH_ClairWood_Music);
					currentlyRunningMusic.setLooping(true);
					currentlyRunningMusic.play();
				}
				if (currentlyRunningAmbiance == null) 
				{
					currentlyRunningAmbiance = Gdx.audio.newMusic(FH_ClairWood_Ambiance);
					currentlyRunningAmbiance.setLooping(true);
					currentlyRunningAmbiance.play();
				}
				break ; 
				
			case Menu_House:
				if (currentlyRunningMusic == null) 
				{
					currentlyRunningMusic = Gdx.audio.newMusic(fileHandleToMenuHouseMusic);
					currentlyRunningMusic.setLooping(true);
					currentlyRunningMusic.play();
				}
				break;
			
			default:
				System.out.println("Unknown Music requested in PlayMusic : " + whichOne);
				break;
		}
	}

	public static void StopAndDisposeMusic() 
	{
		if(currentlyRunningMusic != null)
		{
			currentlyRunningMusic.stop() ;
			currentlyRunningMusic.dispose() ;
			currentlyRunningMusic = null ;
		}
		if(currentlyRunningMusicSecondary != null)
		{
			currentlyRunningMusicSecondary.stop() ;
			currentlyRunningMusicSecondary.dispose() ;
			currentlyRunningMusicSecondary = null ;
		}
		if(currentlyRunningAmbiance != null)
		{
			currentlyRunningAmbiance.stop() ;
			currentlyRunningAmbiance.dispose() ;
			currentlyRunningAmbiance = null ;
		}
	}
}
