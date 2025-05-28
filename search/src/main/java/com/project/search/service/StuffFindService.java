package com.project.search.service;



import com.project.search.dao.StuffFindDao;
import com.project.search.dto.StuffAddDto;


public interface StuffFindService {

    public StuffFindDao findTheStuff(String name);

    public void addTheStuff(StuffAddDto stuffAddDto);
    
    public void updateTheStuff(StuffAddDto stuffAddDto);

}
