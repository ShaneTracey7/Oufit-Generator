# Oufit-Generator

This is a desktop application that generates outfits, written in Java, made up of up to 7 clothing articles: a top (base layer, secondary layer, and tertiary layer), a bottom (ex. jeans, shorts, and etc.), footwear, headwear (ex. abaseball cap), and accessories (ex. sunglasses, a belt and etc.). It takes into account what season (spring, summer, fall, winter) it is when selecting outfits, so it can produce relevant options. Every outfit has at least 1 top, 1 bottom, and a footwear selection, with checkboxes to add headwear and accessories available. Once generated, images of all the clothing articles populate the middle of the screen, displayed in a similar way as if you were to be wearing the clothes.

Purpose: To generate outfits given someone's current wardrobe. Can help solve the problem of deciding what to wear. 

Inspiration: I saw someone made their own outfit generator on social media, thought it would solve a plobem of mine, and be something fun to do. 

User Interface(UI):

The UI consists of several buttons, a drop-down selection, and 2 checkboxes.

Buttons:

Exit button - Exits the application.
Clear button - Clears the current Outfit's graphics and data from screen, as well as the Outfit History.
More Info button - expands the main window to make the current outfit's information avaiable (each clothing article's type, colour, brand, and occasionally name).
Generate button - Creates an outfit and displays to the middle of the screen.
Previous and Next buttons- If the user has created multiple outfits, they can use these buttons to navigate throught the history of outfits generated, during the current session.

Checkboxes:

Headwear checkbox - When selected, headwear will be filtered into the next generated outfit. 
Accessories checkbox - When selected, Accessories will be filtered into the next generated outfit.

Dropdown selection:

Season dropdown selection - This mandatory selection gives the season input for the outfit, upon outfit generation (ex. ensures the outfit won't have winter boots if summer was selected).

For Graphics, this program uses the Java Swing library (JFrame, JLabel, JButton, and etc.). All windows use abosolute positioning for their layout and cannot be resized.

Images:

Logo was created in Google Draw and sized using online png resizer. 

Setup:

I have a function to create instances of each clothing article (Top, Bottom, Footwear, Headwear and Accessories) in their respective classes. Each instance contains a resized png of the clothing article and several revelant data points. All these instances are added to an ArrayList of their class type and are accessed from there. 

So currently, you'd have to hard-code each instance of your wardrobe you desire to use the outfit generator with, within the make()functions.

To start:

To start, you simply press the 'Generate' button.

To finish:

To finish, you can either close the main window or press the 'Exit' button.

Future plans:

Currently, outfits are generated without taking color and material coordination into consideration. I plan on implementing such filters.

