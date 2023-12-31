package wordcount;

import org.apache.hadoop.io.Text;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

//                                    k1 datatype, v1 datatype, etc
public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

	@Override
	protected void map(LongWritable k1, Text v1, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// CONTEXT refer to the input and output of this step 
		// input from HDFS
		// output to Reducer 
		
		// getting data 
		String data = v1.toString();
		
		// Tokenize
		String[] words = data.split(" ");
		
		// transform to output format 
		
		for(String w:words) {
			Text k2 = new Text(w); // cast w from String to Text 
			IntWritable v2 = new IntWritable(1);
			context.write(k2, v2);
		}
	}
	
	
}
