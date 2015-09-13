package com.squirrel.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.squirrel.objects.Player;

public class KeyInput extends KeyAdapter{
	Player player;
	
	public KeyInput(Player p){
		this.player = p;
	}
	public void keyPressed(KeyEvent e){
		player.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		player.keyReleased(e);

	}
}
