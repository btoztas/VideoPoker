package gameUI;

public class Main {
	
	/**
	 * This method issues an error message for bad usage
	 */
	
	
	static private void usage(){
		System.out.println("Usage:");
		System.out.println("VideoPoker <gamemode> [ options ]");
		System.out.println("GAMEMODE:");
		System.out.println("\t-i\t\tInteractive");
		System.out.println("\t\t\t\toptions <credit>");
		System.out.println("\t-d\t\tDebug");
		System.out.println("\t\t\t\toptions <credit> <cmd-file> <card-file>");
		System.out.println("\t-s\t\tSimulation");
		System.out.println("\t\t\t\toptions <credit> <bet> <nbdeals>");
		System.out.println("\t-g\t\tGraphic Interface");
		System.exit(-1);
	}

	public static void main(String[] args) {
		
		if(args.length==0){
			
			usage();
			
		}
		
		else if (args[0].equals("-i")){
			if(args.length!=2)
				usage();
            GameUI Game = new Interactive();
            Game.initGame(args);
            Game.play();
        }
		else if (args[0].equals("-d")){
			if(args.length!=4)
				usage();
			GameUI Game = new Debug();
            Game.initGame(args);
            Game.play();
        }
		else if (args[0].equals("-s")){
			if(args.length!=4)
				usage();
			GameUI Game = new Auto();
            Game.initGame(args);
            Game.play();
        }else{
        	
        	usage();
        	
        }

	}

}
