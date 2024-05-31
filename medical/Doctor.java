package medical;

public class Doctor extends Person 
{
    private String speciality;
	private int yrsOfExp;
	private String workinghrs;
	private String designation;
	private String qualification;

    public Doctor(String name, int age, String speciality, int yrsOfExp, String workinghrs, String designation, String qualification) {
        super(name, age);
        this.speciality = speciality;
		this.yrsOfExp = yrsOfExp;
		this.workinghrs = workinghrs;
		this.designation = designation;
		this.qualification = qualification;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

	public int getYrsOfExp() {
        return yrsOfExp;
    }

    public void setYrsOfExp(int yrsOfExp) {
        this.yrsOfExp = yrsOfExp;
    }
	
	public String getWorkinghrs() {
        return workinghrs;
    }

    public void setWorkinghrs(String workinghrs) {
        this.workinghrs = workinghrs;
    }
	
	public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
	
	public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Speciality: " + speciality);
		System.out.println("Years of experience: " + yrsOfExp);
		System.out.println("Availability hours: " + workinghrs);
		System.out.println("Designation: " + designation);
		System.out.println("Qualification: " + qualification);
    }
}