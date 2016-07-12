package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandPlaceBet implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.PLACE_BET.startPage;
    }
}
