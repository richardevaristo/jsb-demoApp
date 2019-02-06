package com.richardevaristo.demoApp.Dao;

import com.richardevaristo.demoApp.Model.Blog;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository {
    List<Blog> findAll();
    Blog findById(int id);
    Blog save(Blog blog);
    Blog update(int id, Blog blog);
    Blog remove(int id);
    Blog execute(String url, HttpMethod method, HttpEntity<Blog> entity);
}
