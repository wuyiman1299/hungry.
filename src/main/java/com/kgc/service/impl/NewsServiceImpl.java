package com.kgc.service.impl;

import java.util.List;

import com.kgc.dao.NewsDao;
import com.kgc.dao.impl.NewsDaoImpl;
import com.kgc.pojo.News;
import com.kgc.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao = null;
	
	public NewsServiceImpl(){
		newsDao = new NewsDaoImpl();
	}

	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}
	
	// ����������Ϣ
	public boolean add(News news) {
		return newsDao.add(news);
	}
	
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDao.getNewsById(id);
	}
	//��ҳ��ȡ������Ϣ�б�
	public List<News> getPageNewsList(int pageNo,int pageSize){
		return newsDao.getPageNewsList(pageNo, pageSize);
	}
	//��ȡ����������
	public int getTotalCount(){
		return newsDao.getTotalCount();
	}
}
