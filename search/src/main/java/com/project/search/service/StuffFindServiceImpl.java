package com.project.search.service;

import com.project.search.dao.StuffFindDao;
import com.project.search.dto.StuffAddDto;
import com.project.search.model.StuffAddModel;
import com.project.search.model.StuffFindModel;
import com.project.search.repository.StuffAddRepository;
import com.project.search.repository.StuffFindRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StuffFindServiceImpl implements StuffFindService {
	
	@Autowired
    private StuffAddRepository stuffAddRepository;
	
	@Autowired
	private StuffFindRepository stuffFindRepository;

    @Override
    public StuffFindDao findTheStuff(String name) {
    	log.info("getting data from database.....");
    	
    	StuffFindModel stuffFindmodel =  stuffFindRepository.findByName(name);
    	
    	log.info("StuffFindModel from database {}" , stuffFindmodel);
    	
    	StuffFindDao stuffFindDao = StuffFindDao.builder().id(stuffFindmodel.getId())
        			 .name(stuffFindmodel.getName())
        			 .location(stuffFindmodel.getLocation())
        			 .date(stuffFindmodel.getDate())
        			 .build();
    	 
    	 return stuffFindDao;
    }

    @Override
    public void addTheStuff(StuffAddDto stuffAddDto) {
        StuffAddModel stuffAddModel = StuffAddModel.builder()
                .name(stuffAddDto.stuffName)
                .location(stuffAddDto.location)
                .build();
        log.info("Stuff Model to be added to database {}", stuffAddModel);
        stuffAddRepository.save(stuffAddModel);
    }

	@Override
	public void updateTheStuff(StuffAddDto stuffAddDto) {
		// TODO Auto-generated method stub
		StuffAddModel stuffAddModel = StuffAddModel.builder()
                .name(stuffAddDto.stuffName)
                .location(stuffAddDto.location)
                .build();
        log.info("Stuff Model to be added to database {}", stuffAddModel);
        stuffAddRepository.save(stuffAddModel);
	}
}
