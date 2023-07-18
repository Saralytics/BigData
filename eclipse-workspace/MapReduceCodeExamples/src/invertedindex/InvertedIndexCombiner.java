package invertedindex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class InvertedIndexCombiner extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		int counter = 0;
		
		for (Text v:value) {
			counter += Integer.parseInt(v.toString());
			
		}
		
		String data = key.toString();
		int index = data.indexOf(":");
		
		String word = data.substring(0,index);
		String filename = data.substring(index+1);
		
		Text keyout  = new Text(word);
		Text valueout = new Text(filename+":"+counter);
		context.write(keyout, valueout);
	}
	

}
