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
	
	//called when program begins. Creates all instances of Bottom
	public static void makeHeadwear()
	{
		
		//URLS
		URL h1 = Top.class.getResource("/ch1.png");
		URL h2 = Top.class.getResource("/ch2.png");
		URL h2_2 = Top.class.getResource("/ch2-2.png");
		URL h3 = Top.class.getResource("/ch3.png");
		URL h4 = Top.class.getResource("/ch4.png");
		URL h5 = Top.class.getResource("/ch5.png");
		URL h6 = Top.class.getResource("/ch6.png");
		// class objs
		//headwear.add(new Headwear("LA Dodgers hat","blue","47 Brand","DadHat"));
		//headwear.add(new Headwear("UWin Toque","blue","Adidas","Toque"));
		//headwear.add(new Headwear("Maple Leafs Toque","blue","Reebok","Toque"));
		
		headwear.add(new Headwear("UWin Hat","blue","The Game","FittedHat",h1));
		headwear.add(new Headwear("Maple Leafs Hat ","gray","Fanatics","Snapback",h2, h2_2));
		headwear.add(new Headwear("Titleist Golf Hat","gray","Titleist","GolfHat",h3));
		headwear.add(new Headwear("UA Golf Hat","white","Under Armour","GolfHat",h4));
		headwear.add(new Headwear("Essex DBacks Hat","black","New Era","FittedHat",h5));
		headwear.add(new Headwear("Windsor Championship","gray","The Game","GolfHat",h6));
	}
	
	//name of hat is important
		public String toString()
		{
			
			return "     Type: " + this.type + "\n     Name: " + this.name + "\n     Colour: " + this.colour + "\n     Brand: " + this.brand;
			
		}

}



