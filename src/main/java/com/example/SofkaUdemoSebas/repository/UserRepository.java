package com.example.SofkaUdemoSebas.repository;


import com.example.SofkaUdemoSebas.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long> {
}
