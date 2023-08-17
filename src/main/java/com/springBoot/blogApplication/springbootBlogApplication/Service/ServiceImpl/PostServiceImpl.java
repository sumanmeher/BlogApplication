package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Posts;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.PostDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.PostRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.PostService;

@Service
public class PostServiceImpl implements PostService {
	private PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	private Posts DTOToEntity(PostDTO postDto) {
		// Convert DTO into Entity
		Posts post = new Posts();
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		return post;
	}

	private PostDTO EntityToDTO(Posts post) {
		// Convert Entity into DTO
		PostDTO postResponse = new PostDTO();
		postResponse.setId(post.getId());
		postResponse.setTitle(post.getTitle());
		postResponse.setDescription(post.getDescription());
		postResponse.setContent(post.getContent());

		return postResponse;
	}

	@Override
	public PostDTO createPost(PostDTO postDto) {

		Posts post = DTOToEntity(postDto);

		Posts postdto1 = postRepository.save(post);

		PostDTO postResponse = EntityToDTO(postdto1);

		return postResponse;
	}

	public List<PostDTO> getAllPosts() {
		List<Posts> post = postRepository.findAll();
		return post.stream().map(posts -> EntityToDTO(posts)).collect(Collectors.toList());

	}

	@Override
	public PostDTO getSpecificPost(Long id) {
//		Posts post = mapToDTO(postDto);
		Posts postdto1 = postRepository.getReferenceById(id);
		PostDTO postResponse = EntityToDTO(postdto1);
		return postResponse;

	}

	@Override
	public String deletePost(Long id) {
		postRepository.deleteById(id);
		return "Successfully Deleted";
	}

	@Override
	public PostDTO updatePost(Long id,PostDTO postDto) {
		Posts postdto1 = postRepository.getReferenceById(id);
		postdto1.setTitle(postDto.getTitle());
		Posts save = postRepository.save(postdto1);
		PostDTO postResponse = EntityToDTO(save);
		return postResponse;
	}

	
}
