package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        if (DbStore.instOf().findByEmail(email) == null) {
            DbStore.instOf().saveUser(user);
        } else {
            req.setAttribute("error", "Такой пользователь уже зарегестрирован");
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
