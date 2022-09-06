package core.lesson1;

public class Members {
    private String nickName;
    private int stamina;

    public Members(String nickName, int stamina) {
        this.nickName = nickName;
        this.stamina = stamina;
    }

    public String getNickName() {
        return nickName;
    }

    public int getStamina() {
        return stamina;
    }
}
