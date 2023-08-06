package demo.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class SalaryGrader extends UDF {

		String evaluate(int salary) {
			
			if(salary<1000) {
				return "a";
			} 
			else if(salary>=1000) {
				return "b";
			} else {
				return "c";
			}
			
		}

	}


