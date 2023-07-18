package demo.distinct;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class DistinctMapper extends Mapper<LongWritable, Text, IntWritable, NullWritable> {

	@Override
	protected void map(LongWritable k1, Text v1,
			Mapper<LongWritable, Text, IntWritable, NullWritable>.Context context)
			throws IOException, InterruptedException {
		// split words
		
		String data = v1.toString();
		String[] words = data.split(",");
		
		// write to output 
		
		context.write(new IntWritable(Integer.parseInt(words[7])), NullWritable.get());
		
		
	}
	
	

}
