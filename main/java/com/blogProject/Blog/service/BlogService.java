package com.blogProject.Blog.service;
import com.blogProject.Blog.model.Blogs;
import com.blogProject.Blog.model.Users;
import com.blogProject.Blog.repository.BlogRepository;
import com.blogProject.Blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;


    public Blogs addBlog(Blogs blog, int userId) {
        Users currentUser = userRepository.findByUserId(userId);
        blog.setUserId(currentUser);
        return blogRepository.save(blog);

    }

    public List<Blogs> getBlogList() {
        return blogRepository.findAll();
    }

    public List<Blogs> getMyBlogs(int userId) {
        Users currentUser = userRepository.findByUserId(userId);
        return blogRepository.findAllByUserId(currentUser);
    }

   public String deleteBlog(int id) {
      blogRepository.deleteById(id);
      return "\"deleted\"";
    }

    public Blogs editBlog(Blogs blog) {
        Blogs oldBlog = blogRepository.findById(blog.getBlogId());
        oldBlog.setContent(blog.getContent());
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBlogId(blog.getBlogId());
        blogRepository.saveAndFlush(oldBlog);
        return oldBlog;
    }

    public Blogs getBlog(int id) {
        return blogRepository.findById(id);
    }

    public Set<Blogs> getSearchedData(String searchedItem) {
        List<Blogs> productsList = blogRepository.findAll();
        Set<Blogs> result = new HashSet<>();

        for(int i=0; i<productsList.size(); i++) {
            if(productsList.get(i).getTitle().toLowerCase().contains(searchedItem.toLowerCase()) ||
                    productsList.get(i).getContent().toLowerCase().contains(searchedItem.toLowerCase()) ||
                    productsList.get(i).getAuthor().toLowerCase().contains(searchedItem.toLowerCase()) ||
                            productsList.get(i).getDate().toString().toLowerCase().split(" ")[0].contains(searchedItem.toLowerCase())) {

                result.add(productsList.get(i));
            }
        }
        return result;
    }
    public List<Blogs> toGet(int userId) {
        Users viewUser = userRepository.findByUserId(userId);
        return blogRepository.findAllByUserId(viewUser);
    }
}
