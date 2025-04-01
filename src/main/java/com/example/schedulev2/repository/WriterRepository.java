package com.example.schedulev2.repository;

import com.example.schedulev2.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {

    default Writer findByIdOrElseThrow(Long writer_id){
        return findById(writer_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Does not exist writer_id: " + writer_id));
    }
}
