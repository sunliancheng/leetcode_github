package LeetCodeUtils.LeetCode;

public class Problem {

    private int id;

    private String name;

    private String level;

    private boolean isNotFree;

    private boolean isAnswered;

    private double pass;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNotFree() {
        return isNotFree;
    }

    public void setNotFree(boolean free) {
        isNotFree = free;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public double getPass() {
        return pass;
    }

    public void setPass(double pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", isNotFree=" + isNotFree +
                ", isAnswered=" + isAnswered +
                ", pass=" + pass +
                ", comment='" + comment + '\'' +
                '}';
    }

    public static Problem generate(String prob) {
        String[] ss = prob.split(",");
        Problem problem = new Problem();
        problem.setId(Integer.valueOf(ss[0]));
        problem.setName(ss[1]);
        problem.setLevel(ss[3].equals("中等") ? "medium" : (ss[3].equals("简单") ? "easy" : "hard"));
        problem.setNotFree(ss[4].equals("是") ? true : false);
        problem.setAnswered(ss[5].equals("是") ? true : false);
        problem.setPass(Double.valueOf(ss[8].substring(0, 4)));
        return problem;
    }
}
