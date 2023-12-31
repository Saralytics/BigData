package hdfsdemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DemoDownload {
	
	@Test
	public void test1() throws Exception {
		//set user
		System.setProperty("HADOOP_USER_NAME", "root");
		
		// configure NameNode
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.238.111:9000");
		
		//create client to interact with hdfs
		FileSystem client = FileSystem.get(conf);
		
		// input stream (from hdfs)
		
		InputStream input = client.open(new Path("/folder1/a.tar.gz"));
		// output stream (at local)
		OutputStream output = new FileOutputStream("/Users/li/Desktop/x.txt.gz");
		
		
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len=input.read(buffer))>0) {
			output.write(buffer,0,len);
		}
		
		output.flush();
		output.close();
		input.close();
	}
}
