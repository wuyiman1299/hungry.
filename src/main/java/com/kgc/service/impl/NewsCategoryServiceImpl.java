package com.kgc.service.impl;
import com.kgc.dao.NewsCategoryDao;
import com.kgc.dao.NewsDao;
import com.kgc.dao.impl.NewsCategoryDaoImpl;
import com.kgc.dao.impl.NewsDaoImpl;
import com.kgc.pojo.NewsCategory;
import com.kgc.service.NewsCategoryService;


public class NewsCategoryServiceImpl implements NewsCategoryService {

	private NewsCategoryDao newsCategoryDao;
	private NewsDao newsDao;
	
	public NewsCategoryServiceImpl(){
		newsCategoryDao = new NewsCategoryDaoImpl();
		newsDao = new NewsDaoImpl();
	}

	public void deletCategory(NewsCategory category) {
		int count = newsDao.getCountByCategory(category);
		if(count>0){
			System.out.println("������»������ţ�������ɾ����");
		}else{
			newsCategoryDao.deletCategory(category);
		}
	}

}
