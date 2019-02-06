package com.richardevaristo.demoApp.Service;

import com.richardevaristo.demoApp.Model.Blog;
import com.richardevaristo.demoApp.Rest.BlogRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private BlogRest rest;

    public BlogService() {
        rest = new BlogRest();
    }

    public List<Blog> getAllBlogs() {
        return rest.fetchBlogs();
    }

    public Blog getStudent(int id) {
        return rest.fetchBlog(id);
    }

    public Blog createBlog(Blog blog) {
        return rest.addBlog(blog);
    }

    public Blog updateBlog(int id, Blog blog) {
        return rest.editBlog(id, blog);
    }

    public Blog deleteBlog(int id) {
        return rest.deleteBlog(id);
    }
}
