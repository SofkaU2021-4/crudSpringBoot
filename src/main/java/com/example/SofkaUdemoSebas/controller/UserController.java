package com.example.SofkaUdemoSebas.controller;


import com.example.SofkaUdemoSebas.models.UserModel;

import com.example.SofkaUdemoSebas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

        if (userServices.existsById(id)) {
            return  new ResponseEntity(userServices.getOneUser(id), HttpStatus.OK);

        } else {
            return new ResponseEntity("no existe el id a buscar", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserModel userModel) {

        userServices.saveUser(userModel);


        return new ResponseEntity("usuario creado con exito",HttpStatus.CREATED);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")long id){

        userServices.deleteUserById(id);
        return new ResponseEntity("usuario eliminado con exito",HttpStatus.OK);
   }

   @PatchMapping("/")
    public  ResponseEntity<?>update( @RequestBody UserModel userModel) {
       if (userServices.existsById(userModel.getId())) {
           boolean response = userServices.updateUser(userModel);
           if(response){
               return new ResponseEntity("Actualizacion ok", HttpStatus.OK);
           }else{
               return new ResponseEntity("Faltan campos", HttpStatus.NOT_ACCEPTABLE);
           }
       } else {
           return new ResponseEntity("no existe el id a modificar", HttpStatus.NOT_FOUND);
       }
   }


}