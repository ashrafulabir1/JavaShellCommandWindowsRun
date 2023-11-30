
// Run a simple Windows shell command 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.ArrayList; 
import java.util.List; 
  
public class JavaShellCommand { 
  
    public static void main(String[] args) 
    { 
  
        ProcessBuilder processBuilder 
            = new ProcessBuilder(); 
  
        List<String> builderList = new ArrayList<>(); 
  
        // add the list of commands to a list 
        builderList.add("cmd.exe"); 
        builderList.add("/C"); 
        builderList.add("tasklist | findstr chrome"); 
  
        try { 
            // Using the list , trigger the command 
            processBuilder.command(builderList); 
            Process process = processBuilder.start(); 
  
            // To read the output list 
            BufferedReader reader 
                = new BufferedReader(new InputStreamReader( 
                    process.getInputStream())); 
  
            String line; 
            while ((line = reader.readLine()) != null) { 
                System.out.println(line); 
            } 
  
            int exitCode = process.waitFor(); 
            System.out.println("\nExited with error code : "
                               + exitCode); 
        } 
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
    } 
}