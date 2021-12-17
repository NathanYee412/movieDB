package Main;

import java.util.ArrayList;
import java.util.StringTokenizer; 

public class Database {
	// Fields
	private ArrayList<Movie> movies;
	
	public Database() {
		
	}
	
	// Constructor
	public Database(String filename){
		movies = new ArrayList<>();

		fileRead fr = new fileRead(filename);
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			
			String movieName = "";
			String actor1 = "";
			String actor2 = "";
			String director = "";
			String year = "";
			String runtime = "";
			
			if(fr.getLine(i) == "") { 
				continue;
			}
			
			// Get a new line from database file (db.txt)
			String raw = fr.getLine(i);
			
			// parse raw line data delimited by comma 
			StringTokenizer tokenizer = new StringTokenizer(raw, ",");

			// store each value into tempMovie array
			while(tokenizer.hasMoreTokens()) {
				movieName = tokenizer.nextToken();
				actor1 = tokenizer.nextToken();
				actor2 = tokenizer.nextToken();
				director = tokenizer.nextToken();
				year = tokenizer.nextToken();
				runtime = tokenizer.nextToken();
			}
			
			//create Movie object
			Movie newMovie = new Movie(movieName, actor1, actor2, director, Integer.parseInt(year), Integer.parseInt(runtime));
			
			// Add an entry into the movies ArrayList
			addEntry(newMovie);
			
		}
		
	}
	
	public Database(String filename, String removeTitle){
		movies = new ArrayList<>();

		fileRead fr = new fileRead(filename);
		fr.removeLine(removeTitle);
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			
			String movieName = "";
			String actor1 = "";
			String actor2 = "";
			String director = "";
			String year = "";
			String runtime = "";
			
			if(fr.getLine(i) == "") { 
				continue;
			}
			
			// Get a new line from database file (db.txt)
			String raw = fr.getLine(i);
			
			// parse raw line data delimited by comma 
			StringTokenizer tokenizer = new StringTokenizer(raw, ",");

			// store each value into tempMovie array
			while(tokenizer.hasMoreTokens()) {
				movieName = tokenizer.nextToken();
				actor1 = tokenizer.nextToken();
				actor2 = tokenizer.nextToken();
				director = tokenizer.nextToken();
				year = tokenizer.nextToken();
				runtime = tokenizer.nextToken();
			}
			
			//create Movie object
			Movie newMovie = new Movie(movieName, actor1, actor2, director, Integer.parseInt(year), Integer.parseInt(runtime));
			
			// Add an entry into the movies ArrayList
			addEntry(newMovie);
		}
		
	}
	
	// Methods
	public void addEntry(Movie newEntry){
		this.movies.add(newEntry);
		
	}
	
	public void searchByTitle(String title){

		for(int i = 0; i < this.movies.size(); i++) {

			if(this.movies.get(i).getTitle().toLowerCase().equals(title.toLowerCase())) {
				
				System.out.println("Title: " + this.movies.get(i).getTitle());
				System.out.println("Actors: " + this.movies.get(i).getActor1() + " " + this.movies.get(i).getActor2());
				System.out.println("Director: " + this.movies.get(i).getDirector());
				System.out.println("Year: " + this.movies.get(i).getYear());
				System.out.println("Runtime: " + this.movies.get(i).getRuntime());
				System.out.println();
			}
		}
	}
	
	public void searchByActor(String actor){
		for(int i = 0; i < this.movies.size(); i++) {

			if(this.movies.get(i).getActor1().toLowerCase().equals(actor.toLowerCase()) || this.movies.get(i).getActor2().toLowerCase().equals(actor.toLowerCase())) {
				
				System.out.println("Title: " + this.movies.get(i).getTitle());
				System.out.println("Actors: " + this.movies.get(i).getActor1() + " " + this.movies.get(i).getActor2());
				System.out.println("Director: " + this.movies.get(i).getDirector());
				System.out.println("Year: " + this.movies.get(i).getYear());
				System.out.println("Runtime: " + this.movies.get(i).getRuntime());
				System.out.println();
			}
		}
	}
	
	public void searchByDirector(String director){
		for(int i = 0; i < this.movies.size(); i++) {

			if(this.movies.get(i).getDirector().toLowerCase().equals(director.toLowerCase())) {
				
				System.out.println("Title: " + this.movies.get(i).getTitle());
				System.out.println("Actors: " + this.movies.get(i).getActor1() + " " + this.movies.get(i).getActor2());
				System.out.println("Director: " + this.movies.get(i).getDirector());
				System.out.println("Year: " + this.movies.get(i).getYear());
				System.out.println("Runtime: " + this.movies.get(i).getRuntime());
				System.out.println();
			}
		}
	}
	
	public void searchByYear(int year){
		for(int i = 0; i < this.movies.size(); i++) {

			if(this.movies.get(i).getYear() == year) {
				
				System.out.println("Title: " + this.movies.get(i).getTitle());
				System.out.println("Actors: " + this.movies.get(i).getActor1() + " " + this.movies.get(i).getActor2());
				System.out.println("Director: " + this.movies.get(i).getDirector());
				System.out.println("Year: " + this.movies.get(i).getYear());
				System.out.println("Runtime: " + this.movies.get(i).getRuntime());
				System.out.println();
			}
		}
	}
	
	public void searchByRuntime(int runtime){
		for(int i = 0; i < this.movies.size(); i++) {

			if(this.movies.get(i).getRuntime() == runtime) {
				
				System.out.println("Title: " + this.movies.get(i).getTitle());
				System.out.println("Actors: " + this.movies.get(i).getActor1() + " " + this.movies.get(i).getActor2());
				System.out.println("Director: " + this.movies.get(i).getDirector());
				System.out.println("Year: " + this.movies.get(i).getYear());
				System.out.println("Runtime: " + this.movies.get(i).getRuntime());
				System.out.println();
			}
		}
	}
}


//System.out.println(this.movies.get(1).getTitle());
//System.out.println(this.movies.get(1).getActor1());
//System.out.println(this.movies.get(1).getActor2());
//System.out.println(this.movies.get(1).getDirector());
//System.out.println(this.movies.get(1).getYear());
//System.out.println(this.movies.get(1).getRuntime());
