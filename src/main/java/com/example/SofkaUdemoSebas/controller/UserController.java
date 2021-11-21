package com.example.SofkaUdemoSebas.controller;


import com.example.SofkaUdemoSebas.models.UserModel;
import com.example.SofkaUdemoSebas.repository.UserRepository;
import com.example.SofkaUdemoSebas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario" )
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
    @Autowired
    UserServices userServices;

    @GetMapping("/")
    public ResponseEntity<?> list() {

        return new ResponseEntity(userServices.getUser(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> list(@PathVariable("id")long id) {

        return new ResponseEntity(userServices.getOneUser(id),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserModel userModel) {

        userServices.saveUser(userModel);


        return new ResponseEntity("usuario creado con exito",HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")long id){

        userServices.deleteUserById(id);
        return new ResponseEntity("usuario eliminado con exito",HttpStatus.OK);
   }

}