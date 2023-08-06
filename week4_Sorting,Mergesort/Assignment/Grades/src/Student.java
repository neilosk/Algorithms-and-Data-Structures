

public class Student implements Comparable<Student> {
    private String name;
    private String grade;
    
    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
    
 
    @Override   
    public int compareTo(Student that) {
        int result = this.grade.charAt(0) - that.grade.charAt(0);

          if (result == 0 && this.grade.length() > 1 && that.grade.length() > 1) {
        char thisSign = this.grade.charAt(this.grade.length() - 1);
        char thatSign = that.grade.charAt(that.grade.length() - 1);
        if (thisSign != thatSign) {
            if (thisSign == '+') {
                return 1;
            } else if (thisSign == '-') {
                return -1;
            }
        }
    }

        if (result == 0) {
        result = this.grade.compareTo(that.grade);
        }
        if (result == 0) {
            return result = this.name.compareTo(that.name);
        }
        if(this.grade.equals("FX") && that.grade.equals("F") || this.grade.equals("F") && that.grade.equals("FX")) {
            return result * -1;
        }
        return result;
    }

    @Override        
    public String toString() {
        return this.name;
    }
}

