package wordcount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;


public class WordcountMain {
	// This is more or less a template. All Mapreduce main programs follow this structure. 

	public static void main(String[] args) throws Exception {
		// 1. create a job, and specify entrypoint
		
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(WordcountMain.class);
		
		// 2. Specify Map and Map output type 
		job.setMapperClass(WordCountMapper.class);
		job.setMapOutputKeyClass(Text.class); // k2
		job.setMapOutputValueClass(IntWritable.class); //v2
		
		// 3. Specify Reduce and Reduce output type 
		
		job.setReducerClass(WordCountReducer.class); 
		job.setOutputKeyClass(Text.class); //k4
		job.setOutputValueClass(IntWritable.class); // v4
		
		// 4. Specify Job input and output paths 
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		
		// 5. Run job
		job.waitForCompletion(true); // true: print logs 

	}

}
