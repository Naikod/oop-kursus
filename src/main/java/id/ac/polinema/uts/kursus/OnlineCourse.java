package id.ac.polinema.uts.kursus;

public class OnlineCourse extends Course {

    private String code;
    private Instructor instructor;

    public OnlineCourse(String code, String title, int year) {
        super(title, year);
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Code tidak boleh kosong!");
        }
        this.code = code;
        this.instructor = null;
    }

    public OnlineCourse(String code, String title, int year, Instructor instructor) {
        this(code, title, year);
        this.instructor = instructor;
    }

    public String getCode() {
        return code;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public int durationWeeks() {
        return 6;
    }

    @Override
    public String describe() {
        String name = (instructor == null) ? "TBA" : instructor.getName();
        return super.describe() + " by " + name;
    }
}
