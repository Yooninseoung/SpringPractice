package com.spring.function.thumbnail;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController {
private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image-repo";
	
	@RequestMapping("/download")
	protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response)throws Exception{
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName=imageFileName.substring(0, lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".png");
		
		if(image.exists()) { //image객체에 파일 또는 폴더가 존재한다면 ...
			thumbnail.getParentFile().mkdirs();
			//Thumbnails.of(image).size(50, 50).outputFormat("png").toFile(thumbnail); //이미지를 50,50크기로 만들어서 png확장자로 thumbnail파일에 저장.
			Thumbnails.of(image).size(50, 50).outputFormat("png").toOutputStream(out); //이미지를 50,50크기로 만들어서 png확장자로 브라우저로 바로 보냄 (저장x)
		}
		
		//저장된 파일를 읽어올 때 사용
		/*
		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if(count ==-1)
				break;
			out.write(buffer,0,count);
			
		}
		
		in.close();
		*/
		
		out.close();
		
	}

}
