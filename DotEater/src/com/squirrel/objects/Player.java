package com.squirrel.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;
import com.squirrel.input.*;
import javax.swing.ImageIcon;
import com.squirrel.main.Game;
import com.squirrel.main.GlobalPos;
import com.squirrel.sound.SoundPlayer;

public class Player extends GlobalPos{

	
	private String Playerimg = "/assets/Player.png";
	public int VelX = 0;
	public int VelY = 0;
	public int playerSpeed = Shop.speedUpgrades;
	public long interval = 0;
	Random generator = new Random();
	private LinkedList<Dot> dots = Controller.getDotsBounds();
		
	public Player(int x, int y) {
		super(x, y);		
	}
	
	public void update(){
		x += VelX;
		y += VelY;
			
		playerSpeed = Shop.speedUpgrades;
		SpawnDot();
		System.out.println(interval);
		
		//Check Col with border
		if(x < 0){
			x = 0;
		}
		if(x > 602){
			x = 602;
		}
		if(y < 0){
			y = 0;
		}
		if(y > 419){
			y = 419;
		}
		
		//Dot Col
		for(int i = 0; i < dots.size(); i++){
			if(dots.get(i).x < 0){
			   dots.get(i).x = 0;
			}
			if(dots.get(i).x > 602){
				   dots.get(i).x = 600;
			}
			if(dots.get(i).y < 0){
				   dots.get(i).y = 0;
			}
			if(dots.get(i).y > 419){
				   dots.get(i).y = 400;
			}
		}
		Collison();
	}
	
	public void Collison(){
		for(int i = 0; i < dots.size(); i++){
			if(getBounds().intersects(dots.get(i).getBunds())){
				Game.dotsEaten += Shop.dotEatenPerDotUpgrades;
				SoundPlayer.DOT.play();
				dots.remove(i);
			}
		}
	}
	

	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getPlayerImg(), x, y, null);
	}
	
	public Image getPlayerImg(){
		ImageIcon i = new ImageIcon(getClass().getResource(Playerimg));
		return i.getImage();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32,32);
	}
	
	
	public void SpawnDot(){
		if(interval == 350){
			for(int i = 0; i <= Shop.dotSpawnRateUpgrade; i++){
				dots.add(new Dot(generator.nextInt(640) - 20, generator.nextInt(480) - 20));
			}
			interval = 0;
		}else{
			interval++;
		}
	}

	public void keyPressed(KeyEvent e) {
		int Key = e.getKeyCode();
		if(Key == KeyEvent.VK_W){
			VelY = -playerSpeed;
		}
		if(Key == KeyEvent.VK_D){
			VelX = playerSpeed;
		}
		if(Key == KeyEvent.VK_S){
			VelY = playerSpeed;
		}
		if(Key == KeyEvent.VK_A){
			VelX = -playerSpeed;
		}
		if(Key == KeyEvent.VK_ESCAPE && !Game.InShop){
			Game.Playing = false;
			Game.InMenu = true;
		}
		if(Key == KeyEvent.VK_B && !Game.InMenu && !Game.InHelp){
			Game.Playing = false;
			Game.InShop = true;
		}
	}
	

	public void keyReleased(KeyEvent e) {
		int Key = e.getKeyCode();
		if(Key == KeyEvent.VK_W){
			VelY = 0;
		}
		if(Key == KeyEvent.VK_D){
			VelX = 0;
		}
		if(Key == KeyEvent.VK_S){
			VelY = 0;
		}
		if(Key == KeyEvent.VK_A){
			VelX = 0;
		}
	}
}
