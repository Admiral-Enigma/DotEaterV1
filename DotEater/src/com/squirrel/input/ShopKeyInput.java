package com.squirrel.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.squirrel.objects.Shop;

public class ShopKeyInput extends KeyAdapter{
	Shop shop;
	
	public ShopKeyInput(Shop shop){
		this.shop = shop;
	}
	
	public void keyPressed(KeyEvent e){
		shop.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		shop.keyReleased(e);

	}

}
