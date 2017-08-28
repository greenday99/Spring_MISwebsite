package com.practice.webapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.NewsDAO;
import com.practice.webapp.entity.news.Bulletin;

@Controller
public class NewsController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	
	/*get 程穝*/
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ModelAndView getNews(){
		ModelAndView model = new ModelAndView("news");
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");		
		List<Bulletin> getNewsList = new ArrayList<Bulletin>();
		getNewsList = newsDAO.getNewsList();
		model.addObject("getNewsList", getNewsList);		
		return model;
	}
	
	/*get 灿兜程穝*/
	@RequestMapping(value = "/newsBranch", method = RequestMethod.GET)
	public ModelAndView getNewsBranch(@ModelAttribute Bulletin bulletin){
		ModelAndView model = new ModelAndView("newsBranch");
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");		
		List<Bulletin> getNewsBranchList = new ArrayList<Bulletin>();
		getNewsBranchList = newsDAO.getNewsBranchList(bulletin);
		model.addObject("getNewsBranchList", getNewsBranchList);	
		
		return model;
	}
	
	/*get 程穝灿竊*/
	@RequestMapping(value = "/newsDetail", method = RequestMethod.GET)
	public ModelAndView getNewsDetail(@ModelAttribute Bulletin bulletin){
		ModelAndView model = new ModelAndView("newsDetail");
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");
		Bulletin getNewsDetail = new Bulletin();
		getNewsDetail = newsDAO.getNewsDetail(bulletin);
		model.addObject("getNewsDetail", getNewsDetail);
		
		List<Bulletin> getFileList = new ArrayList<Bulletin>();
		getFileList = newsDAO.getFileList(bulletin);
		model.addObject("getFileList", getFileList);
		return model;
	}
	
	/*get 籓程穝*/
	@RequestMapping(value = "/admin/newsAdmin", method = RequestMethod.GET)
	public ModelAndView getNewsAdmin(){
		ModelAndView model = new ModelAndView("newsAdmin");
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");	
		List<Bulletin> getNewsList = new ArrayList<Bulletin>();
		getNewsList = newsDAO.getNewsList();
		model.addObject("getNewsList", getNewsList);		
		return model;
	}
	
	/*get э程穝*/
	@RequestMapping(value = "/admin/newsUpdate", method = RequestMethod.GET)
	public ModelAndView getNewsUpdate(@ModelAttribute Bulletin bulletin){
		ModelAndView model = new ModelAndView("newsUpdate");
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");
		Bulletin getNewsDetail = new Bulletin();
		getNewsDetail = newsDAO.getNewsDetail(bulletin);
		model.addObject("getNewsDetail", getNewsDetail);		
		return model;
	}
	
	/*post э程穝*/
	@RequestMapping(value = "/admin/newsUpdate", method = RequestMethod.POST)
	public ModelAndView postNewsUpdate(@ModelAttribute Bulletin bulletin){
		ModelAndView model = new ModelAndView("redirect:/admin/newsAdmin");
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");		
		newsDAO.newsUpdate(bulletin);		
		return model;
	}
	
	boolean check = false;
	/*get 穝糤そ*/
	@RequestMapping(value = "/admin/newsInsert", method = RequestMethod.GET)
	public ModelAndView getNewsInsert(){
		ModelAndView model = new ModelAndView("newsInsert");	
		if(check)
		{
			model.addObject("message", "狡ン嘿");
			check = false;
		}
		return model;
	}
	
	/*post 穝糤そ*/
	@RequestMapping(value = "/admin/newsInsert", method = RequestMethod.POST)
	public ModelAndView postNewsInsert(@ModelAttribute Bulletin bulletin, HttpServletRequest request)
			throws IllegalStateException, IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/newsAdmin");	
		ModelAndView modelCheck = new ModelAndView("redirect:/admin/newsInsert");	
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");	
		
		String savePath = request.getSession().getServletContext().getRealPath("/") + "img/news/";
		List<MultipartFile> files = bulletin.getFiles();
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {
				String fileName = multipartFile.getOriginalFilename();
				if (!"".equalsIgnoreCase(fileName)) {
					multipartFile.transferTo(new File(savePath + fileName));
					fileNames.add(fileName);
				}
			}
			
			if(newsDAO.fileNameCheck(fileNames))
				newsDAO.fileInsert(fileNames);
			else
			{
				check = true;
				return modelCheck;
			}
		}
				
		newsDAO.newsInsert(bulletin);
		
		return model;
	}
	
	/*get 埃そ*/
	@RequestMapping(value = "/admin/newsDelete", method = RequestMethod.GET)
	public ModelAndView getNewsDelete(@ModelAttribute Bulletin bulletin){
		ModelAndView model = new ModelAndView("redirect:/admin/newsAdmin");	
		NewsDAO newsDAO = (NewsDAO) context.getBean("newsDAO");	
		newsDAO.newsDelete(bulletin);
		return model;
	}
}
