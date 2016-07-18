package by.it.vasilevich.project.java;

import by.it.akhmelev.project.java.*;
import by.it.akhmelev.project.java.Action;
import by.it.akhmelev.project.java.ActionCommand;
import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandCreateAd implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page=Action.CREATEAD.inPage;
        FormHelper frm=new FormHelper(request);
        frm.setMessage(frm.strDebugForm());
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //если данные из формы получены то пробуем создать объявление.
        if (frm.isPost())
        try {
            Ad ad=new Ad();
            ad.setID(0);
            ad.setAddress(frm.getString("Address"));
            ad.setDescription(frm.getString("Description"));
            ad.setArea(frm.getDouble("Area"));
            ad.setPrice(frm.getDouble("Price"));
            ad.setFloor(frm.getInt("Floor"));
            ad.setFloors(frm.getInt("Floors"));
            ad.setRoomCount(frm.getInt("RoomCount"));
            ad.setFK_Users(user.getId());
            DAO dao=DAO.getDAO();
            dao.ad.create(ad);
            frm.setMessage(ad.toString());
            return Action.LOGIN.okPage;
        } catch (Exception e) {
            frm.setErrorMessage(e.toString());
        }
        return page;
    }
}
