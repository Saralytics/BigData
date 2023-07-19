package demo.mrunit;

import org.junit.Test;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;

public class MRUniteWordCount {
	
	@Test
	public void testMapper() throws Exception {
		// create a test object 
		WordCountMapper mapper = new WordCountMapper();
		
		// create a driver for unit test
		MapDriver<LongWritable, Text, Text, IntWritable>  driver = new MapDriver(mapper);
		
		// Specify the map input 
		driver.withInput(new LongWritable(1), new Text("I love Beijing"));
		
		// Specify the Expected map output
		driver.withOutput(new Text("I"), new IntWritable(1))
		.withOutput(new Text("love"), new IntWritable(1))
		.withOutput(new Text("Beijing"), new IntWritable(1));
		
		// Run the unit test 
		driver.runTest();
		
	}
	
	@Test
	public void testReducer() throws Exception {
		
	}
	
	@Test
	public void testJob() throws Exception{
		
	}

}
