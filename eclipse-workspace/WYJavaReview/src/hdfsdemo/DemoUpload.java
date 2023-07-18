package hdfsdemo;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class DemoUpload {
	// upload from local to hdfs
	
	@Test
	public void test1() throws Exception {
		// set user 
		System.setProperty("HADOOP_USER_NAME","root");
		
		// configure namenode 
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.238.111:9000");
		
		// create an hdfs client
		FileSystem client = FileSystem.get(conf);
		
		// create an input stream 
		InputStream input = new FileInputStream("/Users/li/Desktop/ANGHAMI_AO_2023Q2_US.txt.gz");
		
		// create an output stream
		OutputStream output = client.create(new Path("/folder1/a.tar.gz"));
		
		// need byte buffer because we are writing to a tar.gz file 
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = input.read(buffer)) >0) {
			output.write(buffer, 0, len);
		}
		
		output.flush();
		output.close();
		input.close();
	}
	
	@Test
	public void test2() throws Exception {
		// set user 
		System.setProperty("HADOOP_USER_NAME","root");
		
		// configure namenode 
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.238.111:9000");
		
		// create an hdfs client
		FileSystem client = FileSystem.get(conf);
		
		// create an input stream 
		InputStream input = new FileInputStream("/Users/li/Desktop/ANGHAMI_AO_2023Q2_US.txt.gz");
		
		// create an output stream
		OutputStream output = client.create(new Path("/folder1/b.tar.gz"));
		
		// use a copyBytes tool to upload 
		IOUtils.copyBytes(input, output, conf);
	}
	

}
