package com.springBoot.blogApplication.springbootBlogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;

public interface PostRepository extends JpaRepository<Posts, Long>{

}
