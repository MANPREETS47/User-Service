package org.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.example.model.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class UserController {
    

    @Autowired
    private UserService userService;

    @GetMapping("/user/v1/getUser")
    public ResponseEntity<?> getUser(@RequestBody UserInfoDto userinfoDto){
        try{
            UserInfoDto userInfo = userService.getUser(userinfoDto);
            return ResponseEntity.ok(userInfo);
        }catch(Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    
}
