package TestSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient1 {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 9100);
		System.out.println("client start!!!");
		
		OutputStream out = s.getOutputStream();
		ObjectOutputStream dos = new ObjectOutputStream(out);
		Member m = new Member("이름", "전화번호", 19);
		
		dos.writeObject(m);
		dos.close();
		s.close();
		System.exit(0);

	}

}
