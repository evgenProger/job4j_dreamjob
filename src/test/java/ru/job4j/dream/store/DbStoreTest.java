package ru.job4j.dream.store;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DbStoreTest {
    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = DbStoreTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTablePost() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from post")) {
            statement.execute();
        }
    }

    @After
    public void wipeTableCandidate() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from candidate")) {
            statement.execute();
        }
    }

    @Test
    public void whenSavePostAndFindByGeneratedIdThenMustBeTheSame() {
        Post post = new Post(0, "java junior");
        DbStore.instOf().savePost(post);
        assertThat(DbStore.instOf().findById(post.getId()), is(post));
    }

    @Test
    public void whenUpdatePostThenNewPost() {
        Post newPpost = new Post(1, "java updated");
        DbStore.instOf().savePost(newPpost);
        assertThat(DbStore.instOf().findById(1), is(newPpost));
    }

    @Test
    public void whenSaveCandidateAndFindByGeneratedIdThenMustBeTheSame() {
        Candidate candidate = new Candidate(0, "Senior java");
        DbStore.instOf().saveCandidate(candidate);
        assertThat(DbStore.instOf().findCandidateById(candidate.getId()), is(candidate));
    }

    @Test
    public void whenUpdateCandidateThenNewCandidate() {
        Candidate newCandidate = new Candidate(1, "Middle Java");
        DbStore.instOf().saveCandidate(newCandidate);
        assertThat(DbStore.instOf().findCandidateById(1), is(newCandidate));
    }
}