package com.codegym.blog.repository;


import com.codegym.blog.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where id_category = :idCategory", nativeQuery = true)
    List<Blog> getBlogByIdCategory(@Param("idCategory") int id) ;
    @Query(value = "select * from blog where name like :name ", nativeQuery = true)
    Page<Blog> search(@Param("name") String name, Pageable pageable);
    @Query(value = "select * from blog where id_category =:idCategory", nativeQuery = true)
    Page<Blog> searchByCategory(Pageable pageable, @Param("idCategory") int idCate);
    @Query(value = "select * from blog where id_category =:idCategory and name like:name", nativeQuery = true)
    Page<Blog> searchByCategoryAndName(@Param("name") String name,Pageable pageable, @Param("idCategory") int idCate);
}
