package part;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

// 												k2:deptno, v2
public class MyPartitioner extends Partitioner<IntWritable, Employee>{

	@Override
	public int getPartition(IntWritable k2, Employee v2, int numTask) {
		// numTask: how many partitions to create. This is set in main program
		int deptno = v2.getDeptno();
		if(deptno == 10) {
			// put in partition 1 
			return 1%numTask;
		} else if(deptno == 20) {
			return 2%numTask;
		} else {
			return 3%numTask;
		}
		
	}
	

}
