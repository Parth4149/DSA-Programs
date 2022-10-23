package Java.FIle;

import java.io.File;

public class _3_2File2 {
    public static void main(String[] args) {
        File obj=new File("C:\\Parth\\newfile.txt");
        if(obj.exists()){
            System.out.println(obj.getName());
            System.out.println(obj.getAbsolutePath());
            System.out.println(obj.canWrite());
            System.out.println(obj.canRead());
            System.out.println(obj.length());
        } else{
            System.out.println("File does not exists");
        }
    }
}
