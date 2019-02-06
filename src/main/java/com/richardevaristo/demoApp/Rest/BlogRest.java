package com.richardevaristo.demoApp.Rest;

import com.richardevaristo.demoApp.Dao.BlogRepository;
import com.richardevaristo.demoApp.Model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BlogRest implements BlogRepository {

    @Autowired
    private RestTemplate restTemplate;

    private static String BASE_URI = "http://10.0.16.84:3000";

    public List<Blog> findAll() {
        ResponseEntity<List<Blog>> response = restTemplate.exchange(
                BASE_URI + "/blogs",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Blog>>() {
                }
        );
        return response.getBody();
    }

    @Override
    public Blog findById(int id) {
        return execute("/blogs/" + id, HttpMethod.GET, null);
    }

    @Override
    public Blog save(Blog blog) {
        return execute("/blogs", HttpMethod.POST, new HttpEntity<>(blog));
    }

    @Override
    public Blog update(int id, Blog blog) {
        return execute("/blogs/" + id, HttpMethod.PUT, new HttpEntity<>(blog));
    }

    @Override
    public Blog remove(int id) {
        return execute("/blogs/" + id, HttpMethod.DELETE, null);
    }

    @Override
    public Blog execute(String url, HttpMethod method, HttpEntity<Blog> entity) {
        ResponseEntity<Blog> response = restTemplate.exchange(
                BASE_URI+url,
                method,
                entity,
                Blog.class
        );
        return response.getBody();
    }
}
