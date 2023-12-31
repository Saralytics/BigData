package demo.equaljoin;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EqualJoinReducer extends Reducer<IntWritable, Text, Text, Text> {

	@Override
	protected void reduce(IntWritable k3, Iterable<Text> v3, Context context)
			throws IOException, InterruptedException {
		
		String employeeNames = "";
		String deptName = "";
		
		// k3 = 10
		// v3 = (Sally, Joan, Tom, DEPT Sales, Sara)
		for (Text v:v3) {
			String string = v.toString();
			
			// 
			int index = string.indexOf("DEPT");
			
			if (index >= 0) {
				deptName = string.substring(4);
			} else {
				employeeNames += string + ";"; 
			}
		}
		
		context.write(new Text(deptName), new Text(employeeNames));
	}
	

}
