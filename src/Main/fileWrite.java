/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory 
but do not actually write the file to disk until someone calls the 
 * "saveFile" method. The reason for this is for performance and to prevent keeping an open 
 * file pointer (which is poor form and risky) */

package Main;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine){
		writeBuffer.add(newLine);
		
	}
	
	public void saveFile() {
		String dir = System.getProperty("user.dir");
		try {
			FileWriter writer = new FileWriter(dir + "/src/Main/" + filename, true);
			for(String i: writeBuffer) {
				writer.write(i + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void overwriteFile() {
		String dir = System.getProperty("user.dir");
		try {
			FileWriter writer = new FileWriter(dir + "/src/Main/" + filename);
			for(String i: writeBuffer) {
				writer.write(i + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}

