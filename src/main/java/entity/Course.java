package entity;

public class Course {
    private int cid;
    private String name;
    private int tid;
    private String sid;
    private int score;

    public Course(String name, int tid, String uid, int score) {
        this.name = name;
        this.tid = tid;
        this.sid = uid;
        this.score = score;
    }

    public int getCid() {
        return cid;
    }

    public Course() {
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Course(int cid, String name, int tid, String sid, int score) {
        this.cid = cid;
        this.name = name;
        this.tid = tid;
        this.sid = sid;
        this.score = score;
    }
}
