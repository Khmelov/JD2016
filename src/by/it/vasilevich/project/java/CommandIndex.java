package by.it.vasilevich.project.java;

import by.it.akhmelev.project.java.Action;
import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandIndex implements by.it.akhmelev.project.java.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        List<Ad> ads = DAO.getDAO().ad.getAll("");
        request.setAttribute("ads", ads);
        return Action.INDEX.inPage;
    }
}