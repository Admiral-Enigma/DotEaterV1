package com.squirrel.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import com.squirrel.main.Game;
import com.squirrel.sound.SoundPlayer;


public class Shop{

	public static int speedUpgrades = 1;
	public int speedUpgradeCost = 10;
	public static int dotSpawnRateUpgrade = 1;
	public static int dotSpawnRateCost = 50;
	public static int dotEatenPerDotUpgrades = 1;
	public static int dotEatenPerDotUpgradeCost = 100;
	public int Fontsize4 = 30;
	public int Fontsize5 = 15;
	private String upImgPath = "/assets/upgrade.png";
	private String costText = "Cost: N/A";
	private String descriptionText = "N/A";
	private int amountText = 0;
	public int onItem = 1;
	public static boolean canBuySpeed = false;
	public static boolean canBuyDotRate = false;
	public static boolean canBuyDotEat = false;
	
	public void update(){
		
		canBuySpeedUpgrade();
		canBuyDotRateUpgrade();
		canBuyDotEatUpgrade();
		
		if(onItem == 4){
			onItem = 3;
		}
		else if(onItem == 0){
			onItem = 1;
		}
		
	}
	
	public void draw(Graphics2D g2d){
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, Fontsize4)); 
		g2d.drawString("Welcome to the shop", 170, 50);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, Fontsize5));
		
		//Speed
		g2d.drawString("Player Speed Upgrade", 250, 130);
		
		//SpawnRate
		g2d.drawString("Dot Rate Upgrade", 250, 230);
		
		//Eat Rate Text
		g2d.drawString("Dot Eat Rate Upgrade", 250, 330);
		
		//Cost
		g2d.drawString(costText, 30, 410);
		
		//Have
		g2d.drawString("Have: "+amountText, 550, 410);
		
		//description
		g2d.drawString(descriptionText, 220, 410);
		
		if(onItem == 1){
			g2d.setColor(Color.GREEN);
			g2d.drawRect(200, 100, 200, 50);
			g2d.drawImage(getUpImg(), 210, 115, null);
			resetCostTex();
			costText = "Cost: "+speedUpgradeCost;
			resetAmountInt();
			amountText = speedUpgrades;
			resetDescriptionText();
			descriptionText = "Upgradere Din Spillers Speed";
		}
		else if(onItem == 2){
			g2d.setColor(Color.GREEN);
			g2d.drawRect(200, 200, 200, 50);
			g2d.drawImage(getUpImg(), 210, 215, null);
			resetCostTex();
			costText = "Cost: "+dotSpawnRateCost;
			resetAmountInt();
			amountText = dotSpawnRateUpgrade;
			resetDescriptionText();
			descriptionText = "Spawner flere Dot Hvert 5. Sec";
		}
		else if(onItem == 3){
			g2d.setColor(Color.GREEN);
			g2d.drawRect(200, 300, 200, 50);
			g2d.drawImage(getUpImg(), 210, 315, null);
			resetCostTex();
			costText = "Cost: "+dotEatenPerDotUpgradeCost;
			resetAmountInt();
			amountText = dotEatenPerDotUpgrades;
			resetDescriptionText();
			descriptionText = "Giver dig flere dots per dot du spiser";
		}
	

		
	}
	
	public void keyPressed(KeyEvent e){
		int Key = e.getKeyCode();
		if(Key == KeyEvent.VK_UP){
			onItem -= 1;
		}
		if(Key == KeyEvent.VK_DOWN){
			onItem += 1;
		}
		if(Key == KeyEvent.VK_ENTER){
			if(onItem == 1){
				if(canBuySpeed){
					buySpeed();
				}
			}
			if(onItem == 2){
				if(canBuyDotRate){
					buyDotRate();
				}
			}
			if(onItem == 3){
				if(canBuyDotEat){
					buyDotEat();
				}
			}
		}
		if(Key == KeyEvent.VK_N && !Game.InMenu){
			Game.InShop = false;
			Game.Playing = true;
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int Key = e.getKeyCode();
		if(Key == KeyEvent.VK_SPACE){
		}
		if(Key == KeyEvent.VK_ENTER){
			
		}
	}
	
	public void resetCostTex(){
		costText = "Cost: N/A";
	}
	
	public void resetAmountInt(){
		amountText = 0;
	}
	public void resetDescriptionText(){
		descriptionText = "N/A";
	}
	
	public void buySpeed(){
		speedUpgrades += 1;
		Game.dotsEaten -= speedUpgradeCost;
		speedUpgradeCost += 50;
		SoundPlayer.POWERUP.play();
		resetCostTex();
			
	}
	
	//Speed Upgrade
	public void canBuySpeedUpgrade(){
		//Check if you can buy the speed upgrade
		if(Game.dotsEaten >= speedUpgradeCost){
			canBuySpeed = true;
			System.out.println("Kan købe Speed");
		}else{
			canBuySpeed = false;
			System.out.println("Kan ikke købe Speed");
		}
	}
	
	public void canBuyDotRateUpgrade(){
		if(Game.dotsEaten >= dotSpawnRateCost){
			canBuyDotRate = true;
			System.out.println("Kan købe dotRate");
		}else{
			canBuyDotRate = false;
			System.out.println("Kan ikke købe dotRate");
		}
	}
	
	public void canBuyDotEatUpgrade(){
		if(Game.dotsEaten >= dotEatenPerDotUpgradeCost){
			canBuyDotEat = true;
			System.out.println("Kan Købe Dot eat rate");
		}else{
			canBuyDotEat = false;
			System.out.println("Kan ikke købe Dot Eat Rate");
		}
	}
	
	public void buyDotRate(){
		dotSpawnRateUpgrade += 1;
		Game.dotsEaten -= dotSpawnRateCost;
		dotSpawnRateCost += 70;
		SoundPlayer.POWERUP.play();
		resetCostTex();
	}
	
	public void buyDotEat(){
		dotEatenPerDotUpgrades += 1;
		Game.dotsEaten -= dotEatenPerDotUpgradeCost;
		dotEatenPerDotUpgradeCost += 100;
		SoundPlayer.POWERUP.play();
		resetCostTex();
	}
	
	public Image getUpImg(){
		ImageIcon i = new ImageIcon(getClass().getResource(upImgPath));
		return i.getImage();
	}
}