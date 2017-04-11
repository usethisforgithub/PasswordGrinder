import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) throws IOException{
	
		ArrayList <String> names = new ArrayList <String>();		
		String filename= "MyFile.txt";
	    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
	    BufferedWriter bw = new BufferedWriter(fw);
	    
	    bw.write("add a line");//appends the string to the file
	    bw.newLine();
	    bw.write("add a line");
	    bw.close();
	    
		names.add("Zachdogg");
		names.add("abhi");
		names.add("nothingleft000");
		names.add("224190");
		names.add("Loansome");
		names.add("Tanvir");
		names.add("TallaWalla");
		names.add("nudes");
		names.add("Nitsua");
		names.add("yOURLOCALWEEb");
		names.add("g raff");
		names.add("Colin Z");
		names.add("Maxican");
		names.add("Kyle");
		names.add("Weston");
		
		for(String e : names){
			new Thread(new Grinder(e)).start();
		}
		
		
		
	}
}
