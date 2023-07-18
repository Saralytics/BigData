package invertedindex;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text keyin, Iterable<Text> valuein, Context context)
			throws IOException, InterruptedException {
		// Simply reformat the inputs 
		
		String str = "";
		for(Text v:valuein) {
			str += "(" + v.toString()+")";
		}
		
		context.write(keyin, new Text(str));
	}
	

}
