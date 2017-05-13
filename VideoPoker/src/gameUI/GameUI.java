package gameUI;

import videopoker.VideoPoker;

/**
 * 
 * abstract class that lets the programmer implement functions that will tell how to play the game. Always
 * has an object of type VideoPoker
 *
 */

public abstract class GameUI {

	VideoPoker videopoker;
	
	/**
	 * this method is the initializer of the game. It can start the credit, commands to use, cards to insert in the deck. 
	 * This parameters are received in the array args
	 * @param args		parameters of game initialization
	 */
	
	public abstract void initGame(String[] args);
	
	/**
	 * this method plays the game according to the specific mode
	 */
	
	public abstract void play();
	
}