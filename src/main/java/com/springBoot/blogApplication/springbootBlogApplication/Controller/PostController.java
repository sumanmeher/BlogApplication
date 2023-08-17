package com.springBoot.blogApplication.springbootBlogApplication.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto) {
		return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<PostDTO> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> getSpecificPost(@PathVariable Long id) {
		return new ResponseEntity<>(postService.getSpecificPost(id), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable Long id) {
		//return new ResponseEntity<>(postService.deletePost(id), HttpStatus.CREATED);
		return postService.deletePost(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDTO> updatePost(@PathVariable Long id,@RequestBody PostDTO postDto) {
		return new ResponseEntity<>(postService.updatePost(id,postDto), HttpStatus.CREATED);
	}
	
}
