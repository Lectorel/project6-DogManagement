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
    static ArrayList<Dog> dogList = new ArrayList();
    public static void main(String[] args) throws Exception {
        readFromFile();
        //dogList.forEach(x -> System.out.println(x));
    }

    static void readFromFile() throws FileNotFoundException, IOException{
        final String COMMA_DELIMITER = ",";
        String PATH = "C:\\Users\\epomes\\Downloads\\io_ex\\src\\doginfo.csv"; //Ex. if you provide the 
        String directory = System.getProperty("user.dir"); //get the current working directory, the directory from where your program was launched
        String fileName = "doginfo.csv";
        String absolutePath = directory + File.separator + "src" + File.separator + fileName;
        //System.out.print(absolutePath);
        
        //Another solution for getting the path to a file
        /**Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);
        **/
        
        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath))) {
            String line;
            br.readLine(); //Reads the first line which is the headers
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                dogList.add(new Dog(Integer.parseInteger(values[0]), values[1], Double.parseDouble(values[2]), Integer.parseInteger(values[3])));
            }
            br.close();
        }
        
        

    }

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


}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
