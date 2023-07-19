package demo.mrunit;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		// Read in the input and tokenize the line
		String input = value.toString();
		String[] words = input.split(" ");
		
		// for each word, the k2 is the word itself, v2 is 1 
		for (String w:words) {
			context.write(new Text(w), new IntWritable(1));
		}
		
	}

}
