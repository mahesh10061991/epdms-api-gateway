package com.topia.epdms.repository;

import com.topia.epdms.model.Users;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Users, Integer> {
    Mono<Users> findByUsername(String username);
}
