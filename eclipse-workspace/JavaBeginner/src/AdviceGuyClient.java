// This creates a client - who reads the advice
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;

class AdviceGuyClass {
	
	public void go() {
		// define the server address 
		InetSocketAddress serverAddress = new InetSocketAddress("localhost",5000);
		// Create a socket channel by opening from the server address 
		try (SocketChannel socketChannel = SocketChannel.open(serverAddress)){
			// if successfully opened the channel, create a reader that reads from the channel 
			Reader channelReader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
			// Create a BufferedReader on top of channelReader
			BufferedReader reader = new BufferedReader(channelReader);
			
			// Take a  line from the reader 
			
			String advice = reader.readLine();
			System.out.println("You should " + advice);
			
			// must close
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

public class AdviceGuyClient{
	public static void main(String[] args) {
		new AdviceGuyClass().go();
	}
}
