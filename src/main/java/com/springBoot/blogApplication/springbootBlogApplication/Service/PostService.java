package com.springBoot.blogApplication.springbootBlogApplication.Service;

import java.util.List;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;

public interface PostService {
	PostDTO createPost(PostDTO postDto);
	
	List<PostDTO> getAllPosts();

	PostDTO getSpecificPost(Long id);

	String deletePost(Long id);

	PostDTO updatePost(Long id,PostDTO postDto);
}
