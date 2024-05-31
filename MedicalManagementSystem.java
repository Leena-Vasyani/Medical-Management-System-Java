import java.util.Scanner;
import medical.*;

class AgeOutOfBoundsException extends Exception
{
	AgeOutOfBoundsException(String message)
	{
		super(message);
	}
}

class InvalidNameException extends Exception
{
	InvalidNameException(String message)
	{
		super(message);
	}
}

class ProductQuantityException extends Exception
{
	ProductQuantityException(String message)
	{
		super(message);
	}
}

public class MedicalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxPatients = 100; // Maximum number of patients
        Patient[] patients = new Patient[maxPatients];
        int patientCount = 3; // Starting with 3 patients

        // Initialize some patients
        patients[0] = new Patient("John Doe", 35, "Fever");
        patients[1] = new Patient("Alice Smith", 42, "Headache");
        patients[2] = new Patient("Bob Johnson", 28, "Sprained Ankle");
		
        int maxDoctors = 100; // Maximum number of doctors
        Doctor[] doctors = new Doctor[maxDoctors];
        int docCount = 3; // Starting with 3 doctors

        // Initialize some doctors
        doctors[0] = new Doctor("Dr. Lakshita Deshmukh", 48, "ENT Specialist", 9, "11 AM to 6 PM", "Assistant doctor", "MD");
        doctors[1] = new Doctor("Dr. Sanjay Verma", 56, "Cardiologist", 18, "8 AM to 7 PM", "Senior doctor", "MD");
        doctors[2] = new Doctor("Dr. Aleena Sharma", 29, "Physio-therapist", 3, "10 AM to 8 PM", "Fresher", "DPT");
		
        int maxStaff = 100; // Maximum number of staff
        Staff[] staff = new Staff[maxStaff];
        int staffCount = 3; // Starting with 3 staff

        // Initialize some staff
        staff[0] = new Staff("Pooja Chaudhary", 23, "Nurse", 2, "8 AM to 2 PM", "Fresher", "BSc Nursing", 15000);
        staff[1] = new Staff("Sahil Tayade", 49, "Peon", 12, "8 AM to 8 PM", "Senior", "HSC", 30000);
        staff[2] = new Staff("Arun Mishra", 34, "Nurse", 8, "12 PM to 9 PM", "Assistant", "Msc Nursing", 45000);
		
		int maxPdts = 100; // Maximum number of products
        Product[] pdts = new Product[maxPdts];
        int pdtCount = 3; // Starting with 3 products

        // Initialize some products
        pdts[0] = new Product("Crocin Tablet Strips", 15, 34);
        pdts[1] = new Product("Moov gel 50g", 23, 156);
        pdts[2] = new Product("Calpol 250 Syrup 60ml", 40, 45);

        while (true) {
			System.out.println();
            System.out.println("\n** Medical Management System Menu **");
            System.out.println("1. Patient");
            System.out.println("2. Doctor");
            System.out.println("3. Other Staff");
            System.out.println("4. Product");
            System.out.println("5. Exit");
			System.out.println();
            System.out.print("Select record field: ");
			
            int field = scanner.nextInt();
			
			System.out.println();
			switch (field) {
                case 1:
					System.out.println("*** Patient Record ***");
					System.out.println("1. Add a Patient");
					System.out.println("2. View All Patients");
					System.out.println("3. Search for a Patient");
					System.out.println("4. Update a Patient");
					System.out.println("5. Remove a Patient");
					System.out.println();
					System.out.print("Enter your choice: ");
					
					int choice1 = scanner.nextInt();

					switch (choice1) {
						case 1:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter patient name: ");
							String name = scanner.nextLine();
							try
							{
								char[] charArray = name.toCharArray();
								for (char c : charArray)
								{
									if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c == ' '))
										throw new InvalidNameException("Name should contain alphabets only!");
								}
								System.out.print("Enter patient age: ");
								int age = scanner.nextInt();
								try
								{
									if(age<=0)
									{
										throw new AgeOutOfBoundsException("Please enter a valid age!");
									}
									scanner.nextLine();  
									System.out.print("Enter patient diagnosis: ");
									String diagnosis = scanner.nextLine();
									if (patientCount < maxPatients) {
										patients[patientCount] = new Patient(name, age, diagnosis);
										patientCount++;
										System.out.println("Patient added successfully!");
									} else {
										System.out.println("Maximum number of patients reached. Cannot add more!");
									}
								}
								catch(AgeOutOfBoundsException e)
								{
									System.out.println(e);
								}
							}
							catch(InvalidNameException e)
							{
								System.out.println(e);
							}
										
							break;
						  

						case 2:
							  System.out.println();
							  if (patientCount == 0) {
								System.out.println("No patients in the system!");
							} else {
								System.out.println("\n--- List of Patients ---");
								System.out.println();
								for (int i = 0; i < patientCount; i++) {
									System.out.println("Patient " + (i + 1) + ":");
									patients[i].displayInfo();
									System.out.println();
								}
							}
							break;
							
						case 3:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter patient name to search: ");
							String searchName = scanner.nextLine();
							boolean found = false;
							for (int i = 0; i < patientCount; i++) {
								if (patients[i].getName().equalsIgnoreCase(searchName)) {
									System.out.println();
									System.out.println("Patient Found! Details of patient:");
									patients[i].displayInfo();
									found = true;
									break;
								}
							}
							if (!found) {
								System.out.println("Patient not found!");
							}
							break;

						case 4:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter patient name to update: ");
							String updateName = scanner.nextLine();
							boolean updated = false;
							for (int i = 0; i < patientCount; i++) {
								if (patients[i].getName().equalsIgnoreCase(updateName)) {
									System.out.println("Select an option to update:");
									System.out.println("1. Update Name");
									System.out.println("2. Update Age");
									System.out.println("3. Update Diagnosis");
									System.out.println();
									System.out.print("Enter your choice: ");
									int updateChoice = scanner.nextInt();
									scanner.nextLine();  

									switch (updateChoice) {
										case 1:
											System.out.print("Enter new name: ");
											String newName = scanner.nextLine();
											try
											{
												char[] charArray = newName.toCharArray();
												for (char c : charArray)
												{
													if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c == ' '))
														throw new InvalidNameException("Name should contain alphabets only!");
												}
												patients[i].setName(newName);
												System.out.println("Name updated successfully!");
											}
											catch(InvalidNameException e)
											{
												System.out.println(e);
											}
											
											break;
										case 2:
											System.out.print("Enter new age: ");
											int newAge = scanner.nextInt();
											try
											{
												if(newAge<=0)
												{
													throw new AgeOutOfBoundsException("Please enter a valid age!");
												}
												patients[i].setAge(newAge);
												System.out.println("Age updated successfully!");
											}
											catch(AgeOutOfBoundsException e)
											{
												System.out.println(e);
											}
											
											break;
										case 3:
											System.out.print("Enter new diagnosis: ");
											String newDiagnosis = scanner.nextLine();
											patients[i].setDiagnosis(newDiagnosis);
											System.out.println("Diagnosis updated successfully!");
											break;
										default:
											System.out.println("Invalid update option!");
									}

									updated = true;
									break;
								}
							}
							if (!updated) {
								System.out.println("Patient not found. Update failed!");
							}
							break;
							
						case 5:
							scanner.nextLine();  
							System.out.print("Enter patient name to remove: ");
							String removeName = scanner.nextLine();
							boolean removed = false;
							for (int i = 0; i < patientCount; i++) {
								if (patients[i].getName().equalsIgnoreCase(removeName)) {
									
									for (int j = i; j < patientCount - 1; j++) {
										patients[j] = patients[j + 1];
									}
									patients[patientCount - 1] = null;
									patientCount--;
									System.out.println("Patient removed successfully!");
									removed = true;
									break;
								}
							}
							if (!removed) {
								System.out.println("Patient not found. Removal failed!");
							}
							break;
					}
					break;
					
                case 2:
					System.out.println("*** Doctor Record ***");
					System.out.println("1. Add a Doctor");
					System.out.println("2. View All Doctors");
					System.out.println("3. Search for a Doctor");
					System.out.println("4. Update a Doctor");
					System.out.println("5. Remove a Doctor");
					System.out.println();
					System.out.print("Enter your choice: ");
					
					int choice2 = scanner.nextInt();

					switch (choice2) {
						case 1:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter doctor name: ");
							String docName = scanner.nextLine();
							try
							{
								char[] charArray = docName.toCharArray();
								for (char c : charArray)
								{
									if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c == ' ') && !(c == '.'))
										throw new InvalidNameException("Name should contain alphabets only!");
								}
								System.out.print("Enter doctor age: ");
								int docAge = scanner.nextInt();
								try
								{
									if(docAge<=0)
									{
										throw new AgeOutOfBoundsException("Please enter a valid age!");
									}
									scanner.nextLine();  
									System.out.print("Enter doctor speciality (field): ");
									String docSpeciality = scanner.nextLine();
									
									System.out.print("Enter years of experience of doctor: ");
									int docExp = scanner.nextInt();
									
									scanner.nextLine(); 
									System.out.print("Enter availability hours of doctor: ");
									String docHrs = scanner.nextLine();
									
									scanner.nextLine(); 
									System.out.print("Enter designation of doctor: ");
									String docDesignation = scanner.nextLine();
									
									scanner.nextLine(); 
									System.out.print("Enter doctor qualification: ");
									String docQualification = scanner.nextLine();
									
									if (docCount < maxDoctors) {
										doctors[docCount] = new Doctor(docName, docAge, docSpeciality, docExp, docHrs, docDesignation, docQualification);
										docCount++;
										System.out.println("Doctor added successfully!");
									} else {
										System.out.println("Maximum number of doctors reached. Cannot add more!");
									}
								}
								catch(AgeOutOfBoundsException e)
								{
									System.out.println(e);
								}
							}
							catch(InvalidNameException e)
							{
								System.out.println(e);
							}
										
							break;
						  
						case 2:
							  System.out.println();
							  if (docCount == 0) {
								System.out.println("No doctors in the system!");
							} else {
								System.out.println("\n--- List of Doctors ---");
								System.out.println();
								for (int i = 0; i < docCount; i++) {
									System.out.println("Doctor " + (i + 1) + ":");
									doctors[i].displayInfo();
									System.out.println();
								}
							}
							break;
							
						case 3:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter doctor name to search: ");
							String searchDocName = scanner.nextLine();
							boolean docFound = false;
							for (int i = 0; i < docCount; i++) {
								if (doctors[i].getName().equalsIgnoreCase(searchDocName)) {
									System.out.println();
									System.out.println("Doctor Found! Details of doctor:");
									doctors[i].displayInfo();
									docFound = true;
									break;
								}
							}
							if (!docFound) {
								System.out.println("Doctor not found!");
							}
							break;

						case 4:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter doctor name to update: ");
							String updateDocName = scanner.nextLine();
							boolean docUpdated = false;
							for (int i = 0; i < docCount; i++) {
								if (doctors[i].getName().equalsIgnoreCase(updateDocName)) {
									System.out.println("Select an option to update:");
									System.out.println("1. Update Name");
									System.out.println("2. Update Age");
									System.out.println("3. Update Speciality");
									System.out.println("4. Update Years of Experience");
									System.out.println("5. Update Availability hours");
									System.out.println("6. Update Designation");
									System.out.println("7. Update Qualification");
									System.out.println();
									System.out.print("Enter your choice: ");
									int updateDocChoice = scanner.nextInt();
									scanner.nextLine();  

									switch (updateDocChoice) {
										case 1:
											System.out.print("Enter new name: ");
											String newDocName = scanner.nextLine();
											try
											{
												char[] charArray = newDocName.toCharArray();
												for (char c : charArray)
												{
													if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c == ' ') && !(c == '.'))
														throw new InvalidNameException("Name should contain alphabets only!");
												}
												doctors[i].setName(newDocName);
												System.out.println("Name updated successfully!");
											}
											catch(InvalidNameException e)
											{
												System.out.println(e);
											}
											
											break;
										case 2:
											System.out.print("Enter new age: ");
											int newDocAge = scanner.nextInt();
											try
											{
												if(newDocAge<=0)
												{
													throw new AgeOutOfBoundsException("Please enter a valid age!");
												}
												doctors[i].setAge(newDocAge);
												System.out.println("Age updated successfully!");
											}
											catch(AgeOutOfBoundsException e)
											{
												System.out.println(e);
											}
											
											break;
										case 3:
											System.out.print("Enter new speciality: ");
											String newDocSpeciality = scanner.nextLine();
											doctors[i].setSpeciality(newDocSpeciality);
											System.out.println("Speciality updated successfully!");
											break;
										case 4:
											System.out.print("Enter new years of experience: ");
											int newDocExp = scanner.nextInt();
											doctors[i].setYrsOfExp(newDocExp);
											System.out.println("Years of experience updated successfully!");
											break;
										case 5:
											System.out.print("Enter new availability hours: ");
											String newDocHrs = scanner.nextLine();
											doctors[i].setWorkinghrs(newDocHrs);
											System.out.println("Availability hours updated successfully!");
											break;
										case 6:
											System.out.print("Enter new designation: ");
											String newDocDesignation = scanner.nextLine();
											doctors[i].setDesignation(newDocDesignation);
											System.out.println("Designation updated successfully!");
											break;
										case 7:
											System.out.print("Enter new qualification: ");
											String newDocQualification = scanner.nextLine();
											doctors[i].setQualification(newDocQualification);
											System.out.println("Qualification updated successfully!");
											break;
										default:
											System.out.println("Invalid update option!");
									}

									docUpdated = true;
									break;
								}
							}
							if (!docUpdated) {
								System.out.println("Doctor not found. Update failed!");
							}
							break;
							
						case 5:
							scanner.nextLine();  
							System.out.print("Enter doctor name to remove: ");
							String removeDocName = scanner.nextLine();
							boolean docRemoved = false;
							for (int i = 0; i < docCount; i++) {
								if (doctors[i].getName().equalsIgnoreCase(removeDocName)) {
									
									for (int j = i; j < docCount - 1; j++) {
										doctors[j] = doctors[j + 1];
									}
									doctors[docCount - 1] = null;
									docCount--;
									System.out.println("Doctor removed successfully!");
									docRemoved = true;
									break;
								}
							}
							if (!docRemoved) {
								System.out.println("Doctor not found. Removal failed!");
							}
							break;
					}
					break;
					
				case 3:
					System.out.println("*** Other Staff Record ***");
					System.out.println("1. Add a Staff");
					System.out.println("2. View All Staff");
					System.out.println("3. Search for a Staff");
					System.out.println("4. Update a Staff");
					System.out.println("5. Remove a Staff");
					System.out.println();
					System.out.print("Enter your choice: ");
					
					int choice3 = scanner.nextInt();

					switch (choice3) {
						case 1:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter staff name: ");
							String staffName = scanner.nextLine();
							try
							{
								char[] charArray = staffName.toCharArray();
								for (char c : charArray)
								{
									if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c == ' '))
										throw new InvalidNameException("Name should contain alphabets only!");
								}
								System.out.print("Enter staff age: ");
								int staffAge = scanner.nextInt();
								try
								{
									if(staffAge<=0)
									{
										throw new AgeOutOfBoundsException("Please enter a valid age!");
									}
									scanner.nextLine();  
									System.out.print("Enter staff speciality (field): ");
									String staffSpeciality = scanner.nextLine();
									
									System.out.print("Enter years of experience of staff: ");
									int staffExp = scanner.nextInt();
									
									scanner.nextLine(); 
									System.out.print("Enter availability hours of staff: ");
									String staffHrs = scanner.nextLine();
									
									scanner.nextLine(); 
									System.out.print("Enter designation of staff: ");
									String staffDesignation = scanner.nextLine();
									
									scanner.nextLine(); 
									System.out.print("Enter staff qualification: ");
									String staffQualification = scanner.nextLine();
									
									System.out.print("Enter staff salary: ");
									double staffSalary = scanner.nextInt();
									
									if (staffCount < maxStaff) {
										staff[staffCount] = new Staff(staffName, staffAge, staffSpeciality, staffExp, staffHrs, staffDesignation, staffQualification, staffSalary);
										staffCount++;
										System.out.println("Staff added successfully!");
									} else {
										System.out.println("Maximum number of staff reached. Cannot add more!");
									}
								}
								catch(AgeOutOfBoundsException e)
								{
									System.out.println(e);
								}
							}
							catch(InvalidNameException e)
							{
								System.out.println(e);
							}
										
							break;
						  
						case 2:
							  System.out.println();
							  if (staffCount == 0) {
								System.out.println("No staff in the system!");
							} else {
								System.out.println("\n--- List of Staff ---");
								System.out.println();
								for (int i = 0; i < staffCount; i++) {
									System.out.println("Staff " + (i + 1) + ":");
									staff[i].displayInfo();
									System.out.println();
								}
							}
							break;
							
						case 3:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter staff name to search: ");
							String searchStaffName = scanner.nextLine();
							boolean staffFound = false;
							for (int i = 0; i < staffCount; i++) {
								if (staff[i].getName().equalsIgnoreCase(searchStaffName)) {
									System.out.println();
									System.out.println("Staff Found! Details of doctor:");
									staff[i].displayInfo();
									staffFound = true;
									break;
								}
							}
							if (!staffFound) {
								System.out.println("Staff not found!");
							}
							break;

						case 4:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter staff name to update: ");
							String updateStaffName = scanner.nextLine();
							boolean staffUpdated = false;
							for (int i = 0; i < staffCount; i++) {
								if (staff[i].getName().equalsIgnoreCase(updateStaffName)) {
									System.out.println("Select an option to update:");
									System.out.println("1. Update Name");
									System.out.println("2. Update Age");
									System.out.println("3. Update Speciality");
									System.out.println("4. Update Years of Experience");
									System.out.println("5. Update Availability hours");
									System.out.println("6. Update Designation");
									System.out.println("7. Update Qualification");
									System.out.println("8. Update Salary");
									System.out.println();
									System.out.print("Enter your choice: ");
									int updateStaffChoice = scanner.nextInt();
									scanner.nextLine();  

									switch (updateStaffChoice) {
										case 1:
											System.out.print("Enter new name: ");
											String newStaffName = scanner.nextLine();
											try
											{
												char[] charArray = newStaffName.toCharArray();
												for (char c : charArray)
												{
													if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c == ' '))
														throw new InvalidNameException("Name should contain alphabets only!");
												}
												staff[i].setName(newStaffName);
												System.out.println("Name updated successfully!");
											}
											catch(InvalidNameException e)
											{
												System.out.println(e);
											}
											
											break;
										case 2:
											System.out.print("Enter new age: ");
											int newStaffAge = scanner.nextInt();
											try
											{
												if(newStaffAge<=0)
												{
													throw new AgeOutOfBoundsException("Please enter a valid age!");
												}
												staff[i].setAge(newStaffAge);
												System.out.println("Age updated successfully!");
											}
											catch(AgeOutOfBoundsException e)
											{
												System.out.println(e);
											}
											
											break;
										case 3:
											System.out.print("Enter new speciality: ");
											String newStaffSpeciality = scanner.nextLine();
											staff[i].setSpeciality(newStaffSpeciality);
											System.out.println("Speciality updated successfully!");
											break;
										case 4:
											System.out.print("Enter new years of experience: ");
											int newStaffExp = scanner.nextInt();
											staff[i].setYrsOfExp(newStaffExp);
											System.out.println("Years of experience updated successfully!");
											break;
										case 5:
											System.out.print("Enter new availability hours: ");
											String newStaffHrs = scanner.nextLine();
											staff[i].setWorkinghrs(newStaffHrs);
											System.out.println("Availability hours updated successfully!");
											break;
										case 6:
											System.out.print("Enter new designation: ");
											String newStaffDesignation = scanner.nextLine();
											staff[i].setDesignation(newStaffDesignation);
											System.out.println("Designation updated successfully!");
											break;
										case 7:
											System.out.print("Enter new qualification: ");
											String newStaffQualification = scanner.nextLine();
											staff[i].setQualification(newStaffQualification);
											System.out.println("Qualification updated successfully!");
											break;
										case 8:
											System.out.print("Enter new salary: ");
											double newStaffSalary = scanner.nextDouble();
											staff[i].setSalary(newStaffSalary);
											System.out.println("Salary updated successfully!");
											break;
										default:
											System.out.println("Invalid update option!");
									}

									staffUpdated = true;
									break;
								}
							}
							if (!staffUpdated) {
								System.out.println("Staff not found. Update failed!");
							}
							break;
							
						case 5:
							scanner.nextLine();  
							System.out.print("Enter staff name to remove: ");
							String removeStaffName = scanner.nextLine();
							boolean staffRemoved = false;
							for (int i = 0; i < staffCount; i++) {
								if (staff[i].getName().equalsIgnoreCase(removeStaffName)) {
									
									for (int j = i; j < staffCount - 1; j++) {
										staff[j] = staff[j + 1];
									}
									staff[staffCount - 1] = null;
									staffCount--;
									System.out.println("Staff removed successfully!");
									staffRemoved = true;
									break;
								}
							}
							if (!staffRemoved) {
								System.out.println("Staff not found. Removal failed!");
							}
							break;
					}
					break;
					
				case 4:
					System.out.println("*** Product Record ***");
					System.out.println("1. Add a Product");
					System.out.println("2. View All Products");
					System.out.println("3. Search for a Product");
					System.out.println("4. Update a Product");
					System.out.println("5. Remove a Product");
					System.out.println("6. Calculate Bill for Patient");
					System.out.println();
					System.out.print("Enter your choice: ");
					
					int choice4 = scanner.nextInt();

					switch (choice4) {
						case 1:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter product name: ");
							String pdtName = scanner.nextLine();
							System.out.print("Enter product quantity: ");
							int pdtQty = scanner.nextInt();
							try
							{
								if(pdtQty<=0)
								{
									throw new ProductQuantityException("Quantity cannot be negative or zero!");
								}
								System.out.print("Enter product cost: ");
								float pdtCost = scanner.nextFloat();
						
								if (pdtCount < maxPdts) {
									pdts[pdtCount] = new Product(pdtName, pdtQty, pdtCost);
									pdtCount++;
									System.out.println("Product added successfully!");
								} else {
									System.out.println("Maximum number of products reached. Cannot add more!");
								}
							}
							catch(ProductQuantityException e)
							{
								System.out.println(e);		
							}
							
							break;
                  

						case 2:
							  System.out.println();
							  if (pdtCount == 0) {
								System.out.println("No products in the system!");
							} else {
								System.out.println("\n--- List of Products ---");
								System.out.println();
								for (int i = 0; i < pdtCount; i++) {
									System.out.println("Product " + (i + 1) + ":");
									pdts[i].displayPdtInfo();
									System.out.println();
								}
							}
							break;
							
						case 3:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter product name to search: ");
							String searchPdtName = scanner.nextLine();
							boolean pdtFound = false;
							for (int i = 0; i < pdtCount; i++) {
								if (pdts[i].getPdtName().equalsIgnoreCase(searchPdtName)) {
									System.out.println();
									System.out.println("Product Found! Details of product:");
									pdts[i].displayPdtInfo();
									pdtFound = true;
									break;
								}
							}
							if (!pdtFound) {
								System.out.println("Product not found!");
							}
							break;

						case 4:
							System.out.println();
							scanner.nextLine();  
							System.out.print("Enter product name to update: ");
							String updatePdtName = scanner.nextLine();
							boolean pdtUpdated = false;
							for (int i = 0; i < pdtCount; i++) {
								if (pdts[i].getPdtName().equalsIgnoreCase(updatePdtName)) {
									System.out.println("Select an option to update:");
									System.out.println("1. Update Product Name");
									System.out.println("2. Update Product Quantity");
									System.out.println("3. Update Product Cost");
									System.out.print("Enter your choice: ");
									int updatePdtChoice = scanner.nextInt();
									scanner.nextLine();  

									switch (updatePdtChoice) {
										case 1:
											System.out.print("Enter new product name: ");
											String newPdtName = scanner.nextLine();
											pdts[i].setPdtName(newPdtName);
											System.out.println("Product name updated successfully!");
											break;
										case 2:
											System.out.print("Enter new product quantity: ");
											int newPdtQty = scanner.nextInt();
											try
											{
												if(newPdtQty<=0)
												{
													throw new ProductQuantityException("Quantity cannot be negative or zero!");
												}
												pdts[i].setPdtQty(newPdtQty);
												System.out.println("Product quantity updated successfully!");
											}
											catch(ProductQuantityException e)
											{
												System.out.println(e);		
											}
											break;
										case 3:
											System.out.print("Enter new product cost: ");
											float newPdtCost = scanner.nextFloat();
											pdts[i].setPdtCost(newPdtCost);
											System.out.println("Product cost updated successfully!");
											break;
										default:
											System.out.println("Invalid update option!");
									}

									pdtUpdated = true;
									break;
								}
							}
							if (!pdtUpdated) {
								System.out.println("Product not found. Update failed!");
							}
							break;
							
						case 5:
							scanner.nextLine();  
							System.out.print("Enter product name to remove: ");
							String removePdtName = scanner.nextLine();
							boolean pdtRemoved = false;
							for (int i = 0; i < pdtCount; i++) {
								if (pdts[i].getPdtName().equalsIgnoreCase(removePdtName)) {
									
									for (int j = i; j < pdtCount - 1; j++) {
										pdts[j] = pdts[j + 1];
									}
									pdts[pdtCount - 1] = null;
									pdtCount--;
									System.out.println("Product removed successfully!");
									pdtRemoved = true;
									break;
								}
							}
							if (!pdtRemoved) {
								System.out.println("Product not found. Removal failed!");
							}
							break;
							
							case 6:
								System.out.println();
								scanner.nextLine();  
								System.out.print("Enter patient name for purchase: ");
								String searchName = scanner.nextLine();
								boolean found = false;
								for (int i = 0; i < patientCount; i++) {
									if (patients[i].getName().equalsIgnoreCase(searchName)) {
										System.out.println();
										scanner.nextLine();  
										System.out.println("Enter product name to purchase:");
										searchPdtName = scanner.nextLine();
										
										pdtFound = false;
										for (i = 0; i < pdtCount; i++) {
											if (pdts[i].getPdtName().equalsIgnoreCase(searchPdtName)) {
												System.out.println();
												System.out.println("Enter quantity of purchase:");
												int purchaseQty = scanner.nextInt();
												
												double bill = purchaseQty * pdts[i].pdtCost;
												pdtFound = true;
												
												patients[i].displayInfo();
												System.out.println("Bill: " + bill);
												found = true;
											}
										}
											if (!pdtFound) {
												System.out.println("Product not found!");
											}
									}
								}
								if (!found) {
									System.out.println("Patient not found!");
								}
												
								break;
								
					}
					
                case 5:
                    System.out.println("Exiting the Medical Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}