package com.project.search.controller;

import com.project.search.dao.StuffFindDao;
import com.project.search.dto.StuffAddDto;
import com.project.search.dto.StuffFindDto;
import com.project.search.service.StuffFindServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
@AllArgsConstructor
public class StuffController {

    private StuffFindServiceImpl stuffFindService;

    @GetMapping(value = "find")
    @ResponseStatus(HttpStatus.OK)
    public StuffFindDto findStuff(@RequestBody StuffFindDao stuffFindDao){
        return stuffFindService.findTheStuff(stuffFindDao);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addStuff(@RequestBody StuffAddDto stuffAddDao){
        return "Details added successfully";
    }

}
