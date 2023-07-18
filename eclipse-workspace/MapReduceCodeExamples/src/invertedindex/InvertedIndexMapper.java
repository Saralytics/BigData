package invertedindex;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		// getting the input path 
		String path = ((FileSplit)context.getInputSplit()).getPath().toString();
		
		// getting the filename
		int index = path.lastIndexOf("/");
		String fileName = path.substring(index+1);
		
		String data = value.toString();
		String[] words = data.split(" ");
		
		for(String w:words) {
			Text k2 = new Text(w+":"+fileName);
			Text v2 = new Text("1");
			context.write(k2, v2);
		}
		
	}
	

}
