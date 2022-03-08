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
	
	//called when program begins. Creates all instances of Accessory
	//1 example of how this method works(should be many instances created)
	public static void makeAccessory()
	{
		
		//URLS
		URL a1 = Top.class.getResource("/ca1.png");
		
		accessory.add(new Accessory("White Cloth Belt","white","Unknown","Belt",a1));
	}
	
	//name of hat is important
		public String toString()
		{
			
			return "     Type: " + this.type + "\n     Name: " + this.name + "\n     Colour: " + this.colour + "\n     Brand: " + this.brand;
			
		}

}


