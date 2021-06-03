package entity;

public class Course {
    private int cid;
    private String name;
    private int tid;
    private int uid;
    private int score;

    public Course(String name, int tid, int uid, int score) {
        this.name = name;
        this.tid = tid;
        this.uid = uid;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Course(int cid, String name, int tid, int uid, int score) {
        this.cid = cid;
        this.name = name;
        this.tid = tid;
        this.uid = uid;
        this.score = score;
    }
}
