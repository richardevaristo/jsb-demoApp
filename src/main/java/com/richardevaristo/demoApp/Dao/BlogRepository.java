package com.richardevaristo.demoApp.Dao;

import com.richardevaristo.demoApp.Model.Blog;

import java.util.List;

public interface BlogRepository {
    public List<Blog> findAll();
}
