package demo.selfjoin;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SelfJoinReducer extends Reducer<IntWritable, Text, Text, Text> {

	@Override
	protected void reduce(IntWritable k3, Iterable<Text> v3, Context context)
			throws IOException, InterruptedException {
		
		// if 
		
		String managerName = "";
		String employeeList = "";
		
		for(Text v:v3) {
			String str = v.toString();
			
			int index = str.indexOf("MAN*");
			if(index >= 0) {
				managerName = str.substring(4);
			} else {
				employeeList += str + ";";
			}
		}
		
		// see there are people reporting to the manager 
		if(managerName.length() >0 && employeeList.length() > 0) {
			context.write(new Text(managerName), new Text(employeeList));
		}
	}
	

}
