import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PrescriptionTest {

    private Prescription prescription;

    // Setup method to initialize before each test
    @BeforeEach
    public void setUp() {
        // Create a valid Prescription object
        prescription = new Prescription(1, "John", "Smith", "123 Main St, Suburb, 12345, Country", 
                -2.0f, 1.5f, 90, new Date(), "Dr. Optometry");
    }

    // Test cases for addPrescription method with 2 set of test data

    // Test case 1: Valid prescription
    @Test
    public void testAddPrescriptionValid() {
        // First set of valid data
        assertTrue(prescription.addPrescription(), "Prescription should be added with valid data");
        
        // Second set of valid data
        prescription = new Prescription(2, "Jane", "Smith", "456 Another St, Suburb, 67890, Country", 
                1.0f, -1.5f, 120, new Date(), "Dr. Optometrist");
        assertTrue(prescription.addPrescription(), "Prescription should be added with valid data");
    }

    // Test case 2: Invalid first name (too short)
    @Test
    public void testAddPrescriptionInvalidFirstName() {
        // First set of invalid data
        prescription = new Prescription(2, "Jo", "Doe", "123 Main St, Suburb, 12345, Country", 
                -2.0f, 1.5f, 90, new Date(), "Dr. Optometry");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid first name");
        
        // Second set of invalid data
        prescription = new Prescription(3, "A", "Doe", "123 Main St, Suburb, 12345, Country", 
                1.0f, -1.5f, 120, new Date(), "Dr. Optometry");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid first name");
    }

    // Test case 3: Invalid last name (too short)
    @Test
    public void testAddPrescriptionInvalidLastName() {
        // First set of invalid data
        prescription = new Prescription(3, "John", "Do", "123 Main St, Suburb, 12345, Country", 
                -2.0f, 1.5f, 90, new Date(), "Dr. Optometry");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid last name");
        
        // Second set of invalid data
        prescription = new Prescription(4, "Jane", "A", "456 Another St, Suburb, 67890, Country", 
                1.0f, -1.5f, 120, new Date(), "Dr. Optometry");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid last name");
    }

    // Test case 4: Invalid address (too short)
    @Test
    public void testAddPrescriptionInvalidAddress() {
        // First set of invalid data
        prescription = new Prescription(4, "John", "Doe", "Short Address", 
                -2.0f, 1.5f, 90, new Date(), "Dr. Optometry");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid address");
        
        // Second set of invalid data
        prescription = new Prescription(5, "Jane", "Smith", "12345 St", 
                1.0f, -1.5f, 120, new Date(), "Dr. Optometry");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid address");
    }

    // Test case 5: Invalid sphere value (out of range)
    @Test
    public void testAddPrescriptionInvalidSphere() {
        // First set of invalid data
        prescription = new Prescription(5, "John", "Doe", "123 Main St, Suburb, 12345, Country", 
                -25.0f, 1.5f, 90, new Date(), "Dr. Optometry");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid sphere value");
        
        // Second set of invalid data
        prescription = new Prescription(6, "Jane", "Smith", "456 Another St, Suburb, 67890, Country", 
                25.0f, -1.5f, 120, new Date(), "Dr. Optometry");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid sphere value");
    }

    // Test case 6: Invalid optometrist name (too short)
    @Test
    public void testAddPrescriptionInvalidOptometrist() {
        // First set of invalid data
        prescription = new Prescription(6, "John", "Doe", "123 Main St, Suburb, 12345, Country", 
                -2.0f, 1.5f, 90, new Date(), "Dr. Optom");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid optometrist name");
        
        // Second set of invalid data
        prescription = new Prescription(7, "Jane", "Smith", "456 Another St, Suburb, 67890, Country", 
                1.0f, -1.5f, 120, new Date(), "Opto");
        assertFalse(prescription.addPrescription(), "Prescription should not be added with an invalid optometrist name");
    }

    // Test cases for addRemark method with 2 sets of test data

    // Test case 1: Valid remark
    @Test
    public void testAddRemarkValid() {
        // First set of valid data
        assertTrue(prescription.addRemark("This is a valid remark boss", "Client"), 
                   "Remark should be added with valid data");
        
        // Second set of valid data
        assertTrue(prescription.addRemark("Another valid remark from client boss", "Optometrist"), 
                   "Remark should be added with valid data");
    }

    // Test case 2: Remark too short (less than 6 words)
    @Test
    public void testAddRemarkInvalidLength() {
        // First set of invalid data
        assertFalse(prescription.addRemark("Too short.", "Client"), 
                    "Remark should not be added if the remark is too short");
        
        // Second set of invalid data
        assertFalse(prescription.addRemark("Too few.", "Optometrist"), 
                    "Remark should not be added if the remark is too short");
    }

    // Test case 3: Remark too long (more than 20 words)
    @Test
    public void testAddRemarkInvalidTooLong() {
        // First set of invalid data
        assertFalse(prescription.addRemark(
                "This remark contains far too many words, well beyond the twenty word limit allowed for a valid remark ss ss ss.", 
                "Client"), 
                "Client");
        
        // Second set of invalid data
        assertFalse(prescription.addRemark(
                "Again, this remark is excessively verbose and contains more than the twenty words that are permitted dd dd dd dd dd ", 
                "Optometrist"), 
                "Remark should not be added if it exceeds 20 words");
    }

    // Test case 4: Remark does not start with an uppercase letter
    @Test
    public void testAddRemarkInvalidFirstLetter() {
        // First set of invalid data
        assertFalse(prescription.addRemark("this should start with uppercase.", "Optometrist"),
                    "Remark should not be added if it doesn't start with an uppercase letter");
        
        // Second set of invalid data
        assertFalse(prescription.addRemark("invalid start with lowercase.", "Client"),
                    "Remark should not be added if it doesn't start with an uppercase letter");
    }

    // Test case 5: Invalid category (not "Client" or "Optometrist")
    @Test
    public void testAddRemarkInvalidCategory() {
        // First set of invalid data
        assertFalse(prescription.addRemark("This is a valid remark.", "InvalidCategory"),
                    "Remark should not be added if the category is invalid");
        
        // Second set of invalid data
        assertFalse(prescription.addRemark("Another valid remark.", "AnotherInvalidCategory"),
                    "Remark should not be added if the category is invalid");
    }

    // Test case 6: Adding a third remark (should fail since max is 2)
    @Test
    public void testAddRemarkExceedMaxRemarks() {
        // First set of invalid data (third remark)
        prescription.addRemark("First valid remark.", "Client");
        prescription.addRemark("Second valid remark.", "Optometrist");
        assertFalse(prescription.addRemark("This is the third remark.", "Client"),
                    "Should not allow more than 2 remarks");
        
        // Second set of invalid data (third remark)
        prescription.addRemark("First valid remark.", "Client");
        prescription.addRemark("Second valid remark.", "Optometrist");
        assertFalse(prescription.addRemark("This is another third remark.", "Optometrist"),
                    "Should not allow more than 2 remarks");
    }
}
