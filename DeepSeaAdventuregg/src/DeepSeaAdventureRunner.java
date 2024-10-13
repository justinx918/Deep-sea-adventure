import javax.swing.*;
public class DeepSeaAdventureRunner {
	public static void main(String []args) {
		//DSAPanel dsa1 = new DSAPanel("GG");	
		DSAPanel dsa1 = new DSAPanel("GGEZ");
		System.out.println("apsodapsodapsodaspodpasdoapsod");
		int x = 3;
		int y = -4;
		
		try {
            // Adding a 3-second delay (3000 milliseconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // Handle the exception
            e.printStackTrace();
        }
		System.out.println(x+y);
	}
}
