package com.squirrel.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class SoundPlayer {
	public static final String getDotSound = "/assets/dotSound.wav";
	public static final String getErrorSound = "/assets/error.wav";
	public static final String getPowerUpSound = "/assets/shopPowerUp.wav";
	//public static final String getSelectSound = "/assets/shopSelect.wav";
	public static final AudioClip DOT = Applet.newAudioClip(SoundPlayer.class.getResource(getDotSound));
	public static final AudioClip ERROR = Applet.newAudioClip(SoundPlayer.class.getResource(getErrorSound));
	public static final AudioClip POWERUP = Applet.newAudioClip(SoundPlayer.class.getResource(getPowerUpSound));
	//public static final AudioClip SELECT = Applet.newAudioClip(SoundPlayer.class.getResource(getSelectSound));

}
