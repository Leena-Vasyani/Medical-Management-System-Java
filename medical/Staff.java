package medical;

public class Staff extends Doctor
{
	private double salary;
	
	public Staff(String name, int age, String speciality, int yrsOfExp, String workinghrs, String designation, String qualification, double salary) {
        super(name, age, speciality, yrsOfExp, workinghrs, designation, qualification);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Salary: " + salary);
    }
}