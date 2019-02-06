package com.richardevaristo.demoApp.Service;

import com.richardevaristo.demoApp.Dao.BlogRepository;
import com.richardevaristo.demoApp.Model.Blog;
import com.richardevaristo.demoApp.Rest.BlogRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlog(int id) {
        return blogRepository.findById(id);
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(int id, Blog blog) {
        return blogRepository.update(id, blog);
    }

    public Blog deleteBlog(int id) {
        return blogRepository.remove(id);
    }
}
