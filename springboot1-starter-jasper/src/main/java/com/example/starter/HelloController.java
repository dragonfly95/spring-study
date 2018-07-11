package com.example.starter;

import net.sf.jasperreports.engine.JREmptyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import org.springframework.web.servlet.view.jasperreports.JasperReportsHtmlView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsxView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {


	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping("/")
	public String hello(Model model) {
		return "hello";
	}


	@RequestMapping("/jasperReport.do")
	public ModelAndView jasperReport() {

		JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:reports/blank.jrxml");
	    view.setReportDataKey("datasource");
	    view.setApplicationContext(applicationContext);

	    Map<String, Object> params = new HashMap<>();
	    params.put("datasource", new JREmptyDataSource());
	    return new ModelAndView(view, params);
	}


}
