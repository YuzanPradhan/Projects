 

/**
 * Regular
 *
 * Yuzan Pradhan
 * 
 **/
public class Regular extends Student {
    //declaration of variables
    private int numOfModules;
    private int numOfCreditHours;
    private double daysPresent;
    private boolean isGrantedScholarship;

    //constructor caller
    public Regular(int enrollmentID, String dateOfBirth, String courseName, String studentName, String dateOfEnrollment, int courseDuration, double tuitionFee, int numOfModules, int numOfCreditHours, double daysPresent) {
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
        setEnrollmentID(enrollmentID);
        setCourseName(courseName);
        setDateOfEnrollment(dateOfEnrollment);
        this.numOfModules = numOfModules;
        this.numOfCreditHours = numOfCreditHours;
        this.daysPresent = daysPresent;
        this.isGrantedScholarship = false;
    }
    // getter setter methods 
    public int getNumOfModules() {
        return numOfModules;
    }

    public int getNumOfCreditHours() {
        return numOfCreditHours;
    }

    public double getDaysPresent() {
        return daysPresent;
    }

    public boolean isGrantedScholarship() {
        return isGrantedScholarship;
    }

    //calculates the present percentage and displays attendance grade
    public String presentPercentage(double daysPresent) {
        double presentPercentage = daysPresent / ((super.getCourseDuration()) * 30) * 100;
        String attendanceGrade;
        if (presentPercentage >= 80) {
            attendanceGrade = "A";
            isGrantedScholarship = true;
        } else if (presentPercentage >= 60) {
            attendanceGrade = "B";
        } else if (presentPercentage >= 40) {
            attendanceGrade = "C";
        } else if (presentPercentage >= 20) {
            attendanceGrade = "D";
        } else {
            attendanceGrade = "E";
        }
        return attendanceGrade;
    }

    //adding extra for GUI
    public double calculatePresentPercentage(double daysPresent) {
        double presentPercentage = (daysPresent / (super.getCourseDuration() * 30)) * 100;
        return presentPercentage;
    }

    //grants certificate
    public String grantCertificate(String courseName, int enrollmentID, String dateOfEnrollment) {
        String certificate =("Student " + super.getStudentName() + " has graduated in " + courseName + " with enrollment ID " + enrollmentID + " and date of enrollment " + dateOfEnrollment + ".");

        return certificate;

    }

    //displays all the values
    public void display() {
        super.display();
        System.out.println("Number of Modules: " + numOfModules);
        System.out.println("Number of Credit Hours: " + numOfCreditHours);
        System.out.println("Days Present: " + daysPresent);
    }
}
