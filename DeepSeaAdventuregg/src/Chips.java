import java.util.*;
public class Chips {
	private int val;
	private int type;
	private int x;
	private int y;
	private boolean playerOn;
	private boolean isEmpty;
	public boolean isStack;
	private ArrayList<Chips> st = new ArrayList<>();
	
	public Chips(int v) {
		playerOn = false;
		x = 0;
		y = 0;
		val = v;
		if(val<0)type = -1;
		else if(val <4)type = 1;
		else if(val<8)type = 2;
		else if(val<12)type = 3;
		else type = 4;
		if(type == -1) {
			isEmpty = true;
			playerOn = true;
		}
		else isEmpty = false;
	}
	public Chips(boolean sta) {
		isStack = sta;
		type = 5;
	}
	public int getTypeFirst() {
		return st.get(0).getType();
	}
	public void stackAdd(Chips a) {
		st.add(a);
	}
	public void clearSt() {
		st.clear();
	}
	public Chips getFirst() {return st.get(0);}
	public Chips getSecond() {return st.get(1);}
	public Chips getThird() {return st.get(2);}

	public ArrayList returnStack() {return st;}
	public boolean isEmpty() {return isEmpty;}
	public boolean isStack() {return isStack;}
	public void playerOnn() {
		playerOn = true;
	}
	public void playerOff() {
		playerOn = false;
	}
	public boolean isPlayer() {
		return playerOn;
	}
	public void setFirst(Chips a) {
		st.set(0, a);
	}
	public void setSecond(Chips a) {
		st.set(1, a);
	}
	public void setThird(Chips a) {
		st.set(2, a);
	}
	public void setX(int xx) {x = xx;}
	public void setY(int yy) {y = yy;}
	public int getX() {return x;}
	public int getY() {return y;}
	public int getType() {return type;}
	public int getVal() {return val;}
	public String toString() {
		return "Val: " + val + " Type: "+ type+ "\n";
	}
}
	