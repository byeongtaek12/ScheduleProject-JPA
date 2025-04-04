package com.example.schedulev2.repository;

import com.example.schedulev2.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {

    Optional<Writer> findWriterByEmail(String email);

}
