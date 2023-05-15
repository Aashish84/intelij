package com.example.demo_pdf.controller;

import com.example.demo_pdf.service.GetSeriesService;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfDocument;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;

@Controller
public class TestController {
    private final GetSeriesService getSeriesService;
    private final SpringTemplateEngine springTemplateEngine;
    public TestController(GetSeriesService getSeriesService, SpringTemplateEngine springTemplateEngine) {
        this.getSeriesService = getSeriesService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @GetMapping("/file")
    public String getFile(Model model){
        model.addAttribute("myData" , getSeriesService.getSeries());
        return "hello";
    }
    @GetMapping("/file2")
    public ResponseEntity<String> getFile2(){
        return ResponseEntity.ok(renderHtmlTemplate());
    }
    @GetMapping("/fileToPdf")
    public ResponseEntity<byte []> getFileToPdf() throws DocumentException {
        byte[] pdfBytes = null;
        String html = renderHtmlTemplate();
//        System.out.println(html);
        pdfBytes = generatePdfFromHtml(html);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
    private String renderHtmlTemplate(){
        Context ctx = new Context();
        ctx.setVariable("myData" , getSeriesService.getSeries());
        return springTemplateEngine.process("hello" , ctx);
    }
    private byte[] generatePdfFromHtml(String htmlContent) throws DocumentException {
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        PdfDocument pdfDocument = new PdfDocument();
//        PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument,pdfOutputStream);
        pdfDocument.setPageSize(PageSize.A4);
        HtmlConverter.convertToPdf(htmlContent ,pdfOutputStream);
        return pdfOutputStream.toByteArray();
    }
}
