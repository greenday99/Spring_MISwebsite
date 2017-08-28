package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.course.SchedulePlan;


public interface SchedulePlanDAO {
	public List<SchedulePlan> getSchedulePlanListU();
	public List<SchedulePlan> getSchedulePlanListM();
	public List<SchedulePlan> getSchedulePlanListE();
	public List<SchedulePlan> getSchedulePlanListD();
	public List<SchedulePlan> getSchedulePlanListF();
	public List<SchedulePlan> getPlanList();
	public void update(SchedulePlan scheduleplan);
}
