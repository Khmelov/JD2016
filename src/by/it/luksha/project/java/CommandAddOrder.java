package by.it.luksha.project.java;


import javax.servlet.http.HttpServletRequest;

public class CommandAddOrder implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {


        return Action.ADDORDER.inPage;
    }
}
