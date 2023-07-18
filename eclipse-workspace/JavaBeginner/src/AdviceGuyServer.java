import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Random;

class AdviceGuyServerClass {
	// The list of advices 
	final private String[] adviceList = {
			"Take smaller bites",
			"Drink a lot of water, more",
			"Don't be too nice, you can be harsh and then nice",
			"Just for today, be honest"
	};
	
	// Generate a random number 
	private final Random random = new Random();
	
	private String getAdvice() {
		int nextAdvice = random.nextInt(adviceList.length);
		return adviceList[nextAdvice];
	}
	
	public void go() {
		// open a server socket channel and bind it to the port you run the application on 
		try(ServerSocketChannel serverChannel = ServerSocketChannel.open()){
			
			// bind 
			serverChannel.bind(new InetSocketAddress(5000));
			
			while (serverChannel.isOpen()) {
				// waits for client requests 
				// the LIMITATION is that this server can handle 1 client at a time
				SocketChannel clientChannel = serverChannel.accept();
				PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
				
				String advice = getAdvice();
				writer.println(advice); // send the client the advice 
				writer.close();
				System.out.println(advice); // print to the console so we know what's happeneing
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

public class AdviceGuyServer {
	public static void main(String[] args) {
		new AdviceGuyServerClass().go();
	}
}
