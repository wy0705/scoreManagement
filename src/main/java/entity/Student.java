package entity;

public class Student {
    private int id;
    private String sid;
    private String name;
    private int age;
    private String password;
    private String major;

    public Student() {
    }

    public Student(int id, String sid, String name, int age, String password, String major) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.password = password;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student(String sid, String name, int age, String password, String major) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.password = password;
        this.major = major;
    }
}
