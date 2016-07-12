package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    public ActionCommand getCommandFromRequest(HttpServletRequest request) {
        ActionCommand result = new CommandError();

        String commandValue = request.getParameter("command");

        if (commandValue != null && !commandValue.isEmpty()) {
            Action action = Action.valueOf(commandValue.toUpperCase());
            result = action.command;
        }
        return result;
    }
}
