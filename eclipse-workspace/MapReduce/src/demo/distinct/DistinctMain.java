package demo.distinct;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class DistinctMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// 1. create a job, and specify entrypoint
		
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(DistinctMain.class);
		
		// 2. Specify Map and Map output type 
		job.setMapperClass(DistinctMapper.class);
		job.setMapOutputKeyClass(IntWritable.class); // k2
		job.setMapOutputValueClass(NullWritable.class); //v2
		
		// 3. Specify Reduce and Reduce output type 
		
		job.setReducerClass(DistinctReducer.class); 
		job.setOutputKeyClass(IntWritable.class); //k4
		job.setOutputValueClass(NullWritable.class); // v4
		
		// 4. Specify Job input and output paths 
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		
		// 5. Run job
		job.waitForCompletion(true); // true: print logs 

	}

}
