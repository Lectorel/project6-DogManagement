import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;  
public class App {
    static ArrayList<Dog> dogList = new ArrayList<Dog>();
    public static void main(String[] args) throws Exception {
        readFromFile();
        dogList.forEach(x -> System.out.println(x));
    }

    static void readFromFile() throws FileNotFoundException, IOException{
        final String COMMA_DELIMITER = ",";
        String PATH = "bin\\doginfo.csv"; //Ex. if you provide the 
        String directory = System.getProperty("user.dir"); //get the current working directory, the directory from where your program was launched
        Path csvPath = Paths.get(directory, "src", "doginfo.csv");
        
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath.toFile()))) {
            String line;
            br.readLine(); //Reads the first line which is the headers
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER); //each line becomes a string
                dogList.add(new Dog(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2]), Integer.parseInt(values[3])));
            }
            br.close();
        }
        
        

    }

    
    public static ArrayList<dog> getDogs(){
        return dogList;
    }

/*
    static void writeToFile() throws IOException{

        String directory = System.getProperty("user.dir"); //get the current working directory, the directory from where your program was launched
        String fileName = "output.csv";
        String absolutePath = directory + File.separator + "src" + File.separator + fileName;
        File file = new File(absolutePath);
        
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(absolutePath))) {
            
            //Implement code below
            for(var x = 0; x < dogList.size()-1; x++){
                //fw.write()
            }
           
          
        }
    
    }
*/

}

