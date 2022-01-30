package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.List;

public interface Store {
    Collection<Post> findPosts();

    Collection<Candidate> findAllCandidates();

    int savePost(Post post);

    int saveCandidate(Candidate candidate);

    Post findById(int id);

    Candidate findCandidateById(int id);

    boolean removeCandidate(int id);

    User findByEmail(String email);

    int saveUser(User user);

    Collection<City> findAllCities();









}
