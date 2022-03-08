import java.net.URL;

public abstract class Clothing_article extends Outfit{
	
	// Types: head wear, tops, bottoms, foot wear(includes socks), accessories(belts/glasses/watch)
	
	// ATTRIBUTES
	public String name; //name of clothing article (don't include brand)
	public String colour; //colour of article
	public String brand; // brand of article
	public String type; //type of article(deeper than top,bottom etc.)
	public URL image; // image of article
	//public int season; // spring(1) summer(2) fall(3) winter(4)
	
	//CONSTRUCTORS
	
	//default
	public Clothing_article ()
	{
		//nothing
	}
	
	public Clothing_article (String n, String c, String b, String t, URL i)
	{
		name = n; 
		colour = c; 
		brand = b; 
		type = t; 
		image = i; 
	}
	
	//no image 
	public Clothing_article (String n, String c, String b, String t)
	{
		name = n; 
		colour = c; 
		brand = b; 
		type = t;  
	}
	
	
	//METHODS
	public String toString()
	{
		return "     Type: " + this.type + "\n     Colour: " + this.colour + "\n     Brand: " + this.brand;
	}
	

}
