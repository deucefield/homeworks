package core.lesson1;

public class Team {
    private String teamName;
    private Members[] members = new Members[4];

    public Team(String teamName, Members[] members) {
        this.teamName = teamName;
        this.members = members;
    }

    public String getTeamName() {
        return teamName;
    }

    public Members[] getMembers() {
        return members;
    }
}
