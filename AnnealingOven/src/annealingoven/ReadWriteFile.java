package annealingoven;

import java.io.*; 
import java.util.ArrayList;
import java.util.List;
  
public class ReadWriteFile {   
	
    // Read all Cycles from file
    public List<List<Part>> readFromfile() {
        
        List<List<Part>> cycles = new ArrayList<List<Part>>();
        List<Part> cycle;
	try {
            /*// Read all Cycles' information by delimiter 'tab'
                 input = new Scanner(new FileReader("src/annealingoven/Cycles.txt")).useDelimiter("\\n*\t\\n*");
            //need to optimize                
            while(input.hasNext()) { 
            	user.add(input.next());
            }*/
            FileInputStream f = new FileInputStream("src/annealingoven/Cycles.txt"); 
            BufferedReader dr = new BufferedReader(new InputStreamReader(f));
            String line = dr.readLine();
            while(line!= null){ 
		System.out.println(line);
		String[] ss = line.split("\t");
		cycle = new ArrayList<Part>();
		for(int i = 0; i < ss.length; i += 3) {
                    cycle.add(new Part(ss[i], ss[i + 1], ss[i + 2]));
		}
		cycles.add(cycle);
		line = dr.readLine();
            }
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	} catch (IOException e) {
            e.printStackTrace();
	}
	return cycles;
    }
	
    // Write all Cycles to file
    public void writeTofile(List<List<Part>> Cycles) {

	try{
            FileWriter writer = new FileWriter("src/annealingoven/Cycles.txt", true); 
            //Clear the current file and then write it again
            BufferedWriter wr = new BufferedWriter(new FileWriter("src/annealingoven/Cycles.txt"));                          
            wr.flush(); 
            wr.close();
            
            for(List<Part> cycle : Cycles) {
            	for(Part p : cycle) {
                    writer.write(p.startTemprature + "\t");
                    writer.write(p.endTemprature + "\t");
                    writer.write(p.lengthOftime + "\t");
            	}
            	writer.write('\n');
            }
            writer.close();
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
	
    public static void main(String[] args) {
		
	ReadWriteFile r = new ReadWriteFile();
		
	System.out.println(r.readFromfile().get(0).get(1).startTemprature);
    }
}  