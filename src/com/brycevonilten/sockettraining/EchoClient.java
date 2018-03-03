package com.brycevonilten.sockettraining;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.*;

public class EchoClient extends JFrame{
	private ConnectPanel mainpanel;
	
	public EchoClient () {
		setTitle("Connect Information");
		setSize(500,120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainpanel = new ConnectPanel();
		add(mainpanel);
		setVisible(true); 
	}
    
	public static void main(String[] args) throws Exception {
		EchoClient infoBox = new EchoClient();
		String host = null;
		String userInput;
		int port = 0;
		
		while ((host == null) && (port <= 0)) {
			host = infoBox.mainpanel.getIpAddress();
	        port = infoBox.mainpanel.getPortNum();
	        System.out.println(host + ":" + port);
		}

        //System.out.println(host + ":" + port);
		
        Scanner keyboard = new Scanner(System.in);
        /*
        host = "localhost";
        System.out.print("Please enter port number: ");
        port = keyboard.nextInt();
        System.out.println("");
        keyboard.nextLine();
    	*/
        // connect to server
        Socket socket = new Socket(host, port);
        
        // open up IO streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        //BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
                
        System.out.println("Connected to " + host + " on port " + port);
        
        // read in a line from stdin, send to server, and print back reply
        while (true) {
            System.out.println("Waiting for input...");
            userInput = keyboard.nextLine();
            
            if (userInput.equals("bye")) {
            	 userInput = null;
            	 out.println(userInput);
                 break;
            }
            
            out.println(userInput);

            // get reply from server and print it out
            System.out.println("echo: " + in.readLine()); 
        }

        // close IO streams, then socket
        System.out.println("Closing connection to " + host);
        out.close();
        in.close();
        socket.close();
        keyboard.close();
    }
}
