package by.it.novik.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //DO SOMETHING;
        //USE DAO
        //&ETC
        return Action.LOGIN.inPage;
    }
}