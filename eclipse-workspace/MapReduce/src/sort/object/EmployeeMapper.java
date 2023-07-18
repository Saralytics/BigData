package sort.object;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
//                                         k1            v1    k2 Employee object, v2: no need for v2 in this case  
public class EmployeeMapper extends Mapper<LongWritable, Text,Employee, NullWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String data = value.toString();
		
		String[] words = data.split(",");
		
		Employee e = new Employee();
		
		e.setEmpno(Integer.parseInt(words[0]));
		e.setEmpname(words[1]);
		e.setTitle(words[2]);
		e.setMgrno(Integer.parseInt(words[3]));
		e.setHiredate(words[4]);
		e.setSalary(Integer.parseInt(words[5]));
		e.setBonus(Integer.parseInt(words[6]));
		e.setDeptno(Integer.parseInt(words[7]));
		
		context.write(e,NullWritable.get());
		
		
	}
	

}
