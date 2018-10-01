package lab4;
public class Driver {

	public static void main(String[] args) {

		Student[] students = new Student[7];

		students[0] = new Student("Eva", 3.5, "CompSci");
		students[1] = new Student("Ahmed", 4.0, "CompSci");
		students[2] = new Student("Shaina", 3.5, "EE");
		students[3] = new Student("Megan", 3.0, "Accounting");
		students[4] = new Student("Antonio", 3.0, "CompSci");
		students[5] = new Student("Jim", 1.5, "Business");
		students[6] = new Student("Morgan", 3.5, "Architecture");

		System.out.println("All students:");
		
		for(Student s: students) {
			System.out.println(s);
		}
		
		System.out.println("\n\nTesting equals methods.\n");
		
		System.out.println("Does " + students[0].getName() + " equal " + students[1].getName() + "?");	
		if(students[0].equals(students[1])) {
			System.out.println("They are the same.");
		} else {
			System.out.println("They are not the same.");
		}
		
		System.out.println("\nDoes " + students[4].getName() + " equal " + students[4].getName() + "?");	
		if(students[4].equals(students[4])) {
			System.out.println("They are the same.");
		} else {
			System.out.println("They are not the same.");
		}
		
		System.out.println("\n\nTesting static variables.\n");
		System.out.printf("All Students avg = %.2f\n", Student.getStudentAvg());
		System.out.printf("All CompSci Students avg = %.2f\n", Student.getCompSciAvg());

		System.out.println("\nTime to set all gpa values to 3.0.");
		System.out.println("If done correctly, both averages should be 3.0.\n");

		for(Student s: students) {
			s.setGPA(3.0);
		}

		System.out.printf("All Students avg = %.2f\n", Student.getStudentAvg());
		System.out.printf("All CompSci Students avg = %.2f\n", Student.getCompSciAvg());

		System.out.println("\nTime to set all gpa values of CompSci Students to 4.0.");
		System.out.println("If done correctly, both averages should be different.\n");

		for(Student s: students) {
			if(s.getMajor().equals("CompSci"))
				s.setGPA(4.0);
		}

		System.out.printf("All Students avg = %.2f\n", Student.getStudentAvg());
		System.out.printf("All CompSci Students avg = %.2f\n", Student.getCompSciAvg());

	}

}
