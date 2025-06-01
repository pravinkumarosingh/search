package com.project.search.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuffFindDao {
	private Integer id;
    private String name;
    private String location;
    private String date;
}
