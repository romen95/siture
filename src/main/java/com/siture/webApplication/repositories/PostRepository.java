package com.siture.webApplication.repositories;

import com.siture.webApplication.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
