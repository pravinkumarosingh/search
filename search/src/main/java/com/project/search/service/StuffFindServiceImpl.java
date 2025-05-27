package com.project.search.service;

import com.project.search.dao.StuffFindDao;
import com.project.search.dto.StuffAddDto;
import com.project.search.dto.StuffFindDto;
import com.project.search.model.StuffAddModel;
import com.project.search.repository.StuffFindRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StuffFindServiceImpl implements StuffFindService {
	
	@Autowired
    private StuffFindRepository stuffFindRepository;

    @Override
    public StuffFindDao findTheStuff(String name) {
    	 StuffAddModel stuffAddModel =  stuffFindRepository.findStuffByNameLike(name);
    	 log.info("Stuff model from database {}",stuffAddModel);
    	 StuffFindDao stuffFindDao = StuffFindDao.builder().id(stuffAddModel.getId())
    			 .name(stuffAddModel.getName())
    			 .location(stuffAddModel.getLocation())
    			 .date(stuffAddModel.getDate())
    			 .build();
    			 
    	 
    	 return stuffFindDao;
    }

    @Override
    public void addTheStuff(StuffAddDto stuffAddDto) {
        StuffAddModel stuffAddModel = StuffAddModel.builder()
                .name(stuffAddDto.stuffName)
                .location(stuffAddDto.location)
                .build();
        stuffFindRepository.save(stuffAddModel);
    }
}
