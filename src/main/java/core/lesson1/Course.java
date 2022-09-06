package core.lesson1;

public class Course {
    private String result;
    private int run;
    private int swim;
    private int bycicle;

    public Course(int run, int swim, int bycicle) {
        this.run = run;
        this.swim = swim;
        this.bycicle = bycicle;
    }

    public String runCourse(Team team) {
        result = "Команда " + "<<"+team.getTeamName()+">>" + " начинает забег!" + '\n' + '\n';
        for(Members members: team.getMembers()){                                                               // Эта та строчка, которую я не мог написать. Прежде чем втупую переписать пример, я часов 6 просидел с незнаием того как это осуществить. Я и сейчас не особо понимаю, прошу на разборе пояснить что тут происходит...
            result += members.getNickName();
            int value = members.getStamina();
            courseProcess(value);
        }
        return result;
    }

    private void courseProcess(int value) {
        if((value-run-swim-bycicle)>=0) result = result + " прошёл полосу препятствий!" + '\n';
        else result += " не прошёл полосу препятствий!" + '\n';
    }
}
