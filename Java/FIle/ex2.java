package Java.FIle;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

class My {
    public static void main(String[] args) {
        try{
            File obj = new File("C:\\Parth\\file1.txt");
            Scanner sc = new Scanner(obj);

            FileWriter wr = new FileWriter("C:\\Parth\\file2.txt");

            while(sc.hasNextLine()){
                String data = sc.nextLine();
                char[] chars = data.toCharArray();
                wr.write(data);
            }
            sc.close();
            wr.close();
            System.out.println("Successfully written");
        }
        catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}


