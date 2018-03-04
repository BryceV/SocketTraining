package com.brycevonilten.sockettraining;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.*;

//JFrame implements Serializable, for now suppress
@SuppressWarnings("serial")
public class EchoClient extends JFrame{

	public static void main(String[] args) throws Exception {
		UIManager connectBox = new UIManager("connect");

		String host = null;
		String userInput = null;
		int port = 0;
		
		//Find an alternative to this loop
		while ((host == null) || (port <= 0)) {
			host = connectBox.connectpanel.getIpAddress();
			port = connectBox.connectpanel.getPortNum();
	        Thread.sleep(500);
		}
		
		connectBox.window.dispose();
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
        
        UIManager typeBox = new UIManager("type");
        
        // read in a line from stdin, send to server, and print back reply
        while (true) {
            System.out.println("Waiting for input...");
            
            //Find an alternative to this loop
            userInput = null;
    		while ((userInput == null) || userInput.equals("")) {
    			userInput = typeBox.typepanel.getInput();
    			typeBox.typepanel.setInput("");
    	        Thread.sleep(500);
    		}
    		
            //userInput = keyboard.nextLine();
            
            if (userInput.equals("bye")) {
            	 userInput = null;
            	 out.println(userInput);
                 break;
            }
            
            out.println(userInput);

            // get reply from server and print it out
            //System.out.println(in.readLine()); 
            typeBox.typepanel.setLabel(in.readLine());
        }

        // close IO streams, then socket
        System.out.println("Closing connection to " + host);
        out.close();
        in.close();
        socket.close();
        keyboard.close();
    }
}
