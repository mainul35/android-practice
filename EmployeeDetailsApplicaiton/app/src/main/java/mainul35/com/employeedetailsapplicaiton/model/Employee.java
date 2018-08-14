package mainul35.com.employeedetailsapplicaiton.model;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable{

    private String empName;
    private String empAge;
    private String empId;
    private List<String> skills;
    private String gender;
    private String employmentType;
    private String email;
    private String phone;
    private Address address;

    public Employee(String empName, String empAge, String empId, String gender, String email, String phone) {
        this.empName = empName;
        this.empAge = empAge;
        this.empId = empId;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAge() {
        return empAge;
    }

    public void setEmpAge(String empAge) {
        this.empAge = empAge;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empAge='" + empAge + '\'' +
                ", empId='" + empId + '\'' +
                ", skills=" + skills +
                ", gender='" + gender + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
