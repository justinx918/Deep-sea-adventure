import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class ChipList{
	private ArrayList<Chips> cl = new ArrayList<>();
	private boolean isStack;
	private ArrayList<Chips> st = new ArrayList<>();
	
	//private BufferedImage choice, ct1, ct2, ct3, ct4,ct0;
	private int xPos;
	private int yPos;
	public ChipList() {
		//ArrayList<Integer[]> gg = new ArrayList<>();
		
		int[][] one = new int [][]{
			{0,1,0,1,2,3,2,3}, {3,2,0,1,2,1,3,0}, {2,3,1,0,3,2,0,1}, {1,3,0,2,3,1,0,2}};
				
		int [][] two = new int [][] {{4,4,7,6,7,5,6,5},{6,5,7,4,5,4,6,7}, {7,6,5,7,4,5,6,4},{6,5,7,7,4,5,4,6}};
		int [][] three = new int[][] {{8,9,9,10,11,11,8,10}, {10,11,11,9,8,9,8,10}, {11,10,8,9,11,9,8,10}, {9,9,10,8,11,11,8,10}};
		int[][] four = new int[][] {{12,13,13,15,14,14,12,15}, {14,12,13,13,14,15,15,12}, {13,12,14,14,15,13,15,12},{14,13,14,12,13,15,12,15}};
		int i = (int)Math.random()*3;
		for(int each:one[i]) {
			cl.add(new Chips(each));
		}
		i = (int)Math.random()*3;
		for(int each:two[i]) {
			cl.add(new Chips(each));
		}
		i = (int)Math.random()*3;
		for(int each:three[i]) {
			cl.add(new Chips(each));
		}
		i = (int)Math.random()*3;
		for(int each:four[i]) {
			cl.add(new Chips(each));
		}
		int cnt = 0;
		for(Chips e: cl) {
			if(cnt<8) {
			e.setX(325+150*cnt);
			e.setY(200);
			}
			else if(cnt<16) {
				e.setX(1375-(cnt%8)*150);
				e.setY(350);
			}
			else if(cnt <24) {
				e.setX(325+150*(cnt-16));
				e.setY(500);
			}
			else {
				e.setX(1375-(cnt%8)*150);
				e.setY(650);
			}
			cnt++;
		}
		
		//System.out.println(one);
	}
	public ChipList(boolean h) {
		isStack = true;
		
	}
	public void setXp(int xx) {
		xPos = xx;
	}
	public int getXp() {return xPos;}
	public int getYp() {
		return yPos;
	}
	public void setYp(int yy) {
		yPos = yy;
	}
	public void addStack(Chips gg) {
		st.add(gg);
	}
	public void clearStack() {st.clear();}
	public ArrayList returnSt() {return st;}
	
	private boolean isStack() {return isStack;}
	public void printList() {
		System.out.println(cl);
	}
	public void blankChip(int i, ArrayList c) {
		
		c.set(i, new Chips(-1));
		
	}
	public ArrayList returnList() {
		return cl;
	}

}