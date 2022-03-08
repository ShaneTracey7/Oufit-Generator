import javax.swing.JFrame;
import javax.swing.JPanel;

public class Generator {

	

/*NOTES:
 * 
 * Do i need this class? atm... not really (i can move main method back) 
 */
	
	// ATTRIBUTES
	public Outfit fit;

	
	//METHODS
	
	public static void main(String[] args) 
	{
		//makes headwears
		Headwear.makeHeadwear();
		
		//makes tops
		Top.makeTops();
		
		//makes bottoms
		Bottom.makeBottoms();
		
		//makes footwears
		Footwear.makeFootwear();
		
		//makes accessories
		Accessory.makeAccessory();
		
		JFrame frame2 = new JFrame("Fit Generator");
		JPanel panel = new JPanel();
		Outfit.startup(frame2,panel);
	}
	
	
	
}
