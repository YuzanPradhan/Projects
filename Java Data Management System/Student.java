 
/**
 * Student
 *
 * Yuzan Pradhan
 * 
 **/
public class Student {
    //declaration
    private int enrollmentID    ;
    private String dateOfBirth ;
    private String courseName;
    private String studentName    ;
    private String dateOfEnrollment    ;
    private int courseDuration;
    private double tuitionFee;
    private int monthsAttended;
    //constructor
    public Student(String dateOfBirth, String studentName, int courseDuration, double tuitionFee) {
        this.dateOfBirth = dateOfBirth;
        this.studentName = studentName;
        this.courseDuration = courseDuration;
        this.tuitionFee = tuitionFee;
        this.courseName = "";
        this.dateOfEnrollment = "";
        this.enrollmentID = 0;
    }

    //getter // setter method
    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(String dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public int getYearsEnrolled() {
        return courseDuration/12;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    
    
    
    

    public int getMonthsAttended() {
        return monthsAttended;  
    }

    public void setMonthsAttended(int monthsAttended) {
        this.monthsAttended = monthsAttended;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth=dateOfBirth;
    }

    public void setCourseDuration(int courseDuration)
    {
        this.courseDuration=courseDuration;
    }

    public void setTuitionFee(double tuitionFee)
    {
        this.tuitionFee=tuitionFee;
    }    

    public void setStudentName(String studentName)
    {
        this.studentName=studentName;
    }    
    // display the result 
    public void display() {
        if (enrollmentID == 0 || dateOfBirth.isEmpty() || courseName.isEmpty() || studentName.isEmpty() || dateOfEnrollment.isEmpty()) {
            System.out.println("All parameters have been entered.");
        } else {
            System.out.println("Enrollment ID: " + enrollmentID);
            System.out.println("Date of Birth: " + dateOfBirth);
            System.out.println("Course Name: " + courseName);
            System.out.println("Student Name: " + studentName);
            System.out.println("Years Enrolled: " + getYearsEnrolled());
            System.out.println("Course Duration: " + courseDuration);
            System.out.println("Tuition Fee: " + tuitionFee);
        }
    }
}
