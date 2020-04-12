package crazyPackage;

import javax.swing.JFrame;

public class MoveWindow{

	public void Move(int width, int height, JFrame fr) {
		
		System.out.println("wid: " + width + ", hei: " + height);
		
		double rndX = Math.random() * width;
		double rndY = (Math.random() * height) - 10;
		
		int rounedRndX = Math.abs((int) Math.round(rndX));
		int rounedRndY = Math.abs((int) Math.round(rndY));
		
		System.out.println("rnd generated! rndX: " + rounedRndX + ", rndY: " + rounedRndY);
		
		fr.setLocation(rounedRndX, rounedRndY);
		
	}
	
	
}
