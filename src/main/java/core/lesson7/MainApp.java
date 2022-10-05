package core.lesson7;

import core.lesson7.workset.UserInterface;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException {
        UserInterface UI = new UserInterface();
        UI.runDialog();
    }

}
