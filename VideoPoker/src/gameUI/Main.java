package gameUI;


public class Main {

	public static void main(String[] args) {
		if (args.length > 0 && args[0].equals("-i")){
            GameMode Game = new Interactive();
            Game.initGame(args);
            Game.play();
        }
		if (args.length > 0 && args[0].equals("-d")){
			GameMode Game = new Debug();
            Game.initGame(args);
            Game.play();
        }
		if (args.length > 0 && args[0].equals("-e")){
			GameMode Game = new Auto();
            Game.initGame(args);
            Game.play();
        }

	}

}
