package Java.Networking;

import java.io.InputStream;
import java.net.*;
class _2URLconnection{
    public static void main(String[] args) {
        try{
            URL url=new URL("https://nptel.ac.in/cource.php");
            URLConnection uricon=url.openConnection();
            InputStream stream=uricon.getInputStream();
            int b;
            while((b=stream.read())!=-1){
                System.out.print((char)b);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}