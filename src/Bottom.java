import java.net.URL;
import java.util.ArrayList;

public class Bottom extends Clothing_article{
	
	/*
	 Types: 
	- shorts: Walking, Gym, Swim, and Pj  
	- pants: Jeans, Dress, Sweat, and Khaki
	 */
	
	public static ArrayList<Bottom> bottoms = new ArrayList<Bottom>(); // all bottoms
	
	// CONSTRUCTORS
	
	//for no image (mainly for testing)
	public Bottom (String n, String c, String b, String t)
		{
			super(n,c,b,t);
			
		}
	//to include image
	public Bottom (String n, String c, String b, String t, URL i)
		{
			super(n,c,b,t,i);
			
		}
	
	// METHODS
	
	//uses Top as context 
	public static Bottom getBottom(int season, Top top)
	{
		ArrayList<Bottom> filteredbottoms = new ArrayList<Bottom>();
		
		switch(season){
		
		case 1: //spring 
			{
				
			for (int count = 0; count < bottoms.size(); count++)
			{
				if (!(bottoms.get(count).type.contains("Shorts"))) //need to figure out restricted types
				{
					filteredbottoms.add(bottoms.get(count));
				}
			}
			return filteredbottoms.get(getRandom(filteredbottoms.size()));
			
			}
		case 2: //summer - need to fix case where flannel is selected as base or second layer and outfit wants an additional layer
			{
				for (int count = 0; count < bottoms.size(); count++)
				{
					if (bottoms.get(count).type != "Coat") //need to figure out restricted types for summer outfits
					{
						filteredbottoms.add(bottoms.get(count));
					}
				}
				return filteredbottoms.get(getRandom(filteredbottoms.size()));
			}
		case 3: //fall
			{
				for (int count = 0; count < bottoms.size(); count++)
				{
					if (!(bottoms.get(count).type.contains("Shorts"))) //add if it doesnt contain shorts
					{
						filteredbottoms.add(bottoms.get(count));
					}
				}
				return filteredbottoms.get(getRandom(filteredbottoms.size()));
			}
		case 4: //winter
			{
				for (int count = 0; count < bottoms.size(); count++)
				{
					if (!(bottoms.get(count).type.contains("Shorts"))) //need to figure out restricted types
					{
						filteredbottoms.add(bottoms.get(count));
					}
				}
				return filteredbottoms.get(getRandom(filteredbottoms.size()));
			}
		
		default: System.out.println("default:getBottom");return filteredbottoms.get(0);
		
		
		
		}
		
	}
	
	//called when program begins. Creates all instances of Bottom
	public static void makeBottoms()
	{
		
		//URLS
		URL b1 = Top.class.getResource("/cb1.png");
		URL b2 = Top.class.getResource("/cb2.png");
		URL b3 = Top.class.getResource("/cb3.png");
		URL b4 = Top.class.getResource("/cb4.png");
		URL b5 = Top.class.getResource("/cb5.png");
		URL b6 = Top.class.getResource("/cb6.png");
		URL b7 = Top.class.getResource("/cb7.png");
		URL b8 = Top.class.getResource("/cb8.png");
		URL b9 = Top.class.getResource("/cb9.png");
		URL b10 = Top.class.getResource("/cb10.png");
		// class objs
		bottoms.add(new Bottom("black jeans","black","Holister","Jeans",b1));
		bottoms.add(new Bottom("gray adidas sweats","gray","Adidas","SweatPants",b2));
		bottoms.add(new Bottom("blue white thigh jeans","blue","American Eagle","Jeans",b3));
		bottoms.add(new Bottom("H&M Khakis","khaki","H&M","Khakis",b4));
		bottoms.add(new Bottom("dark gray sweats","gray","CSG","SweatPants",b5));
		bottoms.add(new Bottom("gray jeans","gray","American Eagle","Jeans",b6));
		bottoms.add(new Bottom("Blue ripped jeans","navy blue","American Eagle","Jeans",b7));
		bottoms.add(new Bottom("Blue golf shorts","navy blue","Haggar","WalkingShorts",b8));
		bottoms.add(new Bottom("Gray gymshark shorts","gray","GymShark","Shorts",b9));
		bottoms.add(new Bottom("light blue pj shorts","blue","American Eagle","PjShorts",b10));
	}

}
