package com.project.search.controller;

import com.project.search.dao.StuffFindDao;
import com.project.search.dto.StuffAddDto;
import com.project.search.service.StuffFindServiceImpl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search/api")
@Slf4j
public class StuffController {
	
	@Autowired
    private StuffFindServiceImpl stuffFindService;

    @GetMapping(value = "find")
    @ResponseStatus(HttpStatus.OK)
    public StuffFindDao findStuff(@Param(value = "name") String name){
    	log.info("Pattern request received: {}" , name);
        return stuffFindService.findTheStuff(name);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addStuff(@RequestBody StuffAddDto stuffAddDto){
        stuffFindService.addTheStuff(stuffAddDto);
        return "Details added successfully";
    }
    
    @PutMapping(value = "update")
    @ResponseStatus(HttpStatus.OK)
    public String updateStuff(@RequestBody StuffAddDto stuffAddDto) {
    	stuffFindService.updateTheStuff(stuffAddDto);
    	return "Details updated successfully";
    }
    
    
    @DeleteMapping(value = "delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteStuff(@RequestBody String stuffName) {
    	return "Details deleted successfully";
    }

}
