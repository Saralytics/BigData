package demo.mrunit;

import org.junit.Test;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import java.util.List;
import java.util.ArrayList;

public class MRUniteWordCount {
	
	@Test
	public void testMapper() throws Exception {
		// create a test object 
		WordCountMapper mapper = new WordCountMapper();
		
		// create a driver for unit test
		MapDriver<LongWritable, Text, Text, IntWritable>  driver = new MapDriver<LongWritable, Text, Text, IntWritable>(mapper);
		
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
		// create a test object
		WordCountReducer reducer = new WordCountReducer();
		
		// create a driver for test
		ReduceDriver<Text, IntWritable,Text, IntWritable> 
			driver = new ReduceDriver<Text, IntWritable, Text, IntWritable>(reducer);
		
		// create the input 
		List<IntWritable> v3 = new ArrayList<IntWritable>();
		v3.add(new IntWritable(1));
		v3.add(new IntWritable(1));
		
		driver.withInput(new Text("Beijing"),v3);
		
		// create the expected output 
		driver.withOutput(new Text("Beijing"), new IntWritable(2));
		
		// Run test
		driver.runTest();
	}
	
	@Test
	public void testJob() throws Exception{
		
		// create test object
		WordCountMapper mapper = new WordCountMapper();
		WordCountReducer reducer = new WordCountReducer();
		
		// create driver 
		MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> 
			driver = new MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable>(mapper, reducer);
		
		// create input 
		driver.withInput(new LongWritable(1),new Text("I love Beijing"))
		.withInput(new LongWritable(2),new Text("I love China"))
		.withInput(new LongWritable(1),new Text("Beijing is the capital of China"));
		
		// create output 
		// in this case the order matter 
		
		driver
			.withOutput(new Text("Beijing"), new IntWritable(2))
			.withOutput(new Text("China"), new IntWritable(2))
			.withOutput(new Text("I"), new IntWritable(2))
			.withOutput(new Text("capital"), new IntWritable(1))
			.withOutput(new Text("is"), new IntWritable(1))
			.withOutput(new Text("love"), new IntWritable(2))
			.withOutput(new Text("of"), new IntWritable(1))
			.withOutput(new Text("the"), new IntWritable(1));
			
		
		// run test
		driver.runTest();
		
	}

}
