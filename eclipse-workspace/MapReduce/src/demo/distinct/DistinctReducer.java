package demo.distinct;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class DistinctReducer extends Reducer<IntWritable, NullWritable, IntWritable, NullWritable> {

	@Override
	protected void reduce(IntWritable k3, Iterable<NullWritable> v3,
			Reducer<IntWritable, NullWritable, IntWritable, NullWritable>.Context context)
			throws IOException, InterruptedException {
		// no operations needed, just write out 
		
		context.write(k3, NullWritable.get());
	}
	
}
