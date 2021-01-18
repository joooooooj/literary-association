package com.la.service.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    @Value("${dataDir}")
    String dataDir;

    public String saveUploadedFile(MultipartFile file, String processInstanceId) throws IOException {
        String retVal = null;
        if (! file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(getResourceFilePath(dataDir) + File.separator + processInstanceId + '_' + file.getOriginalFilename());
            Files.write(path, bytes);
            retVal = path.toString();
        }
        return retVal;
    }

    public String getResourceFilePath(String path) {
        System.err.println(new FileSystemResource(path).getFile().getAbsolutePath());
        return new FileSystemResource(path).getFile().getAbsolutePath();
    }
}
