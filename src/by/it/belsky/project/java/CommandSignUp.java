package by.it.belsky.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.SIGNUP.inPage;
    }
}