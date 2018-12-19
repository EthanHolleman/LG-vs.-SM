import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Data {
	
		public static void partition(String fileLocation, String fileType) throws FileNotFoundException {
			File file = new File(fileLocation);
			String key;
			String fileKey;
			
			try {
				for(int i = 1; i<24; i++) {
					key = "chr" + i +"\t";
					fileKey = "chr" + i;
					if(i==22) {
						key = "chr" + "Y";
						fileKey  = key;
					}
					if(i==23) {
						key = "chr" + "X";
						fileKey = key;
					}
					//change location of printLocation based on your own preferences but keep variables
					System.out.println("Partitioning " + fileKey + " in file " + fileType);
					String printLocation = "D:\\Download Shite\\Documents\\Partitions\\" + fileType + "\\" + fileKey + fileType + ".txt";
					PrintWriter outLine = new PrintWriter(printLocation);
					Scanner scanner = new Scanner(file);
					String line;
				
						while(scanner.hasNextLine()) {
								line = scanner.nextLine();
								if(line.contains(key)) {
									outLine.println(line);
					}
					
				}
						outLine.close();
						scanner.close();
			  }
				
			}catch(FileNotFoundException e) {
				
				
			}
			
		
			
		}
		
		public static void compare(String outputFile) throws IOException {
			//change file locations to the the location of your files from partition function
			File fileLG = new File("D:\\Download Shite\\Documents\\Partitions\\LG\\chr1LG.txt");
			File fileSM = new File("D:\\Download Shite\\Documents\\Partitions\\SM\\chr1SM.txt");
			File outPut = new File(outputFile);
			Scanner scanner = new Scanner(fileLG);
			
			
			String keySM;
			String keyLG;
			BufferedWriter writer = new BufferedWriter(new FileWriter(outPut, true));
			for(int n = 1; n < 24 ; n++) {
				keySM = "chr" + n + "SM";
				keyLG = "chr" + n + "LG";
				if(n ==22) {
					keySM = "chr" + "X" + "SM";
					keyLG = "chr" + "X" + "LG";
				}else if(n==23) {
					keySM = "chr" + "Y" + "SM";
					keyLG = "chr" + "Y" + "LG";
				}
			
			
			BufferedReader br = new BufferedReader(new FileReader("D:\\Download Shite\\Documents\\Partitions\\LG\\" + keyLG + ".txt"));
			HashMap<Integer, String> map = new HashMap();
			
			
			String line;
			int start;
			
			while( (line = br.readLine()) != null) { //send to the file hash map
				
				String[] splited = line.split("\t");
				start = Integer.parseInt(splited[1]);
				map.put(start, line);
				
				
			}
			line = "";
			BufferedReader brTwo = new BufferedReader(new FileReader("D:\\Download Shite\\Documents\\Partitions\\SM\\" + keySM + ".txt"));
			
			
			
			while((line = brTwo.readLine()) != null) {
				String[] splited = line.split("\t");
				start = Integer.parseInt(splited[1]);
				
				
				
				if(map.containsKey(start)) {
					String mapLine = map.get(start).replace("LG", ""); //coming from large file in the map
					String modLine = line.replace("SM", "");
					
					if(mapLine.equals(modLine)) {
						writer.write("\n" + line);
						writer.write("\n" + map.get(start));
						map.remove(start);
						
					}else {
						writer.write("\n"+line);
					}
					
				}else {
					writer.write("\n"+line);
				}
				
				}
				for(int a: map.keySet()) {
					String value = map.get(a);
				
					writer.write("\n"+value);
				}
				writer.close();
				brTwo.close();
				br.close();
			
				
				}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
	
				
				
			
			
					
					
					
				
				
			
			
			
	
	
	
	


