package Java.FIle;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CharacterStream {
    public static void main(String[] args) throws IOException {
        FileReader in=null;
        FileWriter out=null;
        try{
            in=new FileReader("input.txt");
            out=new FileWriter("output.txr");
            int c;
            while((c=in.read())!=-1){
                out.write(c);
            }
//            out.write("I want to become a software developer");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in!=null){
                in.close();
            }
            if(out!=null){
                out.close();
            }
        }
    }
}
