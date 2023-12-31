package salarySerialization;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// 													  k1            v1    departmentNo  employee object	

public class SalaryMapperSerialization extends Mapper<LongWritable, Text, IntWritable, Employee> {

	@Override
	protected void map(LongWritable k1, Text v1, Context context)
			throws IOException, InterruptedException {
		// split text here 
		String data = v1.toString();
		String[] fields = data.split(",");
		
		Employee e = new Employee();
		
		e.setEmpno(Integer.parseInt(fields[0]));
		e.setEmpname(fields[1]);
		e.setTitle(fields[2]);
		e.setMgrno(Integer.parseInt(fields[3]));
		e.setHiredate(fields[4]);
		e.setSalary(Integer.parseInt(fields[5]));
		e.setBonus(Integer.parseInt(fields[6]));
		e.setDeptno(Integer.parseInt(fields[7]));
		
		context.write(new IntWritable(e.getDeptno()), e);
		
		
	}
	

}
