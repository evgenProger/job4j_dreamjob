package ru.job4j.dream.servlet;

import ru.job4j.dream.store.DbStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidatesAtLast", DbStore.instOf().findCandidatesAt24Hours());
        req.setAttribute("postsLast", DbStore.instOf().findPostsAt24Hours());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
