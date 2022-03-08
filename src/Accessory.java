import java.net.URL;
import java.util.ArrayList;

public class Accessory extends Clothing_article {
	
	/*
	 Types: 
	- Watch, belt, sunglasses
	 */
	
	//static fields
	public static ArrayList<Accessory> accessory = new ArrayList<Accessory>(); // all bottoms
	
	// CONSTRUCTORS
	
	//for no image (mainly for testing)
	public Accessory (String n, String c, String b, String t)
		{
			super(n,c,b,t);
			
		}
	//to include image
	public Accessory (String n, String c, String b, String t, URL i)
		{
			super(n,c,b,t,i);
			
		}
	
	// METHODS
	
	//uses Top as context 
	public static Accessory getAccessory(int season, Top top)
	{
		ArrayList<Accessory> filteredaccessory = new ArrayList<Accessory>();
		
		switch(season){
		
		case 1: //spring 
			{
				
			for (int count = 0; count < accessory.size(); count++)
			{
				if (!(accessory.get(count).type.contains("Toque"))) //No toques
				{
					filteredaccessory.add(accessory.get(count));
				}
			}
			return filteredaccessory.get(getRandom(filteredaccessory.size()));
			
			}
		case 2:  //summer
			{
				for (int count = 0; count < accessory.size(); count++)
				{
					if (accessory.get(count).type != "Toque") //No toques
					{
						filteredaccessory.add(accessory.get(count));
					}
				}
				return filteredaccessory.get(getRandom(filteredaccessory.size()));
			}
		case 3: //fall
			{
				for (int count = 0; count < accessory.size(); count++)
				{
					if (!(accessory.get(count).type.contains("Toque"))) //No toques
					{
						filteredaccessory.add(accessory.get(count));
					}
				}
				return filteredaccessory.get(getRandom(filteredaccessory.size()));
			}
		case 4: //winter
			{
				for (int count = 0; count < accessory.size(); count++)
				{
					if (!(accessory.get(count).type.contains("Sunglasses"))) //no sunglasses
					{
						filteredaccessory.add(accessory.get(count));
					}
				}
				return filteredaccessory.get(getRandom(filteredaccessory.size()));
			}
		
		default: System.out.println("default:getAccessory");return filteredaccessory.get(0);
		
		
		
		}
		
	}
	
	//called when program begins. Creates all instances of Bottom
	public static void makeAccessory()
	{
		
		//URLS
		URL a1 = Top.class.getResource("/ca1.png");
		URL a2 = Top.class.getResource("/ca2.png");
		URL a3 = Top.class.getResource("/ca3.png");
		URL a4 = Top.class.getResource("/ca4.png");
		URL a5 = Top.class.getResource("/ca5.png");
		// class objs
		//accessory.add(new Accessory("Apple watch","black","Apple","Watch"));
		
		accessory.add(new Accessory("White Cloth Belt","white","Unknown","Belt",a1));
		accessory.add(new Accessory("Go-to Brown Belt","brown","Levi's","Belt",a2));
		accessory.add(new Accessory("Brown Prom Dress Belt","brown","Unknown","Belt",a3));
		accessory.add(new Accessory("Knock Off Ray-Ban's","grey","Walmart","Sunglasses",a4));
		accessory.add(new Accessory("Black Costco Belt","black","Columnbia","Belt",a5));
	}
	
	//name of hat is important
		public String toString()
		{
			
			return "     Type: " + this.type + "\n     Name: " + this.name + "\n     Colour: " + this.colour + "\n     Brand: " + this.brand;
			
		}

}


