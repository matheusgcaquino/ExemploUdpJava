package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;
import java.util.Scanner;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

    	    DatagramSocket socket = new DatagramSocket(20000);
    	    
    	    Scanner scan = new Scanner(System.in);
            byte[] msg_buf;
            int msg_size;
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 10000; 
            DatagramPacket pack_send = null;

            byte[] buf = null;
            DatagramPacket pack_receive = null;
            String msg;
            
            while (true) {
                buf = new byte[20];
                System.out.println("Aguardando...");
                pack_receive = new DatagramPacket(buf, buf.length);
                socket.receive(pack_receive);
                msg = new String(pack_receive.getData());
                System.out.println("Recebido: " + msg);
                
                System.out.println("Escreva:");
                msg_buf = scan.next().getBytes();
                msg_size = msg_buf.length;
                pack_send = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
                socket.send(pack_send);
            }
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}