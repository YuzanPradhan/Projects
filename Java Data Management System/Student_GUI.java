 

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Student_GUI implements ActionListener {
    private JFrame frame_MAIN;
    private JLabel Lislington, LWelcome, Lslogan, Lmainbgimage;
    private ImageIcon mainlogo, IMmainbgimage, Iislington;
    private JPanel panel_MAIN;
    private JButton btnRegular, btnDropout;

    //Regular
    private JFrame frame_REGULAR;
    private JPanel panel_REGULAR;
    private JLabel regularRegister, regularEnrollmentID, regularStudentName, regularCourseDuration, regularDaysPresent, regularTuitionFee, regularDateOfEnrollment, regularDateOfBirth, regularCourseName, regularNoOfModules, regularNoOfCreditHours;
    private JTextField regularTxtEnrollmentID, regularTxtStudentName, regularTxtCourseDuration, regularTxtDaysPresent, regularTxtTuitionFee, regularTxtNoOfModules, regularTxtNoOfCreditHours;
    private JButton regularAttendanceGrade, regularScholarship, regularClear, regularBack, regularDisplay, regularSubmit;
    private JComboBox<String> regularCCourseName;
    private JComboBox<String> regularErYear, regulartErDay, regulartErMonth, regularDOBYear, regulartDOBDay, regulartDOBMonth;

    //Dropout
    private JFrame frame_DROPOUT;
    private JPanel panel_DROPOUT;
    private JLabel dropoutRegister, dropoutEnrollmentID, dropoutStudentName, dropoutCourseDuration, dropoutYr, dropoutTuitionFee, dropoutDateOfEnrollment, dropoutDateOfBirth, dropoutCourseName, DropoutRemainingAmount, DropoutMonthsAttended, DropoutDateOfDropout;
    private JTextField txtdropoutEnrollmentID, txtdropoutStudentName, txtdropoutCourseDuration, txtdropoutTuitionFee , txtDropoutRemainingAmount, txtDropoutMonthsAttended;
    private JButton dropoutHasPaid, dropoutClear, dropoutRemove, dropoutBack, dropoutDisplay, dropoutSubmit;
    private JComboBox<String> dropoutCCourseName;
    private JComboBox<String> dropoutErYear, dropoutErDay, dropoutErMonth, dropoutDOBYear, dropoutDOBDay, dropoutDOBMonth, dropoutDODYear, dropoutDODDay, dropoutDODMonth;

    //array list
    private ArrayList <Student> students = new ArrayList<Student>();
    private JTable table;

    //display
    private JPanel panelregularDisplay;

    public Student_GUI() 
    {
        frame_MAIN = new JFrame();
        frame_MAIN.setTitle("Student GUI");
        frame_MAIN.setSize(700, 800);
        panel_MAIN = new JPanel();
        panel_MAIN.setLayout(null);
        frame_MAIN.add(panel_MAIN);

        // window logo
        mainlogo = new ImageIcon("Logo.png");
        frame_MAIN.setIconImage(mainlogo.getImage());

        // Main Page logo
        Iislington = new ImageIcon("islington.png");
        Lislington = new JLabel("", Iislington, JLabel.CENTER);
        Lislington.setBounds(210, 100, 250, 250);
        panel_MAIN.add(Lislington);

        // Welcome
        LWelcome = new JLabel("Welcome");
        LWelcome.setFont(new Font("Helvetica", Font.PLAIN, 40));
        LWelcome.setBounds(251, 351, 200, 55);
        LWelcome.setForeground(Color.white);
        panel_MAIN.add(LWelcome);

        // slogan main page
        Lslogan = new JLabel("To the land of opportunities");
        Lslogan.setFont(new Font("Helvetica", Font.PLAIN, 20));
        Lslogan.setBounds(215, 412, 302, 34);
        Lslogan.setForeground(Color.white);
        panel_MAIN.add(Lslogan);

        // regular button
        btnRegular = new JButton("Add a Regular Student");
        btnRegular.setBounds(100, 600, 200, 30);
        btnRegular.setBackground(new Color(183, 177, 174));
        btnRegular.addActionListener(this);
        panel_MAIN.add(btnRegular);

        // dropout button
        btnDropout = new JButton("Add a Dropout Student");
        btnDropout.setBounds(400, 600, 200, 30);
        btnDropout.setBackground(new Color(183, 177, 174));
        btnDropout.addActionListener(this);
        panel_MAIN.add(btnDropout);

        // Main page image
        IMmainbgimage = new ImageIcon("mainimage.png");
        Lmainbgimage = new JLabel("", IMmainbgimage, JLabel.CENTER);
        Lmainbgimage.setBounds(0, 0, 700, 800);
        panel_MAIN.add(Lmainbgimage);

        frame_MAIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_MAIN.setResizable(false);
        frame_MAIN.setVisible(true);
        frame_MAIN.setLocationRelativeTo(null);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegular) {

            frame_REGULAR = new JFrame();
            frame_REGULAR.setTitle("Student Registration Form");
            frame_REGULAR.setSize(730, 800);
            frame_REGULAR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // window logo
            mainlogo = new ImageIcon("Logo.png");
            frame_REGULAR.setIconImage(mainlogo.getImage());

            panel_REGULAR = new JPanel();
            panel_REGULAR.setLayout(null);
            frame_REGULAR.add(panel_REGULAR);

            // Student registration form
            regularRegister = new JLabel("Regular Student Form");
            regularRegister.setFont(new Font("Helvetica", Font.BOLD, 24));
            regularRegister.setBounds(222, 66, 256, 34);
            panel_REGULAR.add(regularRegister);

            // EnrollmentID
            regularEnrollmentID = new JLabel("Enrolment ID");
            regularEnrollmentID.setBounds(50, 170, 85, 20);
            panel_REGULAR.add(regularEnrollmentID);

            regularTxtEnrollmentID = new JTextField();
            regularTxtEnrollmentID.setBounds(167, 170, 150, 20);
            panel_REGULAR.add(regularTxtEnrollmentID);

            // StudentName
            regularStudentName = new JLabel("Student Name");
            regularStudentName.setBounds(50, 245, 90, 20);
            panel_REGULAR.add(regularStudentName);

            regularTxtStudentName = new JTextField();
            regularTxtStudentName.setBounds(167, 245, 150, 20);
            panel_REGULAR.add(regularTxtStudentName);

            // CourseDuration
            regularCourseDuration = new JLabel("Course Duration");
            regularCourseDuration.setBounds(50, 320, 102, 20);
            panel_REGULAR.add(regularCourseDuration);

            regularTxtCourseDuration = new JTextField();
            regularTxtCourseDuration.setBounds(167, 320, 41, 20);
            panel_REGULAR.add(regularTxtCourseDuration);

            JLabel yr = new JLabel("Months");
            yr.setBounds(216, 320,45 , 20);
            panel_REGULAR.add(yr);

            // DaysPresent
            regularDaysPresent = new JLabel("Days Present");
            regularDaysPresent.setBounds(50, 395, 84, 20);
            panel_REGULAR.add(regularDaysPresent);

            regularTxtDaysPresent = new JTextField();
            regularTxtDaysPresent.setBounds(167, 395, 150, 20);
            panel_REGULAR.add(regularTxtDaysPresent);

            
            // TutionFee
            regularTuitionFee = new JLabel("Tuition Fee");
            regularTuitionFee.setBounds(50, 470, 70, 20);
            panel_REGULAR.add(regularTuitionFee);

            regularTxtTuitionFee = new JTextField();
            regularTxtTuitionFee.setBounds(167, 470, 150, 20);
            panel_REGULAR.add(regularTxtTuitionFee);

            // DateOfEnrollment
            regularDateOfEnrollment = new JLabel("Date Of Enrolment");
            regularDateOfEnrollment.setBounds(370, 170, 119, 20);
            panel_REGULAR.add(regularDateOfEnrollment);

            String[] ERdays = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
            regulartErDay = new JComboBox<>(ERdays);
            regulartErDay.setBounds(495, 170, 40, 32);
            panel_REGULAR.add(regulartErDay);

            String[] ERmonths = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
            regulartErMonth = new JComboBox<>(ERmonths);
            regulartErMonth.setBounds(535, 170, 73, 32);
            panel_REGULAR.add(regulartErMonth);

            String[] ERyears = { "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" };
            regularErYear = new JComboBox<>(ERyears);
            regularErYear.setBounds(608, 170, 55, 32);
            panel_REGULAR.add(regularErYear);

            // DateOfBirth
            regularDateOfBirth = new JLabel("Date Of Birth");
            regularDateOfBirth.setBounds(370, 245, 81, 20);
            panel_REGULAR.add(regularDateOfBirth);

            String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
            regulartDOBDay = new JComboBox<>(days);
            regulartDOBDay.setBounds(495, 245, 40, 32);
            panel_REGULAR.add(regulartDOBDay);

            String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
            regulartDOBMonth = new JComboBox<>(months);
            regulartDOBMonth.setBounds(535, 245, 73, 32);
            panel_REGULAR.add(regulartDOBMonth);

            String[] years = { "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" };
            regularDOBYear = new JComboBox<>(years);
            regularDOBYear.setBounds(608, 245, 55, 32);
            panel_REGULAR.add(regularDOBYear);

            // CourseName
            regularCourseName = new JLabel("Course Name");
            regularCourseName.setBounds(370, 320, 86, 20);
            panel_REGULAR.add(regularCourseName);

            String[] year = { "Computing", "Networking", "AI", "Cyber Security", "Business" };
            regularCCourseName = new JComboBox<>(year);
            regularCCourseName.setBounds(500, 320, 150, 20);
            panel_REGULAR.add(regularCCourseName);

            // NoOfModules
            regularNoOfModules = new JLabel("No Of Modules");
            regularNoOfModules.setBounds(370, 395, 120, 20);
            panel_REGULAR.add(regularNoOfModules);

            regularTxtNoOfModules = new JTextField();
            regularTxtNoOfModules.setBounds(500, 395, 150, 20);
            panel_REGULAR.add(regularTxtNoOfModules);

            // NoOfCreditHours
            regularNoOfCreditHours = new JLabel("No Of Credit Hours");
            regularNoOfCreditHours.setBounds(370, 470, 118, 20);
            panel_REGULAR.add(regularNoOfCreditHours);

            regularTxtNoOfCreditHours = new JTextField();
            regularTxtNoOfCreditHours.setBounds(500, 470, 150, 20);
            panel_REGULAR.add(regularTxtNoOfCreditHours);

            // AttendanceGrade
            regularAttendanceGrade = new JButton("Present Percentage");
            regularAttendanceGrade.setBounds(85, 588, 154, 32);
            panel_REGULAR.add(regularAttendanceGrade);

            regularAttendanceGrade.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addPresentPercentage();
                    }
                });

            //submit button
            regularSubmit= new JButton("Submit");
            regularSubmit.setBounds(278, 588, 145, 32);
            panel_REGULAR.add(regularSubmit);

            regularSubmit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addRegularStudent();
                    }
                });

            // Scholarship
            regularScholarship = new JButton("Grant Certificate");
            regularScholarship.setBounds(471, 588, 145, 32);
            panel_REGULAR.add(regularScholarship);

            regularScholarship.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addGrantCertificate();
                    }
                });

            // back
            regularBack = new JButton("Go Back");
            regularBack.setBounds(85, 680, 145, 32);
            panel_REGULAR.add(regularBack);
            regularBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame_REGULAR.dispose();
                        new Student_GUI();
                    }
                });

            // clear
            regularClear = new JButton();
            regularClear.setBounds(278, 680, 145, 32);
            regularClear.setText("Clear");
            panel_REGULAR.add(regularClear);
            regularClear.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearallfields();
                    }
                });

            //Display button
            regularDisplay= new JButton("Display");
            regularDisplay.setBounds(471, 680, 145, 32);
            panel_REGULAR.add(regularDisplay);

            regularDisplay.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addDisplay();
                    }
                });

            frame_REGULAR.setLocationRelativeTo(null);
            frame_REGULAR.setResizable(false);
            frame_REGULAR.setVisible(true);
            panel_REGULAR.setBackground(new Color(255, 255, 255));
            frame_MAIN.dispose();
        }
        else if (e.getSource() == btnDropout) 
        {
            frame_DROPOUT = new JFrame("Dropout Student Form");
            panel_DROPOUT = new JPanel();
            panel_DROPOUT.setLayout(null);
            frame_DROPOUT.add(panel_DROPOUT);

            // window logo
            mainlogo = new ImageIcon("Logo.png");
            frame_DROPOUT.setIconImage(mainlogo.getImage());

            // Student registration form
            dropoutRegister = new JLabel("Dropout Student Form");
            dropoutRegister.setFont(new Font("Helvetica", Font.BOLD, 24));
            dropoutRegister.setBounds(222, 66, 265, 34);
            panel_DROPOUT.add(dropoutRegister);

            // EnrollmentID
            dropoutEnrollmentID = new JLabel("Enrolment ID");
            dropoutEnrollmentID.setBounds(50, 170, 85, 20);
            panel_DROPOUT.add(dropoutEnrollmentID);

            txtdropoutEnrollmentID = new JTextField();
            txtdropoutEnrollmentID.setBounds(167, 170, 150, 20);
            panel_DROPOUT.add(txtdropoutEnrollmentID);

            // StudentName
            dropoutStudentName = new JLabel("Student Name");
            dropoutStudentName.setBounds(50, 245, 90, 20);
            panel_DROPOUT.add(dropoutStudentName);

            txtdropoutStudentName = new JTextField();
            txtdropoutStudentName.setBounds(167, 245, 150, 20);
            panel_DROPOUT.add(txtdropoutStudentName);

            // CourseDuration
            dropoutCourseDuration = new JLabel("Course Duration");
            dropoutCourseDuration.setBounds(50, 320, 102, 20);
            panel_DROPOUT.add(dropoutCourseDuration);

            txtdropoutCourseDuration = new JTextField();
            txtdropoutCourseDuration.setBounds(167, 320, 41, 20);
            panel_DROPOUT.add(txtdropoutCourseDuration);

            dropoutYr = new JLabel("Months");
            dropoutYr.setBounds(216, 320, 45, 20);
            panel_DROPOUT.add(dropoutYr);

            // TutionFee
            dropoutTuitionFee = new JLabel("Tuition Fee");
            dropoutTuitionFee.setBounds(50, 395, 70, 20);
            panel_DROPOUT.add(dropoutTuitionFee);

            txtdropoutTuitionFee = new JTextField();
            txtdropoutTuitionFee.setBounds(167, 395, 150, 20);
            panel_DROPOUT.add(txtdropoutTuitionFee);

            // MonthsAttended
            DropoutMonthsAttended = new JLabel("Months Attended");
            DropoutMonthsAttended.setBounds(50, 470, 104, 20);
            panel_DROPOUT.add(DropoutMonthsAttended);

            txtDropoutMonthsAttended = new JTextField();
            txtDropoutMonthsAttended.setBounds(167, 470, 150, 20);
            panel_DROPOUT.add(txtDropoutMonthsAttended);

            // DateOfEnrollment
            dropoutDateOfEnrollment = new JLabel("Date Of Enrolment");
            dropoutDateOfEnrollment.setBounds(370, 170, 119, 20);
            panel_DROPOUT.add(dropoutDateOfEnrollment);

            String[] ERdays = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
            dropoutErDay = new JComboBox<>(ERdays);
            dropoutErDay.setBounds(495, 170, 40, 32);
            panel_DROPOUT.add(dropoutErDay);

            String[] ERmonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            dropoutErMonth = new JComboBox<>(ERmonths);
            dropoutErMonth.setBounds(535, 170, 73, 32);
            panel_DROPOUT.add(dropoutErMonth);

            String[] ERyears = {"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};
            dropoutErYear = new JComboBox<>(ERyears);
            dropoutErYear.setBounds(608, 170, 55, 32);
            panel_DROPOUT.add(dropoutErYear);

            // DateOfBirth
            dropoutDateOfBirth = new JLabel("Date Of Birth");
            dropoutDateOfBirth.setBounds(370, 245, 81, 20);
            panel_DROPOUT.add(dropoutDateOfBirth);

            String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
            dropoutDOBDay = new JComboBox<>(day);
            dropoutDOBDay.setBounds(495, 245, 40, 32);
            panel_DROPOUT.add(dropoutDOBDay);

            String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            dropoutDOBMonth = new JComboBox<>(month);
            dropoutDOBMonth.setBounds(535, 245, 73, 32);
            panel_DROPOUT.add(dropoutDOBMonth);

            String[] year = {"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};
            dropoutDOBYear = new JComboBox<>(year);
            dropoutDOBYear.setBounds(608, 245, 55, 32);
            panel_DROPOUT.add(dropoutDOBYear);

            // CourseName
            dropoutCourseName = new JLabel("Course Name");
            dropoutCourseName.setBounds(370, 320, 86, 20);
            panel_DROPOUT.add(dropoutCourseName);

            String[] COURSE = {"Computing", "Networking", "AI", "Cyber Security", "Business"};
            dropoutCCourseName = new JComboBox<>(COURSE);
            dropoutCCourseName.setBounds(490, 320, 163, 20);
            panel_DROPOUT.add(dropoutCCourseName);

            // RemainingModules
            DropoutRemainingAmount = new JLabel("Remaining modules");
            DropoutRemainingAmount.setBounds(370, 395, 118, 20);
            panel_DROPOUT.add(DropoutRemainingAmount);

            txtDropoutRemainingAmount = new JTextField();
            txtDropoutRemainingAmount.setBounds(490, 395, 163, 20);
            panel_DROPOUT.add(txtDropoutRemainingAmount);

            // DateOfDropout
            DropoutDateOfDropout = new JLabel("Date Of Dropout");
            DropoutDateOfDropout.setBounds(367, 470, 102, 20);
            panel_DROPOUT.add(DropoutDateOfDropout);

            String[] DODdays = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
            dropoutDODDay = new JComboBox<>(DODdays);
            dropoutDODDay.setBounds(495, 470, 40, 32);
            panel_DROPOUT.add(dropoutDODDay);

            String[] DODmonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            dropoutDODMonth = new JComboBox<>(DODmonths);
            dropoutDODMonth.setBounds(535, 470, 73, 32);
            panel_DROPOUT.add(dropoutDODMonth);

            String[] DODyears = {"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};
            dropoutDODYear = new JComboBox<>(DODyears);
            dropoutDODYear.setBounds(608, 470, 55, 32);
            panel_DROPOUT.add(dropoutDODYear);

            // HasPaid
            dropoutHasPaid = new JButton("Has Paid");
            dropoutHasPaid.setBounds(85, 588, 154, 32);
            panel_DROPOUT.add(dropoutHasPaid);

            // Inside the ActionListener for dropoutHasPaid button
            dropoutHasPaid.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addHasPaid();
                    }
                });

            //submit button
            dropoutSubmit= new JButton("Submit");
            dropoutSubmit.setBounds(278, 588, 154, 32);
            panel_DROPOUT.add(dropoutSubmit);

            dropoutSubmit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addDropoutStudent();
                    }
                });

            // Remove
            dropoutRemove = new JButton();
            dropoutRemove.setBounds(471, 588, 145, 32);
            dropoutRemove.setText("Remove Student");
            panel_DROPOUT.add(dropoutRemove);

            dropoutRemove.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addRemove();
                    }
                });

            // Back
            dropoutBack = new JButton("Go Back");
            dropoutBack.setBounds(85, 680, 145, 32);
            panel_DROPOUT.add(dropoutBack);
            dropoutBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame_DROPOUT.dispose();
                        new Student_GUI();
                    }
                });

            // Clear
            dropoutClear = new JButton();
            dropoutClear.setBounds(278, 680, 145, 32);
            dropoutClear.setText("Clear");
            panel_DROPOUT.add(dropoutClear);

            //dropoutClear button
            dropoutClear.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearAllDropoutFields();
                    }
                });

            //Display    
            dropoutDisplay = new JButton("Display");
            dropoutDisplay.setBounds(471, 680, 145, 32);
            panel_DROPOUT.add(dropoutDisplay);

            dropoutDisplay.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        adddropoutDisplay();
                    }
                });

            panel_DROPOUT.setBackground(new Color(255, 255, 255));
            frame_DROPOUT.setSize(730, 800);
            frame_DROPOUT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame_DROPOUT.setVisible(true);
            frame_DROPOUT.setLocationRelativeTo(null);

            frame_DROPOUT.setResizable(false);
            frame_MAIN.dispose();
        }

    }

    //Regular page methods

    // Enrollment ID
    public int getEnrollmentID() {
        String EnrollmentID = regularTxtEnrollmentID.getText(); 
        int enrollmentID = -1;
        try {
            enrollmentID = Integer.parseInt(EnrollmentID);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_REGULAR, "Field: Enrollment Id \nOnly numeric values are allowed to be entered!!! ", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
        return enrollmentID;   
    }

    // Student Name
    public String getStudentName() {   
        String studentName = regularTxtStudentName.getText();
        if (!studentName.matches("[a-zA-z]+")) {
            JOptionPane.showMessageDialog(frame_REGULAR, "Field: Student Name \nInvalid inputs. Please enter valid inputs.", "Alert", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return studentName;
    }

    // Course Duration
    public int getCourseDuration() {   
        String courseDuration = regularTxtCourseDuration.getText();
        int CourseDurations = -1;
        try {
            CourseDurations = Integer.parseInt(courseDuration);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_REGULAR,"Field: Course Duration \nOnly numeric values are allowed to be entered!!! ","Invalid Input",JOptionPane.WARNING_MESSAGE);   
        }
        return CourseDurations;
    }

    // Days Present
    public double getDaysPresent() {
        String daysPresent = regularTxtDaysPresent.getText();
        double dayspresent = -1;
        try {
            dayspresent = Double.parseDouble(daysPresent);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_REGULAR, "Field: Days Present \nOnly numeric values are allowed to be entered!!!","Invalid Input",JOptionPane.WARNING_MESSAGE);
        }
        return dayspresent;
    }

    // Tuition Fee
    public int getTuitionFee() {
        String tuitionFee = regularTxtTuitionFee.getText();
        int TuitionFee = -1;
        try {
            TuitionFee = Integer.parseInt(tuitionFee);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_REGULAR,"Field: Tuition Fee \nOnly numeric values are allowed to be entered!!!","Invalid Input",JOptionPane.WARNING_MESSAGE);
        }
        return TuitionFee;
    }

    // Date of Enrollment
    public String getDateOfEnrollment() {
        String dateOfEnrollment = regularErYear.getSelectedItem() + "-" + (regulartErMonth.getSelectedIndex() + 1) + "-" + regulartErDay.getSelectedItem();
        return dateOfEnrollment;
    }

    // Date of Birth
    public String getDateOfBirth() {
        String dateOfBirth = regularDOBYear.getSelectedItem() + "-" + (regulartDOBMonth.getSelectedIndex() + 1) + "-" + regulartDOBDay.getSelectedItem();
        return dateOfBirth;
    }

    // Course Name
    public String getCourseName() {
        String courseName = regularCCourseName.getSelectedItem().toString();
        return courseName;
    }

    // Number of Modules
    public int getNoOfModules() {
        String numOfModules = regularTxtNoOfModules.getText();
        int numOfmodules = -1;
        try {
            numOfmodules = Integer.parseInt(numOfModules);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_REGULAR,"Field: No Of Modules \nOnly numeric values are allowed to be entered!!!","Invalid Input",JOptionPane.WARNING_MESSAGE);
        }
        return numOfmodules;
    }

    // Number of Credit Hours
    public int getNoOfCreditHours() {
        String numOfCreditHours = regularTxtNoOfCreditHours.getText();
        int numofcredithours = -1;
        try {
            numofcredithours = Integer.parseInt(numOfCreditHours);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_REGULAR,"Field: No Of Credit Hours \nOnly numeric values are allowed to be entered!!!","Invalid Input",JOptionPane.WARNING_MESSAGE);
        }
        return numofcredithours;
    }

    // Add Regular Student
    public void addRegularStudent() {
        // get infromations for the fields
        int enrollmentID = this.getEnrollmentID();
        String studentName = this.getStudentName();
        int courseDuration = this.getCourseDuration();
        double daysPresent = this.getDaysPresent();
        double tuitionFee = this.getTuitionFee();
        String dateOfEnrollment = this.getDateOfEnrollment();
        String dateOfBirth = this.getDateOfBirth();
        String courseName = this.getCourseName();
        int numOfModules = this.getNoOfModules();
        int numOfCreditHours = this.getNoOfCreditHours();
        //check if empty or invalid
        if(enrollmentID == -1 || studentName.isEmpty() || courseDuration == -1 || daysPresent == -1 || tuitionFee == -1 || numOfModules == -1 || numOfCreditHours == -1) {
            JOptionPane.showMessageDialog(frame_REGULAR, "All Fields must be filled \nPlease enter a value.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        } else {
            // Check if student already exists in the database
            boolean studentAlreadyExists = false;
            for(Student check : students) {
                if (check instanceof Regular) {
                    if (check.getEnrollmentID() == enrollmentID) {
                        JOptionPane.showMessageDialog(frame_REGULAR, "The student is already registered into the database.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        studentAlreadyExists = true;
                        break;
                    }
                }
            }

            //if dosent exist add to the database
            if (studentAlreadyExists== false) {
                Regular regularObj = new Regular(enrollmentID, dateOfBirth, courseName, studentName, dateOfEnrollment, courseDuration, tuitionFee, numOfModules, numOfCreditHours, daysPresent);
                students.add(regularObj);
                JOptionPane.showMessageDialog(frame_REGULAR, "Thank you for registering..", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // fields are cleared after adding the student to let new addition
        clearallfields();
    }

    // Display Students
    public void addDisplay() {
        // Create a new DefaultTableModel with column headers
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Enrollment ID", "Student Name", "Course Name", "Course Duration",
                "Date of Enrollment", "Date of Birth", "Tuition Fee"});

        // Add data to the model from the studentList
        for (Student student : students) {
            model.addRow(new Object[]{
                    student.getEnrollmentID(),
                    student.getStudentName(),
                    student.getCourseName(),
                    student.getCourseDuration(),
                    student.getDateOfEnrollment(),
                    student.getDateOfBirth(),
                    student.getTuitionFee()
                });
        }

        // Create a JTable with the model
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        // Set the table as uneditable
        table.setEnabled(false);

        // Wrap the JTable in a JScrollPane to enable scrolling
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Create a panel and add the JScrollPane to it
        JPanel panelDisplay = new JPanel(new BorderLayout());
        panelDisplay.add(scroll, BorderLayout.CENTER);

        // Create a new JFrame to display the panel with the table
        JFrame displayFrame = new JFrame("Student Records");
        displayFrame.setSize(800, 800);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.add(panelDisplay);
        displayFrame.setVisible(true);
    }

    public void clearallfields()
    {
        // Clear text fields
        regularTxtEnrollmentID.setText("");
        regularTxtStudentName.setText("");
        regularTxtCourseDuration.setText("");
        regularTxtDaysPresent.setText("");
        regularTxtTuitionFee.setText("");
        regularTxtNoOfModules.setText("");
        regularTxtNoOfCreditHours.setText("");
        regularTxtEnrollmentID.setText("");
        regularTxtStudentName.setText("");
        regularTxtCourseDuration.setText("");
        regularTxtDaysPresent.setText("");
        regularTxtTuitionFee.setText("");
        regularTxtNoOfModules.setText("");
        regularTxtNoOfCreditHours.setText("");
        regularCCourseName.setSelectedIndex(0);
        regulartErDay.setSelectedIndex(0);
        regulartErMonth.setSelectedIndex(0);
        regularErYear.setSelectedIndex(0);
        regulartDOBDay.setSelectedIndex(0);
        regulartDOBMonth.setSelectedIndex(0);
        regularDOBYear.setSelectedIndex(0);
    }

    public void addPresentPercentage() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame_REGULAR, "Fill the form first", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        } else {
            // Create separate dialog box for EnrollmentID
            String enrollmentIDbox = JOptionPane.showInputDialog(frame_REGULAR, "Enter Enrollment ID:");
            if (enrollmentIDbox == null || enrollmentIDbox.isEmpty()) {
                JOptionPane.showMessageDialog(frame_REGULAR, "Fields Empty.\nPlease enter valid Enrollment ID .", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int enrollmentID;
            try {
                enrollmentID = Integer.parseInt(enrollmentIDbox);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame_REGULAR, "Enrollment ID should be a valid integer.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String daysPresentbox = JOptionPane.showInputDialog(frame_REGULAR, "Enter Days present:");
            if (daysPresentbox == null || daysPresentbox.isEmpty()) {
                JOptionPane.showMessageDialog(frame_REGULAR, "Fields Empty.\nPlease enter valid Days Present.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int daysPresent;
            try {
                daysPresent = Integer.parseInt(daysPresentbox);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame_REGULAR, "Days present should be a valid integer.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Regular foundRegularStudent = null;
            for (Student student : students) {
                if (student instanceof Regular && student.getEnrollmentID() == enrollmentID) {
                    foundRegularStudent = (Regular) student;

                    // Check if the daysPresent matches the corresponding student's record
                    if (foundRegularStudent.getDaysPresent() == daysPresent) {
                        break;
                    } else {
                        foundRegularStudent = null; // Reset to null if the daysPresent does not match
                    }
                }
            }

            if (foundRegularStudent == null) {
                JOptionPane.showMessageDialog(frame_REGULAR, "Student with Enrollment ID: " + enrollmentID + " and \nDays Present: " + daysPresent + " \nNot found.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int courseDuration = foundRegularStudent.getCourseDuration();
            int maxdays = courseDuration * 30;

            if (daysPresent < 0 || daysPresent > maxdays) {
                JOptionPane.showMessageDialog(frame_REGULAR, "Days Present should be between 0 and " + maxdays + ".", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Calculate the present percentage by passing value to Regular class
            double percentage = foundRegularStudent.calculatePresentPercentage(daysPresent);
            String Grade = foundRegularStudent.presentPercentage(daysPresent);

            // Display the attendance grade and percentage
            JOptionPane.showMessageDialog(frame_REGULAR, "Present percentage: " + percentage + "\nAttendance Grade: " + Grade, "Regular Student Attendance Grade", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void addGrantCertificate() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame_REGULAR, "Fill the form first", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        } else {
            String enrollmentIDbox = JOptionPane.showInputDialog(frame_REGULAR, "Enter Enrollment ID:");
            if (enrollmentIDbox == null || enrollmentIDbox.isEmpty()) {
                JOptionPane.showMessageDialog(frame_REGULAR, "Fields Empty.\nPlease enter valid Enrollment ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int enrollmentID;
            try {
                enrollmentID = Integer.parseInt(enrollmentIDbox);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame_REGULAR, "Enrollment ID should be a valid integer.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String[] courseOptions = {"Computing", "Networking", "AI", "Cyber Security", "Business"};
            JComboBox<String> courseComboBox = new JComboBox<>(courseOptions);

            int result = JOptionPane.showOptionDialog(null,
                    courseComboBox,
                    "Select Course Name",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);


            String courseName = (String) courseComboBox.getSelectedItem();

            // Combo boxes for day, month, and year
            String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String[] years = {"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};

            JComboBox<String> dayComboBox = new JComboBox<>(days);
            JComboBox<String> monthComboBox = new JComboBox<>(months);
            JComboBox<String> yearComboBox = new JComboBox<>(years);

            JPanel datePanel = new JPanel();
            datePanel.add(dayComboBox);
            datePanel.add(monthComboBox);
            datePanel.add(yearComboBox);

            int DOE = JOptionPane.showOptionDialog(null,
                    datePanel,
                    "Select Date of Enrollment",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);

           

            // Combine selected day, month, and year to form the final date string
            String day = (String) dayComboBox.getSelectedItem();
            String month = (String) monthComboBox.getSelectedItem();
            String year = (String) yearComboBox.getSelectedItem();
            String dateOfEnrollment = year + "-" + (monthComboBox.getSelectedIndex() + 1) + "-" + day;

            // Find the Regular student with the given Enrollment ID, Course Name, and Date of Enrollment
            Regular regularStudent = null;
            for (Student student : students) {
                if (student instanceof Regular && student.getEnrollmentID() == enrollmentID
                && ((Regular) student).getCourseName().equals(courseName)
                && ((Regular) student).getDateOfEnrollment().equals(dateOfEnrollment)) {
                    regularStudent = (Regular) student;
                    break;
                }
            }
            // Check if Regular student with given Enrollment ID, Course Name, and Date of Enrollment is found
            if (regularStudent == null) {
                JOptionPane.showMessageDialog(frame_REGULAR, "No Regular student found with the entered information.", "Student Not Found", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Grant certificate to the Regular student
            String certificateMessage = regularStudent.grantCertificate(courseName, enrollmentID, dateOfEnrollment);

            // Display the certificate information in a dialog
            JOptionPane.showMessageDialog(frame_REGULAR, certificateMessage, "Certificate Granted", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    //Dropout page
    // Enrollment ID
    public int getdropoutEnrollmentID() {
        String enrollmentID = txtdropoutEnrollmentID.getText();
        int dropoutEnrollmentID = -1;
        try {
            dropoutEnrollmentID = Integer.parseInt(enrollmentID);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_DROPOUT, "Field: Enrollment ID \nOnly numeric values are allowed to be entered!!! ", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
        return dropoutEnrollmentID;
    }

    // Student Name
    public String getdropoutStudentName() {
        String studentName = txtdropoutStudentName.getText();
        if (!studentName.matches("[a-zA-z]+")) {
            JOptionPane.showMessageDialog(frame_DROPOUT, "Field: Student Name \nInvalid inputs. Please enter valid inputs.", "Alert", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return studentName;
    }

    // Course Duration
    public int getdropoutCourseDuration() {
        String courseDurationStr = txtdropoutCourseDuration.getText();
        int courseDuration = -1;
        try {
            courseDuration = Integer.parseInt(courseDurationStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_DROPOUT, "Field: Course Duration \nOnly numeric values are allowed to be entered!!! ", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
        return courseDuration;
    }

    // Tuition Fee
    public int getdropoutTuitionFee() {
        String tuitionFee = txtdropoutTuitionFee.getText();
        int dropoutTuitionFee = -1;
        try {
            dropoutTuitionFee = Integer.parseInt(tuitionFee);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_DROPOUT, "Field: Tuition Fee \nOnly numeric values are allowed to be entered!!!", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
        return dropoutTuitionFee;
    }

    // Date of Enrollment
    public String getdropoutDateOfEnrollment() {
        String dateOfEnrollment = dropoutErYear.getSelectedItem() + "-" + (dropoutErMonth.getSelectedIndex() + 1) + "-" + dropoutErDay.getSelectedItem();
        return dateOfEnrollment;
    }

    // Date of Birth
    public String getdropoutDateOfBirth() {
        String dateOfBirth = dropoutDOBYear.getSelectedItem() + "-" + (dropoutDOBMonth.getSelectedIndex() + 1) + "-" + dropoutDOBDay.getSelectedItem();
        return dateOfBirth;
    }

    // Course Name
    public String getdropoutCourseName() {
        String courseName = dropoutCCourseName.getSelectedItem().toString();
        return courseName;
    }

    // Number Months attended
    public int getDropoutMonthsAttended() {
        String numOfMonthsAttended = txtDropoutMonthsAttended.getText();
        int dropoutMonthsAttended = -1;
        try {
            dropoutMonthsAttended = Integer.parseInt(numOfMonthsAttended);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_DROPOUT, "Field: Months Attended \nOnly numeric values are allowed to be entered!!!", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
        return dropoutMonthsAttended;
    }

    // Remaining Amount of modules
    public int getDropoutRemainingAmount() {
        String remainingAmount = txtDropoutRemainingAmount.getText();
        int dropoutRemainingAmount = -1;
        try {
            dropoutRemainingAmount = Integer.parseInt(remainingAmount);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_DROPOUT, "Field: Remaining Amount \nOnly numeric values are allowed to be entered!!!", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
        return dropoutRemainingAmount;
    }

    //date of dropout

    public String getDropoutDateOfDropout() {
        String dateOfDropout = dropoutDODYear.getSelectedItem().toString() + "-" + (dropoutDODMonth.getSelectedIndex() + 1) + "-" + dropoutDODDay.getSelectedItem().toString();
        return dateOfDropout;
    }

    //Dropout methods
    public void addHasPaid() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame_DROPOUT, "No Dropout students entered.", "Display", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            // Create separate dialog box for EnrollmentID
            String enrollmentIDbox = JOptionPane.showInputDialog(frame_DROPOUT, "Enter Enrollment ID:");
            if (enrollmentIDbox == null || enrollmentIDbox.isEmpty()) {
                JOptionPane.showMessageDialog(frame_DROPOUT, "Fields Empty.\nPlease enter valid Enrollment ID .", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int enrollmentID;
            try {
                enrollmentID = Integer.parseInt(enrollmentIDbox);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame_DROPOUT, "Enrollment ID should be a valid integer.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Dropout payment = null;
            for (Student student : students) {
                if (student instanceof Dropout && student.getEnrollmentID() == enrollmentID) {
                    payment = (Dropout) student;
                    break;
                }
            }

            if (payment == null) {
                JOptionPane.showMessageDialog(frame_DROPOUT, "Student with Enrollment ID: " + enrollmentID + " not found.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String studentName = payment.getStudentName();
            int courseDuration = payment.getCourseDuration();
            int numOfMonthsAttended = payment.getMonthsAttended();
            double tuitionFee = payment.getTuitionFee();
            Dropout dropout = new Dropout(studentName, "N/A", courseDuration, tuitionFee, numOfMonthsAttended, 0, "N/A", enrollmentID, "", "N/A");

            double remainingAmount = payment.billsPayable();

            if (remainingAmount <= 0) {
                JOptionPane.showMessageDialog(frame_DROPOUT, "The student " + studentName + " (Enrollment ID: " + enrollmentID + ") has paid all bills.", "Payment Status", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(frame_DROPOUT, "The student " + studentName + " (Enrollment ID: " + enrollmentID + ") has remaining bills to pay.", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void clearAllDropoutFields() {
        // Clear text fields
        txtdropoutEnrollmentID.setText("");
        txtdropoutStudentName.setText("");
        txtdropoutCourseDuration.setText("");
        txtdropoutTuitionFee.setText("");
        txtDropoutRemainingAmount.setText("");
        txtDropoutMonthsAttended.setText("");
        dropoutCCourseName.setSelectedIndex(0);
        dropoutErDay.setSelectedIndex(0);
        dropoutErMonth.setSelectedIndex(0);
        dropoutErYear.setSelectedIndex(0);
        dropoutDOBDay.setSelectedIndex(0);
        dropoutDOBMonth.setSelectedIndex(0);
        dropoutDOBYear.setSelectedIndex(0);
        dropoutDODDay.setSelectedIndex(0);
        dropoutDODMonth.setSelectedIndex(0);
        dropoutDODYear.setSelectedIndex(0);
    }

    public void addRemove() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame_DROPOUT, "No Dropout students to Remove.", "Display", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String enrollmentIDbox = JOptionPane.showInputDialog(frame_DROPOUT, "Enter Enrollment ID:");
            if (enrollmentIDbox == null || enrollmentIDbox.isEmpty()) {
                JOptionPane.showMessageDialog(frame_DROPOUT, "Fields Empty.\nPlease enter valid Enrollment ID .", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int enrollmentID;
            try {
                enrollmentID = Integer.parseInt(enrollmentIDbox);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame_DROPOUT, "Enrollment ID should be a valid integer.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Dropout remove = null;
            for (Student student : students) {
                if (student instanceof Dropout && student.getEnrollmentID() == enrollmentID) {
                    remove = (Dropout) student;
                    break;
                }
            }

            if (remove != null) {
                if (remove.billsPayable() <= 0) {
                    students.remove(remove);
                    JOptionPane.showMessageDialog(frame_DROPOUT, "Student with Enrollment ID " + enrollmentID + " removed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame_DROPOUT, "Cannot remove student with Enrollment ID " + enrollmentID + ". They still have bills to pay.", "Cannot Remove", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame_DROPOUT, "No student found with Enrollment ID " + enrollmentID + ".", "Not Found", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void addDropoutStudent() 
    {
        // get infromations for the fields
        int enrollmentID = this.getdropoutEnrollmentID();
        String studentName = this.getdropoutStudentName();
        int courseDuration = this.getdropoutCourseDuration();
        double tuitionFee = this.getdropoutTuitionFee();
        int monthsAttended=this.getDropoutMonthsAttended();
        String dateOfEnrollment = this.getdropoutDateOfEnrollment();
        String dateOfBirth = this.getdropoutDateOfBirth();
        String courseName = this.getdropoutCourseName();
        int numOfModules = this.getDropoutRemainingAmount();
        String dateOfDropout = this.getDropoutDateOfDropout();
        //check if empty or invalid
        if(enrollmentID == -1 || studentName.isEmpty() || courseDuration == -1  || tuitionFee == -1 || numOfModules == -1 || monthsAttended==-1) 
        {
            JOptionPane.showMessageDialog(frame_DROPOUT, "All Fields must be filled \nPlease enter a value.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        } else {
            // Check if student already exists in the database
            boolean studentAlreadyExists = false;
            for(Student check : students) {
                if (check instanceof Dropout) {
                    if (check.getEnrollmentID() == enrollmentID) {
                        JOptionPane.showMessageDialog(frame_DROPOUT, "The student is already registered into the database.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        studentAlreadyExists = true;
                        break;
                    }
                }
            }

            //if dosent exist add to the database
            if (studentAlreadyExists== false) {
                Dropout dropoutObj = new Dropout(studentName,dateOfBirth,courseDuration, tuitionFee,monthsAttended,  numOfModules,dateOfDropout,enrollmentID ,courseName, dateOfEnrollment);
                students.add(dropoutObj);
                JOptionPane.showMessageDialog(frame_DROPOUT, "Thank you for registering..", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // fields are cleared after adding the student to let new addition
        clearAllDropoutFields();
    }

    private void adddropoutDisplay() {
        // Create a new DefaultTableModel with column headers
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Enrollment ID", "Student Name", "Course Name", "Course Duration", "Date of Enrollment", "Date of Birth", "Tuition Fee", "Months Attended", "Date of Dropout"});

        // Add data to the model from the students list (assuming you have a list of Dropout students)
        for (Student student : students) {
            if (student instanceof Dropout) {
                Dropout dropoutStudent = (Dropout) student;
                model.addRow(new Object[]{
                        dropoutStudent.getEnrollmentID(),
                        dropoutStudent.getStudentName(),
                        dropoutStudent.getCourseName(),
                        dropoutStudent.getCourseDuration(),
                        dropoutStudent.getDateOfEnrollment(),
                        dropoutStudent.getDateOfBirth(),
                        dropoutStudent.getTuitionFee(),
                        dropoutStudent.getnumOfMonthsAttended(),
                        dropoutStudent.dateOfDropout()
                    });
            }
        }

        // Create a JTable with the model
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        
        //set table as uneditable
        table.setEnabled(false);

        // Wrap the JTable in a JScrollPane to enable scrolling
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Create a panel and add the JScrollPane to it
        JPanel panelDisplay = new JPanel(new BorderLayout());
        panelDisplay.add(scroll, BorderLayout.CENTER);

        // Create a new JFrame to display the panel with the table
        JFrame displayFrame = new JFrame("Dropout Student Records");
        displayFrame.setSize(800, 800);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.add(panelDisplay);
        displayFrame.setVisible(true);
    }

    // The main method 
    public static void main(String[] args) {
        new Student_GUI();
    }
}
