package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByStatusFalse();

    List<Blog> findBlogsByCategoryIdAndStatusIsFalse(Integer id);

    @Query(value = "select * from blogs as b where title like concat('%',:title,'%') and status = 'false'", nativeQuery = true)
    List<Blog> findAllByTitle(@Param("title") String title);

    List<Blog> findBlogByTitleContainingAndStatusIsFalse(String title);

    List<Blog> findAllByStatusIsFalse();
    boolean existsBlogById(Integer id);

    Blog findBlogByTitle(String title);
    @Query(value = "select * from blogs where status= 'false' limit :number ",nativeQuery = true)
    List<Blog> getMoreBlogs(@Param("number") int number);

}
