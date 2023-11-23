package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByFlagDeleteIsFalse(Pageable pageable);

    Page<Blog> findBlogsByCategoryId(Integer id, Pageable pageable);

    @Query(value = "select * from blogs where title like concat ('%',:name,'%')", nativeQuery = true)
    Page<Blog> searchBlog(@Param("name") String name, Pageable pageable);
}
