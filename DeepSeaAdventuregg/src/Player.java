import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
public class Player {
	private int score;
	private int x;
	private int y;
	private boolean isBack;
	private int listpos = -1;
	private int nextPos;
	private boolean isOnSub;
	private boolean initialSub;
	private int numTreasure;
	private boolean inPlay;
	private String name;
	private ArrayList<Chips> chip = new ArrayList<>();
	private ArrayList<Chips> chiptotal = new ArrayList<>();
	private boolean hasChange = false;
	private int t1,t2,t3,t4;
	

	public Player(int xpos, int ypos, String na) {
		x = xpos;
		name = na;
		y = ypos;
		score = 0;
		isBack = false;
		isOnSub = true;
		initialSub = true;
		inPlay = true;
	}
	public void setPos() {
		listpos = -1;
	}
	public boolean hasChange() {
		return hasChange;
	}
	public void setChanged( boolean miger) {
		hasChange = miger;
	}
	public void clearChip() {
		chip.clear();
		numTreasure = 0;
	}
	public boolean initialSub() {return initialSub;}
	public String name() {return name;}
	public void addPos(ArrayList cl) {
		listpos++;
		isOnSub = false;
		initialSub = false;
		if(listpos>=cl.size()) listpos = cl.size()-1;}
	public void subPos() {
		
		if(listpos >= 0)listpos--;
		if(listpos<0) {listpos = 0; isOnSub = true; inPlay = false;}
	}
	public boolean inPlay() {return inPlay;}
	public void setInPlay(boolean ppsucker) {inPlay = ppsucker;}
	public boolean isOnSub() {return isOnSub;}
	public void changeX(int xx) {x = xx;}
	public int getPos() {return listpos;}
	public void changeY(int yy) {y = yy;}
	public void back() {isBack = true;}
	public void forw() {isBack = false;}
	public boolean isBackward() {return isBack;}
	public int getNextPos(int a,ArrayList cl) {
		if(listpos + a>=0 && listpos + a < cl.size()) {
		nextPos = listpos;
		if(isBack == true)nextPos +=a;
		if(isBack == false)nextPos+=a;
		return nextPos;
		}
		else return 0;
	}
	public int getNumTreasure() {
		return numTreasure;
	}
	public void addC(Chips s) {
		chip.add(s);
		numTreasure = chip.size();
	}
	public void calcScore() {
		for(Chips ch:chip) {
			if(ch.isStack() == true) {
				ArrayList<Chips> hehaw = new ArrayList<>();
				hehaw = ch.returnStack();
				for(Chips ea:hehaw) {
					score+= ea.getVal();
				}
				chiptotal.add(ch);
			}
			else {
			chiptotal.add(ch);
			score += ch.getVal();
			}
		}
	}
	public int getLastVal() {
		return chip.get(chip.size()-1).getVal();
	}
	public int getLastX() {
		return chip.get(chip.size()-1).getX();

	}
	public int getLastY() {
		return chip.get(chip.size()-1).getY();

	}
	public int pgetX() {
		return x;
	}
	public int pgetY() {
		return y;
	}
	public int returnscore() {
		return score;
	}
	public ArrayList returnChips() {
		return chip;
	}
	public void setInitial(boolean x) {
		initialSub = x;
	}
	public void setIsOnSub(boolean z) {
		isOnSub = z;
	}
	public ArrayList returnTotal() {
		return chiptotal;
	}
	public Chips returnLast() {
		numTreasure--;
		return chip.get(chip.size()-1);
	}
	public void removeLast() {
		chip.remove(chip.size()-1);
	}
	public void calcTotal() {
		for(Chips ea:chiptotal) {
			if(ea.isStack == true) {
				ArrayList<Chips> balls = new ArrayList<>();
				balls = ea.returnStack();
				for(Chips eac:balls) {
					if(eac.getType() == 1)t1++;
					if(eac.getType() == 2)t2++;
					if(eac.getType() == 3)t3++;
					if(eac.getType() == 4)t4++;
				}
			}
			if(ea.getType() == 1)t1++;
			if(ea.getType() == 2)t2++;
			if(ea.getType() == 3)t3++;
			if(ea.getType() == 4)t4++;

			

		}
	}
	public int t1() {
		return t1;
	}
	public int t2() {return t2;}
	public int t3() {return t3;}
	public int t4() {return t4;}
}
