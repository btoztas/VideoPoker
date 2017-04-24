package gameUI;


public class Main {

	public static void main(String[] args) {
		if (args.length > 0 && args[0].equals("-i")){
            Interactive Game = new Interactive();
            Game.readCommand(args);
            Game.play();
        }
		if (args.length > 0 && args[0].equals("-d")){
            
        }
		if (args.length > 0 && args[0].equals("-e")){
            
        }

	}

}
