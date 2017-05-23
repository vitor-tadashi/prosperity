package br.com.prosperity.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/manual")
public class ManualController {
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	@ResponseBody
	public void getFile(HttpServletResponse response) {
		try {
			File file = new File("archives\\ManualProsperityFull.pptx");
			response.addHeader("Content-Disposition", "attachment; filename=ManualProsperityFull.pptx");
			InputStream is = new FileInputStream(file);
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();

			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
