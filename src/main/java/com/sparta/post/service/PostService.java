package com.sparta.post.service;

import com.sparta.post.dto.RequestDto;
import com.sparta.post.dto.ResponseDto;
import com.sparta.post.entity.Post;
import com.sparta.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 1. 게시글 작성
    // 제목,작성자명,비밀번호,작성 내용을 저장하고
    // 저장된 게시글을 client로 반환하기
    public ResponseDto createPost(RequestDto requestDto) {
        Post post = new Post(requestDto);

        // db에 저장
        Post savePost = postRepository.save(post);

        // 반환
        ResponseDto responseDto = new ResponseDto(post);
        return responseDto;

    }

    // 2. 게시글 전체 조회
    // 전체 조회 : 제목,작성자명, 작성 내용, 작성 날짜
    // 작성 날짜 기준, 내림차순 정렬
    public List<ResponseDto> getPosts() {
        List<Post> posts = postRepository.findAllByOrderByModifiedAtDesc();
        List<ResponseDto> result = new ArrayList<>();

        for (Post post : posts) {
            result.add(new ResponseDto(post));
        }

        return result;
    }

    // 3. 선택한 게시글 조회
    // 선택한 게시글의 제목,작성자명,작성 날짜, 작성 내용을 조회하기
    // (검색 기능이 아닌, 간단한 게시글 조회)
    public ResponseDto getPost(Long id) {
        Post post = findPost(id);

        ResponseDto result = new ResponseDto(post);

        return result;
    }

    // 4. 게시글 수정
    // 수정을 요청할 때 수정할 데이터와 비번을 같이 보내서 서버에서 일치 여부 확인 -> 트랜젝션 활용
    // 제목,작성자명,작성 내용 수정 후, 수정된 게시글 반환
    @Transactional
    public Long updatePost(Long id, RequestDto requestDto) {
        Post post = findPost(id);

        if(requestDto.getPassword() == post.getPassword()){
            post.update(requestDto);
        } else {
            throw new IllegalArgumentException("비밀버호가 같지 않습니다");
        }
        return id;
    }

    // 5. 게시글 삭제
    // 삭제를 요청할 때 비밀번호를 같이 보내서 비밀번호 일치 확인 한 후
    // 선택한 게시글 삭제 client로 성공했다는 표시 반환하기 ->
    public Long deletePost(Long id, RequestDto requestDto) {
        Post post = findPost(id);

        if(requestDto.getPassword() == post.getPassword()){
            postRepository.delete(post);
        } else {
            throw new IllegalArgumentException("비밀버호가 같지 않습니다");
        }
        return id;
    }

    // id 찾기
    public Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
