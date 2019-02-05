package com.richardevaristo.demoApp.Rest;

import com.richardevaristo.demoApp.Model.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BlogRest {
    private RestTemplate restTemplate;
    private static Logger log = LoggerFactory.getLogger(BlogRest.class);
    private static String BASE_URI = "http://10.0.16.84:3000";
    public BlogRest() {
        restTemplate = new RestTemplate();
    }

    public List<Blog> fetchBlogs() {
        ResponseEntity<List<Blog>> response = restTemplate.exchange(
                BASE_URI + "/blogs",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Blog>>() {
                }
        );
        return response.getBody();
    }

    public Blog fetchBlog(int id) {
        ResponseEntity<Blog> response = restTemplate.exchange(
                BASE_URI + "/blogs/" +id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Blog>() {
                }
        );
        return response.getBody();
    }

    public Blog addBlog(Blog blog) {
        HttpEntity<Blog> entity = new HttpEntity<>(blog);
        ResponseEntity<Blog> response = restTemplate.exchange(
                BASE_URI + "/blogs",
                HttpMethod.POST,
                entity,
                Blog.class
        );

        return response.getBody();
    }

    public Blog editBlog(int id, Blog blog) {
        HttpEntity<Blog> entity = new HttpEntity<>(blog);
        ResponseEntity<Blog> response = restTemplate.exchange(
                BASE_URI + "/blogs/" + id,
                HttpMethod.PUT,
                entity,
                Blog.class
        );
        return response.getBody();
    }

    public Blog deleteBlog(int id) {
        ResponseEntity<Blog> response = restTemplate.exchange(
                BASE_URI + "/blogs/" + id,
                HttpMethod.DELETE,
                null,
                Blog.class
        );
        return response.getBody();
    }
}
