package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.news.Bulletin;

public interface NewsDAO {
	public List<Bulletin> getNewsList();//最新消息list
	public List<Bulletin> getNewsBranchList(Bulletin bulletin);//細項最新消息list
	public List<Bulletin> getFileList(Bulletin bulletin);//附件list
	public Bulletin getNewsDetail(Bulletin bulletin);//消息細節
	public void newsUpdate(Bulletin bulletin);//修改公告
	public void newsInsert(Bulletin bulletin);//新增公告
	public void newsDelete(Bulletin bulletin);//刪除公告
	public void fileInsert(List<String> fileNames);//新增附件
	public boolean fileNameCheck(List<String> fileNames);//檢查附件名稱是否相同
}
