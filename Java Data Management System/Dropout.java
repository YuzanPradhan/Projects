 
/**
 * Regular
 *
 * Yuzan Pradhan
 * 
 **/
public class Dropout extends Student
{
    //declares the varaibles
    private int numOfRemainingModules;
    private int  numOfMonthsAttended;
    private String dateOfDropout;
    private double remainingAmount;
    private boolean hasPaid;

    //constructer caller
    public Dropout(String studentName,String dateOfBirth, int courseDuration, double tuitionFee,int numOfMonthsAttended ,int numOfRemainingModules, String dateOfDropout, int enrollmentID,String courseName, String dateOfEnrollment) {
        super(dateOfBirth, studentName , courseDuration , tuitionFee);
        setCourseName(courseName);
        setDateOfEnrollment(dateOfEnrollment);
        setEnrollmentID(enrollmentID);
        this.numOfMonthsAttended=numOfMonthsAttended;
        this.numOfRemainingModules=numOfRemainingModules;
        this.dateOfDropout=dateOfDropout;
        this.remainingAmount=0;
        this.hasPaid=false;
    }

    //getter setter start
    public int getnumOfRemainingModules(){
        return numOfRemainingModules;
    }

    public int getnumOfMonthsAttended(){
        return numOfMonthsAttended;
    }

    public double remainingAmount(){
        return remainingAmount;
    }

    public boolean hasPaid(){
        return hasPaid;
    }

    public String dateOfDropout(){
        return dateOfDropout;
    }

    //billsPayable
    public double billsPayable() {
        int numOfMonthsAttended = this.getnumOfMonthsAttended();
        double tuitionFee = this.getTuitionFee();
        double remainingAmount = tuitionFee * (this.getCourseDuration() - numOfMonthsAttended) / this.getCourseDuration();

        return remainingAmount;
    }

    //payment cleared or not        
    public void removeStudent(){
        if(hasPaid){
            setCourseName("");
            setDateOfEnrollment("");
            setDateOfBirth("");
            setEnrollmentID(0);
            setCourseDuration(0);
            this.dateOfDropout="0";
            setTuitionFee(0);
            setStudentName("");
            numOfMonthsAttended=0;
            numOfRemainingModules= 0;
            remainingAmount=0;
            this.hasPaid= false;
        }else{
            System.out.println("bills are not cleared");
        }
    }

    //display method
    public void display(){
        super.display();
        System.out.println("Number of months attended: "+ numOfMonthsAttended);
        System.out.println("Number of remaining modules: "+ numOfRemainingModules);
        System.out.println("Date of dropout: "+ dateOfDropout);
        System.out.println("Remaning Amount: "+ remainingAmount);
    }
}
