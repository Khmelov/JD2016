package by.it.luksha.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandLogout implements by.it.luksha.project.java.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.LOGOUT.inPage;
    }
}
