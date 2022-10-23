package Java.FIle;

import java.io.File;
import java.io.IOException;

class FileTest {
    public static void main(String[] args) {
        try{
            File obj = new File("C:\\Parth\\newfile.txt");
            if(obj.createNewFile()){
                System.out.println(obj.getName());
            } else{
                System.out.println("File already exists");
            }
        } catch(IOException e){
            System.out.println("An error occurred");
        }
    }
}
