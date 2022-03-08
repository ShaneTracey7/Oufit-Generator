import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Top extends Clothing_article { 
	
	/*
	 Types: 
	- t-shirt - graphic tee/solid tee/
	- long sleeve - graphic tee/solid tee/
	- button down
	- hoodie
	- jacket - zip up/ button up/heavy/light
	-flannel
	 */
	
	//attributes
	int layer; // first(1), second(2), or third(2)
	URL x_image; //extra image for flannels
	public static ArrayList<Top> tops = new ArrayList<Top>(); // all tops
	/*
	ArrayList<Top> base_layers; // all base layers
	ArrayList<Top> second_layers; // all second layers
	ArrayList<Top> third_layers; // all third layers
	*/
	
	//CONSTRUCTORS
	
	//for no image (mainly for testing)
	public Top (String n, String c, String b, String t, int l)
	{
		super(n,c,b,t);
		layer = l;
		
	}
	//to include image
	public Top (String n, String c, String b, String t, URL i, int l)
	{
		super(n,c,b,t,i);
		layer = l;
		
	}
	
	//to for 2 images
		public Top (String n, String c, String b, String t, URL i,URL i2, int l)
		{
			super(n,c,b,t,i);
			layer = l;
			x_image = i2;
			
		}
	/*
	public Top ()
	{
		super("n","c","b","t",0);
		layer = 0;
		
	}
	*/
	//METHODS
	
	
	//completely random clothes(season independent)
	
	// the outfit revolves around the base layer (randomly selected form list) 
	public Top getBaseLayer()
	{
		int max = tops.size();
		Random r = new Random();
		int index = r.nextInt(max); //0-size of list
		return tops.get(index);
	}
	
	
	// season dependent
	
	// NEED TO MAKE THIS ACCURATE PER SEASON (CREATE RESTRICTIONS ON WHAT CLOTHES WORK PER SEASON)
	// the outfit revolves around the base layer (randomly selected from list) given season 
		public static Top getTop(int season, int layer, Top [] current_tops)
		{
			ArrayList<Top> unfilteredtops = new ArrayList<Top>();
			ArrayList<Top> filteredtops = new ArrayList<Top>();
			
			switch(season){
			
			case 1: //spring 
				{
					System.out.println("season:"+ season);
				unfilteredtops = getTopLayer(layer, current_tops);
				for (int count = 0; count < unfilteredtops.size(); count++)
				{
					if (unfilteredtops.get(count).type != "Coat")
					{
						filteredtops.add(unfilteredtops.get(count));
					}
				}
				return filteredtops.get(getRandom(filteredtops.size()));
				
				}
			case 2: //summer - need to fix case where flannel is selected as base or second layer and outfit wants an additional layer
				{
					System.out.println("season:"+ season);
				unfilteredtops = getTopLayer(layer, current_tops);	
				for (int count = 0; count < unfilteredtops.size(); count++)
				{
					if (unfilteredtops.get(count).type != "Hoodie" && unfilteredtops.get(count).type != "Jacket" && unfilteredtops.get(count).type != "Coat")
					{
						filteredtops.add(unfilteredtops.get(count));
					}
				}
				return filteredtops.get(getRandom(filteredtops.size()));
				}
			case 3: //fall
				{
					System.out.println("season:"+ season);
				unfilteredtops = getTopLayer(layer, current_tops);
				for (int count = 0; count < unfilteredtops.size(); count++)
				{
					if (unfilteredtops.get(count).type != "Coat")
					{
						filteredtops.add(unfilteredtops.get(count));
					}
				}
				return filteredtops.get(getRandom(filteredtops.size()));
				}
			case 4: //winter
				{
					System.out.println("season:"+ season);
				unfilteredtops = getTopLayer(layer, current_tops);
				for (int count = 0; count < unfilteredtops.size(); count++)
				{
					if (true) //wear any shirt in the winter
					{
						filteredtops.add(unfilteredtops.get(count));
					}
				}
				return filteredtops.get(getRandom(filteredtops.size()));
				}
			
			default: System.out.println("default:getTop");return filteredtops.get(0);
			
			
			
			}
			
		}
		
	// returns a random summer top
	public static ArrayList<Top> getTopLayer(int layer, Top [] current_tops)
	{
		ArrayList<Top> layerlist = new ArrayList<Top>();

		switch(layer)
		{
			case 1: // first layer
			{
				System.out.println("layer:"+ layer);
				for (int count = 0; count < tops.size(); count++)
				{
					if (tops.get(count).type != "Hoodie" && tops.get(count).type != "Jacket" && tops.get(count).type != "Coat")
					{
						layerlist.add(tops.get(count));
					}
				}
				return layerlist;
			}
			
			case 2: // second layer
			{
				System.out.println("layer:"+ layer);
				for (int count = 0; count < tops.size(); count++)
				{
					if(tops.get(count).type == current_tops [0].type || tops.get(count).type == "Hoodie" && current_tops [0].type == "Flannel") 
					//skips if baselayer has same type as second or flannel then hoodie
					{
						continue;
					}
					if (tops.get(count).type != "T-Shirt" && tops.get(count).type != "Long-Sleeve")
					{
						layerlist.add(tops.get(count));
					}
				}
				return layerlist;
			}
			
			case 3: 
			{
				System.out.println("layer:"+ layer);
				for (int count = 0; count < tops.size(); count++)
				{
					
					if(tops.get(count).type == current_tops [0].type || tops.get(count).type == "Hoodie" && current_tops [0].type == "Flannel") 
						//skips if baselayer has same type as second or flannel then hoodie
						{
							continue;
						}
					
					if (tops.get(count).type == "Jacket" || tops.get(count).type == "Coat" || tops.get(count).type == "Flannel")
					{
						layerlist.add(tops.get(count));
					}
				}
				return layerlist;
			}
			
			default: System.out.println("default: getTopLayer");return layerlist; //this case shouldn't happen
		}
		
	}
	/*
	public String toString()
	{
		if(this.image != null) //only here for testing 
		{
		return "Name: " + this.name + "\n Colour " + this.colour;
		}
		else
		{
		return "Name: " + this.name + " Colour: " + this.colour;
		}
	}
	*/
	
	//creates all instances of Top
	//1 example of how this method works(should be many instances created)
	public static void makeTops()
	{
		//URLS
		URL t1 = Top.class.getResource("/ct1.png");
		
		// class objs
		tops.add(new Top("bbno$","black","gilden","T-Shirt",t1,1));
	}
	
	
}
