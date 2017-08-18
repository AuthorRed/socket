package cn.author;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class CSocket {
	public static void main(String[] args) throws Exception, IOException {
		long startTime=System.currentTimeMillis();
		int port=12345;
		String host="127.0.0.1";
		//while(true){
			for(int i=0;i<1000;i++){
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
					//Thread.sleep(2000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					dataOutputStream.close();
					socket.close();
				}
				
			//}
		}
			long endTime=System.currentTimeMillis();
			long compareTime=endTime-startTime;
			System.out.println("使用线程池的时间是："+compareTime);
	}
}
