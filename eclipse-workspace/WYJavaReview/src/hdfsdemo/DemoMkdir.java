package hdfsdemo;

import org.junit.Test;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class DemoMkdir {
	
	@Test
	public void test1() throws Exception{
		
		// set user 
		System.setProperty("HADOOP_USER_NAME", "root");
		
		// configure the location of namenode 
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.238.111:9000");
		
		// create a hdfs client 
		FileSystem client = FileSystem.get(conf);  
		
		// create a directory using the client 
		
		client.mkdirs(new Path("/folder1"));
		
		// close the client 
		client.close();
	}

}
