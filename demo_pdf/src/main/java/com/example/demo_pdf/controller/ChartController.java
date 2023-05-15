package com.example.demo_pdf.controller;

import com.example.demo_pdf.service.GetSeriesService;
import com.example.demo_pdf.service.HtmlToPdfConverter;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@AllArgsConstructor
@Controller
public class ChartController {
    private final GetSeriesService getSeriesService;
    @GetMapping("/barchart")
    public String getFile(Model model){
        model.addAttribute("myData" , getSeriesService.getSeries());
        return "chart";
    }
    @GetMapping("/fileToPdf03")
    public ResponseEntity<?> getFile() throws IOException {
        String htmlFilePath = "src/main/resources/templates/chart.html";
        String pdfFilePath = "src/main/resources/static/hello.pdf";

        HtmlToPdfConverter.convertHtmlToPdf(htmlFilePath, pdfFilePath);

        File pdfFile = new File(pdfFilePath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename("hello.pdf").build());

        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(pdfFile.toPath()));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
