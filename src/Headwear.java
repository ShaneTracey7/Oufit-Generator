import java.net.URL;
import java.util.ArrayList;

public class Headwear extends Clothing_article{
	
	/*
	 Types: 
	- FittedHat, Snapback, DadHat, Toques, Visors, GolfHat, Strapback
	 */
	// ATTRIBUTES
	URL x_image;
	
	//static fields
	public static ArrayList<Headwear> headwear = new ArrayList<Headwear>(); // all bottoms
	
	// CONSTRUCTORS
	
	//for no image (mainly for testing)
	public Headwear (String n, String c, String b, String t)
		{
			super(n,c,b,t);
			
		}
	//to include image
	public Headwear (String n, String c, String b, String t, URL i)
		{
			super(n,c,b,t,i);
			
		}
	//to for 2 images
	public Headwear (String n, String c, String b, String t, URL i,URL i2)
		{
			super(n,c,b,t,i);
			x_image = i2;
				
		}
	
	// METHODS
	
	//uses Top as context 
	public static Headwear getHeadwear(int season, Top top)
	{
		ArrayList<Headwear> filteredheadwear = new ArrayList<Headwear>();
		
		switch(season){
		
		case 1: //spring 
			{
				
			for (int count = 0; count < headwear.size(); count++)
			{
				if (!(headwear.get(count).type.contains("Toque"))) //No toques
				{
					filteredheadwear.add(headwear.get(count));
				}
			}
			return filteredheadwear.get(getRandom(filteredheadwear.size()));
			
			}
		case 2:  //summer
			{
				for (int count = 0; count < headwear.size(); count++)
				{
					if (headwear.get(count).type != "Toque") //No toques
					{
						filteredheadwear.add(headwear.get(count));
					}
				}
				return filteredheadwear.get(getRandom(filteredheadwear.size()));
			}
		case 3: //fall
			{
				for (int count = 0; count < headwear.size(); count++)
				{
					if (!(headwear.get(count).type.contains("Toque"))) //No toques
					{
						filteredheadwear.add(headwear.get(count));
					}
				}
				return filteredheadwear.get(getRandom(filteredheadwear.size()));
			}
		case 4: //winter
			{
				for (int count = 0; count < headwear.size(); count++)
				{
					if ((headwear.get(count).type.contains("Toque"))) //Toques only
					{
						filteredheadwear.add(headwear.get(count));
					}
				}
				return filteredheadwear.get(getRandom(filteredheadwear.size()));
			}
		
		default: System.out.println("default:getHeadwear");return filteredheadwear.get(0);
		
		
		
		}
		
	}
	
	//called when program begins. Creates all instances of Headwear
	//1 example of how this method works(should be many instances created)
	public static void makeHeadwear()
	{
		//URLS
		URL h1 = Top.class.getResource("/ch1.png");
		
		// class objs
		headwear.add(new Headwear("UWin Hat","blue","The Game","FittedHat",h1));
	}
	
	//name of hat is important
		public String toString()
		{
			
			return "     Type: " + this.type + "\n     Name: " + this.name + "\n     Colour: " + this.colour + "\n     Brand: " + this.brand;
			
		}

}



