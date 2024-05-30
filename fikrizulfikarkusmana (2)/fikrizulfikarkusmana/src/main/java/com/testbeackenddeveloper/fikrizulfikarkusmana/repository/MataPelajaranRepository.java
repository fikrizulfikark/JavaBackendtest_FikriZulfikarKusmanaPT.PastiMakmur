package com.testbeackenddeveloper.fikrizulfikarkusmana.repository;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.MataPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MataPelajaranRepository extends JpaRepository<MataPelajaran, Integer> {
}
