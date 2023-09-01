package com.sparta.post.controller;

import com.sparta.post.dto.RequestDto;
import com.sparta.post.dto.ResponseDto;
import com.sparta.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 1. 게시글 작성
    @PostMapping("/post")
    public ResponseDto createPost(@RequestBody RequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    // 2. 게시글 전체 조회
    @GetMapping("/posts")
    public List<ResponseDto> getPosts() {
        return postService.getPosts();
    }

    // 3. 선택한 게시글 조회
    @GetMapping("/post/{id}")
    public ResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // 4. 게시글 수정
    @PutMapping("/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }

    // 5. 게시글 삭제
    @DeleteMapping("/post/{id}")
    public Long deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    //test -commit 2
}
