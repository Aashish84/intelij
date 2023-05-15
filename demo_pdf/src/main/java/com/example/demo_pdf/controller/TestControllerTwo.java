package com.example.demo_pdf.controller;

import com.example.demo_pdf.service.GetSeriesService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;

@Controller
public class TestControllerTwo {
    private final GetSeriesService getSeriesService;
    private final SpringTemplateEngine springTemplateEngine;

    public TestControllerTwo(GetSeriesService getSeriesService, SpringTemplateEngine springTemplateEngine) {
        this.getSeriesService = getSeriesService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @GetMapping("/fileToPdf02")
    public ResponseEntity<?> getFile() throws MalformedURLException, InterruptedException {
        ITextRenderer renderer = new ITextRenderer();
        Context ctx = new Context();
        ctx.setVariable("myData" , getSeriesService.getSeries());
        String helloHtmlString = springTemplateEngine.process("hello", ctx);
        String baseUrl = FileSystems.getDefault()
                .getPath("src/main/resources/static/")
                .toUri().toURL().toString();
        renderer.setDocumentFromString(helloHtmlString , baseUrl);
//        renderer.getSharedContext().setBaseURL("https://code.highcharts.com");
        renderer.layout();
//        renderer.wait(5000);
        ByteArrayOutputStream pdfStream  = new ByteArrayOutputStream();
        renderer.createPDF(pdfStream);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(pdfStream.toByteArray() , headers , HttpStatus.OK);
    }
}
