package Java.Networking;

import java.net.*;
public class _1URL{
    public static void main(String[] args) {
        try{
            URL url=new URL("https://nptel.ac.in/cource.php");
            System.out.println("Protocol : "+url.getProtocol());
            System.out.println("Host Name : "+url.getHost());
            System.out.println("Port Number : "+url.getPort());
            System.out.println("File Name : "+url.getFile());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*
Protocol : https
Host Name : nptel.ac.in
Port Number : -1
File Name : /cource.php
 */