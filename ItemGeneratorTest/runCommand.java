package ItemGeneratorTest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class runCommand
{
    //Runs CMD. Changes directory to newDirectory and executes command com.
    public void excCommand(String newDirectory, String com) throws IOException{
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd \"" + newDirectory+"\" && " + com);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }
    public void excCommand(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", command);
            builder.redirectErrorStream(true);
            int counter = 0;
            Process p = builder.start();
            String totalText = "";
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                counter++;
                totalText+=line+"\n";
                if (line == null) { break; }
                System.out.println(line);
            }    
    }
}