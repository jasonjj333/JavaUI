import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.print("What Directory would you like to change to: ");
        String directory = scan.nextLine();
        System.out.println(directory + " Length: " + directory.length());

        runCommand run = new runCommand();
        run.excCommand(directory,"dir");
    }
}

