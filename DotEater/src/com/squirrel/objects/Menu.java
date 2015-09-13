package com.squirrel.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.squirrel.main.Game;

public class Menu {
	
	public static int OnMenuItem = 1;
	
	
	public void update(){
		if(OnMenuItem == 4){
			OnMenuItem = 3;
		}else if (OnMenuItem == 0){
			OnMenuItem = 1;
		}
		
	}
	
	public void draw(Graphics2D g2d){
		//TITLE
		g2d.drawString("Dot Eater!", 230, 50);
		
		
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 27)); 
		g2d.setColor(Color.WHITE);
		
		//Play
		g2d.drawString("Play", 290, 200);
		
		//Help
		g2d.drawString("Help", 290, 300);

		//Quit
		g2d.drawString("Quit", 290, 400);
		
		
		if(OnMenuItem == 1){
			g2d.setColor(Color.GREEN);
			g2d.drawRect(210, 170, 200, 50);
		}
		if(OnMenuItem == 2){
			g2d.setColor(Color.GREEN);
			g2d.drawRect(210, 270, 200, 50);
		}
		if(OnMenuItem == 3){
			g2d.setColor(Color.GREEN);
			g2d.drawRect(210, 370, 200, 50);
		}
	}

	public void keyPressed(KeyEvent e) {
		int Key = e.getKeyCode();
		if(Key == KeyEvent.VK_UP){
			OnMenuItem -= 1;
		}
		if(Key == KeyEvent.VK_DOWN){
			OnMenuItem += 1;
		}
		if(Key == KeyEvent.VK_ESCAPE && Game.InHelp){
			Game.InHelp = false;
			Game.InMenu = true;
		}
		if(Key == KeyEvent.VK_ENTER && !Game.InShop){
			if(OnMenuItem == 1){
				Game.InMenu = false;
				Game.Playing = true;
			}
			if(OnMenuItem == 2){
				Game.InMenu = false;
				Game.InHelp = true;
			}
			if(OnMenuItem == 3){
				System.exit(0);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		//int Key = e.getKeyCode();
		
	}

}
