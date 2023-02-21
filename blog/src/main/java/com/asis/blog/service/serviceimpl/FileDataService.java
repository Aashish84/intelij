package com.asis.blog.service.serviceimpl;


import com.asis.blog.entity.FileData;
import com.asis.blog.repository.FileDataRepository;
import com.asis.blog.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataService(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        FileData save = fileDataRepository.save(
                FileData
                        .builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .fileData(FileUtils.compressImage(file.getBytes())).build()
        );
        return "file uploaded sucessfully";
    }

    public FileData downloadFile(String fileName){
        Optional<FileData> fileByName = fileDataRepository.findByName(fileName);
        FileData fileData = fileByName.get();
        fileData.setFileData(FileUtils.decompressImage(fileData.getFileData()));
        return fileData;
    }
}
