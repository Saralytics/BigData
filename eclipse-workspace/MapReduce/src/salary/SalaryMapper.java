package salary;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SalaryMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {

	@Override
	protected void map(LongWritable k1, Text v1, Context context)
			throws IOException, InterruptedException {
		// split text here 
		String data = v1.toString();
		String[] fields = data.split(",");
		
		context.write(new IntWritable(Integer.parseInt(fields[7])), 
				new IntWritable(Integer.parseInt(fields[5])));
		
		
	}
	

}
