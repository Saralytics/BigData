package demo.selfjoin;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class SelfJoinMain {

	public static void main(String[] args) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(SelfJoinMain.class);
		
		// 2. Specify Map and Map output type 
		job.setMapperClass(SelfJoinMapper.class);
		job.setMapOutputKeyClass(IntWritable.class); // k2
		job.setMapOutputValueClass(Text.class); //v2
		
		// 3. Specify Reduce and Reduce output type 
		
		job.setReducerClass(SelfJoinReducer.class); 
		job.setOutputKeyClass(Text.class); //k4
		job.setOutputValueClass(Text.class); // v4
		
		// 4. Specify Job input and output paths 
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		
		// 5. Run job
		job.waitForCompletion(true); // true: print logs 

	}

}
