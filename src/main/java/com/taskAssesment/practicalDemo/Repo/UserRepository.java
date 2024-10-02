package com.taskAssesment.practicalDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskAssesment.practicalDemo.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
