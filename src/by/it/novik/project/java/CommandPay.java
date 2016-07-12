package by.it.novik.project.java;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kate Novik.
 */
public class CommandPay implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.PAY.inPage;
    }
}
