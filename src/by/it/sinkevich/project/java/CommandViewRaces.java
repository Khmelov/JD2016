package by.it.sinkevich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandViewRaces implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.VIEW_RACES.startPage;
    }
}
