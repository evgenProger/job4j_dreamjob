package ru.job4j.dream.servlet;

import org.apache.commons.io.FilenameUtils;
import ru.job4j.dream.store.Store;
import ru.job4j.dream.model.Candidate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CandidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (req.getParameter("id") != null) {
            doDelete(req, resp);
        }
        req.setAttribute("candidates", Store.instOf().findAllCandidates());
        req.getRequestDispatcher("/candidate/candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Store.instOf().saveCandidate(
                new Candidate(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name")));
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Store.instOf().removeCandidate(Integer.parseInt(id));
        req.setAttribute("candidates", Store.instOf().findAllCandidates());
        File folder = new File("c:\\images\\");
        for (File f : Objects.requireNonNull(folder.listFiles())) {
            if (FilenameUtils.removeExtension(f.getName()).equals(id)) {
                f.delete();
            }
        }
        req.getRequestDispatcher("/candidate/candidate.jsp");
    }
}
