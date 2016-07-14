package by.it.luksha.project.java;

import by.it.luksha.project.java.beans.User;
import by.it.luksha.project.java.dao.DAO;
import by.it.luksha.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandSignIn implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String resultPage = Action.SIGNIN.inPage;

        if (request.getParameter("Login") == null || request.getParameter("Password") == null) {
            return resultPage;
        }

        String login = request.getParameter("Login"); //логин пользователя
        String password = request.getParameter("Password"); //пароль

        //проверка на валидность логина и пароля
        if (FormHelper.valid(login) && FormHelper.valid(password)) {
            //получение DAO пользователя
            UserDAO userDAO = DAO.getDAO().getUserDAO();
            List<User> users = userDAO.getAll(String.format("where Login='%s' and Password='%s'", login, password));

            //если есть пользователь с таким логином и паролем возвращаем приветствием
            if (users.size() > 0) {
                User user = users.get(0);
                request.setAttribute(Action.msgMessage, "Добро пожаловать, " + user.getLogin());
                resultPage = Action.SIGNIN.okPage;
            } else {
                request.setAttribute(Action.msgMessage, "Неверный логин или пароль");
            }
        }
        return resultPage;
    }
}