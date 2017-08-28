package com.practice.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import com.practice.webapp.dao.ImintroDAO;

import com.practice.webapp.entity.introduction.Assitant;
import com.practice.webapp.entity.introduction.AssitantWork;
import com.practice.webapp.entity.introduction.Award;
import com.practice.webapp.entity.introduction.Imintro;
import com.practice.webapp.entity.introduction.NewInfoGu;

@Controller
public class ImintroController {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/Imintro", method = RequestMethod.GET)
	public ModelAndView getImintroList(@ModelAttribute Imintro imintro) {
		ModelAndView model = new ModelAndView("Imintro");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		List<Imintro> imintroList = new ArrayList<Imintro>();
		imintroList = imintroDAO.getList(imintro);
		model.addObject("imintroList", imintroList);
		return model;
	}

	@RequestMapping(value = "/assitant", method = RequestMethod.GET)
	public ModelAndView getassitantList() {
		ModelAndView model = new ModelAndView("assitant");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		List<Assitant> assitantList = new ArrayList<Assitant>();
		assitantList = imintroDAO.getassitantList();
		model.addObject("assitantList", assitantList);

		return model;
	}

	@RequestMapping(value = "/Imintro2", method = RequestMethod.GET)
	public ModelAndView getImintroList2(@ModelAttribute Imintro imintro) {
		ModelAndView model = new ModelAndView("deptintro");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		Imintro imintro1 = new Imintro();
		imintro1 = imintroDAO.gettwo(imintro, "1");
		model.addObject("imintro1", imintro1);

		Imintro imintro2 = new Imintro();
		imintro2 = imintroDAO.gettwo(imintro, "2");
		model.addObject("imintro2", imintro2);

		Imintro imintro3 = new Imintro();
		imintro3 = imintroDAO.getthree(imintro, "3");
		model.addObject("imintro3", imintro3);

		List<Imintro> getfileList = new ArrayList<Imintro>();
		getfileList = imintroDAO.getfile(imintro);
		model.addObject("getfileList", getfileList);

		return model;
	}

	@RequestMapping(value = "/admin/back_imintro", method = RequestMethod.GET)
	public ModelAndView getImintroBackList() {
		ModelAndView model = new ModelAndView("fix");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		List<Imintro> getAll = new ArrayList<Imintro>();
		getAll = imintroDAO.getAll();
		model.addObject("getAll", getAll);

		List<Imintro> getDeptIntro = new ArrayList<Imintro>();
		getDeptIntro = imintroDAO.getDeptIntro();
		model.addObject("getDeptIntro", getDeptIntro);

		return model;
	}

	@RequestMapping(value = "/award", method = RequestMethod.GET)
	public ModelAndView getawardList() {
		ModelAndView model = new ModelAndView("award");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		List<Award> awardList = new ArrayList<Award>();
		awardList = imintroDAO.getawardList();
		model.addObject("awardList", awardList);

		return model;
	}

	@RequestMapping(value = "/admin/updatedeptintro", method = RequestMethod.GET)
	public ModelAndView updatedeptintroget(@ModelAttribute Imintro imintro) {
		ModelAndView model = new ModelAndView("updatedeptintro");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		Imintro updatedeptintro = new Imintro();
		updatedeptintro = imintroDAO.getdiccont(imintro);
		model.addObject("updatedeptintro", updatedeptintro);

		List<Imintro> getfileList = new ArrayList<Imintro>();
		getfileList = imintroDAO.getfile(imintro);
		model.addObject("getfileList", getfileList);

		return model;
	}

	@RequestMapping(value = "/admin/updatedeptintro", method = RequestMethod.POST)
	public ModelAndView updatedeptintropost(@ModelAttribute Imintro imintro, HttpServletRequest request)
			throws IllegalStateException, IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/back_imintro");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");
		imintroDAO.update(imintro);

		if (imintro.getFile_url() != null) {
			String saveDirectory2 = request.getSession().getServletContext().getRealPath("/") + "img/asistant/";

			List<MultipartFile> crunchifyFiles = imintro.getFiles();
			List<String> fileNames = new ArrayList<String>();

			if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
				for (MultipartFile multipartFile : crunchifyFiles) {

					String fileName = multipartFile.getOriginalFilename();
					if (!"".equalsIgnoreCase(fileName)) {
						multipartFile.transferTo(new File(saveDirectory2 + fileName));
						fileNames.add(fileName);
					}
				}
			}
			if (fileNames.size() != 0) {
				imintroDAO.updatexidafile(fileNames, imintro);
				model.addObject("fileNames", fileNames);
			}

		}
		return model;
	}

	@RequestMapping(value = "/admin/deletedeptintro", method = RequestMethod.POST)
	public ModelAndView deleteImintro(@ModelAttribute Imintro imintro) {
		ModelAndView model = new ModelAndView("redirect:/admin/back_imintro");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");
		imintroDAO.delete(imintro);

		return model;
	}

	@RequestMapping(value = "/admin/insertdeptintro", method = RequestMethod.GET)
	public ModelAndView insertdeptintroget(@ModelAttribute Imintro imintro) {
		ModelAndView model = new ModelAndView("insertdeptintro");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		Imintro insertdeptintro = new Imintro();
		insertdeptintro = imintroDAO.getdiccont(imintro);
		model.addObject("insertdeptintro", insertdeptintro);
		return model;
	}

	@RequestMapping(value = "/admin/insertdeptintro", method = RequestMethod.POST)
	public ModelAndView insertdeptintropost(@ModelAttribute Imintro imintro) {
		ModelAndView model = new ModelAndView("redirect:/admin/back_imintro");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");
		imintroDAO.insert(imintro);

		return model;
	}

	// @RequestMapping(value = "/upload", method = RequestMethod.GET)
	// public ModelAndView upload() {
	// ModelAndView model = new ModelAndView("fileupload");
	// return model;
	// }
	//
	// @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
	// public ModelAndView savefiles(@ModelAttribute Fileupload fileupload)
	// throws IllegalStateException, IOException {
	// ModelAndView model = new ModelAndView("fileuploadsuccess");
	//
	// String saveDirectory = "d:/crunchify/";
	//
	// List<MultipartFile> crunchifyFiles = fileupload.getFiles();
	//
	// List<String> fileNames = new ArrayList<String>();
	//
	// if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
	// for (MultipartFile multipartFile : crunchifyFiles) {
	//
	// String fileName = multipartFile.getOriginalFilename();
	// if (!"".equalsIgnoreCase(fileName)) {
	// // Handle file content - multipartFile.getInputStream()
	// multipartFile.transferTo(new File(saveDirectory + fileName));
	// fileNames.add(fileName);
	// }
	// }
	// }
	//
	// model.addObject("fileNames", fileNames);
	//
	// return model;
	// }

	// award
	@RequestMapping(value = "/admin/back_award", method = RequestMethod.GET)
	public ModelAndView getbackaward() {
		ModelAndView model = new ModelAndView("back_award");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		List<Award> getAward = new ArrayList<Award>();
		getAward = imintroDAO.getawardList();
		model.addObject("getAward", getAward);

		return model;
	}

	@RequestMapping(value = "/admin/updateaward", method = RequestMethod.GET)
	public ModelAndView updateaward(@ModelAttribute Award award) {

		ModelAndView model = new ModelAndView("updateaward");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		Award updateaward = new Award();
		updateaward = imintroDAO.getaward(award);
		model.addObject("updateaward", updateaward);
		return model;
	}

	@RequestMapping(value = "/admin/updateaward", method = RequestMethod.POST)
	public ModelAndView updateawardpost(@ModelAttribute Award award) {
		ModelAndView model = new ModelAndView("redirect:/admin/back_award");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");
		imintroDAO.updateaward(award);

		return model;
	}

	// ass
	@RequestMapping(value = "/admin/back_updateass", method = RequestMethod.GET)
	public ModelAndView getbackass() {
		ModelAndView model = new ModelAndView("back_updateass");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		List<Assitant> getAss = new ArrayList<Assitant>();
		getAss = imintroDAO.getassitantList();
		model.addObject("getAss", getAss);

		return model;
	}

	@RequestMapping(value = "/admin/updateass", method = RequestMethod.GET)
	public ModelAndView updateass(@ModelAttribute Assitant assitant) {

		ModelAndView model = new ModelAndView("updateass");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		Assitant updateass = new Assitant();
		updateass = imintroDAO.getass(assitant);
		model.addObject("updateass", updateass);
		return model;
	}

	@RequestMapping(value = "/admin/updateass", method = RequestMethod.POST)
	public ModelAndView updateasspost(@ModelAttribute Assitant assitant, HttpServletRequest request)
			throws IllegalStateException, IOException {
		// System.out.println(assitant.getM_ldap());
		ModelAndView model = new ModelAndView("redirect:/admin/back_updateass");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");
		imintroDAO.updateass(assitant);

		String saveDirectory2 = request.getSession().getServletContext().getRealPath("/") + "img/asistant/";

		List<MultipartFile> crunchifyFiles = assitant.getFiles();
		// System.out.println(crunchifyFiles.size());
		List<String> fileNames = new ArrayList<String>();

		if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
			for (MultipartFile multipartFile : crunchifyFiles) {

				String fileName = multipartFile.getOriginalFilename();
				if (!"".equalsIgnoreCase(fileName)) {
					multipartFile.transferTo(new File(saveDirectory2 + fileName));
					fileNames.add(fileName);
				}
			}
			if (fileNames.size() != 0) {
				imintroDAO.updatepic(fileNames, assitant);
				model.addObject("fileNames", fileNames);
			}
		}
		return model;
	}

	@RequestMapping(value = "/admin/updateworkcontent", method = RequestMethod.GET)
	public ModelAndView updateworkcontent(@ModelAttribute Assitant assitant) {

		ModelAndView model = new ModelAndView("updateworkcontent");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		List<AssitantWork> updateworkcontent = new ArrayList<AssitantWork>();
		updateworkcontent = imintroDAO.getassitantWorkList(assitant);
		model.addObject("updateworkcontent", updateworkcontent);
		return model;
	}

	@RequestMapping(value = "/admin/updateworkcontent", method = RequestMethod.POST)
	public ModelAndView updateworkcontentpost(@ModelAttribute AssitantWork assitantWork) {
		ModelAndView model = new ModelAndView("redirect:/admin/back_updateass");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");
		imintroDAO.updateworkcontent(assitantWork);

		return model;
	}

	@RequestMapping(value = "/admin/insertworkcontent", method = RequestMethod.GET)
	public ModelAndView insertworkcontentget(@ModelAttribute Assitant assitant) {
		ModelAndView model = new ModelAndView("insertworkcontent");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		AssitantWork insertworkcontent = new AssitantWork();
		insertworkcontent = imintroDAO.getassitantWork(assitant);
		model.addObject("insertworkcontent", insertworkcontent);

		return model;
	}

	@RequestMapping(value = "/admin/insertworkcontent", method = RequestMethod.POST)
	public ModelAndView insertworkcontentpost(@ModelAttribute AssitantWork assitantWork) {
		ModelAndView model = new ModelAndView("redirect:/admin/back_updateass");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");
		imintroDAO.insertworkcontent(assitantWork);

		return model;
	}

	@RequestMapping(value = "/admin/insertass", method = RequestMethod.GET)
	public ModelAndView insertassget() {
		ModelAndView model = new ModelAndView("insertasistant");

		return model;
	}

	@RequestMapping(value = "/admin/insertass", method = RequestMethod.POST)
	public ModelAndView insertasspost(@ModelAttribute NewInfoGu assitant, HttpServletRequest request)
			throws IllegalStateException, IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/back_updateass");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		String saveDirectory2 = request.getSession().getServletContext().getRealPath("/") + "img/asistant/";

		// if(assitant.getFiles() == null)
		// {

		List<MultipartFile> crunchifyFiles = assitant.getFiles();
		List<String> fileNames = new ArrayList<String>();
		if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
			for (MultipartFile multipartFile : crunchifyFiles) {

				String fileName = multipartFile.getOriginalFilename();
				if (!"".equalsIgnoreCase(fileName)) {
					multipartFile.transferTo(new File(saveDirectory2 + fileName));
					fileNames.add(fileName);
				}
			}
		}

		imintroDAO.insertass(fileNames, assitant);
		model.addObject("fileNames", fileNames);
		// }

		return model;
	}

	// 上傳檔案
	@RequestMapping(value = "/admin/uploadfile", method = RequestMethod.GET)
	public ModelAndView uploadfileget(@ModelAttribute Imintro imintro) {
		ModelAndView model = new ModelAndView("uploadfile");

		Imintro fileimintro = new Imintro();
		fileimintro.setDi_code(imintro.getDi_code());
		fileimintro.setDic_code(imintro.getDic_code());
		model.addObject("fileimintro", imintro);

		return model;
	}

	@RequestMapping(value = "/admin/uploadfile", method = RequestMethod.POST)
	public ModelAndView uploadfilepost(@ModelAttribute Imintro imintro, HttpServletRequest request)
			throws IllegalStateException, IOException {
		ModelAndView model = new ModelAndView("redirect:/admin/back_imintro");
		ImintroDAO imintroDAO = (ImintroDAO) context.getBean("imintroDAO");

		String saveDirectory2 = request.getSession().getServletContext().getRealPath("/") + "img/asistant/";

		List<MultipartFile> crunchifyFiles = imintro.getFiles();
		List<String> fileNames = new ArrayList<String>();

		if (null != crunchifyFiles && crunchifyFiles.size() > 0) {
			for (MultipartFile multipartFile : crunchifyFiles) {

				String fileName = multipartFile.getOriginalFilename();
				if (!"".equalsIgnoreCase(fileName)) {
					multipartFile.transferTo(new File(saveDirectory2 + fileName));
					fileNames.add(fileName);
				}
			}
		}
		if (fileNames.size() != 0) {
			imintroDAO.uploadfile(fileNames, imintro);
		}

		return model;
	}

}
