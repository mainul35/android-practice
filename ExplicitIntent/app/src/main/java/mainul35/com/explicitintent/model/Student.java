package mainul35.com.explicitintent.model;

import java.io.Serializable;

public class Student implements Serializable{
    private String stdName;
    private int stdAge;
    private String stdDept;

    public Student(String stdName, int stdAge, String stdDept) {
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.stdDept = stdDept;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdtAge) {
        this.stdAge = stdtAge;
    }

    public String getStdDept() {
        return stdDept;
    }

    public void setStdDept(String stdDept) {
        this.stdDept = stdDept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdName='" + stdName + '\'' +
                ", stdtAge=" + stdAge +
                ", stdDept='" + stdDept + '\'' +
                '}';
    }
}
