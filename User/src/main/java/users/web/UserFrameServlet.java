package users.web;

import users.logic.ManagementSystem;
import users.UsersEntity;
import users.web.forms.MainFrameForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;

public class UserFrameServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String uId = req.getParameter("userId");
        if (uId != null && req.getParameter("OK") != null) {
            try {
                if (Integer.parseInt(uId) > 0) {
                    updateUser(req);
                }
                else {
                    insertUser(req);
                }
            } catch (SQLException | ParseException sql_e) {
                throw new IOException(sql_e.getMessage());
            }
        }
        MainFrameForm form = new MainFrameForm();
        try {
            Collection users = ManagementSystem.getInstance().getAllUsers();
            form.setUsers(users);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        req.setAttribute("form", form);
        getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void updateUser(HttpServletRequest req) throws SQLException, ParseException {
        UsersEntity u = prepareUser(req);
        ManagementSystem.getInstance().updateUser(u);
    }

    private void insertUser(HttpServletRequest req) throws SQLException, ParseException {
        UsersEntity u = prepareUser(req);
        ManagementSystem.getInstance().insertUser(u);
    }

    private UsersEntity prepareUser(HttpServletRequest req) throws ParseException {
        UsersEntity u = new UsersEntity();
        u.setUserId(Integer.parseInt(req.getParameter("userId")));
        u.setFirstName(req.getParameter("firstName").trim());
        u.setSurName(req.getParameter("surName").trim());
        u.setNumber(req.getParameter("number").trim());
        return u;
    }
}
