package com.tticareer.hrms.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

<<<<<<< HEAD
public class ExtjsPageRequest {

	private int 	page 	= 0;
	private int 	limit	= 20;
=======
public class ExtjsPageRequest 
{
	private int 	page 	= 1;
	private int 	limit	=15;
>>>>>>> 78870184fc8b79adf984df8907b833d3da127536
	private String  sort	= "id";
	private String  dir 	= "DESC";
	
	public void setPage(int page) {this.page = page;}
	public void setLimit(int limit) {this.limit = limit;}
	public void setSort(String sort) {this.sort = sort;}
	public void setDir(String dir) {this.dir = dir;}
	
<<<<<<< HEAD
	
	
	public int getPage() {
		return page;
	}
	public int getLimit() {
		return limit;
	}
	public String getSort() {
		return sort;
	}
	public String getDir() {
		return dir;
	}
	
=======
>>>>>>> 78870184fc8b79adf984df8907b833d3da127536
	public Pageable getPageable() 
	{
		Pageable pageable = null;
		if(!sort.trim().equals("") && !dir.trim().equals("")) 
		{
			Sort pageSort = new Sort(Direction.DESC,sort);
			if(!dir.equals("DESC")) {
				pageSort = new Sort(Direction.ASC,sort);
			}
			pageable =  PageRequest.of(page-1, limit,pageSort); 
		}else {
			pageable = PageRequest.of(page-1, limit);
		}
		return pageable;
	}
}
<<<<<<< HEAD
=======

>>>>>>> 78870184fc8b79adf984df8907b833d3da127536
