package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandRegister implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.REGISTER.startPage;
    }
}
