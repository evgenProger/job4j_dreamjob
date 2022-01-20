package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.DbStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.notNullValue;

public class CandidateServletTest {

    @Test
    public void whenCreateCandidate() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("name of new candidate");
        new CandidateServlet().doPost(req, resp);
        List<Candidate> candidates = (List<Candidate>) DbStore.instOf().findAllCandidates();
        Candidate candidate = candidates.get(0);
        assertThat(candidate, notNullValue());
        assertThat(candidate.getName(), is("name of new candidate"));
    }
}