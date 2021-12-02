package com.kgc.dao;

import java.util.List;

import com.kgc.pojo.News;
import com.kgc.pojo.NewsCategory;

public interface NewsDao {
	//��������Դ��ȡ������Ϣ
	public void getNewsListByDS() ;

	// ��ѯ������Ϣ
	public List<News> getNewsList();

	// ����������Ϣ
	public boolean add(News news) ;
	// �޸����ű���
	public void update(News news);
	// ɾ��������Ϣ
	public void delete(News news);

	// �����ض������������Ϣ
	public void getNewsByTitle(News news);
	
	//��ȡĳ���������������
	public int getCountByCategory(NewsCategory category);
	
	//��������ID�õ�������Ϣ
	public News getNewsById(int id);
	
	//��ȡ����������
	public int getTotalCount();
	
	//��ҳ��ȡ������Ϣ
	public List<News> getPageNewsList(int pageNo, int pageSize);
}
