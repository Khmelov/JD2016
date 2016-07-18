package by.it.vasilevich.project.java;

import by.it.akhmelev.project.java.*;
import by.it.akhmelev.project.java.Action;
import by.it.akhmelev.project.java.ActionCommand;
import by.it.akhmelev.project.java.beans.Role;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandAllUsers implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        FormHelper frm = new FormHelper(request);
        DAO dao = DAO.getDAO();
        //получим список ролей (лучше бы это сделать при инциализации сервлета)
        List<Role> roles = dao.role.getAll("");
        request.setAttribute("roles", roles);

        //получим пользователя из сессии и его роль
        User sessionUser = (User) httpSession.getAttribute("user");

        if (sessionUser == null)
            {
                frm.setErrorMessage("Операции невозможны. Нужно выполнить вход. ");
                return Action.ALLUSERS.inPage;
            }
        else if (frm.isPost())
        {
            Role sessionUserRole = null;
            for (Role r : roles) {
                if (r.getId() == sessionUser.getFk_Role())
                    sessionUserRole = r;
            }
            //проверим имеет ли пользователь права на операцию
            if (sessionUserRole!=null && !sessionUserRole.getRole().equals("administrator")) {
                frm.setErrorMessage("Операция невозможна. Недостаточно прав.");
            } else //иначе операция возможна.
            {
                User user = new User();
                try {
                    user.setId(frm.getInt("ID"));
                    user.setEmail(frm.getString("Email"));   //почта
                    user.setLogin(frm.getString("Login"));   //логин
                    user.setPassword(frm.getString("Password"));
                    user.setFk_Role(frm.getInt("fk_Role"));
                    frm.setMessage(user.toString());
                    //Определим, это обновление или удаление.
                    if (0 < user.getId()) {
                        dao.user.update(user);
                    } else if (0 > user.getId()) {
                        user.setId(-1*user.getId());
                        dao.user.delete(user);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //покажем всех пользователей, вне зависимости от проверки прав
        List<User> users = dao.user.getAll("");
        request.setAttribute("users", users);
        return Action.ALLUSERS.inPage;
    }
}