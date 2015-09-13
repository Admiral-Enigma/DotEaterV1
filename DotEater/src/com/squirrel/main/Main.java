package com.squirrel.main;

import javax.swing.JFrame;

public class Main {

	public static final String title = "DotEater V1";
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH,HEIGHT);
		frame.setResizable(false);
		frame.setTitle(title);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Game());
		frame.setVisible(true);
	}

}
