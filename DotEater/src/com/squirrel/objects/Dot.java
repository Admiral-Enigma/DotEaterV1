package com.squirrel.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.squirrel.main.GlobalPos;

public class Dot extends GlobalPos{
	
	private String DotImg = "/assets/coin.png";

	public Dot(int x, int y) {
		super(x, y);
	}
	
	public void update(){
		
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getDotImg(), x, y, null);
	}
	
	public Rectangle getBunds(){
		return new Rectangle(x, y, 20, 20);
	}
	
	public Image getDotImg(){
		ImageIcon i = new ImageIcon(getClass().getResource(DotImg));
		return i.getImage();
	}

}
