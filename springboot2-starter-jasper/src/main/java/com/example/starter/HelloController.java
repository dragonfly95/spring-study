package com.example.starter;

import net.sf.jasperreports.engine.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

	@RequestMapping("/")
	public HttpEntity<byte[]> hello(Model model) throws JRException {

		JasperPrint jasperPrint = null;
        InputStream inputStream = null;

		jasperPrint = JasperFillManager.fillReport(
				JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/blank.jrxml")),
				null, new JREmptyDataSource()
		);

		final byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		header.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=employeeReport.pdf");
		header.setContentLength(data.length);

		return new HttpEntity<byte[]>(data, header);

	}

}
