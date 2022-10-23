package Java.FIle;// Import the File class
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        try{
            File obj=new File("C:\\Parth\\newfile.txt");
            Scanner sc=new Scanner(obj);
            String str="";
            while(sc.hasNextLine()){
                str+=sc.nextLine()+" ";
            }
            System.out.println(str);
            String[] temp = str.split(" ");
            String key="good";
            int count=0;
            for(String i: temp){
                if(key.equals(i))
                    count++;
            }
            System.out.println(count);
            sc.close();
        } catch(IOException e){
            System.out.println("An error occurred");
        }
    }
}
