package id.ac.polinema.uts.kursus;

public class OfflineCourse extends Course {
    private String room;

    public OfflineCourse(String title, int year, String room) {
        super(title, year);
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    @Override
    public String describe() {
        // TODO Auto-generated method stub
        return super.describe() + " [room "+room+"]";
    }

    @Override
    public int durationWeeks() {
        // TODO Auto-generated method stub
        return 10;
    }
    
}
