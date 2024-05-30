package com.testbeackenddeveloper.fikrizulfikarkusmana.repository;

import com.testbeackenddeveloper.fikrizulfikarkusmana.model.Penilaian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenilaianRepository extends JpaRepository<Penilaian, Long> {
}
