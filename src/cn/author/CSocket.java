package cn.author;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class CSocket {
	public static void main(String[] args) throws Exception, IOException {
		int port=12345;
		String host="127.0.0.1";
		while(true){
			DataOutputStream dataOutputStream=null;
			Socket socket=null;
			try {
				socket = new Socket(host,port);
				 dataOutputStream = new DataOutputStream(socket.getOutputStream());
				Random random = new Random();
				int nextInt = random.nextInt(5);
				
				dataOutputStream.writeUTF("客户端向服务器发送请求。。"+"&"+nextInt);
				System.out.println("客户端向服务器发送请求。。"+"&"+nextInt);
//			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//			System.out.println(dataInputStream.readUTF());	
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				dataOutputStream.close();
				socket.close();
			}
		}
	}
}
