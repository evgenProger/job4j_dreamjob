package ru.job4j.dream.servlet;

import org.apache.commons.io.FilenameUtils;
import ru.job4j.dream.model.Path;
import ru.job4j.dream.store.MemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        MemStore.instOf().removeCandidate(Integer.parseInt(id));
        req.setAttribute("candidates", MemStore.instOf().findAllCandidates());
        File folder = new File(Path.pathToImages("path"));
        for (File f : Objects.requireNonNull(folder.listFiles())) {
            if (FilenameUtils.removeExtension(f.getName()).equals(id)) {
                f.delete();
            }
        }
        req.getRequestDispatcher("/candidate/candidates.jsp").forward(req, resp);
    }
}

