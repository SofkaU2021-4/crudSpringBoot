package com.example.SofkaUdemoSebas.services;


import com.example.SofkaUdemoSebas.Mensaje.Mensaje;
import com.example.SofkaUdemoSebas.models.UserModel;
import com.example.SofkaUdemoSebas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUser(){
        return  (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel getOneUser(long id){
        return  userRepository.findById(id).orElseThrow(() -> new Mensaje("User by id " + id + " was not found"));
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
