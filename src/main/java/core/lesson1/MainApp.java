package core.lesson1;

public class MainApp {

    public static void main(String[] args) {
        Members[] teamWinners = new Members[4];
        teamWinners[0] = new Members("deuce", 60);
        teamWinners[1] = new Members("kate", 140);
        teamWinners[2] = new Members("max", 80);
        teamWinners[3] = new Members("wycc", 220);
        Team winners = new Team("Winners!", teamWinners);
        Course newCourse = new Course(30,40,50);

        System.out.println(newCourse.runCourse(winners));
    }
}
