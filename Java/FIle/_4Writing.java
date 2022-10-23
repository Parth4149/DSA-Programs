package Java.FIle;

import java.io.FileWriter;
import java.io.IOException;

public class _4Writing {
    public static void main(String[] args) {
        try{
            FileWriter wr=new FileWriter("C:\\Parth\\newfile.txt");
            wr.write("I want to become a software developer");// this line is written in newfile.txt
            wr.write("I will be wording at good organization");
            wr.close();
            System.out.println("successfully wrote");
        } catch (IOException e) {
            System.out.println("An error occurred");
//            e.printStackTrace();  //FileNotFoundException
        }
    }
}
