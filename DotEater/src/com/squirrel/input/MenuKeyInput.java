package com.squirrel.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.squirrel.objects.Menu;

public class MenuKeyInput extends KeyAdapter{
	Menu menu;
	
	public MenuKeyInput(Menu menu){
		this.menu = menu;
	}
	
	public void keyPressed(KeyEvent e){
		menu.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		menu.keyReleased(e);

	}

}
