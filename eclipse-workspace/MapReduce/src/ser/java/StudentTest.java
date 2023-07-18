package ser.java;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class StudentTest {

	public static void main(String[] args) throws Exception {
		Student s = new Student();
		s.setStudentID(1);
		s.setStudentName("Abraham");
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(""));
		out.writeObject(s);
		out.close();

	}

}
