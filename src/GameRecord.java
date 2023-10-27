/**
 * @Description:
 * @Title: GameRecord
 * @Package PACKAGE_NAME
 * @Author: lijunpeng
 * @CreateTime: 10/24/23 6:36 PM
 */
public class GameRecord implements Comparable {

    private int grade;
    private String id;


    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new NullPointerException("GameRecord, compareTo()");
        }
        if (!(o instanceof GameRecord)) {
            throw new RuntimeException("GameRecord, compareTo(), not GameRecord");
        }
        GameRecord gr = (GameRecord) o;
        int grade = gr.getGrade();
        if (this.grade > grade) {
            return 1;
        } else if (this.grade == grade) {
            return 0;
        } else {
            return -1;
        }
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GameRecord{" +
                "grade=" + grade +
                ", id='" + id + '\'' +
                '}';
    }
}
