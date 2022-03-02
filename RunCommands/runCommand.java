import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class runCommand
{
    //Runs CMD. Changes directory to newDirectory and executes command com.
    public void excCommand(String newDirectory, String com) throws IOException{
        Runtime rt = Runtime.getRuntime();
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd \"" + newDirectory+"\" && " + com);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        System.out.println(rt);
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }
}