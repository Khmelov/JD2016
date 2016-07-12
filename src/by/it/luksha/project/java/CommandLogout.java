package by.it.luksha.project.java;

import by.it.luksha.project.java.*;
import by.it.luksha.project.java.Action;

import javax.servlet.http.HttpServletRequest;

public class CommandLogout implements by.it.luksha.project.java.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.LOGOUT.inPage;
    }
}
