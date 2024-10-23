import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private float axis;
    private Date examinationDate;
    private String optometrist;
    private String[] remarkTypes = { "Client", "Optometrist" };
    private ArrayList<String> postRemarks = new ArrayList<>();

    // Constructor
    public Prescription(int prescID, String firstName, String lastName, String address, float sphere, float cylinder, float axis, Date examinationDate, String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

    // Method to add prescription information to a text file
    public boolean addPrescription() {
        // Condition 1: Length of first and last name
        if (firstName.length() < 4 || firstName.length() > 15 || lastName.length() < 4 || lastName.length() > 15) {
            return false;
        }
        
        // Condition 2: length of address
        if (address.length() < 20) {
            return false;
        }
        
        // Condition 3: Range of sphere
        if (sphere < -20.00 || sphere > 20.00) {
            return false;
        }
        
        // Condition 3: Range of cylinder
        if (cylinder < -4.00 || cylinder > 4.00) {
            return false;
        }

        // Condition 3: Range of axis
        if (axis < 0 || axis > 180) {
            return false;
        }

        // Condition 5: length of optometrist name
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            return false;
        }

        // Writing prescription to a file if all conditions are met
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("presc.txt", true))) {
            writer.write("Prescription ID: " + prescID + "\n");
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Sphere: " + sphere + "\n");
            writer.write("Cylinder: " + cylinder + "\n");
            writer.write("Axis: " + axis + "\n");
            writer.write("Examination Date: " + examinationDate + "\n");
            writer.write("Optometrist: " + optometrist + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // Method to add a remark to a text file
    public boolean addRemark(String remark, String category) {
        // Condition 1: number of words in remark should be 6 to 20
        String[] words = remark.split("\\s+");
        if (words.length < 6 || words.length > 20) {
            return false;
        }

        // The first word of the remark must start with an uppercase letter
        if (!Character.isUpperCase(remark.charAt(0))) {
            return false;
        }

        // Condition 2: Category has to be either "Client" or "Optometrist"
        if (!category.equalsIgnoreCase("Client") && !category.equalsIgnoreCase("Optometrist")) {
            return false;
        }

        // Condition 3: more than 2 remarks are not permitted
        if (postRemarks.size() >= 2) {
            return false;
        }

        // here we are adding a remark and writing it to a file
        postRemarks.add(remark);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("remark.txt", true))) {
            writer.write("Remark: " + remark + "\n");
            writer.write("Category: " + category + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
