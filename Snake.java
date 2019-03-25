/*  Name: Julia Xie
    Program Name: Snake
    Teacher: Ms. Krasteva
    Date: January 16, 2019
    Description:    The main purpose of this program is to have fun playing the game snake.
		    The first screen is the splash screen, which displays an animation of a snake eating apples.
		    Once the animation is finished, the main menu screen is displayed.
		    If 1 is pressed on the main menu, the instructions screen is shown, explaining the game.
		    If 3 is pressed on the main menu, the program displays all the highscores, allowing the user to clear them.
		    If 4 is pressed on the main menu, the program displays a goodbye screen which allows the user to close the window.
		    If 2 is pressed on the main menu, the program then asks which level is to be played, which the askLevel screen.
		    Once the user chooses a level on the askLevel screen, the program then displays a grid with the game on it, along with the chosen level and the current score.
		    On this screen, the user is able to play the game.
		    Once the game is over, the user is led to a screen where they are able to hold down a key until the next screen is shown.
		    The next screen displays a game over message along with the chosen level and final score.
		    The user is able to type in their name on this screen, which then leads to the main menu.
    -----------------------------------------------------------------------------------------------------------------------------------------
    Variable Dictionary:
    -----------------------------------------------------------------------------------------------------------------------------------------
    Name:               Type:           Description/Purpose:
    -----------------------------------------------------------------------------------------------------------------------------------------
    lifetimeGrid        int [] []       It is used to determine if the space on the grid is a part of the snake, food, or an empty space.
    coordinateGridX     int []          It is used to determine where the x coordinate of each square is on the grid.
    coordinateGridY     int []          It is used to determine where the y coordinate of each square is on the grid.
    userData            String []       It is used to store the score, level, and name of the user.
    score               int             It is the current score that the user has.
    level               char            It is the difficulty level chosen by the user. The options are 1, 2, or 3.
    name                String          It is the name that the user chooses to enter after the game is over.
    choice              char            It is the menu option that the user chooses in the main menu
    FILENAME            final String    It is the name of the file that stores the name, level, and score of the top 10 users.
    file                File            It is the highscores file.
    keyPress            char            It is the key (W, A, S, or D) that the user presses to move the snake. This variable must be global to be used in a thread.
    line                String          It is used to count the number of lines in a file.
    numOfLines          int             It is the number of lines in a file.
    background          Color           It is the background colour used for all screens
*/

import java.awt.*;
import java.io.*;
import hsa.Console;
import javax.swing.JOptionPane;

public class Snake
{
    Console c;
    int lifetimeGrid[] [] = {{ - 2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2}, { - 2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2}};
    int coordinateGridX[] = {245, 285, 325, 365, 405, 445, 485, 525, 565, 605, 645, 685, 725, 765, 805};
    int coordinateGridY[] = {105, 145, 185, 225, 265, 305, 345, 385, 425, 465, 505, 545, 585, 625, 665};
    String userData[];
    int score;
    char level;
    String name;
    char choice;
    final String FILENAME = "highscores.isp";
    File file = new File (FILENAME);
    char keyPress;
    String line;
    int numOfLines;

    /*  Purpose of Method: The purpose of this method is to clear the screen and display the title at the top of the console.
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------     
	Name:       Type:       Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------     
	background  Color       It is the colour of the background
    */        
    private void title ()
    {
	Color background = new Color (255, 232, 186);
	c.clear ();
	c.setColour (background);
	c.setTextBackgroundColour (background);
	c.fillRect (0, 0, 1080, 740);
	c.setColour (Color.black);
	c.setFont (new Font ("Courier New", 1, 30));
	c.drawString ("Snake", 500, 40);
	c.println ();
    }


    //  Purpose of Method: The purpose of this method is to pause the program until the user chooses to press a key.
    public void pauseProgram ()
    {
	c.setCursor (36, 1);
	c.println ("Press any key to continue...");
	c.getChar ();
    }


    //  Purpose of Method: The purpose of this method is to display a introductory message and an animation.
    public void splashScreen ()
    {
	title ();
	SplashScreen ss = new SplashScreen (c);
	c.setCursor (5, 5);
	c.println ("Welcome to Snake!");
	c.setCursor (6, 5);
	c.println ("This program will allow you to play the classic game snake.");
	ss.start ();
	// Purpose of try block: Used to delay the animation for 12 seconds
	try
	{
	    Thread.sleep (12000);
	}
	catch (InterruptedException e)
	{
	}

    }


    // Purpose of Method: The purpose of this method is to display a 4 options for the user to pick. These options are to see the instructions, play the game, show the high scores, and exit the program.
    public void mainMenu ()
    {
	title ();
	c.setCursor (5, 57);
	c.println ("Please choose an option:");
	c.setCursor (7, 61);
	c.println ("1. Instructions");
	c.setCursor (9, 61);
	c.println ("2. Play");
	c.setCursor (11, 61);
	c.println ("3. High Scores");
	c.setCursor (13, 61);
	c.println ("4. Exit");
	// Purpose of Loop: The loop keeps looping until the user enters a correct input.
	while (true)
	{
	    choice = c.getChar ();
	    // If the user enters an input which is not 1, 2, 3, or 4, an error message is displayed.
	    if (choice < '1' || choice > '4')
	    {
		JOptionPane.showMessageDialog (null, "Please enter an option from 1 to 4.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    // Otherwise, it breaks out of the while loop.
	    else
	    {
		break;
	    }
	}
    }


    // Purpose of Method: The purpose of this method is to display the instructions for the user to read.
    public void instructions ()
    {
	title ();
	c.setCursor (5, 33);
	c.println ("Press 2 on the menu to play the game. Choose level 1, 2, or 3, with 1");
	c.setCursor (7, 33);
	c.println ("being the easiest. Use the WASD keys to change the direction of the snake");
	c.setCursor (9, 33);
	c.println ("on the grid and try to contact the yellow squares. Each time the snake");
	c.setCursor (11, 33);
	c.println ("\"eats\" a square, both its length and the score increases by one. The game");
	c.setCursor (13, 33);
	c.println ("ends when the snake makes contact with the wall or itself.");
	pauseProgram ();
    }


    /*  Purpose of Method: The purpose of this method is to read from the highscore file and to display the sorted high scores.
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------
	Name:           Type:           Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------
	displayData     String []       It is the data of the top 10 highest scoring users.
	clear           char            It is the the choice that the user inputs to choose whether or not to clear the high scores.
	msg             int             It is used to store the JOptionPane yes or no choice.
    */
    public void highScores () throws IOException
    {
	String displayData[];
	char clear;
	BufferedReader in;
	int msg;
	// Purpose of Loop: The loop keeps looping until the user chooses to go back to the main menu,=.
	while (true)
	{
	    title ();
	    numOfLines = -2;
	    line = "";
	    c.setCursor (4, 18);
	    c.println ("Place");
	    c.setCursor (4, 50);
	    c.println ("Name");
	    c.setCursor (4, 83);
	    c.println ("Level");
	    c.setCursor (4, 115);
	    c.println ("Score");

	    // If the file doesn't already exist, a new file is created with a header.
	    if (!file.exists ())
	    {
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter (FILENAME)));
		out.println ("HIGHSCORES");
		out.close ();
	    }
	    in = new BufferedReader (new FileReader (FILENAME));

	    // Purpose of Loop: The loop loops through every line of the file and counts the number of lines until there is no more lines to loop through.
	    while (line != null)
	    {
		line = in.readLine ();
		numOfLines++;
	    }
	    in.close ();
	    in = new BufferedReader (new FileReader (FILENAME));
	    displayData = new String [numOfLines];
	    in.readLine ();

	    /*  Purpose of Loop: The loop loops through the number of lines in the file to store the high scores in an array.
		 The loop starts at 0 and ends at the length of the displayData array
	    */
	    for (int i = 0 ; i < displayData.length ; i++)
	    {
		displayData [i] = in.readLine ();
	    }
	    in.close ();
	    /*  Purpose of Loop: The loop loops through the number of lines in the file to display all the data in the array.
		The loop starts at 0 and ends at the length of the displayData array
	    */
	    for (int i = 0 ; i < displayData.length ; i++)
	    {
		c.setCursor (6 + (i * 2), 19);
		c.println ("#" + (i + 1));
		c.setCursor (6 + (i * 2), 50);
		c.println (displayData [i].substring (0, displayData [i].indexOf (" ")));
		c.setCursor (6 + (i * 2), 85);
		c.println (displayData [i].substring (displayData [i].indexOf (" ") + 1, (displayData [i].indexOf (" ", displayData [i].indexOf (" ") + 1))));
		c.setCursor (6 + (i * 2), 116);
		c.println (displayData [i].substring ((displayData [i].indexOf (" ", displayData [i].indexOf (" ") + 1) + 1)));
	    }
	    c.setCursor (35, 5);
	    c.println ("Press c to clear scores.");
	    c.setCursor (36, 5);
	    c.println ("Press any other key to continue...");
	    clear = c.getChar ();
	    // If the key that the user inputs isn't the letter c, then it breaks out of the while loop.
	    if (clear != 'c' && clear != 'C')
	    {
		break;
	    }
	    // Otherwise, a warning message is shown, asking the user to confirm their decision.
	    else
	    {
		msg = JOptionPane.showConfirmDialog (null, "Are you sure you want to clear all scores? This action cannot be undone.", "Warning", JOptionPane.YES_NO_OPTION);
		// If the user chooses the yes option, the file is cleared.
		if (msg == JOptionPane.YES_OPTION)
		{
		    PrintWriter out = new PrintWriter (new FileWriter (FILENAME));
		    out.print ("HIGHSCORES");
		    out.close ();
		}
	    }
	}
    }


    /*  Purpose of Method: The purpose of this method is to store and sort the high scores in a file.
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------
	Name:       Type:       Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------
	scoreData   int []      It is used to store the top score in a file. It is then sorted from highest to lowest.
	counter1    int         It is used to sort the scores.
	counter2    int         It is used to sort the scores.
	current     int         It is used a temporary variable to switch elements of the score array while sorting.
	currentStr  String      It is used a temporary variable to switch elements of the user data array while sorting.
    */
    public void storeHighScores () throws IOException
    {
	int scoreData[];
	int counter1, counter2;
	int current;
	String currentStr;
	BufferedReader in;
	line = "";
	numOfLines = -1;
	// If the file doesn't already exists, a new file is created with a header.
	if (!file.exists ())
	{
	    PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter (FILENAME)));
	    out.println ("HIGHSCORES");
	    out.close ();
	}
	in = new BufferedReader (new FileReader (FILENAME));

	// Purpose of Loop: The loop loops through every line of the file and counts the number of lines until there is no more lines to loop through.
	while (line != null)
	{
	    line = in.readLine ();
	    numOfLines++;
	}
	in.close ();
	in = new BufferedReader (new FileReader (FILENAME));
	userData = new String [numOfLines];
	in.readLine ();
	// Purpose of Loop: Starts from 0 and ends at the last element of the array to enter all values into the array.
	for (int i = 0 ; i < userData.length - 1 ; i++)
	{
	    userData [i] = in.readLine ();
	}
	in.close ();
	userData [userData.length - 1] = name + " " + level + " " + score;
	scoreData = new int [userData.length];
	// Purpose of Loop: Starts from 0 and ends at the length of the array to enter all score values into the array.
	for (int i = 0 ; i < userData.length ; i++)
	{
	    scoreData [i] = Integer.parseInt (userData [i].substring ((userData [i].indexOf (" ", userData [i].indexOf (" ") + 1) + 1)));
	}
	counter1 = 0;
	counter2 = 1;
	// If there is more than one score then the data is sorted
	if (numOfLines > 1)
	{
	    // Purpose of Loop: It loops through all the elements in the score array until the end of the array is reached
	    do
	    {
		// If the element of the array on the right is greater than the element on the left, they switch
		if (scoreData [counter2] > scoreData [counter1])
		{
		    current = scoreData [counter1];
		    currentStr = userData [counter1];
		    scoreData [counter1] = scoreData [counter2];
		    userData [counter1] = userData [counter2];
		    scoreData [counter2] = current;
		    userData [counter2] = currentStr;
		    counter1 = 0;
		    counter2 = 1;
		}
		// Otherwise, both counters increase to move to the next elements.
		else
		{
		    counter1++;
		    counter2++;
		}
	    }
	    while (counter1 != numOfLines - 1 && counter2 != numOfLines);
	}
	PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter (FILENAME)));
	out.println ("HIGHSCORES");
	// If there are less than 10 elements in the array then the entire array is printed to the file.
	if (userData.length < 10)
	{
	    for (int i = 0 ; i < userData.length ; i++)
	    {
		out.println (userData [i]);
	    }
	}
	// Otherwise, the top 10 elements in the array are printed to the file.
	else
	{
	    for (int i = 0 ; i < 10 ; i++)
	    {
		out.println (userData [i]);
	    }
	}
	out.close ();
    }


    // Purpose of Method: Asks the user which difficulty level they want. Level 1 is the easiest, and Level 3 is the hardest.
    public void askLevel ()
    {
	title ();
	c.setCursor (5, 57);
	c.println ("Please choose an option:");
	c.setCursor (7, 63);
	c.println ("1. Level 1");
	c.setCursor (9, 63);
	c.println ("2. Level 2");
	c.setCursor (11, 63);
	c.println ("3. Level 3");
	// Purpose of Loop: Loop runs continuously until the user enters a valid input.
	while (true)
	{
	    level = c.getChar ();
	    // If the input is not 1, 2, or 3, an error message is shown.
	    if (level < '1' || level > '3')
	    {
		JOptionPane.showMessageDialog (null, "Please enter an option from 1 to 3.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    // Otherwise it breaks out of the loop.
	    else
	    {
		break;
	    }
	}
    }


    /*  Purpose of Method: Allows the user to play the game.
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------
	Name:       Type:       Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------
	grid        Color       It is the colour of the grid used in the game
	gridLines   Color       It is the colour of the lines on the grid
	snake       Color       It is the colour of the snake that the user controls
	square      Color       It is the colour of the food square on the grid
	lifetime    int         It is the number of movements that a certain square stays on the play field
	headX       int         It is the x coordinate of the first square of the snake
	headY       int         It is the y coordinate of the first square of the snake
	randSquare  boolean     It is used to determine whether or not there is already a piece of food on the grid
	prevKey     char        It is used to store the previous keypress from the user
	xCoord      int         It is used to store the x coordinate of the square of food
	yCoord      int         It is used to store the y coordinate of the square of food
	thread      Thread      It is the thread variable used to get input while the animation keeps running
    */
    public void playGame ()
    {
	Color grid = new Color (53, 57, 66);
	Color gridLines = new Color (133, 137, 147);
	Color snake = new Color (217, 219, 224);
	Color square = new Color (244, 223, 66);
	int lifetime = 1;
	int headX = 7;
	int headY = 7;
	boolean randSquare;
	char prevKey = ' ';
	int xCoord = 0;
	int yCoord = 0;
	Thread thread;
	score = 0;
	keyPress = ' ';

	title ();

	// display level
	c.setCursor (5, 57);
	c.println ("Use the WASD keys to move");
	c.setCursor (16, 15);
	c.println ("Level");
	c.setCursor (17, 17);
	c.println (level);

	c.setColour (grid);
	c.fillRect (280, 140, 520, 520);
	c.setColour (gridLines);

	/*  Purpose of Loop: The loop is used to draw the vertical grid lines
	    The loop starts at 280, ends at 800, and increases by 40 every time
	*/
	for (int i = 280 ; i <= 800 ; i += 40)
	{
	    c.drawLine (i, 140, i, 660);
	}
	/*  Purpose of Loop: The loop is used to draw the horizontal grid lines
	    The loop starts at 280, ends at 800, and increases by 40 every time
	*/
	for (int i = 140 ; i <= 660 ; i += 40)
	{
	    c.drawLine (280, i, 800, i);
	}
	c.setCursor (16, 115);
	c.println ("Score");
	c.setCursor (17, 117);
	c.println (score);

	// game
	lifetimeGrid [7] [7] = lifetime;
	/*  Purpose of Loop: It is used to loop through the first dimension of the lifetimeGrid array
	    The loop starts at 0 and ends at 15
	*/
	for (int i = 0 ; i < 15 ; i++)
	{
	    /*  Purpose of Loop: It is used to loop through the second dimension of the lifetimeGrid array
		The loop starts at 0 and ends at 15
	    */
	    for (int j = 0 ; j < 15 ; j++)
	    {
		// If a square on the grid has a lifetime of more than 0, it is reset back to 0
		if (lifetimeGrid [j] [i] > 0)
		{
		    lifetimeGrid [j] [i] = 0;
		}
	    }
	}
	// Purpose of Loop: It loops infinitely until the user hits themselves or the wall
	while (true)
	{
	    // https://stackoverflow.com/questions/43887711/how-to-get-console-input-for-different-threads-in-java
	    thread = new Thread (new Runnable ()
	    {
		public void run ()
		{
		    keyPress = c.getChar ();
		}
	    }
	    );
	    randSquare = false;
	    /*  Purpose of Loop: It is used to loop through the first dimension of the lifetimeGrid array
		The loop starts at 0 and ends at 15
	    */
	    for (int i = 0 ; i < 15 ; i++)
	    {
		/*  Purpose of Loop: It is used to loop through the second dimension of the lifetimeGrid array
		    The loop starts at 0 and ends at 15
		*/
		for (int j = 0 ; j < 15 ; j++)
		{
		    // If a square on the grid already has a food square then randSquare is set to true
		    if (lifetimeGrid [j] [i] == -1)
		    {
			randSquare = true;
		    }
		}
	    }
	    // If there isn't already a food square on the grid
	    if (!randSquare)
	    {
		// Purpose of Loop: It loops infintely until the generated square is on an empty square
		while (true)
		{
		    xCoord = generateSquareX ();
		    yCoord = generateSquareY ();
		    // If the generated square is on an empty square then it breaks out of the loop
		    if (lifetimeGrid [xCoord] [yCoord] == 0)
		    {
			break;
		    }
		}
		lifetimeGrid [xCoord] [yCoord] = -1;
	    }

	    // If the first square (head) of the snake is on an empty square then the lifetime is set to the max lifetime
	    if (lifetimeGrid [headX] [headY] == 0)
	    {
		lifetimeGrid [headX] [headY] = lifetime;
	    }
	    // If the head of the snake is on a food square, both the score and max lifetime increase by 1 and all of the squares of the current snake increase by 1 lifetime
	    else if (lifetimeGrid [headX] [headY] == -1)
	    {
		lifetime++;
		score++;
		c.setCursor (17, 117);
		c.println (score);
		/*  Purpose of Loop: It is used to loop through the first dimension of the lifetimeGrid array
		    The loop starts at 0 and ends at 15
		*/
		for (int i = 0 ; i < 15 ; i++)
		{
		    /*  Purpose of Loop: It is used to loop through the second dimension of the lifetimeGrid array
			The loop starts at 0 and ends at 15
		    */
		    for (int j = 0 ; j < 15 ; j++)
		    {
			if (lifetimeGrid [j] [i] > 0)
			{
			    lifetimeGrid [j] [i]++;
			}
		    }
		}
		lifetimeGrid [headX] [headY] = lifetime;
	    }
	    // Otherwise, it breaks out of the while loop
	    else
	    {
		break;
	    }
	    /*  Purpose of Loop: It is used to loop through the first dimension of the lifetimeGrid array
		The loop starts at 0 and ends at 15
	    */
	    for (int i = 0 ; i < 15 ; i++)
	    {
		/*  Purpose of Loop: It is used to loop through the second dimension of the lifetimeGrid array
		    The loop starts at 0 and ends at 15
		*/
		for (int j = 0 ; j < 15 ; j++)
		{
		    // If a square on the grid has a lifetime greater than 0 then it is coloured white and the lifetime decreases by 1
		    if (lifetimeGrid [j] [i] > 0)
		    {
			c.setColour (snake);
			c.fillRect (coordinateGridX [j], coordinateGridY [i], 31, 31);
			lifetimeGrid [j] [i]--;
		    }
		    // If a square on the grid has a lifetime of 0, it is coloured grey
		    else if (lifetimeGrid [j] [i] == 0)
		    {
			c.setColour (grid);
			c.fillRect (coordinateGridX [j], coordinateGridY [i], 31, 31);
		    }
		    // If a square on the grid has a lifetime of -1, it is coloured yellow
		    else if (lifetimeGrid [j] [i] == -1)
		    {
			c.setColour (square);
			c.fillRect (coordinateGridX [j], coordinateGridY [i], 31, 31);
		    }
		}
	    }
	    // Purpose of Try Block: it is used to delay how fast the snake moves
	    try
	    {
		Thread.sleep (calculateDelay (level));
	    }
	    catch (InterruptedException e)
	    {
	    }
	    // Purpose of try block: It is used to catch the error if the game every runs out of memory
	    try
	    {
		thread.start ();
	    }
	    catch (OutOfMemoryError e)
	    {
	    }
	    // If the key that the user presses isn't w, a, s, or d, or is in the direct opposite direction than the previous keypress then the keypress stays the same as the previous one
	    if (keyPress != 'w' && keyPress != 'W' && keyPress != 'a' && keyPress != 'A' && keyPress != 's' && keyPress != 'S' && keyPress != 'd' && keyPress != 'D' || (keyPress == 'w' || keyPress == 'W') && prevKey == 's' || (keyPress == 's' || keyPress == 'S') && prevKey == 'w' || (keyPress == 'a' || keyPress == 'A') && prevKey == 'd' || (keyPress == 'd' || keyPress == 'D') && prevKey == 'a')
	    {
		keyPress = prevKey;
	    }
	    // If the user presses w then the snake moves up and the previous keypress is set to w
	    if (keyPress == 'w' || keyPress == 'W')
	    {
		headY--;
		prevKey = 'w';
	    }
	    // If the user presses a then the snake moves left and the previous keypress is set to a
	    else if (keyPress == 'a' || keyPress == 'A')
	    {
		headX--;
		prevKey = 'a';
	    }
	    // If the user presses s then the snake moves down and the previous keypress is set to s
	    else if (keyPress == 's' || keyPress == 'S')
	    {
		headY++;
		prevKey = 's';
	    }
	    // If the user presses d then the snake moves right and the previous keypress is set to d
	    else if (keyPress == 'd' || keyPress == 'D')
	    {
		headX++;
		prevKey = 'd';
	    }
	}
    }


    // Purpose of Method: The purpose of this method is to all the user to hold down the key to clear all the getChars from the previous method
    public void holdKey ()
    {
	title ();
	c.setCursor (15, 36);
	c.println ("Please hold down any letter until you are able to enter your name.");
	c.getChar ();
    }


    /*  Purpose of Method: The purpose of this method is to display a game over message and to allow the user to enter their name
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------
	Name:       Type:       Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------
	red         Color       It is the colour of the game over text
	validName   boolean     It is used to store whether or not the name the user enters is valid
    */
    public void endScreen ()
    {
	Color red = new Color (163, 31, 31);
	boolean validName;
	title ();
	c.setColour (red);
	c.setFont (new Font ("Trebuchet MS", 1, 70));
	c.drawString ("GAME OVER", 350, 170);
	c.setCursor (17, 53);
	c.println ("Level");
	c.setCursor (18, 55);
	c.println (level);
	c.setCursor (17, 79);
	c.println ("Score");
	c.setCursor (18, 81);
	c.println (score);
	// Purpose of Loop: It loops infinitely until the user enters a valid name
	while (true)
	{
	    validName = true;
	    c.setCursor (21, 55);
	    c.println ();
	    c.setCursor (21, 55);
	    c.print ("Enter your name: ");
	    name = c.readLine ();
	    // Purpose of Loop: It starts from 0 and ends at the length of the name the user enters to determine if the name contains any special characters
	    for (int i = 0 ; i < name.length () ; i++)
	    {
		// If the name contains any numbers, spaces, or special characters, then validName is set to false
		if (name.charAt (i) < 'A' || name.charAt (i) > 'Z' && name.charAt (i) < 'a' || name.charAt (i) > 'z' && (name.charAt (i) != '-' || name.charAt (i) != '\''))
		{
		    validName = false;
		}
	    }
	    // If the name isn't valid then an error message is shown
	    if (!validName)
	    {
		JOptionPane.showMessageDialog (null, "Your name may not contain any numbers, spaces, or special characters.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    // Otherwise it breaks out of the loop
	    else
	    {
		break;
	    }
	}
    }


    // Purpose of Method: The purpose of this method is to display a goodbye message and to allow the user to exit
    public void goodbye ()
    {
	title ();
	c.setCursor (14, 59);
	c.println ("Thanks for playing!");
	c.setCursor (17, 50);
	c.println ("This program was created by Julia Xie.");
	c.setCursor (23, 56);
	c.println ("Press any key to exit...");
	c.getChar ();
	c.close ();
    }


    /*  Purpose of Method: The purpose of this method is to determine the delay depending on which level the user chooses
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------
	Name:       Type:       Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------
	delay       int         It is the number of milliseconds that the snake is delayed
    */
    private int calculateDelay (char level)
    {
	int delay = 0;
	// If the user chooses level 1 then the delay is set to 400 milliseconds
	if (level == '1')
	{
	    delay = 400;
	}
	// If the user chooses level 2 then the delay is set to 200 milliseconds
	else if (level == '2')
	{
	    delay = 200;
	}
	// If the user chooses level 3 then the delay is set to 50 milliseconds
	else if (level == '3')
	{
	    delay = 50;
	}

	return delay;
    }


    /*  Purpose of Method: The purpose of this method is to generate a random x coordinate of the food square
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------
	Name:       Type:       Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------
	location    int         It is the randomly generated x coordinate of the food square
    */
    private int generateSquareX ()
    {
	int location = 0;
	location = (int) (Math.random () * 12 + 2);
	return location;
    }


    /*  Purpose of Method: The purpose of this method is to generate a random y coordinate of the food square
	-----------------------------------------------------------------------------------------------------------------------------------------
	Variable Dictionary:
	-----------------------------------------------------------------------------------------------------------------------------------------
	Name:       Type:       Description/Purpose:
	-----------------------------------------------------------------------------------------------------------------------------------------
	location    int         It is the randomly generated y coordinate of the food square
    */
    private int generateSquareY ()
    {
	int location = 0;
	location = (int) (Math.random () * 12 + 2);
	return location;
    }


    // Purpose of Constructor: creates an instance of the console
    public Snake ()
    {
	c = new Console (37, 135, "Snake");
    }


    // Purpose of Method: It is used to execute all methods
    public static void main (String[] args) throws IOException
    {
	Snake s = new Snake ();
	s.splashScreen ();
	// Purpose of Loop: It loops infintely until the user chooses to quit
	while (true)
	{
	    s.mainMenu ();
	    // If the user chooses to see the instructions in the main menu then the instructions are shown
	    if (s.choice == '1')
	    {
		s.instructions ();
	    }
	    // If the user chooses to play the game in the main menu, they would then be asked which level they wanted, they would be allowed to play the game, and once they lose, the highscores are stored
	    else if (s.choice == '2')
	    {
		s.askLevel ();
		s.playGame ();
		s.holdKey ();
		s.endScreen ();
		s.storeHighScores ();
	    }
	    // If the user chooses to see the highscores in the main menu then the highscores are shown
	    else if (s.choice == '3')
	    {
		s.highScores ();
	    }
	    // If the user chooses to quit then it breaks out of the loop
	    else if (s.choice == '4')
	    {
		break;
	    }
	}
	s.goodbye ();
    }
}




