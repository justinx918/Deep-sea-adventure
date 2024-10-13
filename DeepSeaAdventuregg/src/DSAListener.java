import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
public class DSAListener extends JPanel implements MouseListener{
	private int air= 25;
	private BufferedImage bg, ct1, ct2, ct3, ct4, ct0, choice,p1,p2,p3,p4,forward,backward,dice, pickup, drop, board, p1b, p2b, p3b,p4b, p1f,p2f,p3f, p4f;
	private Player pl1 = new Player(100,225, "Red");
	private Player pl2 = new Player(125, 225, "Blue");
	private Player pl3 = new Player(150,225, "Green");
	private Player pl4 = new Player(175,225, "Yellow");	
	private ArrayList<Player> pl = new ArrayList<>();
	private String str;
	private ArrayList<Chips> cl = new ArrayList<>();
	private boolean dhira = false;
	private boolean movee = false;
	private 			ArrayList<Chips> clst = new ArrayList<>();
	private ArrayList<BufferedImage> fin = new ArrayList<>();
	private boolean take = false;
private int a, b ,c, d;
private	int diceval = 2;
	private int playernum = 0;
	private BufferedImage sub, choicep, arrow, nothing,tb,ch1,ch2,ch3;
	private int con = 0;
	private int round = 1;
	private String cond = "";
	private ArrayList<ChipList> st = new ArrayList<>();
	public DSAListener() {
		
		pl.add(pl1);
		pl.add(pl2);
		pl.add(pl3);
		pl.add(pl4);
		ChipList cl1 = new ChipList();
		cl = cl1.returnList();
		System.out.println("gg");
		Scanner scann = null;
		String filename = "tileinfo.txt";
		File file;
		
		try {
			file = new File(filename);
			scann = new Scanner(file);
			
			bg = ImageIO.read(DSAListener.class.getResource("/Images/deepsea.jpg"));
			sub = ImageIO.read(DSAListener.class.getResource("/Images/submarine.png"));
			ct1 = ImageIO.read(DSAListener.class.getResource("/Images/Tier1.png"));
			ct2 = ImageIO.read(DSAListener.class.getResource("/Images/Tier2.png"));
			ct3 = ImageIO.read(DSAListener.class.getResource("/Images/Tier3.png"));
			ct4 = ImageIO.read(DSAListener.class.getResource("/Images/Tier4.png"));
			ct0 = ImageIO.read(DSAListener.class.getResource("/Images/gggggg-removebg-preview.png"));
			p1 = ImageIO.read(DSAListener.class.getResource("/Images/player1.png"));
			p2 = ImageIO.read(DSAListener.class.getResource("/Images/player2.png"));
			p3= ImageIO.read(DSAListener.class.getResource("/Images/player3.png"));
			p4 = ImageIO.read(DSAListener.class.getResource("/Images/player4.png"));
			forward = ImageIO.read(DSAListener.class.getResource("/Images/forwards.png"));
			backward = ImageIO.read(DSAListener.class.getResource("/Images/backwards.png"));
			dice = ImageIO.read(DSAListener.class.getResource("/Images/rolldice.png"));
			pickup = ImageIO.read(DSAListener.class.getResource("/Images/pickup.png"));
			drop = ImageIO.read(DSAListener.class.getResource("/Images/drop.png"));
			board = ImageIO.read(DSAListener.class.getResource("/Images/board.png"));
			p1b = ImageIO.read(DSAListener.class.getResource("/Images/player1back.png"));
			p2b = ImageIO.read(DSAListener.class.getResource("/Images/player2back.png"));
			p3b = ImageIO.read(DSAListener.class.getResource("/Images/player3back.png"));
			p4b = ImageIO.read(DSAListener.class.getResource("/Images/player4back.png"));
			p1f = ImageIO.read(DSAListener.class.getResource("/Images/player1for.png"));
			p2f = ImageIO.read(DSAListener.class.getResource("/Images/player2for.png"));
			p3f = ImageIO.read(DSAListener.class.getResource("/Images/player3for.png"));
			p4f = ImageIO.read(DSAListener.class.getResource("/Images/player4for.png"));
			arrow = ImageIO.read(DSAListener.class.getResource("/Images/arrowup.png"));
			nothing = ImageIO.read(DSAListener.class.getResource("/Images/nothing.png"));
			tb = ImageIO.read(DSAListener.class.getResource("/Images/treasureboard.png"));

		}
		catch(Exception e) {
			System.out.println("exception fr");
			return;
		}
		addMouseListener(this);
		fin.add(p1);
		fin.add(p2);
		fin.add(p3);
		fin.add(p4);
	}
	@Override
	public void paint(Graphics g) {
		//make player point down when going down and point up when going up
		super.paint(g);
		
		if(round <=3) {
			
			

			/*Chips ha = new Chips(true);
			int lmfao = clst.size()-1;
			for(int l = 0; l < lmfao-1;l++) {
				
				if(ha.returnStack().size() <= 3) {
					ha.stackAdd(clst.get(0));
					clst.remove(0);
				}
				else {
					cl.add(ha);
					ha.clearSt();
				}
			}*/
		int i = 0;
		//int lol = 0;
		g.drawImage(bg, 0, 0, 1600, 960, null);
		g.drawImage(sub, 0, 125, 300, 225, null);
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

		System.out.println(cl.size());
		System.out.println(cl.get(cl.size()-1).isStack());

		/*int cnnt = 0;//this does not work
		ChipList aas = new ChipList(true);
		int lmfao = clst.size();
		for(int o = 0; o < lmfao; o++){
			if(cnnt<3&&o<lmfao-1) {
				aas.addStack(clst.get(0));
				clst.remove(0);	
				cnnt++;
			}
			else{
				if(cl.size() + st.size()%8!=0) {
				if(st.size()<=0) {
				aas.setXp(cl.get(cl.size()-1).getX()+150);
				aas.setYp(cl.get(cl.size()-1).getY());
				}
				else {
					aas.setXp(st.get(st.size()-1).getXp()+150);
					aas.setYp(st.get(st.size()-1).getYp());

				}
				}
				else {
					if(cl.size()-1<17 ) {
					aas.setXp(350);
					aas.setYp(cl.get(cl.size()-1).getY());
					}
				}
				st.add(aas);
				aas.clearStack();
				cnnt = 0;
				
			}
		}//this does not work */
		
		
		
		
		for(Chips each:cl) {
		if(each.getType() == 1) choice = ct1;
			else if(each.getType() == 2) choice = ct2;
			else if(each.getType() == 3) choice = ct3;
			else if(each.getType() == 4) choice = ct4;
			else if(each.getType() == 5) {
				int k = each.getTypeFirst();
				if(k== 1) choice = ct1;
				else if(k == 2) choice = ct2;
				else if(k == 3) choice = ct3;
				else if(k == 4) choice = ct4;
			}
			else choice = ct0;
			g.drawImage(choice,each.getX() , each.getY(), 125,125,null);
			Font abc = new Font("SansSerif", 1, 18);
			g.setFont(abc);
			if(each.getType() == 5)g.drawString("STACK", each.getX()+30, each.getY()+50);
			
		}
			for(int p = 0; p <4; p++) {
				if(p == 0)
					{
					if(pl.get(0).isBackward() == false) choicep = p1f;
					else choicep = p1b;
					if(pl.get(0).isOnSub() == true)choicep = p1;
					if(pl.get(0).isOnSub()==false)g.drawImage(choicep, pl.get(p).pgetX(), pl.get(p).pgetY(), 60,60,null);
					else if(pl.get(0).isOnSub()==true) g.drawImage(choicep, 100, 225, 60,60,null);

					}
				
				
				else if(p == 1) {
					if(pl.get(1).isBackward() == false) choicep = p2f;
					else choicep = p2b;
					if(pl.get(1).isOnSub() == true)choicep = p2;
					if(pl.get(1).isOnSub()==false)g.drawImage(choicep, pl.get(p).pgetX(), pl.get(p).pgetY(), 60,60,null);
					else if(pl.get(1).isOnSub()==true) g.drawImage(choicep, 125, 225, 60,60,null);

				}
				
				
				else if(p == 2)
					{
					if(pl.get(2).isBackward() == false) choicep = p3f;
					else choicep = p3b;
					if(pl.get(2).isOnSub() == true)choicep = p3;
					if(pl.get(2).isOnSub()==false)g.drawImage(choicep, pl.get(p).pgetX(), pl.get(p).pgetY(), 60,60,null);
					else if(pl.get(2).isOnSub()==true) g.drawImage(choicep, 150, 225, 60,60,null);

					}
				
				
				else {
					if(pl.get(3).isBackward() == false) choicep = p4f;
					else choicep = p4b;
					if(pl.get(3).isOnSub() == true)choicep = p4;
					if(pl.get(3).isOnSub()==false)   g.drawImage(choicep, pl.get(p).pgetX(), pl.get(p).pgetY(), 60,60,null);
					else if(pl.get(3).isOnSub()==true) g.drawImage(choicep, 175, 225, 60,60,null);
				}
			}
		
	//	g.drawImage(p1,  pl1.getX(), pl1.getY(), 60, 60, null);
		//g.drawImage(p2,  pl2.getX(), pl2.getY(), 60, 60, null);
	//	g.drawImage(p3,  pl3.getX(), pl3.getY(), 60, 60, null);
		//g.drawImage(p4,  pl4.getX(), pl4.getY(), 60, 60, null);
		Font myFont = new Font ("SansSerif", 1, 22);
		g.setFont(myFont);
		g.setColor(Color.black);
		g.drawString("Player 1 Score: "+pl1.returnscore(), 40, 30);
		g.drawString("Player 2 Score: "+pl2.returnscore(), 40, 55);
		g.drawString("Player 3 Score: "+pl3.returnscore(), 40, 80);
		g.drawString("Player 4 Score: "+pl4.returnscore(), 40, 105);
		Font airFont = new Font("Courier New",1, 22);
		g.setColor(Color.white);
		if(air>0)g.drawString("Oxygen Count: " + air, 55, 200);
		else g.drawString("Oxygen Count: " + 0, 55, 200);
		g.setColor(Color.red);
		g.fillOval(14, 13, 18, 18);
		g.setColor(Color.blue);
		g.fillOval(14, 38, 18, 18);
		g.setColor(Color.green);
		g.fillOval(14, 63, 18, 18);
		g.setColor(Color.yellow);
		g.fillOval(14, 88, 18, 18);
		g.drawImage(backward, 500, 35, 200,40,null);
		g.drawImage(forward, 300, 35, 200,40,null);
		g.drawImage(dice, 700, 35, 200, 40, null);
		g.drawImage(pickup, 900,35,200,40,null);
		g.drawImage(drop, 1100,35,200,40,null);
		g.drawImage(nothing, 1300, 35, 200, 40, null);
		g.drawImage(board, 300,0,1200,40, null);
		g.setColor(Color.black);
		g.drawString("TURN:", 630, 100);
		g.drawImage(p1, 700, 75, 43,43,null);
		g.drawImage(p2, 750, 75, 40,40,null);
		g.drawImage(p3, 800, 75, 45,45,null);
		g.drawImage(p4, 850, 75, 40,40,null);
		
		if(playernum == 4)playernum = 0;
		if(playernum == 0) {
			//if(con == 1)g.drawString("Player "+ pl.get(0).name()+ " rolled a "+ diceval+"!", 350, 25);
			//else if(con == 2)g.drawString("Player "+ pl.get(0).name()+ " chose to go backwards!", 350, 25);
			//else if(con == 3)g.drawString("Player "+ pl.get(0).name()+ " chose to go forwards!", 350, 25);
			//else if(con == 4)g.drawString("Player "+ pl.get(0).name()+ " Made it to the submarine!", 350, 25);
			//else if(con == 5)g.drawString("Player "+ pl.get(0).name()+ " Is already on the sub", 350, 25);
			//else if(con == 6)g.drawString("Player "+ pl.get(0).name()+ " Is already on the sub!", 350, 25);
			if(con == 0)g.drawString("The Game Has Begun! It Is Player "+ pl.get(0).name()+ "'s Turn!", 350, 25);
			g.drawImage(arrow, 713, 110,20,20,null);
		//	g.drawString(pl.get(playernum).getNumTreasure()+"", 100,150);

		}
		if(playernum == 1) {
			//if(con == 1)g.drawString("Player "+ pl.get(1).name()+ " rolled a "+ diceval+"!", 350, 25);
			//else if(con == 2)g.drawString("Player "+ pl.get(1).name()+ " chose to go backwards!", 350, 25);
			//else if(con == 3)g.drawString("Player "+ pl.get(1).name()+ " chose to go forwards!", 350, 25);
			//else if(con == 4)g.drawString("Player "+ pl.get(1).name()+ " Made it to the submarine!", 350, 25);
			//else if(con == 5)g.drawString("Player "+ pl.get(1).name()+ " Is already on the sub", 350, 25);
			//else if(con == 6)g.drawString("Player "+ pl.get(1).name()+ " Is already on the sub!", 350, 25);
			//else if(con == 0)g.drawString("It is Player "+ pl.get(1).name()+ "'s Turn!", 350, 25);
			g.drawImage(arrow, 760, 110,20,20,null);
			//g.drawString(pl.get(playernum).getNumTreasure()+"", 100,150);


		}
		if(playernum == 2) {
			//if(con == 1)g.drawString("Player "+ pl.get(2).name()+ " rolled a "+ diceval+"!", 350, 25);
			//else if(con == 2)g.drawString("Player "+ pl.get(2).name()+ " chose to go backwards!", 350, 25);
			//else if(con == 3)g.drawString("Player "+ pl.get(2).name()+ " chose to go forwards!", 350, 25);
			//else if(con == 4)g.drawString("Player "+ pl.get(2).name()+ " Made it to the submarine!", 350, 25);
			//else if(con == 5)g.drawString("Player "+ pl.get(2).name()+ " Is already on the sub", 350, 25);
			//else if(con == 6)g.drawString("Player "+ pl.get(2).name()+ " Is already on the sub!", 350, 25);
			//else if(con == 0)g.drawString("It is Player "+ pl.get(2).name()+ "'s Turn!", 350, 25);
			g.drawImage(arrow, 814, 110,20,20,null);
		//	g.drawString(pl.get(playernum).getNumTreasure()+"", 100,150);





		}
		if(playernum == 3) {
			//if(con == 1)g.drawString("Player "+ pl.get(3).name()+ " rolled a "+ diceval+"!", 350, 25);
			//else if(con == 2)g.drawString("Player "+ pl.get(3).name()+ " chose to go backwards!", 350, 25);
			//else if(con == 3)g.drawString("Player "+ pl.get(3).name()+ " chose to go forwards!", 350, 25);
			//else if(con == 4)g.drawString("Player "+ pl.get(3).name()+ " Made it to the submarine!", 350, 25);
			//else if(con == 5)g.drawString("Player "+ pl.get(3).name()+ " Is already on the sub", 350, 25);
			//else if(con == 6)g.drawString("Player "+ pl.get(3).name()+ " Is already on the sub!", 350, 25);
			//else if(con == 0)g.drawString("It is Player "+ pl.get(3).name()+ "'s Turn!", 350, 25);
			g.drawImage(arrow, 861, 110,20,20,null);
			
		//	g.drawString(pl.get(playernum).getNumTreasure()+"", 100,150);

	}
	
		if(air< 0) {
			if(round <2)cond = "ROUND " + round +" OVER. You ran out of air! Round "+ (round+1) + " starts now with " + pl.get(0).name()  + " to move. (Click anywhere to continue)";
			else if (round == 2)cond = "ROUND " + round +" OVER. You ran out of air! Last round sarts now with " + pl.get(0).name() + " to move. (Click anywhere to continue)";
			else cond = "GAME OVER! You ran out of air! (Click anywhere to continue)";
		}
		else if(pl.get(0).inPlay() == false &&pl.get(1).inPlay() == false && pl.get(2).inPlay() == false && pl.get(3).inPlay() == false) 
		{
			if(round <2)cond = "ROUND " + round +" OVER. All players made it to the sub!! Round "+ (round+1) + " starts now with " + pl.get(0).name()  + " to move. (Click anywhere to continue)";
			else if (round ==2) cond = "ROUND " + round +" OVER. All players made it to the sub! Last round sarts now with " + pl.get(0).name() + " to move. (Click anywhere to continue)";
			else cond = "GAME OVER! All players made it to the sub!(Click anywhere to continue)";
		}
		g.drawString(cond, 350,25);

		}
		ArrayList<Chips> ar = new ArrayList<>(); 
		ar = pl.get(playernum).returnChips();
		g.drawImage(tb, 30,400,200,300,null);	
		int a = 0;
		for(Chips ea: ar) {
			if(a<4) {
			if(ea.getType() == 1) choice = ct1;
			else if(ea.getType() == 2) choice = ct2;
			else if(ea.getType() == 3) choice = ct3;
			else if(ea.getType() == 4) choice = ct4;
			else {
				if(ea.getTypeFirst() == 1) choice = ct1;
				else if(ea.getTypeFirst() == 2) choice = ct2;
				else if(ea.getTypeFirst() == 3) choice = ct3;
				else if(ea.getTypeFirst() == 4) choice = ct4;
				Font abc = new Font("SansSerif", 1, 18);
				}
			g.drawImage(choice, 40+a*50, 425, 50,50,null);
			if(ea.getType() == 5)g.drawString("STACK", 50+a*50, 435);
			a++;
						}
			else if(a<8) {
				if(ea.getType() == 1) choice = ct1;
				else if(ea.getType() == 2) choice = ct2;
				else if(ea.getType() == 3) choice = ct3;
				else if(ea.getType() == 4) choice = ct4;
				else {
					if(ea.getTypeFirst() == 1) choice = ct1;
					else if(ea.getTypeFirst() == 2) choice = ct2;
					else if(ea.getTypeFirst() == 3) choice = ct3;
					else if(ea.getTypeFirst() == 4) choice = ct4;
					Font abc = new Font("SansSerif", 1, 18);
				}
				g.drawImage(choice, 40+(a%4)*50, 485, 50,50,null);
				if(ea.getType() == 5)g.drawString("STACK", 50+a*50, 435);

				a++;
				}
			}
		ar = pl.get(playernum).returnTotal();
		a = 0;
		for(Chips ea: ar) {
			if(a<6) {
			if(ea.getType() == 1) choice = ct1;
			else if(ea.getType() == 2) choice = ct2;
			else if(ea.getType() == 3) choice = ct3;
			else if(ea.getType() == 4) choice = ct4;
			else {
				if(ea.getTypeFirst() == 1) choice = ct1;
				else if(ea.getTypeFirst() == 2) choice = ct2;
				else if(ea.getTypeFirst() == 3) choice = ct3;
				else if(ea.getTypeFirst() == 4) choice = ct4;
				Font abc = new Font("SansSerif", 1, 18);
			}
			g.drawImage(choice, 40+a*30, 580, 50,50,null);
			if(ea.getType() == 5)g.drawString("STACK", 50+a*30, 580);

			a++;
						}
			else if(a<12) {
				if(ea.getType() == 1) choice = ct1;
				else if(ea.getType() == 2) choice = ct2;
				else if(ea.getType() == 3) choice = ct3;
				else if(ea.getType() == 4) choice = ct4;
				else choice = ct0;
				g.drawImage(choice, 40+(a%6)*30, 640, 50,50,null);
				a++;
				}
			else if(a<18) {
				if(ea.getType() == 1) choice = ct1;
				else if(ea.getType() == 2) choice = ct2;
				else if(ea.getType() == 3) choice = ct3;
				else if(ea.getType() == 4) choice = ct4;
				else choice = ct0;
				g.drawImage(choice, 40+(a%12)*30, 700, 50,50,null);
				a++;
				}
			}

		if(round >3) {
			for(Player pppp:pl) {
				pppp.calcTotal();
			}
			g.drawImage(bg, 0,0, getWidth(), getHeight(),null);
			Font airFont = new Font("SansSerif",1, 70);
			g.setFont(airFont);
			g.drawString("GAME OVER", getWidth()/2-200, 50);
			g.drawImage(p1, 100,100,70,70,null);
			g.drawImage(ct1, 270,107,75,75, null);			
			g.drawImage(ct2, 370,107,75,75, null);			
			g.drawImage(ct3, 470,107,75,75, null);			
			g.drawImage(ct4, 570,107,75,75, null);	
			
			g.drawImage(ct1, 270,187,75,75, null);			
			g.drawImage(ct2, 370,187,75,75, null);			
			g.drawImage(ct3, 470,187,75,75, null);			
			g.drawImage(ct4, 570,187,75,75, null);	
			
			g.drawImage(ct1, 270,267,75,75, null);			
			g.drawImage(ct2, 370,267,75,75, null);			
			g.drawImage(ct3, 470,267,75,75, null);			
			g.drawImage(ct4, 570,267,75,75, null);	
			
			g.drawImage(ct1, 270,347,75,75, null);			
			g.drawImage(ct2, 370,347,75,75, null);			
			g.drawImage(ct3, 470,347,75,75, null);			
			g.drawImage(ct4, 570,347,75,75, null);	

			g.drawImage(p2, 100,180,70,70,null);
			g.drawImage(p3, 100,260,70,70,null);
			g.drawImage(p4, 100,320,70,70,null);
			Font pp = new Font("SansSerif", 1, 22);
			g.setColor(Color.white);
			g.setFont(pp);
			g.drawString("Score : " + pl.get(0).returnscore(),170,140);
			g.drawString("Score : " + pl.get(1).returnscore(),170,220);
			g.drawString("Score : " + pl.get(2).returnscore(),170,300);
			g.drawString("Score : " + pl.get(3).returnscore(),170,380);
			Font gg = new Font("SansSerif", 1, 12);
			g.drawString("x" + pl.get(0).t1(), 340, 162);
			g.drawString("x" + pl.get(0).t2(), 440, 162);
			g.drawString("x" + pl.get(0).t3(), 540, 162);
			g.drawString("x" + pl.get(0).t4(), 640, 162);
			
			g.drawString("x" + pl.get(1).t1(), 340, 242);
			g.drawString("x" + pl.get(1).t2(), 440, 242);
			g.drawString("x" + pl.get(1).t3(), 540, 242);
			g.drawString("x" + pl.get(1).t4(), 640, 242);
			
			g.drawString("x" + pl.get(2).t1(), 340, 322);
			g.drawString("x" + pl.get(2).t2(), 440, 322);
			g.drawString("x" + pl.get(2).t3(), 540, 322);
			g.drawString("x" + pl.get(2).t4(), 640, 322);
			
			g.drawString("x" + pl.get(3).t1(), 340, 402);
			g.drawString("x" + pl.get(3).t2(), 440, 402);
			g.drawString("x" + pl.get(3).t3(), 540, 402);
			g.drawString("x" + pl.get(3).t4(), 640, 402);
			System.out.println(pl.get(0).t1());
			String ggs = "";
			int s1,s2,s3,s4;
			boolean draw = false;
			s1 = pl.get(0).returnscore();
			s2 = pl.get(1).returnscore();
			s3 = pl.get(2).returnscore();
			s4 = pl.get(3).returnscore();
			String w1,w2,w3,w4; 
		/*	if(pl.get(0).returnscore()>pl.get(1).returnscore() && pl.get(0).returnscore()>pl.get(2).returnscore()&&pl.get(0).returnscore()>pl.get(3).returnscore())ggs = pl.get(0).name();
			else if(pl.get(1).returnscore()>pl.get(0).returnscore() && pl.get(1).returnscore()>pl.get(2).returnscore()&&pl.get(0).returnscore()>pl.get(3).returnscore())ggs = pl.get(1).name();
			else if(pl.get(2).returnscore()>pl.get(0).returnscore() && pl.get(2).returnscore()>pl.get(1).returnscore()&&pl.get(2).returnscore()>pl.get(3).returnscore())ggs = pl.get(2).name();
			else if(pl.get(3).returnscore()>pl.get(0).returnscore() && pl.get(3).returnscore()>pl.get(1).returnscore()&&pl.get(3).returnscore()>pl.get(2).returnscore())ggs = pl.get(3).name();
			else if(s1 == s2 && s1 > s3 && s1 > s4) {
				 if(pl.get(0).t4()>pl.get(1).t4()) ggs = pl.get(0).name();
				 else if(pl.get(0).t4()<pl.get(1).t4())ggs = pl.get(1).name();
				 else draw = true;
			} */
			ArrayList<Integer> xyz = new ArrayList<>();
			xyz.add(s1);
			xyz.add(s2);
			xyz.add(s3);
			xyz.add(s4);
			Collections.sort(xyz, Collections.reverseOrder());
			if(xyz.get(0)>xyz.get(1)) {
			if(xyz.get(0) == pl.get(0).returnscore()) { ggs = pl.get(0).name(); choice = p1;}
			if(xyz.get(0) == pl.get(1).returnscore()) {ggs = pl.get(1).name();choice = p2;}
			if(xyz.get(0) == pl.get(2).returnscore()) { ggs = pl.get(2).name();choice = p3;}
			if(xyz.get(0) == pl.get(3).returnscore()) {ggs = pl.get(3).name();choice = p4;}
			}
			else {
				if(xyz.get(1)==xyz.get(2)) {
					if(xyz.get(2)==xyz.get(3)) {//4 way
						if(pl.get(0).t4() > pl.get(1).t4()&& pl.get(0).t4()>pl.get(2).t4()&&pl.get(0).t4()>pl.get(3).t4()) { ggs = pl.get(0).name(); choice = p1;}
						else if(pl.get(1).t4() > pl.get(0).t4()&& pl.get(1).t4()>pl.get(2).t4()&&pl.get(1).t4()>pl.get(3).t4()) { ggs = pl.get(1).name(); choice = p2;}
						else if(pl.get(2).t4() > pl.get(1).t4()&& pl.get(2).t4()>pl.get(0).t4()&&pl.get(2).t4()>pl.get(3).t4()) { ggs = pl.get(2).name();choice = p3;}
						else if(pl.get(3).t4() > pl.get(1).t4()&& pl.get(3).t4()>pl.get(0).t4()&&pl.get(3).t4()>pl.get(2).t4()){ ggs = pl.get(3).name();choice = p4;}
						else {draw = true; str = "Four Way";}
					}
					else {//not 4 way onl 3 way
						if(s1 == xyz.get(3)) {pl.remove(0); fin.remove(0);}
						else if(s2 ==xyz.get(3)) {pl.remove(1); fin.remove(1);}
						else if (s3 == xyz.get(3)) {pl.remove(2);fin.remove(2);}
						else {pl.remove(3); fin.remove(3);}
						if(pl.get(0).t4() > pl.get(1).t4()&& pl.get(0).t4()>pl.get(2).t4()&&pl.get(0).t4()>pl.get(3).t4()) { ggs = pl.get(0).name(); }
						else if(pl.get(1).t4() > pl.get(0).t4()&& pl.get(1).t4()>pl.get(2).t4()&&pl.get(1).t4()>pl.get(3).t4()) { ggs = pl.get(1).name(); }
						else if(pl.get(2).t4() > pl.get(1).t4()&& pl.get(2).t4()>pl.get(0).t4()&&pl.get(2).t4()>pl.get(3).t4()) { ggs = pl.get(2).name();}
						else {draw = true; str = "Three Way";}
						if(ggs.equals("Red"))choice = p1;
						if(ggs.equals("Blue"))choice = p2;
						if(ggs.equals("Green"))choice = p3;
						if(ggs.equals("Yellow"))choice = p4;
					}//end 3way
				}
				else {//2 way
					if(s4 == xyz.get(2)||s4 == xyz.get(3)) {pl.remove(3); fin.remove(3);}
					if(s3 == xyz.get(2)||s3 == xyz.get(3)) {pl.remove(2);fin.remove(2);}
					if(s2 == xyz.get(2)||s2 == xyz.get(3)) {pl.remove(1);fin.remove(1);}
					if(s1 == xyz.get(2)||s1 == xyz.get(3)) {pl.remove(0);fin.remove(0);}
					if(pl.get(0).t4() > pl.get(1).t4()&& pl.get(0).t4()>pl.get(2).t4()&&pl.get(0).t4()>pl.get(3).t4()) { ggs = pl.get(0).name(); }
					else if(pl.get(1).t4() > pl.get(0).t4()&& pl.get(1).t4()>pl.get(2).t4()&&pl.get(1).t4()>pl.get(3).t4()) { ggs = pl.get(1).name(); }
					else {draw = true; str = "Two Way";}
					if(ggs.equals("Red"))choice = p1;
					if(ggs.equals("Blue"))choice = p2;
					if(ggs.equals("Green"))choice = p3;
					if(ggs.equals("Yellow"))choice = p4;
				}
			}

			if(draw == false) {
			Font geg = new Font("SansSerif", 1, 42);
			g.drawString("The Winner Is Player: " + ggs, 800, 200);
			g.drawImage(choice, 800,200,400,400,null);
			}
			if(draw == true && str.equals("Two Way")) {
				g.drawString("There was a two way tie with player "+pl.get(0).name()+ " and " +pl.get(1).name(), 800, 200);
				g.drawImage(fin.get(0), 800, 200, 200,200,null);
				g.drawImage(fin.get(1), 800, 400, 200,200,null);

			}
			if(draw == true && str.equals("Three Way")) {
				g.drawString("There was a three way tie with player "+pl.get(0).name()+ ", " + pl.get(1).name() + ", and " + pl.get(2).name(), 800, 200);
				g.drawImage(fin.get(0), 800, 200, 200,200,null);
				g.drawImage(fin.get(1), 1000, 200, 200,200,null);
				g.drawImage(fin.get(2), 900, 400, 200,200,null );
			}
			if(draw == true && str.equals("Four Way")) {
				g.drawString("There was a four way tie with player "+pl.get(0).name()+ ", " + pl.get(1).name() + ", " + pl.get(2).name() + " and " + pl.get(3).name(), 800, 200);
				g.drawImage(fin.get(0), 800, 200, 200,200,null);
				g.drawImage(fin.get(1), 1000, 200, 200,200,null);
				g.drawImage(fin.get(2), 800, 400, 200,200,null );
				g.drawImage(fin.get(3), 1000, 400, 200,200,null );

			}
		}
		
			
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (playernum > 3) playernum = 0;
		int x = e.getX();
		int y = e.getY();
		con = 1;
		rounds();
		System.out.println("loc is (" + x + ", " + y + ")");
		if(e.getButton() == e.BUTTON1) {//moveforward
			if(x>300 && x<500 && y >35 && y < 75) { 
						if(pl.get(playernum).inPlay() == true) {
							if(pl.get(playernum).hasChange() == false) {

							if(dhira == false) {
								air -= pl.get(playernum).getNumTreasure();
								pl.get(playernum).forw();

			cond = "Player "+ pl.get(playernum).name()+ " chose to go forwards!";

				repaint();
			dhira = true;
				}
			else 
				{
				cond = "You cannot choose your direction now!";
				 

				}
				System.out.println(dhira);
			}
			else {
				cond = "You have already changed direction this dive!";

			}
			}
			else {

				cond = "Player "+ pl.get(playernum).name()+ " Is already on the sub!";
				playernum++;			}
			}
			
			else if(x>500 && x < 700 && y > 35 && y < 75) {//backwards
				if(pl.get(playernum).inPlay() == true) {
					if(pl.get(playernum).hasChange() == false||pl.get(playernum).isBackward()==true) {
					if(dhira == false) {
				if(pl.get(playernum).initialSub() == true)cond = "You cannot go backwards!";
				else {
				pl.get(playernum).back();
				cond = "Player "+ pl.get(playernum).name()+ " chose to go backwards!";
				repaint(); 
				dhira = true;
				pl.get(playernum).setChanged(true);
				}
				
				}
				else {
					
					 cond = "You cannot choose your direction now!";

				}
				System.out.println(dhira);
				}
				else {
					cond = "You have already changed direction this dive!";
				}

			}
				else {
			
					cond = "Player "+ pl.get(playernum).name()+ " Is already on the sub!";
					 playernum++; 
				}
				
			}
			else if(x>700 && x < 900 && y > 35 && y <75) { //dice and move
				if(pl.get(playernum).inPlay() == true) {
					//if(dhira == true) {
						if(movee == false) {
							air -= pl.get(playernum).getNumTreasure();
					movee = true;
				diceval = (int)(Math.random()*5)+2;
				con=1;
				if(diceval-pl.get(playernum).getNumTreasure() > 0&& pl.get(playernum).getPos()!= -1) {
					cl.get(pl.get(playernum).getPos()).playerOff();
					System.out.println("chogga");
				}
				//if in play
				if (diceval-pl.get(playernum).getNumTreasure() < 0) {
					cond = 	"Player "+ pl.get(playernum).name()+ " rolled a "+ diceval+" and moved " + 0+" spots! Please Choose your action.";

				}
				else cond = 	"Player "+ pl.get(playernum).name()+ " rolled a "+ diceval+" and moved " + (diceval - pl.get(playernum).getNumTreasure() )+" spots! Please Choose your action.";
				for(int i = 0; i<diceval-pl.get(playernum).getNumTreasure(); i++) {
					System.out.println(pl.get(playernum).name());
					dhira = true;
				if(pl.get(playernum).isBackward() == false)move();
				else {
					moveBack();
					if(pl.get(playernum).isOnSub()==true&&pl.get(playernum).initialSub()==false)
					{
					if(playernum <3 )cond = "Player "+ pl.get(playernum).name()+ " Made it to the submarine with a roll of " + diceval + "! It is now "+ pl.get(playernum+1).name()+"'s turn.";
					else {
						cond = "Player "+ pl.get(playernum).name()+ " Made it to the submarine with a roll of " + diceval + "! It is now "+ pl.get(0).name()+"'s turn.";
					}
					playernum++;
					dhira = false;
					movee = false;
					break;
					}
				}
					}//loop
					}//move false
						else {
							cond = "You have already moved! Please choose your action.";
						}
				if(playernum > 3)playernum = 0;
				repaint();
				System.out.println(movee);
				if(pl.get(playernum).isOnSub()==false)
				{
				cl.get(pl.get(playernum).getPos()).playerOnn();
				System.out.println("aihaihaihaihaihaHAIAHIAHAIHAIHAIHAIAH");
				
					}
			
				}
				else {//else if not in play
					System.out.println(pl.get(playernum).name()+ " not in play");
					if(playernum <3)cond = "Player "+ pl.get(playernum).name()+ " Is already on the sub! It is now "+pl.get(playernum+1).name()+"'s turn" ;
					if(playernum >=3)cond = "Player "+ pl.get(playernum).name()+ " Is already on the sub! It is now "+pl.get(0).name()+"'s turn" ;
					playernum++;
					//con = 5;
					movee = false;
					dhira = false;
					repaint();
					}
			

				

			
			}
			else if(x>900 && x < 1100 && y > 35 && y <75 ) {//pickup
			if(pl.get(playernum).inPlay() == true) {
				if(movee = true) {
				if(cl.get(pl.get(playernum).getPos()).isEmpty()==false){
					
				
			int swap =	pl.get(playernum).getPos();
			pl.get(playernum).addC(cl.get(swap));
			blank(swap);
			repaint();
		//	playernum++;
			take = true;
			if(playernum <3)cond = "Player " + pl.get(playernum).name() + " picked up the treasure! It is now Player " + pl.get(playernum+1).name()+"'s turn.";
			else cond = "Player " + pl.get(playernum).name() + " picked up the treasure! It is now Player " + pl.get(0).name()+"'s turn.";
			System.out.println(take);
				}
				else cond = "You cannot pick up an empty chip!";
			}
				else cond = "You have not moved yet!";
			}
			else cond = "Player "+ pl.get(playernum).name()+ " Is already on the sub!";
			}
			else if(x> 1100 && x < 1300 && y > 35 && y <75 ) {//drop / swap
				
				System.out.println("drop");
				if(movee == true&&pl.get(playernum).getNumTreasure()>0&&cl.get(pl.get(playernum).getPos()).isEmpty()==true) {
					cl.remove(pl.get(playernum).getPos());
					cl.add(pl.get(playernum).getPos(),    pl.get(playernum).returnLast());	
					pl.get(playernum).removeLast();
					take = true;
					cond = "Player " + pl.get(playernum).name() + " Dropped their last treasure!";

				}
				else cond  = "You cannot do that! Choose to do something else.";
				repaint();
				
			}
			else if (x >1300 && x < 1500 && y >35 && y<75) {//nothing
				if(movee == true) {
				System.out.println("PRX SOMETHING");
				take = true;
				if(playernum <3)cond = "Player " + pl.get(playernum).name() + " chose to do nothing! It is now Player " + pl.get(playernum+1).name()+"'s turn.";
				else cond = "Player " + pl.get(playernum).name() + " chose to do nothing! It is now Player " + pl.get(0).name()+"'s turn.";
				System.out.println(take);
				}
				else {
					cond = "You need to roll the dice first!";
				}

			}
			if(playernum == 4)playernum = 0;
			if(take == true && movee == true) {
				playernum++;
				 dhira = false;
				 movee = false;
				take = false;
				
			}
		}
		//if(dhira == true&& movee == true)con =0;//fix monkey fat ftaftaftatfatftaf
		
		repaint();
	}
	public void move()  {
		if(cl.get(pl.get(playernum).getNextPos(1, cl)).isPlayer() == true) {
		System.out.println("one"); 
			if(cl.get(pl.get(playernum).getNextPos(2,cl)).isPlayer() == true) {
				System.out.println("two");
					if(cl.get(pl.get(playernum).getNextPos(3,cl)).isPlayer() == true) {
						System.out.println("three");
							if(cl.get(pl.get(playernum).getNextPos(4,cl)).isPlayer() == true) {
								System.out.println("four");
									if(cl.get(pl.get(playernum).getNextPos(5,cl)).isPlayer() == true) {
										System.out.println("five");
								}
									pl.get(playernum).addPos(cl);
							}
							pl.get(playernum).addPos(cl);
				}
				pl.get(playernum).addPos(cl);
		}
		pl.get(playernum).addPos(cl);	
		}
		
		
		
		pl.get(playernum).addPos(cl);
			int yp = cl.get( pl.get(playernum).getPos()).getY();
			int xp = cl.get(pl.get(playernum).getPos()).getX();
		pl.get(playernum).changeX(xp+10);
		pl.get(playernum).changeY(yp+20);
	}
	public void moveBack() {
		if(cl.get(pl.get(playernum).getNextPos(-1,cl)).isPlayer() == true) {
			System.out.println("one"); 
				if(cl.get(pl.get(playernum).getNextPos(-2,cl)).isPlayer() == true) {
					System.out.println("two");
						if(cl.get(pl.get(playernum).getNextPos(-3,cl)).isPlayer() == true) {
							System.out.println("three");
								if(cl.get(pl.get(playernum).getNextPos(-4,cl)).isPlayer() == true) {//useless
									System.out.println("four");
										if(cl.get(pl.get(playernum).getNextPos(-5,cl)).isPlayer() == true) {//useless
											System.out.println("five");
									}
										pl.get(playernum).subPos();
								}
								pl.get(playernum).subPos();
					}
					pl.get(playernum).subPos();
			}
			pl.get(playernum).subPos();	
			}
			
			
			
			pl.get(playernum).subPos();//subtract position by 1
			if(pl.get(playernum).isOnSub()==false||pl.get(playernum).initialSub() == true) {//checks if first turn or is on sub
				int yp = cl.get( pl.get(playernum).getPos()).getY();//get ypos of chip to land on
				int xp = cl.get(pl.get(playernum).getPos()).getX();//x pos
			pl.get(playernum).changeX(xp+10);
			pl.get(playernum).changeY(yp+20);
			}
			

			//ratio
			
	}
	public void blank(int i) {
		cl.set(i, new Chips(-1));
		cl.get(i).setX(pl.get(playernum).getLastX());
		cl.get(i).setY(pl.get(playernum).getLastY());
	}
	public void rounds() {
		int pp = 100;
		if(air < 0 ||round > 3||(pl.get(0).inPlay() == false &&pl.get(1).inPlay() == false && pl.get(2).inPlay() == false && pl.get(3).inPlay() == false)) {//is air smaller than 0 or if all players are on sub
			System.out.println("ecks dee");
			if(round <3)cond = "ROUND " + round +" OVER. Round "+ (round+1) + " starts now with " + pl.get(0).name()  + " to move. ";
			else cond = "ROUND " + round +" OVER. Last round sarts now with " + pl.get(0).name() + " to move. ";
			round++;
			playernum = 0;
			air = 25;
			pl.get(0).changeX(100);
			for(Player p:pl) {
				movee = false;
				take = false;
				p.setChanged(false);
				if(p.isOnSub()==true)     p.calcScore();
				else {
					ArrayList<Chips> ppt = p.returnChips();
					for(Chips eac: ppt) {
						clst.add(eac);
					}
				}
				pp+=25;
				p.changeX(pp);
				p.changeY(225);
				p.setInitial(true);
				p.setIsOnSub(true);
				p.forw();
				p.setInPlay(true);
				p.clearChip();
				p.setPos();
			}
			for(int i = cl.size()-1; i>=0; i--) {
				if(cl.get(i).getVal()==-1) {
					cl.remove(i);
				}
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
			System.out.println("HEHEHEHAW");
			int coun = clst.size()/3+clst.size()%3;

			int ok = 0;
			while(clst.size()>0) {
				for(int i = 0; i < coun; i++) {
					cl.add(new Chips(true));
					cl.get(cl.size()-1).stackAdd(clst.get(0));
					clst.remove(0);
					if(clst.size()==0)break;
					cl.get(cl.size()-1).stackAdd(clst.get(0));
					clst.remove(0);
					if(clst.size()==0)break;
					cl.get(cl.size()-1).stackAdd(clst.get(0));
					clst.remove(0);
					if(clst.size()==0)break;

				}
			}
		}
		else System.out.println("lmfao round not over L");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
