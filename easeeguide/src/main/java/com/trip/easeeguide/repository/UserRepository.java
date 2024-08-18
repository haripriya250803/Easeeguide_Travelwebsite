package com.trip.easeeguide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trip.easeeguide.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}