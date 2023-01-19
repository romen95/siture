package com.siture.webApplication.repo;

import com.siture.webApplication.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
