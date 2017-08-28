package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.teachresult.*;

public interface Teach_ResultDAO {
	public List<Sym> getSymList();
	public List<String> getGraYearList();
	public List<Graduation> getGraduationList();
	public List<Graduation> getMasterPaperList();
	public List<Graduation> getEMasterPaperList();
	public List<Category> getMasterCategory();
	public List<String> getMasterPaperYear();
	public List<String> getEMasterPaperYear();
	public List<Award> getAwardList();
	
	public void insertSym(Sym sym);
	public void insertGraduation(Graduation graduation);
	public void insertTea_stu_paper(Graduation paperInfo);
	public void insertAward(Award award);
	
	public void deleteSym(Sym sym);
	public void deleteGraduation(Graduation graduation);
	public void deleteTea_stu_paper(String paperid);
	public void deleteAward(Award award);
	
	public void updateSym(Sym sym);
	public void updateGraduation(Graduation graduation);
	public void updateTea_stu_paper(Graduation info);
	public void updateAward(Award award);
	
	public Sym get(Sym sym);
	public Graduation get(Graduation graduation);
	public Tea_stu_paper get(Tea_stu_paper tea_stu_paper);
	public Award get(Award award);
	public Sym getSym(int sym_code);
	public Graduation getGraduation(String gra_code);
	public Graduation getTea_stu_paper(String paperid);
	public Award getAward(int articleid);
	
}
