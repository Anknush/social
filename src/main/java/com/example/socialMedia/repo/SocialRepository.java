package com.example.socialMedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.socialMedia.model.UserModel;

@Repository
public interface SocialRepository extends JpaRepository<UserModel, Integer> {

}
