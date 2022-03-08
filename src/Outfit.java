import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* NOTES:
 * 
 * Should I connect to a database? cuz i need to Store hundreds of Clothing_article objects
 * 
 * Searching:
 * season
 * occasion: dt, around the house, school, fancy, casual, date
 * time: day or night
 * 
 * FIX:
 * -when i initially click generate, it should generate (after the second)
 *-getting a lot of bound must be positive ERROR from seasonal conditions @ Top 111
 * -footwear should be a lil smaller 250 wide maybe and hats 100x100
 * -rearrange control center (not on top of outfit)  
 * -make input areas nicer
 * - base layer width is set 300(only good for short sleeves) need to dynamically change to 420 for long sleeves.
 * - dynamically change location of accessory based off (belt, glasses, or watch)
 * - dynamically change location and sze of bottom based off (belt or shorts)
 * ADD:
 
 * - nice bg for window
 * -logic to come up with good outfits using context(base_layer)
 */

public class Outfit {
	
	// ATTRIBUTES
	public Top base_layer; 			// Anything but jackets/coats and hoodies 
	public Top second_layer; 		// anything but T-shirt or long sleeve shirt
	public Top third_layer; 		// only jackets/coats/flannels 
	public Bottom bottom;			// Pants,Shorts
	public Footwear footwear;		// Shoes,Boots,socks
	public Accessory accessory;		// Belts,watches,sunglasses,necklaces
	public Headwear headwear;		// Hats,toques,visors
	
	public int layer_count = 1;
	
	public boolean headwear_cb;
	public boolean accessory_cb;
	
	//static fields
	static int switcher = 0; 	//needed for more info feature
	
	static ImageIcon i_baselayer;  
	static ImageIcon i_secondlayer;
	static ImageIcon i_thirdlayer;
	static ImageIcon i_bottom;
	static ImageIcon i_footwear;
	static ImageIcon i_headwear;
	static ImageIcon i_accessory;
	
	static public int outfitIndex = -1; //after first outfit, it's incremented
	
	//used to make an outputs pictures properly visible
	static public ArrayList<JLabel> labels = new ArrayList<JLabel>();
	static public ArrayList<JTextArea> tAreas = new ArrayList<JTextArea>();
	
	//necessary for prev and next features
	static public ArrayList<Outfit> outfits = new ArrayList<Outfit>();
	
	
	// CONSTRUCTORS
	
	//default 
	public Outfit()
		{
			//does nothing		
		}
	// 1-LAYER
	
	// simple
	public Outfit(Top bl, Bottom b, Footwear f)
		{
			base_layer = bl;
			bottom = b;
			footwear = f;			
		}
	// accessory
	public Outfit(Top bl, Bottom b, Footwear f, Accessory a)
		{
			base_layer = bl;
			bottom = b;
			footwear = f;
			accessory = a;
		}
	// headwear
	public Outfit(Top bl, Bottom b, Footwear f, Headwear h)
		{
			base_layer = bl;
			bottom = b;
			footwear = f;
			headwear = h;
		}
	// all 
	public Outfit(Top bl, Bottom b, Footwear f, Headwear h, Accessory a)
		{
			base_layer = bl;
			bottom = b;
			footwear = f;
			accessory = a;				
			headwear = h;
		}
	// 2-LAYERS
	
	// simple
	public Outfit(Top bl, Top sl, Bottom b, Footwear f)
		{
			base_layer = bl;
			second_layer = sl;
			bottom = b;
			footwear = f;			
		}
	// accessory
	public Outfit(Top bl, Top sl, Bottom b, Footwear f, Accessory a)
		{
			base_layer = bl;
			second_layer = sl;
			bottom = b;
			footwear = f;
			accessory = a;
		}
	// headwear
	public Outfit(Top bl, Top sl, Bottom b, Footwear f, Headwear h)
		{
			base_layer = bl;
			second_layer = sl;
			bottom = b;
			footwear = f;
			headwear = h;
		}
	// all 
	public Outfit(Top bl, Top sl, Bottom b, Footwear f, Headwear h, Accessory a)
		{
			base_layer = bl;
			second_layer = sl;
			bottom = b;
			footwear = f;
			accessory = a;				
			headwear = h;
		}
	
	// 3-LAYERS
	
	// simple
	public Outfit(Top bl, Top sl, Top tl, Bottom b, Footwear f)
		{
			base_layer = bl;
			second_layer = sl;
			third_layer = tl;
			bottom = b;
			footwear = f;			
		}
	// accessory
	public Outfit(Top bl, Top sl, Top tl, Bottom b, Footwear f, Accessory a)
		{
			base_layer = bl;
			second_layer = sl;
			third_layer = tl;
			bottom = b;
			footwear = f;
			accessory = a;
		}
	// headwear
	public Outfit(Top bl, Top sl, Top tl, Bottom b, Footwear f, Headwear h)
		{
			base_layer = bl;
			second_layer = sl;
			third_layer = tl;
			bottom = b;
			footwear = f;
			headwear = h;
		}
	// all 
	public Outfit(Top bl, Top sl, Top tl, Bottom b, Footwear f, Headwear h, Accessory a)
		{
			base_layer = bl;
			second_layer = sl;
			third_layer = tl;
			bottom = b;
			footwear = f;
			accessory = a;				
			headwear = h;
		}
	//METHODS
	
				
	// gets random number given a size of list
	public static int getRandom(int size)
		{
			Random r = new Random();
			int index = r.nextInt(size); //0-size of list
			return index;
		}				
	
	public static void startup (JFrame frame2, JPanel panel)
	{
		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(1000, 800);
		frame2.setLocationRelativeTo(null); // puts frame in center of screen upon opening
		frame2.setResizable(false); 
		frame2.setMinimumSize(new Dimension(500,400));
		frame2.setMaximumSize(new Dimension(1000,800));
		//panel = new JPanel();
		panel .setLayout(null);
		frame2.add(panel);
		panel.setBackground(Color.darkGray);
		
		//logo
		URL logo_url = Outfit.class.getResource("/fglogo2.png");
		ImageIcon i_logo = new ImageIcon(logo_url);
		JLabel logo = new JLabel(i_logo); //new changed to static variable
		logo.setBounds(10,10,250,200);
		
		/*
		JTextField seasonInput = new JTextField("");
		seasonInput.setBounds(80,300,100, 30);
		seasonInput.setForeground(Color.DARK_GRAY);
		*/
		
		String seasons[]={"","Spring","Summer","Fall","Winter"};        
	    JComboBox<String> seasonInput = new JComboBox<String>(seasons);
	    seasonInput.setBounds(80,300,100, 30);
		
	    JCheckBox headwearCb = new JCheckBox("Headwear");
	    headwearCb.setBounds(80,350,100, 30);
	    
	    JCheckBox accessoryCb = new JCheckBox("Accessories");
	    accessoryCb.setBounds(80,400,100, 30);
		/*
		JLabel label4 = new JLabel("Enter Word:");
		label4.setBounds(10,165,100, 25);
		label4.setForeground(Color.white);
		label4.setFont(new java.awt.Font("Serif", Font.PLAIN, 18));
		label4.setVisible(true);
		*/
		
		JButton button = new JButton("Generate");
		button.setBounds(440,700,120, 30);
		button.setForeground(Color.black);
		
		JButton buttonE = new JButton("Exit");   //new
		buttonE.setBounds(80,240,100, 30);
		buttonE.setForeground(Color.black);
		
		JButton buttonC = new JButton("More Info");
		buttonC.setBounds(440,660,120, 30);
		buttonC.setForeground(Color.black);
		
		JButton buttonPrev = new JButton("Previous");
		buttonPrev.setBounds(220,700,120, 30);
		buttonPrev.setForeground(Color.black);
		
		JButton buttonNext = new JButton("Next");
		buttonNext.setBounds(660,700,120, 30);
		buttonNext.setForeground(Color.black);
		
		JButton buttonClear = new JButton("Clear");
		buttonClear.setBounds(80,600,100, 30);
		buttonClear.setForeground(Color.black);
		
		
		panel.add(logo);
		panel.add(seasonInput);
		panel.add(accessoryCb);
		panel.add(headwearCb);
		//panel.add(label4); 
		panel.add(button);
		panel.add(buttonE);  //new
		panel.add(buttonC);  //new
		panel.add(buttonPrev);  //new
		panel.add(buttonNext);  //new
		panel.add(buttonClear);  //new
		frame2.setVisible(true);
		
		//new
		buttonE.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		//previous outfit in ArrayList<Outfit> or nothing 
		buttonPrev.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e)
			{
				if(outfitIndex != 0 && outfitIndex != -1)
				{
					int cb = cb_to_int(headwearCb,accessoryCb );
					--outfitIndex;
					Outfit prevfit =outfits.get(outfitIndex);
				prevfit.setJComponent(prevfit, i_baselayer, i_secondlayer, i_thirdlayer, i_bottom, i_footwear, i_headwear, i_accessory, panel, frame2, cb);
					
				}
				else
				{
					//do nothing
				}
				
			}
		});
				
		//next outfit in ArrayList<Outfit> or new 
		buttonNext.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e)
			{
				if(outfits.size() == 0)
				{
					//do nothing
				}
				else if(outfitIndex == (outfits.size()-1))
				{
					//deciding if i want to create new outfit here
				}
				else
				{
					int cb = cb_to_int(headwearCb,accessoryCb );
					++outfitIndex;
					Outfit nextfit = outfits.get(outfitIndex);
					nextfit.setJComponent(nextfit, i_baselayer, i_secondlayer, i_thirdlayer, i_bottom, i_footwear, i_headwear, i_accessory, panel, frame2, cb);
					
				}
			}
		});
		
		//clears clothing article JLabels & outfit history (mainly for testing)
		buttonClear.addActionListener(new ActionListener() {
						
			public void actionPerformed(ActionEvent e)
			{
				for(int count = 0; count < labels.size(); count++)
				{
					labels.get(count).setVisible(false);
				}
				labels.clear();
				
				for(int count = 0; count < tAreas.size(); count++)
				{
					tAreas.get(count).setVisible(false);
				}
				
				//clearing Outfit history
				outfits.clear();
				outfitIndex = 0;
				
			}
		});
		
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{ 
				int cb = cb_to_int(headwearCb,accessoryCb); //might be issue with this
				/*
				int cb;
				if(headwearCb.isSelected() && accessoryCb.isSelected())
				{
					cb = 3; 
				}
				else if(headwearCb.isSelected())
				{
					cb = 2;
				}
				else if(accessoryCb.isSelected())
				{
					cb = 1;
				}
				else
				{
					cb = 0;
				}
				*/
				
				String season_str = null;
				//season_str = seasonInput.getText();
				season_str = (String)seasonInput.getSelectedItem();
				int season;
				
				// ensures outfit won't be created until a season is entered
				if(season_str == null)
				{
					return;
				}
				else
				{
				// converts season_str_ into an int
				if(season_str.equalsIgnoreCase("spring"))
				{
					season = 1;
				}
				else if(season_str.equalsIgnoreCase("summer"))
				{
					season = 2;
				}
				else if(season_str.equalsIgnoreCase("fall"))
				{
					season = 3;
				}
				else if(season_str.equalsIgnoreCase("winter"))
				{
					season = 4;
				}
				else
				{
					return;
				}
				
				System.out.println("Generator has begun.");
				
				Outfit fit = new Outfit();
				
				//fit.base_layer = null;
				//fit.second_layer = null;
				//fit.third_layer = null;
				//fit.bottom = null;
				//setting all stuff back to default
				//fit.layer_count = 1; //sets count back to default 
				//i_baselayer = null;
				//i_bottom = null;
				//i_footwear = null;
				
				
				System.out.println(fit.generateOutfit(season, cb));
				
				
				fit.setJComponent(fit, i_baselayer, i_secondlayer, i_thirdlayer, i_bottom, i_footwear, i_headwear, i_accessory, panel, frame2, cb);
				
				outfits.add(fit);
				++outfitIndex;
				frame2.revalidate();
				}
			}
		});
		
		buttonC.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				if(switcher % 2 == 1)
				{
					frame2.setSize(1000,800);
				}
				else
				{
					frame2.setSize(800,800);
				}
				
				++switcher;
			}
		});
		
	}
	
	public static int cb_to_int(JCheckBox cb1, JCheckBox cb2)
	{
		
		if(cb1.isSelected() && cb2.isSelected())
		{
			return 3;
		}
		else if(cb1.isSelected())
		{
			return 2;
		}
		else if(cb2.isSelected())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public static void clearLabels()
	{
		for(int count = 0; count < labels.size(); count++)
		{
			labels.get(count).setVisible(false);
		}
	}
	
	public static void clearTextAreas()
	{
		for(int count = 0; count < tAreas.size(); count++)
		{
			tAreas.get(count).setVisible(false);
		}
	}

	public Outfit generateOutfit(int season, int cb)
	{
		// get baselayer
		Top [] tops = new Top [2];
		int limiter;
		
		if(season == 4)
		{
			limiter = 1; //to make sure a winter outfit has minimum 2 top layers
		}
		else
		{
			limiter = 2;
		}
	
		base_layer = Top.getTop(season, 1, tops);
		
		//check to make sure it's not a jacket or coat
		if(base_layer.type != "Jacket" && base_layer.type != "Coat")
		{
			//decide if i want 1 more layer(random)
			if(Top.getRandom(limiter) == 0) //another layer
			{
				
				System.out.println("won the random");
				tops [0] = base_layer; // adds the first top
				second_layer = Top.getTop(season, 2, tops);
				layer_count = 2;
				
				if(season == 2)
				{
					// do nothing (prevents summer from reaching third-top-layer code)
				}
				else
				{
					//check to make sure it's not a jacket or coat
					if(second_layer.type != "Jacket" && second_layer.type != "Coat")
					{
						//decide if i want 1 more layer(random)
						if(Top.getRandom(2) == 1) //another layer
						{
							tops [1] = second_layer; // adds the first top
							third_layer = Top.getTop(season, 3, tops);
							layer_count = 3;
						}
						else
						{
							//nothing
						}
					}
					else
					{
						//nothing
					}
				}
			}
			else
			{
				System.out.println("Lost the random");
			}
		}
		else
		{
			//nothing
		}
		
		// get bottoms
		bottom = Bottom.getBottom(season, base_layer);
		
		//get shoes
		footwear = Footwear.getFootwear(season, base_layer);
		
		//cb is using the rsult of the checkboxes to determine if headwear and/or accessory are required
		switch(cb)
		{
		case 3:
		{
			headwear = Headwear.getHeadwear(season, base_layer);
			accessory = Accessory.getAccessory(season, base_layer);
			
			headwear_cb = true;
			accessory_cb = true;
			
			//create instance of outfit & return instance
			switch(layer_count)
			{
			case 1:	Outfit a = new Outfit(base_layer,bottom, footwear, headwear, accessory); return a;
			
			case 2: Outfit b = new Outfit(base_layer,second_layer, bottom, footwear, headwear, accessory); return b;
				
			case 3: Outfit c = new Outfit(base_layer, second_layer, third_layer, bottom, footwear, headwear, accessory); return c;
				
			default: Outfit d = new Outfit(base_layer,bottom, footwear); return d; //shouldn't happen
			}
			
		}
			
		case 2:
		{
			headwear = Headwear.getHeadwear(season, base_layer);
			
			headwear_cb = true;
			//create instance of outfit & return instance
			switch(layer_count)
			{
			case 1:	Outfit a = new Outfit(base_layer,bottom, footwear, headwear); return a;
			
			case 2: Outfit b = new Outfit(base_layer,second_layer, bottom, footwear, headwear); return b;
				
			case 3: Outfit c = new Outfit(base_layer, second_layer, third_layer, bottom, footwear, headwear); return c;
				
			default: Outfit d = new Outfit(base_layer,bottom, footwear); return d; //shouldn't happen
			}
		}
			
		case 1:
		{
			accessory = Accessory.getAccessory(season, base_layer);
			
			accessory_cb = true;
			//create instance of outfit & return instance
			switch(layer_count)
			{
			case 1:	Outfit a = new Outfit(base_layer,bottom, footwear, accessory); return a;
			
			case 2: Outfit b = new Outfit(base_layer,second_layer, bottom, footwear, accessory); return b;
				
			case 3: Outfit c = new Outfit(base_layer, second_layer, third_layer, bottom, footwear, accessory); return c;
				
			default: Outfit d = new Outfit(base_layer,bottom, footwear); return d; //shouldn't happen
			}
		}
			
		default: //0
		{
			//create instance of outfit & return instance
			switch(layer_count)
			{
			case 1:	Outfit a = new Outfit(base_layer,bottom, footwear); return a;
			
			case 2: Outfit b = new Outfit(base_layer,second_layer, bottom, footwear); return b;
				
			case 3: Outfit c = new Outfit(base_layer, second_layer, third_layer, bottom, footwear); return c;
				
			default: Outfit d = new Outfit(base_layer,bottom, footwear); return d; //shouldn't happen
			}
		}
			
		}
		
		
	}
	
	public void setJComponent(Outfit fit, ImageIcon base_layer, ImageIcon second_layer, ImageIcon third_layer, ImageIcon bottom, ImageIcon footwear,ImageIcon headwear, ImageIcon accessory, JPanel panel, JFrame frame2, int cb)
	{
		if(labels.size()!= 0)
		{
			clearLabels();
		}
		
		if(tAreas.size()!= 0)
		{
			clearTextAreas();
		}
		
		// check to see if headwear & accessory JComponents need to be set
		//has to be here so that the accessoy(belts) go on top of bottoms
		if(cb == 3) //both
		{
			accessory = new ImageIcon(fit.accessory.image);
			JLabel a = new JLabel(accessory); //new changed to static variable
			a.setBounds(400,415,200,25); //for belts
			panel.add(a);
			a.setVisible(true); //testing bc clear() makes it false
			labels.add(a);
			
			headwear = new ImageIcon(fit.headwear.image);
			JLabel h = new JLabel(headwear); //new changed to static variable
			h.setBounds(440,40,120,120);
			panel.add(h);
			h.setVisible(true); //testing bc clear() makes it false
			labels.add(h);
		}
		else if(cb == 2) // headwear
		{
			headwear = new ImageIcon(fit.headwear.image);
			JLabel h = new JLabel(headwear); //new changed to static variable
			h.setBounds(440,40,120,120);
			panel.add(h);
			h.setVisible(true); //testing bc clear() makes it false
			labels.add(h);
		}
		else if(cb == 1) // accessory
		{
			accessory = new ImageIcon(fit.accessory.image);
			JLabel a = new JLabel(accessory); //new changed to static variable
			a.setBounds(400,415,200,25); //for belts
			panel.add(a);
			a.setVisible(true); //testing bc clear() makes it false
			labels.add(a);
		}
		else 			//neither
		{
			
		}
		
			if(layer_count == 1)
			{
				System.out.println("base has image");
				base_layer = new ImageIcon(fit.base_layer.image);
				JLabel bl = new JLabel(base_layer); //new changed to static variable
				bl.setBounds(350,200,300,200);
				panel.add(bl);
				bl.setVisible(true); //testing bc clear() makes it false
				labels.add(bl);
			}
			else if(layer_count == 2)
			{
				
				System.out.println("second has image");
				
				if(fit.second_layer.type == "Flannel")
				{
					second_layer = new ImageIcon(fit.second_layer.x_image);
				}
				else
				{
					second_layer = new ImageIcon(fit.second_layer.image);
				}
				
				JLabel sl = new JLabel(second_layer); //new changed to static variable
				sl.setBounds(250,160,500,250);
				panel.add(sl);
				sl.setVisible(true); //testing bc clear() makes it false
				labels.add(sl);
				
				System.out.println("base has image");
				base_layer = new ImageIcon(fit.base_layer.image);
				JLabel bl = new JLabel(base_layer); //new changed to static variable
				bl.setBounds(350,200,300,200);
				panel.add(bl);
				bl.setVisible(true); //testing bc clear() makes it false
				labels.add(bl);
			}
			else
			{
				System.out.println("third has image");
				
				if(fit.third_layer.type == "Flannel")
				{
					third_layer = new ImageIcon(fit.third_layer.x_image);
				}
				else
				{
					third_layer = new ImageIcon(fit.third_layer.image);
				}
				
				JLabel tl = new JLabel(third_layer); //new changed to static variable
				tl.setBounds(250,160,500,250);
				panel.add(tl);
				tl.setVisible(true); //testing bc clear() makes it false
				labels.add(tl);
				
				System.out.println("second has image");
				
				if(fit.second_layer.type == "Flannel")
				{
					second_layer = new ImageIcon(fit.second_layer.x_image);
				}
				else
				{
					second_layer = new ImageIcon(fit.second_layer.image);
				}
				
				JLabel sl = new JLabel(second_layer); //new changed to static variable
				sl.setBounds(250,160,500,250);
				panel.add(sl);
				sl.setVisible(true); //testing bc clear() makes it false
				labels.add(sl);
				
				System.out.println("base has image");
				base_layer = new ImageIcon(fit.base_layer.image);
				JLabel bl = new JLabel(base_layer); //new changed to static variable
				bl.setBounds(350,200,300,200);
				panel.add(bl);
				bl.setVisible(true); //testing bc clear() makes it false
				labels.add(bl);			
				
			}
			
			//frame2.setSize(1000,800); //should display now
			frame2.setVisible(true);
			
			System.out.println("bottom has image");
			bottom = new ImageIcon(fit.bottom.image);
			JLabel b = new JLabel(bottom); //new changed to static variable
			
			if(fit.bottom.type.contains("Shorts"))
			{
				b.setBounds(350,410,300,150);
			}
			else
			{
				b.setBounds(400,410,200,200);
			}
			
			panel.add(b);
			b.setVisible(true); //testing bc clear() makes it false
			labels.add(b);
			
			System.out.println("footwear has image");
			footwear = new ImageIcon(fit.footwear.image);
			JLabel f = new JLabel(footwear); //new changed to static variable
			f.setBounds(400,610,300,100);
			
			panel.add(f);
			f.setVisible(true); //testing bc clear() makes it false
			labels.add(f);
			
			// Jcomponents for "more info" section
			JTextArea infoText = new JTextArea(fit.toString());
			infoText.setBounds(810,100,180,600);
			infoText.setEditable(false);
			infoText.setBackground(Color.DARK_GRAY);
			infoText.setForeground(Color.green);
			panel.add(infoText);
			infoText.setVisible(true); //testing bc clear() makes it false
			tAreas.add(infoText);
			
			JLabel infoTitle = new JLabel("Clothing Info");
			infoTitle.setBounds(810,50,180,30);
			infoTitle.setHorizontalAlignment(JTextField.CENTER);
			//infoTitle.setFont(font3);
			infoTitle.setForeground(Color.white);
			panel.add(infoTitle);
			infoTitle.setVisible(true); //testing bc clear() makes it false
			labels.add(infoTitle);
			 
	}
	
public String toString() 
	
	{
	if(accessory_cb && headwear_cb)
	{
		if(layer_count == 1)
		{
			return  "Headwear: \n" + this.headwear + "\n\n Base layer: \n" + this.base_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Accessory: \n" + this.accessory + "\n\n Footwear: \n" + this.footwear;
			
		}
		else if (layer_count == 2)
		{
			return "Headwear: \n" + this.headwear + "\n\nBase layer: \n" + this.base_layer + "\n\n Second layer: \n" + this.second_layer + "\n\n Bottom: \n" + this.bottom +"\n\n Accessory: \n" + this.accessory + "\n\n Footwear: \n" + this.footwear ;
			
		}
		else
		{
			return "Headwear: \n" + this.headwear + "\n\nBase layer: \n" + this.base_layer + "\n\n Second layer: \n" + this.second_layer + "\n\n Third layer: \n" + this.third_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Accessory: \n" + this.accessory + "\n\n Footwear: \n" + this.footwear;
				
		}
	}
	else if(headwear_cb)
	{
		if(layer_count == 1)
		{
			return  "Headwear: \n" + this.headwear + "\n\n Base layer: \n" + this.base_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Footwear: \n" + this.footwear;
			
		}
		else if (layer_count == 2)
		{
			return "Headwear: \n" + this.headwear + "\n\nBase layer: \n" + this.base_layer + "\n\n Second layer: \n" + this.second_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Footwear: \n" + this.footwear ;
			
		}
		else
		{
			return "Headwear: \n" + this.headwear + "\n\nBase layer: \n" + this.base_layer + "\n\n Second layer: \n" + this.second_layer + "\n\n Third layer: \n" + this.third_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Footwear: \n" + this.footwear;
				
		}
	}
	else if(accessory_cb)
	{
		if(layer_count == 1)
		{
			return  "Base layer: \n" + this.base_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Accessory: \n" + this.accessory + "\n\n Footwear: \n" + this.footwear;
			
		}
		else if (layer_count == 2)
		{
			return "Base layer: \n" + this.base_layer + "\n\n Second layer: \n" + this.second_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Accessory: \n" + this.accessory + "\n\n Footwear: \n" + this.footwear ;
			
		}
		else
		{
			return "Base layer: \n" + this.base_layer + "\n\n Second layer: \n" + this.second_layer + "\n\n Third layer: \n" + this.third_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Accessory: \n" + this.accessory + "\n\n Footwear: \n" + this.footwear;
				
		}
	}
	else
	{
		if(layer_count == 1)
		{
			return  "Base layer: \n" + this.base_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Footwear: \n" + this.footwear;
			
		}
		else if (layer_count == 2)
		{
			return "Base layer: \n" + this.base_layer + "\n\n Second layer: \n" + this.second_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Footwear: \n" + this.footwear ;
			
		}
		else
		{
			return "Base layer: \n" + this.base_layer + "\n\n Second layer: \n" + this.second_layer + "\n\n Third layer: \n" + this.third_layer + "\n\n Bottom: \n" + this.bottom + "\n\n Footwear: \n" + this.footwear;
				
		}
	}		
		
	}

}
