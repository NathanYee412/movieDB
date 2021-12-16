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
//				System.out.println(s.nextLine());
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
}
