import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    private int rollNumber;
    private String name;
    private int age;

    // Constructor
    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class StudentManagementGUI extends JFrame {

    private ArrayList<Student> studentList;
    private JTextArea displayArea;

    public StudentManagementGUI() {
        studentList = new ArrayList<>();

        // Set up the frame
        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JButton addButton = new JButton("Add Student");
        JButton removeButton = new JButton("Remove Student");
        JButton searchButton = new JButton("Search Student");
        JButton displayButton = new JButton("Display All Students");
        displayArea = new JTextArea(10, 30);

        // Add components to the frame
        add(addButton);
        add(removeButton);
        add(searchButton);
        add(displayButton);
        add(new JScrollPane(displayArea));

        // Set layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllStudents();
            }
        });
    }

    private void addStudent() {
        int rollNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Roll Number:"));
        String name = JOptionPane.showInputDialog("Enter Name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));

        Student student = new Student(rollNumber, name, age);
        studentList.add(student);

        JOptionPane.showMessageDialog(this, "Student added successfully!");
    }

    private void removeStudent() {
        int rollNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Roll Number to remove:"));

        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                studentList.remove(student);
                JOptionPane.showMessageDialog(this, "Student removed successfully!");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Student with Roll Number " + rollNumber + " not found.");
    }

    private void searchStudent() {
        int rollNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Roll Number to search:"));

        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                JOptionPane.showMessageDialog(this, "Student Found:\n" +
                        "Roll Number: " + student.getRollNumber() + "\n" +
                        "Name: " + student.getName() + "\n" +
                        "Age: " + student.getAge());
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Student with Roll Number " + rollNumber + " not found.");
    }

    private void displayAllStudents() {
        StringBuilder displayText = new StringBuilder("Student Information:\n");
        for (Student student : studentList) {
            displayText.append("Roll Number: ").append(student.getRollNumber()).append("\n");
            displayText.append("Name: ").append(student.getName()).append("\n");
            displayText.append("Age: ").append(student.getAge()).append("\n");
            displayText.append("---------------\n");
        }

        displayArea.setText(displayText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementGUI().setVisible(true);
            }
        });
    }
}
