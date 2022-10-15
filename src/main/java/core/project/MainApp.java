package core.project;

import core.project.workset.UserInterface;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws Exception {
        UserInterface UI = new UserInterface();
        UI.runDialog();
    }

}
