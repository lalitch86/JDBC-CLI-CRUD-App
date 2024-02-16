import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("welcome to Student Management App");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter 1 to add student");
			System.out.println("Enter 2 to delete student");
			System.out.println("Enter 3 to display student");
			System.out.println("Enter 4 to update student details");
			System.out.println("Enter 5 to exit app");
			int c = Integer.parseInt(bf.readLine());
			if (c == 1) {
				// add student
				System.out.println("Enter Student Name : ");
				String name = bf.readLine();

				System.out.println("Enter Student phone: ");
				String phone = bf.readLine();

				System.out.println("Enter Student city : ");
				String city = bf.readLine();
				// create student object to store student
				Student st = new Student(name, phone, city);

				boolean answer = StudentDao.insertStudentToDB(st);
				if (answer) {
					System.out.println("student added successfully!!");
				} else {

					System.out.println("something went wrong!");
				}
				System.out.println(st);

			} else if (c == 2) {
				// delete student
				System.out.println("Enter Student Id to Delete : ");
				int sid = Integer.parseInt(bf.readLine());
				Boolean f = StudentDao.deleteStudent(sid);
				if (f) {
					System.out.println("student deleted successfully!!");
				} else {

					System.out.println("something went wrong!");
				}

			} else if (c == 3) {
				// display student
				System.out.println("Student Into");
				StudentDao.showStudents();

			} else if (c == 4) {
				System.out.println("Enter Student Id to updated : ");
				int sid = Integer.parseInt(bf.readLine());

				Boolean f = StudentDao.checkId(sid);
				if (f) {

					System.out.println("Enter Student Name : ");
					String name = bf.readLine();

					System.out.println("Enter Student phone: ");
					String phone = bf.readLine();

					System.out.println("Enter Student city : ");
					String city = bf.readLine();
					// create student object to store student
					Student st = new Student(sid, name, phone, city);

					Boolean f2 = StudentDao.updateStudent(st);
					if (f2) {
						System.out.println("student updated successfully!!");
						System.out.println(st);
					}
				} else {
					System.out.println("something went wrong! or Enter Valid Id");
				}

			} else if (c == 5) {
				// exit
				System.out.println("");
				break;
			} else {
				System.out.println("Enter valid Option");

			}

		}
		System.out.println("Thank You for using my application");

	}

}
