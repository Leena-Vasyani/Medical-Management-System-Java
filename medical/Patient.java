package medical;

public class Patient extends Person 
{
    private String diagnosis;

    public Patient(String name, int age, String diagnosis) {
        super(name, age);
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Diagnosis: " + diagnosis);
    }
}