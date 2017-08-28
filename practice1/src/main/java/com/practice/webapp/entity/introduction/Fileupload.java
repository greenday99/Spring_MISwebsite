package com.practice.webapp.entity.introduction;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class Fileupload {
	
	private List<MultipartFile> crunchifyFiles;
	 
    public List<MultipartFile> getFiles() {
        return crunchifyFiles;
    }
 
    public void setFiles(List<MultipartFile> files) {
        this.crunchifyFiles = files;
    }

}
