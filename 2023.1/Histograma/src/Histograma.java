import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Histograma {

    
    public static void main(String args[]) throws IOException {
        
        
        Path path = Paths.get("");
        Files.lines(path).forEach(System.out::println);
        
        
        
    }
}

