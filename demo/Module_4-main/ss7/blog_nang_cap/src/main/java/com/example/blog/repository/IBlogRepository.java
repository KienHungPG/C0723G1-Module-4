package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByStatusFalse(Pageable pageable);

    Page<Blog> findBlogsByCategoryIdAndStatusIsFalse(Integer id, Pageable pageable);

    @Query(value = "select * from blogs as b where title like concat('%',:title,'%') and status = 'false'", nativeQuery = true)
    Page<Blog> findAllByTitle(Pageable pageable, @Param("title") String title);

}
