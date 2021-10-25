package com.sherlockmen.blog.dao;

import com.sherlockmen.blog.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query("select t from type_table t")
    List<Type> findTop(Pageable pageable);

}
