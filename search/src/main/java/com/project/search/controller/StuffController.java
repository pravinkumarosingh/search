package com.project.search.controller;

import com.project.search.dao.StuffFindDao;
import com.project.search.dto.StuffAddDto;
import com.project.search.service.StuffFindServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search/api")
@Slf4j
@Tag(name = "Stuff Controller" , description = "APIs to add, update, get, delete stuffs")
@CrossOrigin(origins = "http://localhost:3000")
public class StuffController {
	
	@Autowired
    private StuffFindServiceImpl stuffFindService;

    @GetMapping(value = "find")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Stuff Search API" , description = "API to search the stuff details")
    public StuffFindDao findStuff(@Param(value = "name") String name){
    	log.info("Pattern request received: {}" , name);
        return stuffFindService.findTheStuff(name);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Stuff Add API" , description = "API to add the stuff details")
    public String addStuff(@RequestBody StuffAddDto stuffAddDto){
        stuffFindService.addTheStuff(stuffAddDto);
        return "Details added successfully";
    }
    
    @PutMapping(value = "update")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Stuff Details Update API" , description = "API to update the stuff details")
    public String updateStuff(@RequestBody StuffAddDto stuffAddDto) {
    	stuffFindService.updateTheStuff(stuffAddDto);
    	return "Details updated successfully";
    }
    
    
    @DeleteMapping(value = "delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Stuff Delete API" , description = "API to delete stuff details")
    public String deleteStuff(@Param(value = "name") String name) {
    	stuffFindService.deleteTheStuff(name);
    	return "Details deleted successfully";
    }

}
