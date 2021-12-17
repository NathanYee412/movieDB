package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class fileRead {
	// Fields
	private ArrayList<String> lines;
	private int lineCount;
	
	// Constructor
	public fileRead(String filename){
		
		lines = new ArrayList<>();
		int count = 0;
		String dir = System.getProperty("user.dir");
		
		try {
			Scanner s = new Scanner(new File(dir + "/src/Main/" + filename));
			while(s.hasNext()) {
				lines.add(s.nextLine());
				count++;
			}
			s.close();
			this.lineCount = count;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// Methods
	public int getNumberOfLines(){
		return this.lineCount;
	}
	
	public String getLine(int index){
		return this.lines.get(index);
	}
	
	public void removeLine(String title) {	
		for(int i = 0; i < this.lines.size(); i++) {
			
			String tempTitle[] = this.lines.get(i).split(",",2);

			if(tempTitle[0].toLowerCase().equals(title.toLowerCase())) {
				System.out.println("Removing " + lines.get(i));
				lines.remove(i);
				this.lineCount--;
			}
		}
		fileWrite fr = new fileWrite("db.txt");
		for(int i = 0; i < this.lines.size(); i++) {
			
			fr.writeLine(this.lines.get(i));
			
		}
		fr.overwriteFile();
	}
}
