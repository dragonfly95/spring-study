package com.example.starter;

import net.sf.jasperreports.engine.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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



	@RequestMapping(value = "/helloworld.do", method = RequestMethod.GET)
	public HttpEntity<byte[]> helloworld(ModelAndView modelAndView) throws JRException {

		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("param1", getDothomeMessage());
		parameterMap.put("param2", "");


		JasperPrint jasperPrint = null;
		InputStream inputStream = null;

		jasperPrint = JasperFillManager.fillReport(
				JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/hello.jrxml")),
				parameterMap, new JREmptyDataSource()
		);

		final byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		header.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=employeeReport.pdf");
		header.setContentLength(data.length);

		return new HttpEntity<byte[]>(data, header);
	}


	// hello world 가져오기
	private String getDothomeMessage() {
		StringBuffer builder = new StringBuffer();

		try {
			URL url = new URL("http://ahhoinn.dothome.co.kr/myData/hello.txt");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();

			http.setDefaultUseCaches(false);
			http.setDoInput(true);
			http.setDoOutput(true);
			http.setRequestMethod("GET");

			StringBuffer buffer = new StringBuffer();

			OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "utf-8");
			PrintWriter writer = new PrintWriter(outStream);
			writer.write(buffer.toString());
			writer.flush();

			// 서버에서내용받기
			InputStreamReader tmp = new InputStreamReader(http.getInputStream(),"utf-8");
			BufferedReader reader = new BufferedReader(tmp);

			String str;
			while((str = reader.readLine()) != null) {
				builder.append(str + "\n");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
}
