package Java.FIle;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class _5Reading {
    public static void main(String[] args) {
        try{
            File obj=new File("C:\\Parth\\mynewfile.txt");
            Scanner sc=new Scanner(obj);
            while(sc.hasNextLine()){
                String data=sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
//            e.printStackTrace();
        }
    }
}

