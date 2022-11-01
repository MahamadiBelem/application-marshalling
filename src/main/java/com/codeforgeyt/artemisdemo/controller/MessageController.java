package com.codeforgeyt.artemisdemo.controller;

import com.codeforgeyt.artemisdemo.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/****************************************
 * 
 * Author: Mahamadi BELEM
 ****************************************/

@RestController
public class MessageController {

    @Autowired
    DispatcherService dispatcherService;

    /******************************
     * @param model
     * @return
     ******************************/

    @GetMapping("/")
	public String viewHomePage(Model model) {
		return  "Bienvenue ! Vous Decouvrerez Ici Une IMPLEMENTATION TECHNIQUE  A travers Artemis MQ et Spring-boot" ;
    }


    @PostMapping(value="/send")
    public ResponseEntity<String> send(@RequestBody String message){
        dispatcherService.sendMessage(message);
        return new ResponseEntity<>("Message sent: " + message, HttpStatus.OK);
    }



      /* findPaginated(1, "firstName", "asc", model); 
    private String findPaginated(int i, String string, String string2, Model model) {
        return null} */
}

