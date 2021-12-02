package com.kgc.service;

import java.util.List;

import com.kgc.pojo.News;

public interface NewsService {
	//��ҳ��ȡ������Ϣ�б�
	public List<News> getPageNewsList(int pageNo, int pageSize);
	// ��ѯ������Ϣ
	public List<News> getNewsList();
	
	// ����������Ϣ
	public boolean add(News news) ;
	
	//��������ID��ѯ������Ϣ
	public News getNewsById(int id);
	
	//��ȡ����������
	public int getTotalCount();
}
