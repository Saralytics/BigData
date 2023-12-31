package ser.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class EmployeeMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// 1. Create a job and specify the entry point
				Job job = Job.getInstance(new Configuration());
				job.setJarByClass(EmployeeMain.class);
				
				
				// 2. Specify the Mapper and the output of Mapper 
				job.setMapperClass(EmployeeMapper.class);
				job.setMapOutputKeyClass(IntWritable.class);
				job.setMapOutputValueClass(Employee.class);
				
				
				// 3. Specify the Reducer and the output of Reducer 
				
				job.setOutputKeyClass(IntWritable.class);
				job.setOutputValueClass(Employee.class);
				
				// 4. Specify the input and output path of the Job
				
				FileInputFormat.setInputPaths(job, new Path(args[0]));
				FileOutputFormat.setOutputPath(job, new Path(args[1]));
				
				
				// 5. Run job
				job.waitForCompletion(true);

	}

}
