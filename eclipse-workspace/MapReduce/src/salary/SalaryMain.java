package salary;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;



public class SalaryMain {

	public static void main(String[] args) throws Exception{
		
		// 1. Create a job and specify the entry point
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(SalaryMain.class);
		
		
		// 2. Specify the Mapper and the output of Mapper 
		job.setMapperClass(SalaryMapper.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		// Adding a Combiner
		// In this case, the combiner logic is the same as Reducer logic
		job.setCombinerClass(SalaryReducer.class);
		
		// 3. Specify the Reducer and the output of Reducer 
		job.setReducerClass(SalaryReducer.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		
		// 4. Specify the input and output path of the Job
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		
		// 5. Run job
		job.waitForCompletion(true);
	}

}
