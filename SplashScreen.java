/*  Name: Julia Xie
    Program Name: Snake
    Teacher: Ms. Krasteva
    Date: January 16, 2019
    Description: The main purpose of this class is to use threads to display an animation
*/

import java.awt.*;
import hsa.Console;
import java.lang.*;

public class SplashScreen extends Thread
{
    private Console c;

    /*  Purpose of Method: The purpose of this method is to display an animation in the splash screen.
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------
	Name:       Type:           Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------
	green       Color           It is the colour of the snake.
	red         Color           It is the colour of the food.
	background  Color           It is the colour of the background.
    */
    public void animation ()
    {
	Color background = new Color (255, 232, 186);
	Color green = new Color (92, 132, 72);
	Color red = new Color (178, 62, 62);
	c.setColour (red);
	c.fillOval (680, 300, 20, 20);
	// Purpose of Loop: The purpose of this loop is to allow the snake animation to move right.
	for (int i = 0 ; i < 700 ; i++)
	{
	    c.setColour (background);
	    c.fillRect (-200 + i, 300, 200, 20);
	    c.setColour (green);
	    c.fillRoundRect (-199 + i, 300, 200, 20, 10, 10);
	    // Purpose of Try Block: The purpose of this try block to delay the animation.
	    try
	    {
		sleep (5);
	    }
	    catch (InterruptedException e)
	    {
	    }
	}
	// Purpose of Loop: The purpose of this loop is to allow the snake animation to turn left around a corner.
	for (int i = 0 ; i < 180 ; i++)
	{
	    c.setColour (background);
	    c.fillRect (500 + i, 300, 180 - i, 20);
	    c.setColour (green);
	    c.fillRoundRect (501 + i, 300, 199 - i, 20, 10, 10);
	    c.fillRoundRect (680, 300 + i, 20, 20, 10, 10);
	    // Purpose of Try Block: The purpose of this try block to delay the animation.
	    try
	    {
		sleep (5);
	    }
	    catch (InterruptedException e)
	    {
	    }
	}
	c.setColour (red);
	c.fillOval (300, 640, 20, 20);
	// Purpose of Loop: The purpose of this loop is to allow the snake animation to move down.
	for (int i = 0 ; i < 160 ; i++)
	{
	    c.setColour (background);
	    c.fillRect (680, 299 + i, 20, 201);
	    c.setColour (green);
	    c.fillRoundRect (680, 300 + i, 20, 200, 10, 10);
	    // Purpose of Try Block: The purpose of this try block to delay the animation.
	    try
	    {
		sleep (5);
	    }
	    catch (InterruptedException e)
	    {
	    }
	}
	// Purpose of Loop: The purpose of this loop is to allow the snake animation to turn left around a corner.
	for (int i = 0 ; i < 180 ; i++)
	{
	    c.setColour (background);
	    c.fillRect (680, 459 + i, 21, 181 - i);
	    c.setColour (green);
	    c.fillRoundRect (681, 461 + i, 20, 199 - i, 10, 10);
	    c.fillRoundRect (681 - i, 640, 20, 20, 10, 10);
	    // Purpose of Try Block: The purpose of this try block to delay the animation.
	    try
	    {
		sleep (5);
	    }
	    catch (InterruptedException e)
	    {
	    }
	}
	// Purpose of Loop: The purpose of this loop is to allow the snake animation to move left.
	for (int i = 0 ; i < 702 ; i++)
	{
	    c.setColour (background);
	    c.fillRect (501 - i, 640, 201, 20);
	    c.setColour (green);
	    c.fillRoundRect (501 - i, 640, 200, 20, 10, 10);
	    // Purpose of Try Block: The purpose of this try block to delay the animation.
	    try
	    {
		sleep (5);
	    }
	    catch (InterruptedException e)
	    {
	    }
	}
    }

    // Purpose of constructor: The purpose of this constructor is to pass the console to a variable called con
    public SplashScreen (Console con)
    {
	c = con;
    }

    // Purpose of Method: The purpose of this method is to execute the animation method
    public void run ()
    {
	animation ();
    }
}
