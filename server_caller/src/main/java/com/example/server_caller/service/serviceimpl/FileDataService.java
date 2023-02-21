package com.example.server_caller.service.serviceimpl;

import com.example.server_caller.entity.FileData;
import com.example.server_caller.repository.FileDataRepository;
import com.example.server_caller.util.FileUtils;
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
        if(save !=null){
            return "file uploaded sucessfully";
        }
        return null;
    }

    public FileData downloadFile(String fileName){
        Optional<FileData> fileByName = fileDataRepository.findByName(fileName);
        FileData fileData = fileByName.get();
        fileData.setFileData(FileUtils.decompressImage(fileData.getFileData()));
        return fileData;
    }
}
