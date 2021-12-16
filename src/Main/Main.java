package Main;

public class Main {
	public static void main(String args[]) {
		Database db = new Database("db.txt");
		

		Boolean exit = false;
		keyboardInput input = new keyboardInput();
		
		while(exit != true) {
			
			
			System.out.println("a.) new entry");
			System.out.println("b.) search by actor");
			System.out.println("c.) search by year");
			System.out.println("d.) search by runtime (in minutes)");
			System.out.println("e.) search by director");
			System.out.println("f.) search by title");
			System.out.println("g.) quit");
			System.out.println();

			System.out.printf("Please enter your selection: ");
			

			String switchSelection = input.getKeyboardLine();

			if(switchSelection.toLowerCase().equals("a")) {
				System.out.println("Please enter movie data as shown below");
				System.out.println("MovieTitle,Actor1,Actor2,Director,Year,Director");
				System.out.println("Movie Data: ");
				String movieData = input.getKeyboardLine();
				
				fileWrite fr = new fileWrite("db.txt");
				fr.writeLine(movieData);
				fr.saveFile();

			}
			
			else if(switchSelection.toLowerCase().equals("b")) {
				System.out.printf("Please enter an actor name: ");
				String actor = input.getKeyboardLine();
				System.out.println();
				db.searchByActor(actor);
				input.getKeyboardLine();
			}
			else if(switchSelection.toLowerCase().equals("c")) {
				System.out.printf("Please enter a year: ");
				String year = input.getKeyboardLine();
				System.out.println();
				db.searchByYear(Integer.parseInt(year));
				input.getKeyboardLine();

			}
			else if(switchSelection.toLowerCase().equals("d")) {
				System.out.printf("Please enter a movie runtime: ");
				String rt = input.getKeyboardLine();
				System.out.println();
				db.searchByRuntime(Integer.parseInt(rt));
				input.getKeyboardLine();

			}
			else if(switchSelection.toLowerCase().equals("e")) {
				System.out.printf("Please enter a director name: ");
				String director = input.getKeyboardLine();
				System.out.println();
				db.searchByDirector(director);
				input.getKeyboardLine();

			}
			else if(switchSelection.toLowerCase().equals("f")) {
				System.out.printf("Please enter a movie title: ");
				String title = input.getKeyboardLine();
				System.out.println();
				db.searchByTitle(title);
				input.getKeyboardLine();

			}
			
			else if(switchSelection.toLowerCase().equals("g")) {
				System.out.printf("Exitng Program");
				System.out.println();
				exit = true;
			}

		}
		
		input.closeKeyboard();
		System.out.println("program exit");
		System.exit(0);
	}
		
}
