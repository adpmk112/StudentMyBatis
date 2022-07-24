package com.example.mybatisStudent.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import com.example.mybatisStudent.dto.ResponseStudentDto;
import com.example.mybatisStudent.repository.StudentMapper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

public class ReportService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	public void exportReport(String reportFormat,HttpServletResponse response)
																										throws JRException, IOException{
		
		String path = "C:\\Users\\PMK\\eclipse-workspace\\StudentMyBatis"
				+ "\\src\\main\\resources";
		
		List<ResponseStudentDto> resStudentDto = studentMapper.selectAll();
		
		File file = ResourceUtils.getFile("classpath:student.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(resStudentDto);
		
		Map<String,Object> parameter = new HashMap<>();
		
		parameter.put("ReportTitle", "StudentList");
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter ,dataSource);
		
		if(reportFormat.equalsIgnoreCase("html")) {
			
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\student.html");
		}
		
		else if(reportFormat.equalsIgnoreCase("pdf")){
			
			JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());
			response.setContentType("application/pdf");
			response.addHeader("Content header", "inline; filename=student.pdf;");
		}
		
		else if (reportFormat.equalsIgnoreCase("excel")){
			
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			
			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
			configuration.setOnePagePerSheet(true);
			configuration.setDetectCellType(true);
			exporter.setConfiguration(configuration);
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
			 response.setContentType("application/xlsx");
	         response.addHeader("ContentHeader", "inline; filename=student.xlsx;"); 
	         exporter.exportReport();
			
		}
		
	}
}
