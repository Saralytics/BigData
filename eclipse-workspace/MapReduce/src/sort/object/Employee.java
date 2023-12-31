package sort.object;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

// WritableComparable interface: both serializable and comparator
public class Employee implements WritableComparable<Employee>{
	
	private int empno;
	private String empname;
	private String title;
	private int mgrno;
	private String hiredate;
	private int salary;
	private int bonus;
	private int deptno;
	


	@Override
	public int compareTo(Employee o) {
		// sort by 1 column: by employee salary in asc order
		// sort by 2 columns
		
		if(this.deptno > o.getDeptno()) {
			return 1;
		} else if(this.deptno < o.getDeptno()) {
			return -1;
		}
		
		if(this.salary >= o.salary) {
			return 1;
		} else {
			return -1;
		}
	}
	
	@Override
	public void readFields(DataInput input) throws IOException {
		// "De-serialization"
		// the order must match serializer 
		this.empno = input.readInt();
		this.empname = input.readUTF();
		this.title = input.readUTF();
		this.mgrno = input.readInt();
		this.hiredate = input.readUTF();
		this.salary = input.readInt();
		this.bonus = input.readInt();
		this.deptno = input.readInt();
		
		
	}

	@Override
	public void write(DataOutput output) throws IOException {
		// Serialization
		output.writeInt(this.empno);
		output.writeUTF(this.empname);
		output.writeUTF(title);
		output.writeInt(this.mgrno);
		output.writeUTF(hiredate);
		output.writeInt(salary);
		output.writeInt(bonus);
		output.writeInt(deptno);
	}

	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + ", salary=" + salary + ", deptno=" + deptno + "]";
	}

	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMgrno() {
		return mgrno;
	}
	public void setMgrno(int mgrno) {
		this.mgrno = mgrno;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	

}
