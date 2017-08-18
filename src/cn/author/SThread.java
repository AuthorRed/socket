package cn.author;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SThread implements Runnable{
	private Socket socket;
	
	public SThread(Socket socket){
		this.socket=socket;
	}

	@Override
	public void run() {
		DataInputStream dataInputStream =null;
		DataOutputStream dataOutputStream =null;

//		System.out.println("服务器开始接收socket..");

			//处理输入
			 try {
				dataInputStream = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				//parse inputstream
				String readUTF = dataInputStream.readUTF();
				if(readUTF.contains("&")){
					String[] splitStr = readUTF.split("&");					
					System.out.println("服务器开始接收到的数据是："+splitStr[1]);
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//处理输出
			 try {
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dataOutputStream.writeUTF("服务器响应客户端。。");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					dataInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	

}
