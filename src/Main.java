import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // here we are creating a prescription object with valid data
        Prescription prescription = new Prescription(1, "John", "Doel", "123 Main St, Suburb, 12345, Country", 
                -2.0f, 1.5f, 90, new Date(), "Dr. Optometry");

        // Testing the addPrescription method
        boolean isPrescriptionAdded = prescription.addPrescription();
        if (isPrescriptionAdded) {
            System.out.println("Prescription added successfully.");
        } else {
            System.out.println("Failed to add prescription. Check the conditions.");
        }

        // Testing the addRemark method making use of a valid remark
        boolean isRemarkAdded = prescription.addRemark("This is a valid remark boss", "Client");
        if (isRemarkAdded) {
            System.out.println("Remark added successfully.");
        } else {
            System.out.println("Failed to add remark. Check the conditions.");
        }

        // testing now with invalid remark
        boolean isRemarkAddedInvalid = prescription.addRemark("Too short.", "Client");
        if (isRemarkAddedInvalid) {
            System.out.println("Remark added successfully.");
        } else {
            System.out.println("Failed to add remark. Remark does not meet the conditions.");
        }
    }
}
