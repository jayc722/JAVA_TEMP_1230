package day015.socket3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex03_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int port = 5001;
		
		
		try {
			
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		System.out.println("[연결 대기 중...]");
		
		Socket socket = serverSocket.accept();
		
		System.out.println("[연결 성공!]");
		
		Client c = new Client(socket);
		c.send();
		c.recieve();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
