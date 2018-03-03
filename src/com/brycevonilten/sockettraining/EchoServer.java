package com.brycevonilten.sockettraining;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Vector;

public class EchoServer extends Thread{

    public static void main(String[] args) {
    	//Vector<Connection> connections = new Vector<Connection>(); 
    	//ConnectionListener connectionListener = new ConnectionListener(connections);
    	
    	Socket clientSocket = null;
    	ServerSocket serverSocket = null;
    	
    	try {
	        // create socket
	        serverSocket = new ServerSocket(0);
	        final int port = serverSocket.getLocalPort();
	        
	        System.out.println("Started server on port " + port);
    	}
    	catch(IOException e) {
    	    e.printStackTrace();
    	    System.out.println("Server error");

    	}
    	
        // repeatedly wait for connections, and process
    	try {
	    	while (true) {
	        		// a "blocking" call which waits until a connection is requested
	                clientSocket = serverSocket.accept();
	                System.out.println("Accepted connection from client " + clientSocket.toString());
	                ServerThread st = new ServerThread(clientSocket);
	                
	                // listen to client in a separate thread
	                //Connection connection = new Connection(clientSocket);
	                //connections.add(connection);
	                
	                st.start();
	        }
    	}
	    catch(Exception e){
	        e.printStackTrace();
	        System.out.println("Connection Error");

	    }
    	finally {
    		if (serverSocket != null) {
                try {
                    serverSocket.close();
                }
                catch (IOException e) {
                	 e.printStackTrace();
                }
            }
    	}
    }
}