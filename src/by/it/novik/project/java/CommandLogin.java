package by.it.novik.project.java;

import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandLogin implements ActionCommand {

    public static void main(String[] args) {

    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.LOGIN.inPage;
        if (request.getParameter("Password") == null) {
            return page;
        } else {

            String password = request.getParameter("Password");   //пароль
            String login = request.getParameter("Login");   //логин

            if (Validation.validDataFromForm(password, "password") && Validation.validDataFromForm(login, "login")) {
                //Получаем объект DAO
                DAO dao = DAO.getDAO();
                //Получаем user по введенному логину и паролю
                List<User> users = dao.getUserDAO().getAll(String.format("where Login='%s' and Password='%s'", login, password));
                User user = null;
                //Проверка на наличие user в базе данных
                if (users.size() > 0) {
                    user = users.get(0);
                }
                if (user == null) { //Вывод сообщение при отсутствии юзера в БД
                    request.setAttribute(Action.msgMessage, "Wrong data! Repeat, please, input or make registration.");
                    page = Action.LOGIN.inPage;
                } else {
                    request.setAttribute(Action.msgMessage, "Welcome, " + user.getNickname());
                    page = Action.LOGIN.okPage;
                }
            } else {
                request.setAttribute(Action.msgMessage, "Not valid data! Repeat, please, input.");
                page = Action.LOGIN.inPage;
            }
            return page;
        }
    }
}