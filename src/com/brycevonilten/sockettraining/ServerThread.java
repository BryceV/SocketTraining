package com.brycevonilten.sockettraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	
	Socket s = null;
	BufferedReader in = null;
    PrintWriter out = null;
    
    public ServerThread(Socket s){
        this.s=s;
    }

	public void run() {
		try {
			// open up IO streams
	        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	        out = new PrintWriter(s.getOutputStream(), true);
		}
		catch(IOException e) {
			 System.out.println("IO error in server thread");
		}
		
		try {
	        // waits for data and reads it in until connection dies
	        // readLine() blocks until the server receives a new line from client
	        String s = null;
	        while (true) {
	        	System.out.println("Waiting for client input...");
	        	s = in.readLine();
	        	
	        	if (s == null) { 
	        		break;
	        	}
	        	
	        	s = "Server echoes back \'" + s + "\'"; 
	        	
	        	out.println(s);
	        } 
		}
		catch (IOException e) {
			//Put code
	    }
		finally {
	        // close IO streams, then socket
	        System.out.println("Closing connection with client " + s.toString());
	        
	        try {
	        	if(out != null)
	        		out.close();
	        	if(in != null)
	        		in.close();
	        	if(s != null)
	        		s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
