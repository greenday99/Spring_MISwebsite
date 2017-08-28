package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.news.Bulletin;

public interface NewsDAO {
	public List<Bulletin> getNewsList();//�̷s����list
	public List<Bulletin> getNewsBranchList(Bulletin bulletin);//�Ӷ��̷s����list
	public List<Bulletin> getFileList(Bulletin bulletin);//����list
	public Bulletin getNewsDetail(Bulletin bulletin);//�����Ӹ`
	public void newsUpdate(Bulletin bulletin);//�ק綠�i
	public void newsInsert(Bulletin bulletin);//�s�W���i
	public void newsDelete(Bulletin bulletin);//�R�����i
	public void fileInsert(List<String> fileNames);//�s�W����
	public boolean fileNameCheck(List<String> fileNames);//�ˬd����W�٬O�_�ۦP
}
