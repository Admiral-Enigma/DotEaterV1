package com.squirrel.input;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

import com.squirrel.objects.Dot;

public class Controller {
	
	static LinkedList<Dot> dots = new LinkedList<Dot>();
	Random generator = new Random(); 
	public int dotX = generator.nextInt(640) - 20;
	public int dotY = generator.nextInt(480) - 20;
	Dot TempDot;
	
	public Controller(){
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));
		addDot(new Dot(generator.nextInt(640) - 40 ,generator.nextInt(480) - 40));

	}
	
	public void draw(Graphics2D g2d){
		for (int i = 1; i < dots.size(); i ++){
			TempDot = dots.get(i);
			
			TempDot.draw(g2d);
		}
	}
	
	public void update(){
		for(int i = 0; i < dots.size(); i++){
			TempDot = dots.get(i);
			
			TempDot.update();
		}
	}
	
	public void addDot(Dot dot){
		dots.add(dot);
	}
	
	
	public void removeDot(Dot dot){
		dots.remove(dot);
	}
	
	public static LinkedList<Dot> getDotsBounds(){
		return dots;
	}

}
