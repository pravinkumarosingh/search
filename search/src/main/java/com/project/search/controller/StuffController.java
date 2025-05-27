package com.project.search.controller;

import com.project.search.dao.StuffFindDao;
import com.project.search.dto.StuffAddDto;
import com.project.search.dto.StuffFindDto;
import com.project.search.service.StuffFindServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class StuffController {
	
	@Autowired
    private StuffFindServiceImpl stuffFindService;

    @GetMapping(value = "find")
    @ResponseStatus(HttpStatus.OK)
    public StuffFindDao findStuff(@RequestBody String name){
        return stuffFindService.findTheStuff(name);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addStuff(@RequestBody StuffAddDto stuffAddDto){
        stuffFindService.addTheStuff(stuffAddDto);
        return "Details added successfully";
    }

}
