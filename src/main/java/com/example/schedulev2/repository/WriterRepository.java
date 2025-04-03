package com.example.schedulev2.repository;

import com.example.schedulev2.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {

    Optional<Writer> findWriterByEmailAndPassword(String email,String password);

    default Writer findByIdOrElseThrow(Long writer_id){
        return findById(writer_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Does not exist writer_id: " + writer_id));
    }

    default Writer findWriterByEmailAndPasswordOrElseThrow(String email, String password) {
        return findWriterByEmailAndPassword(email,password).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "이메일이나 패스워드가 틀려서 로그인 실패했습니다."));
    }
}
