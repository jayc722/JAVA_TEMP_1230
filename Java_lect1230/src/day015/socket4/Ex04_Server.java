package day015.socket4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex04_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int port = 5001;

		List<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();

		try {


			ServerSocket serverSocket = new ServerSocket(port);

			System.out.println("[연결 대기 중...]");



			while(true) {

				Socket socket = serverSocket.accept();

				System.out.println("[연결 성공!]");

				Server server = new Server(list, socket);
				server.receive();

			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
