package echo;

import java.io.*;
import java.net.*;

public class Correspondent {
	protected Socket sock;
	protected BufferedReader sockIn;
	protected PrintWriter sockOut;
	protected ObjectInputStream objInStream;
	protected ObjectOutputStream objOutStream;

	public Correspondent() { } // init fields later
	public Correspondent(Socket s) {
		sock = s;
		initStreams();
	}
	
	public void setSocket(Socket socket) {
		this.sock = socket;
		initStreams();
	}

	protected void initStreams() {
		try {
			sockIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			sockOut = new PrintWriter(sock.getOutputStream(), true);
//			objInStream = new ObjectInputStream(sock.getInputStream());
//			objOutStream = new ObjectOutputStream(sock.getOutputStream());
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}

	protected void close() {
		try {
			sock.close();
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void requestConnection(String host, int port) {
		try {
			sock = new Socket(host, port);
			initStreams();
		} catch(UnknownHostException uhe) {
			System.err.println("unknown host " + uhe);
			System.exit(1);
		} catch(IOException ioe) {
			System.err.println("failed to create streams " + ioe);
			System.exit(1);
		}
	}

	public void send(String request) {
		sockOut.println(request);
	}

	public String receive() {
		String msg = null;
		try {
			msg = sockIn.readLine();
		} catch(Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		return msg;
	}
	
//	public void writeObject(Object msg) throws IOException {
//		objOutStream.writeObject(msg);
//	}
//	
//	public Object readObject() throws ClassNotFoundException, IOException {
//		return objInStream.readObject();
//	}
	
} // Correspondent
