package by.it.novik.project.java;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kate Novik.
 */
public class CommandGetPayments implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.PAYMENTS.inPage;
    }
}
