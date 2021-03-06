package com.helpdesk.HelpDesk.Repository;

import com.helpdesk.HelpDesk.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    @Query(value = "SELECT * FROM user where is_agent = 1 ;", nativeQuery = true)
    Iterable<User> getUserAgent();

    @Query(value = "SELECT * FROM user where (is_agent = 1) and (username like ?1 );", nativeQuery = true)
    Iterable<User> getAgentByUsername(String username);

    @Query(value = "SELECT * FROM user where (is_agent = 0) and (is_administrator = 0) ;", nativeQuery = true)
    Iterable<User> getUserUser();

    @Query(value = "SELECT * FROM user where (is_agent = 0) and (username like ?1 );", nativeQuery = true)
    Iterable<User> getUserByUsername(String username);

    @Query(value = "SELECT * FROM user where (is_administrator = 1) ;", nativeQuery = true)
    Iterable<User> getAdministrator();

    @Query(value = "SELECT * FROM user where (username like ?1 ) ;", nativeQuery = true)
    Iterable<User> getPerson(String username);
}