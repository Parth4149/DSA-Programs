package Java.Exeption.Program;
// Java java_.JAVA_Exeption.Program to Illustrate Checked Exceptions Where FileNotFoundException does not occur

// Importing I/O classes
import java.io.*;
/**
 We have used throws in the below program. Since FileNotFoundException is a subclass of IOException, we can just specify
 IOException in the throws list and make the above program compiler-error-free.
 */
class Example {
    public static void main(String[] args) throws IOException {

        // Creating a file and reading from local repository
        FileReader file = new FileReader("C:\\Parth\\cloud1.txt");//FileNotFoundException

        // Reading content inside a file
        BufferedReader fileInput = new BufferedReader(file);

        // Printing first 10 lines of file "C:\Parth\cloud1.txt"
        for (int counter = 0; counter < 10; counter++)
            System.out.println(fileInput.readLine());//IOException

        // Closing all file connections using close() method Good practise to avoid any memory leakage
        fileInput.close();//IOException
    }
}