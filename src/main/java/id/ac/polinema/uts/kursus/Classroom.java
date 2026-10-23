package id.ac.polinema.uts.kursus;

public class Classroom {
    private String code;
    private OnlineCourse[] courses;
    private int courseCount;

    public Classroom(String code) {
        this.code = code;
        this.courses = new OnlineCourse[5];
        this.courseCount = 0;
    }

    public String getCode() {
        return code;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public boolean addCourse(OnlineCourse course) {
        if (course == null || courseCount >= 5) {
            return false;
        }
        courses[courseCount] = course;
        courseCount++;
        return true;
    }

    public OnlineCourse findByCode(String code) {
        if (code == null) {
            return null;
        }
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCode().equals(code)) {
                return courses[i];
            }
        }
        return null;
    }

    public int countAvailable() {
        int n = 0;
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].isAvailable()) {
                n++;
            }
        }
        return n;
    }

}
