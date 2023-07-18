package demo.selfjoin;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SelfJoinMapper extends Mapper<LongWritable, Text, IntWritable, Text>{

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		// Split words 
		String data = value.toString();
		String[] words = data.split(",");
		
		try {
		// Read in as Manager 
			// persons's own ID
		context.write(new IntWritable(Integer.parseInt(words[0])), new Text("MAN*" + words[1]));
		// As employee
		// perons's manager ID
		context.write(new IntWritable(Integer.parseInt(words[3])), new Text("EMP*" + words[1]));
		
		} catch(Exception ex) {
			// when the manager id is null, means the person has no one above them
			context.write(new IntWritable(-1), new Text(words[1]));
			
		}
		
	}
	

}
