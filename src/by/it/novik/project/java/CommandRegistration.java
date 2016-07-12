package by.it.novik.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandRegistration implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.REGISTRATION.inPage;
    }
}