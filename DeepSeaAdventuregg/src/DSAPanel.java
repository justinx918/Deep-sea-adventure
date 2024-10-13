import javax.swing.*;
import javax.swing.JFrame;

public class DSAPanel extends JFrame{
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 960;
	public DSAPanel(String title) {
		super(title);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new DSAListener());
		setVisible(true);
	}
}