package demo.equaljoin;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EqualJoinMapper extends Mapper<LongWritable, Text, IntWritable, Text> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		// Tokenize
		String data = value.toString();
		String[] words = data.split(",");
		
		// differentiate which data source we are taking in 
		// in this case by using the length of the array
		
		if(words.length ==3) {
			// input is department info 
			// adding a tag "DEPT" so we can differentiate department name from employee name
			context.write(new IntWritable(Integer.parseInt(words[0])), new Text("DEPT" + words[1]));
		} else {
			// input is from emp table 
			context.write(new IntWritable(Integer.parseInt(words[7])), new Text("EMP" + words[1]));
			
		}
	}
	

}
