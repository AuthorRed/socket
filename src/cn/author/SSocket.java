package cn.author;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SSocket {

	public static void main(String[] args) throws Throwable {

		
		System.out.println("服务器开始接收socket..");
	    int port=12345;
		String host="127.0.0.1";
		
		ServerSocket serverSocket = new ServerSocket(port);
		try {			
			while(true){
				Socket socket = serverSocket.accept();
				if(socket!=null){
					Thread thread = new Thread(new SThread(socket));
					thread.start();													
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
