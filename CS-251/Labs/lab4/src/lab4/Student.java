package lab4;

public class Student {

	private String name;
	private double gpa;
	private String major;

	private static int totalStudents;
	private static double totalGPA;
	private static int totalCompSciMajors;
	private static double totalCompSciGPA;

	public Student(String name, double gpa, String major) {
		this.name = name;
		this.gpa = gpa;
		this.major = major;
		totalStudents++;
		totalGPA += gpa;
		if (major.equals("CompSci")) {
			totalCompSciMajors++;
			totalCompSciGPA += gpa;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = name;

	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		if (gpa < 0.0 || gpa > 4.0) {
			System.out.print("Error - GPA must be between 0.0 and 4.0.");
			return;
		}
		if (major.equals("CompSci")) {
			totalCompSciGPA -= this.gpa;
			totalGPA -= this.gpa;
			this.gpa = gpa;
			totalCompSciGPA += this.gpa;
			totalGPA += this.gpa;
			return;
		}
		totalGPA -= this.gpa;
		this.gpa = gpa;
		totalGPA += this.gpa;

	}

	public String getMajor() {
		return major;
	}

	public static double getStudentAvg() {
		if (totalStudents == 0) {
			System.out.print("Error - Divide By Zero");
			return 0.0;
		}
		return totalGPA / totalStudents;

	}

	public static double getCompSciAvg() {
		if (totalCompSciMajors == 0) {
			System.out.print("Error - Divide By Zero");
			return 0.0;
		}
		return totalCompSciGPA / totalCompSciMajors;
	}

	public String toString() {
		return "Student Name: " + this.name + ", Major: " + this.major + ", GPA: " + this.gpa + "\n";
	}

	public boolean equals(Object other) {
		if (other instanceof Student) {
			Student s1 = (Student) other;
			if (this.gpa == s1.getGpa() && this.name.equals(s1.getName()) && this.major.equals(s1.getMajor())) {
				return true;
			}
			return false;
		}
		return false;
	}

}
