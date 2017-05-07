package gameUI;

import videopoker.VideoPoker;

public abstract class GameUI {

	// TODO: Is this protected?
	VideoPoker videopoker;
	
	public abstract void initGame(String[] args);
	public abstract void play();
	
}