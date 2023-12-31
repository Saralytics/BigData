package salarySerialization;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;


public class SalaryReducerSerialization extends Reducer<IntWritable, Employee, IntWritable, IntWritable>{

	@Override
	protected void reduce(IntWritable k3, Iterable<Employee> v3, Context context)
			throws IOException, InterruptedException {
		int total = 0;
		for(Employee v:v3) {
			total += v.getSalary();
		}
		
		context.write(k3, new IntWritable(total));
	}
	

}
