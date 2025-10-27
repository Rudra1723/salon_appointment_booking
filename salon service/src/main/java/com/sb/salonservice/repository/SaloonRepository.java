package com.sb.salonservice.repository;

import com.sb.salonservice.model.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaloonRepository extends JpaRepository<Saloon, Long> {

    Saloon findByOwnerId(Long id);

    @Query(
            "select s from Saloon s where " +
                    "(lower(s.city) like lower(concat('%', :keyword, '%')) OR " +
                    " lower(s.name) like lower(concat('%', :keyword, '%')) OR " +
                    " lower(s.address) like lower(concat('%', :keyword, '%')))"
    )
    List<Saloon> searchSaloon(@Param("keyword") String keyword);

}