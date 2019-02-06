package com.richardevaristo.demoApp.Controller;

import com.richardevaristo.demoApp.Model.Blog;
import com.richardevaristo.demoApp.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://10.0.16.84:3001")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogs")
    public List<Blog> index() {
        return blogService.getAllBlogs();
    }

    @RequestMapping("/blogs/{id}")
    public Blog getStudent(@PathVariable int id) {
        return blogService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/blogs")
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/blogs/{id}")
    public void deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/blogs/{id}")
    public Blog updateBlog(@PathVariable int id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }
}
