import java.net.URL;
import java.util.ArrayList;

public class Footwear extends Clothing_article{

	/*
	 Types: 
	 -socks: Ankle, High
	 -Shoes: Running, Casual, Dress, Boots, WinterBoots, Sandal
	 */
	
public static ArrayList<Footwear> footwears = new ArrayList<Footwear>(); // all bottoms
	
	// CONSTRUCTORS
	
	//for no image (mainly for testing)
	public Footwear (String n, String c, String b, String t)
		{
			super(n,c,b,t);
			
		}
	//to include image
	public Footwear (String n, String c, String b, String t, URL i)
		{
			super(n,c,b,t,i);
			
		}
	
	// METHODS
	
	//uses Top as context 
	public static Footwear getFootwear(int season, Top top)
	{
		ArrayList<Footwear> filteredfootwears = new ArrayList<Footwear>();
		
		switch(season){
		
		case 1: //spring 
			{
				
			for (int count = 0; count < footwears.size(); count++)
			{
				if (!(footwears.get(count).type.contains("Winter"))) //can't wear winter footwear (winter boots)
				{
					filteredfootwears.add(footwears.get(count));
				}
			}
			return filteredfootwears.get(getRandom(filteredfootwears.size()));
			
			}
		case 2: //summer 
			{
				for (int count = 0; count < footwears.size(); count++)
				{
					if (!(footwears.get(count).type.contains("Boots"))) //can't wear boots
					{
						filteredfootwears.add(footwears.get(count));
					}
				}
				return filteredfootwears.get(getRandom(filteredfootwears.size()));
				
			}
		case 3: //fall
			{
				for (int count = 0; count < footwears.size(); count++)
				{
					if (!(footwears.get(count).type.contains("Winter"))) //can't wear winter footwear (winter boots)
					{
						filteredfootwears.add(footwears.get(count));
					}
				}
				return filteredfootwears.get(getRandom(filteredfootwears.size()));
				
			}
		case 4: //winter
			{
				for (int count = 0; count < footwears.size(); count++)
				{
					if (!(footwears.get(count).type.contains("Sandal"))) //can't wear sandals in the winter
					{
						filteredfootwears.add(footwears.get(count));
					}
				}
				return filteredfootwears.get(getRandom(filteredfootwears.size()));
				
			}
		
		default: System.out.println("default:getFootwear");return filteredfootwears.get(0);
		
		
		
		}
		
	}
	
	//called when program begins. Creates all instances of Footwear
	//1 example of how this method works(should be many instances created)
	public static void makeFootwear()
	{
		
		//URLS
		URL c1 = Top.class.getResource("/cf1-2.png");
		
		// class objs
		footwears.add(new Footwear("nike af1s","white","Nike","Casual",c1));
	}
	
	//name of shoe is important
	public String toString()
	{
		
		return "     Type: " + this.type + "\n     Name: " + this.name + "\n     Colour: " + this.colour + "\n     Brand: " + this.brand;
		
	}
	

}
	
	
	

