package com.example.server02.helper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FileServiceHelper {
    public String getExtension(String mimeTypeString) throws MimeTypeException {
//        Apache Tika library
//        get mime(String) extension
        MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
        MimeType mimeType = allTypes.forName(mimeTypeString);
        return mimeType.getExtension();
    }

    public void addPageToPDFDocument(PDDocument pdDocument , String newContent) throws IOException {
        PDPage blankPage = new PDPage();
        PDPageContentStream contentStream = new PDPageContentStream(pdDocument , blankPage);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN , 12);
        contentStream.newLineAtOffset(10 , 780);
        contentStream.showText(newContent);
        contentStream.showText("new something");
        contentStream.showText(" something else new something");
        contentStream.endText();
        contentStream.close();
        pdDocument.addPage(blankPage);
    }
}
