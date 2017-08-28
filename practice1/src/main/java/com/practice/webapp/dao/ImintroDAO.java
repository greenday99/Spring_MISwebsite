package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.introduction.Imintro;
import com.practice.webapp.entity.introduction.NewInfoGu;
import com.practice.webapp.entity.introduction.Assitant;
import com.practice.webapp.entity.introduction.AssitantWork;
import com.practice.webapp.entity.introduction.Award;

public interface ImintroDAO {

	public List<Imintro> getList(Imintro imintro);
	public Imintro get(Imintro imintro);
	public Imintro gettwo(Imintro imintro, String dic_code);
	public Imintro getthree(Imintro imintro, String dic_code);
	
	public List<Assitant> getassitantList();
	public List<AssitantWork> getassitantWorkList(Assitant assitant);//
	public AssitantWork getassitantWork(Assitant assitant);
	
	public List<Award> getawardList();//�o���O��
	public List<Imintro> getfile(Imintro imintro);//�t�j�Ƭ�
	public List<Imintro> getAll();//department introduction + department introduation class
	public List<Imintro> getDeptIntro();//department introduction
	public Imintro getdiccont(Imintro imintro);//get dic_cont
	public void update(Imintro imintro);//update deptintro
	public void delete(Imintro imintro);//delete deptintro
	public void insert(Imintro imintro);//insert deptintro
	public void updateaward(Award award);//update award
	public Award getaward(Award award);//get award
	public void updateass(Assitant assitant);//update assitant
	public Assitant getass(Assitant assitant);//get assitant 
	public void updateworkcontent(AssitantWork assitantWork);//update updateworkcontent
	public void insertworkcontent(AssitantWork assitantWork);//�s�W�U�Фu�@
	public void insertass(List<String> fileNames,NewInfoGu newInfo);//�s�W�U��
	public void updatepic(List<String> fileNames, Assitant assitant);//��s�U�зӤ�
	public void updatexidafile(List<String> fileNames, Imintro imintro);//��s�t�j�Ƭ�+��k�ɮ�
	public void uploadfile(List<String> fileNames, Imintro imintro);//�s�W�ɮ�
	
	
}
