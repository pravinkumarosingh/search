package com.project.search.service;



import com.project.search.dao.StuffFindDao;
import com.project.search.dto.StuffFindDto;


public interface StuffFindService {

    public StuffFindDto findTheStuff(StuffFindDao stuffFindDao);

}
