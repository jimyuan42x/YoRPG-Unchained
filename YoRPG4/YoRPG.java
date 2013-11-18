
/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Warrior pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name, eh?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
    =============================================*/
    public void newGame() {

	String s;
	String name = "";
	s = "Welcome to Ye Olde RPG!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }


	//instantiate the player's character
	pat = new Warrior( name );

    }//end newGame()
  

    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
     =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "Nothing to see here. Move along!" );

	else {
	    System.out.println( "Lo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "Do you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    pat.specialize();
		else
		    pat.normalize();

		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );

		System.out.println( pat.getName() + " dealt " + d1 +
				    " points of damage.");
		smaug.lowerHP(d1);
		System.out.println( "Ye Olde Monster hit back for " + d2 +
				    " points of damage.");
		pat.lowerHP(d2);
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
 
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...



	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
	/*=============================================
	  =============================================*/
	/*	//testz
	Warrior hero = new Warrior("Jim");
	Monster bad = new Monster();
	System.out.println("Is our hero, " + hero.getName() + ", alive?... " + hero.isAlive());
	System.out.println("Is our fearsome Monster, " + bad.getName() + ", alive?... " + bad.isAlive());
	System.out.println("Our hero's defense stat is: " + hero.getDefense());
	System.out.println("Our monster's defense stat is: " + bad.getDefense());
	System.out.println("Magically, the magical fairy Fairylilis has smacked both doods in the face, dealing 12 damage.\nHero is now at " + hero.lowerHP(12) + "HP.\nMonster has " + bad.lowerHP(12) + "HP.");
	System.out.println("If hero attacks monster, he would deal " + hero.attack(bad) + " damage.");
	System.out.println("If monster attacks hero, it would deal " + bad.attack(hero) + " damage.");
	System.out.println("The GM let them hit each other at the same moment. So now, hero is at " + hero.lowerHP(bad.attack(hero)) + "HP.\nMonster is at " + bad.lowerHP(hero.attack(bad)) + "HP.");
	//the math seems consistent...
	//super special awesome time?
	hero.specialize();
	System.out.println("But suddenly, our hero powers up! And he counterattacks!");
	System.out.println("Our hero attacks, dealing " + hero.attack(bad) + " damage!... Leaving monster at " + bad.lowerHP(hero.attack(bad)) + "HP!");
	hero.normalize();
	System.out.println("And somehow our hero gets to attack yet again! He deals " + hero.attack(bad) + " damage! Leaving monster at " + bad.lowerHP(hero.attack(bad)) + "HP!");

	//test new stuffs.
	Monster pat = new Monster();
	System.out.println("This is pat, a monster");
	System.out.println(pat.getName());
	Mage mervin = new Mage("mervin");
	System.out.println("This is mervin, a mage");
	System.out.println(mervin.getName());
	*/
    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/
