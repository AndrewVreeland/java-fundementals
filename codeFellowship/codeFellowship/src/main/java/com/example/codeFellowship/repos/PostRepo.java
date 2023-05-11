package com.example.codeFellowship.repos;

import com.example.codeFellowship.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PostRepo extends JpaRepository<Post, Long> {
}