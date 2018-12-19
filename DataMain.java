import java.io.*;


public class DataMain {

	
	public static void main(String[] args) {
		
	
		
		//change file location to where ever original files are stored on your pc
		String largeGenesLocation = "D:\\Download Shite\\Documents\\Research Data\\LGvariants.txt";
		String smallGenesLocation = "D:\\Download Shite\\Documents\\Research Data\\SMvariants.txt";
		String outPutLocation = "D:\\Download Shite\\Documents\\Research Data\\outPut.txt";
		
		try {
			Data.partition(largeGenesLocation, "LG");
			Data.partition(smallGenesLocation, "SM");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			Data.compare(outPutLocation);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//will print the unique  elements of each file to the output file 
	}
}
		
		
		
		
		
		
		
	

			
			
			
			
			
		



