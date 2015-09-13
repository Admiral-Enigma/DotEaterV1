package com.squirrel.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.squirrel.input.Controller;
import com.squirrel.input.KeyInput;
import com.squirrel.input.MenuKeyInput;
import com.squirrel.input.ShopKeyInput;
import com.squirrel.objects.Menu;
import com.squirrel.objects.Player;
import com.squirrel.objects.Shop;


public class Game extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4793486362167567881L;
	public static int dotsEaten = 0;
	public static boolean InMenu = true;
	public static boolean Playing = false;
	public static boolean InShop = false;
	public static boolean InHelp = false;
	public static final int FontSize = 30;
	public static final int FontSize2 = 15;
	public static final int FontSize3 = 20;
	private String bgpath = "/assets/menuBG.png";
	
	
	Timer gameLoopTimer;
	
	Player player;
	Controller ct;
	Shop shop;
	Menu menu;

	
	public Game(){
		setFocusable(true);

		
		gameLoopTimer = new Timer(10, this);
		gameLoopTimer.start();
		
		player = new Player(100, 100);
		ct = new Controller();
		shop = new Shop();
		menu = new Menu();
		addKeyListener(new ShopKeyInput(shop));
		addKeyListener(new KeyInput(player));
		addKeyListener(new MenuKeyInput(menu));
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		if(InMenu){
			//OLD MENU 
			//g2d.setColor(Color.white);
			//g2d.setFont(new Font("TimesRoman", Font.PLAIN, FontSize)); 
			//g2d.drawImage(getBG(), 0, 0, null);
			//g2d.drawString("Welcome to dot eater!", 150, 100);
			//g2d.setFont(new Font("TimesRoman", Font.PLAIN, FontSize2)); 
			//g2d.drawString("A game where you eat dots", 200, 150);
			//g2d.drawString("Press space to begin", 200, 300);
			
			g2d.drawImage(getBG(), 0, 0, null);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
			g2d.setColor(Color.WHITE);
			menu.draw(g2d);
		}
		
		if(Playing){
			g2d.drawImage(getBG(), 0, 0, null);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, FontSize3)); 
			g2d.setColor(Color.WHITE);
			ct.draw(g2d);
			g2d.drawString("Dots Eaten: "+dotsEaten, 30, 50);
			player.draw(g2d);
		}
		if(InShop){
			g2d.drawImage(getBG(), 0, 0, null);
			shop.draw(g2d);
		}
		if(InHelp){
			g2d.drawImage(getBG(), 0, 0, null);
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
			g2d.drawString("Help!", 280, 50);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
			g2d.drawString("Controls: ", 30, 150);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
			g2d.drawString("Move: WASD", 30, 170);
			g2d.drawString("Shop: B/N", 30, 190);
			g2d.drawString("Shop/Menu: Arrow keys", 30, 210);
			g2d.drawString("Usekey: Enter", 30, 230);
			
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
			g2d.drawString("Credits: ", 400, 150);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2d.drawString("Made By Dem_Squirrel", 400, 170);
			g2d.drawString("Sound FX by Bfxr.net", 400, 190);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(InMenu){
			menu.update();
		}
		if(Playing){
			player.update();
			ct.update();
		}
		if(InShop){
			shop.update();
		}
		repaint();
		
	}
	public Image getBG(){
		ImageIcon i = new ImageIcon(getClass().getResource(bgpath));
		return i.getImage();
	}

}
