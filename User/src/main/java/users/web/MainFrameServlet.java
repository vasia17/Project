package users.web;

import users.logic.ManagementSystem;
import users.UsersEntity;
import users.web.forms.MainFrameForm;
import users.web.forms.UserForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class MainFrameServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int answer = 0;
        try {
            answer = checkAction(req);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        if (answer == 1) {
            UsersEntity u = new UsersEntity();
            u.setUserId(0);
            UserForm uForm = new UserForm();
            uForm.initFromUser(u);
            req.setAttribute("user", uForm);
            getServletContext().getRequestDispatcher("/UserFrame.jsp").forward(req, resp);
            return;

        }

        if (answer == 2) {
            try {
                if (req.getParameter("userId") != null) {
                    int uId = Integer.parseInt(req.getParameter("userId"));
                    UsersEntity u = ManagementSystem.getInstance().getUserById(uId);
                    UserForm uForm = new UserForm();
                    uForm.initFromUser(u);
                    req.setAttribute("user", uForm);
                    getServletContext().getRequestDispatcher("/UserFrame.jsp").forward(req, resp);
                    return;
                }
            } catch (SQLException sql_e) {
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

    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("Add") != null) {
            return 1;
        }
        if (req.getParameter("Edit") != null) {
            return 2;
        }
        if (req.getParameter("Delete") != null) {
            if (req.getParameter("userId") != null) {
                UsersEntity u = new UsersEntity();
                u.setUserId(Integer.parseInt(req.getParameter("userId")));
                ManagementSystem.getInstance().deleteUser(u);
            }
            return 0;
        }
        return 0;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}
