package flume01;

import java.nio.charset.Charset;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

public class DataSender {

	public static void main(String[] args) throws EventDeliveryException {
		
		String ip = "192.168.143.134";
		int port = 44444;
		
		RpcClient client = RpcClientFactory.getDefaultInstance(ip, port);
		
		Event event = EventBuilder.withBody("Hello again!!!!!!!!!!!", Charset.forName("UTF-8"));
		client.append(event);
		client.close();

	}

}
