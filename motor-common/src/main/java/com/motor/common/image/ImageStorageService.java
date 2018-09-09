package com.motor.common.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageStorageService implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageStorageService.class);
    private static final Path rootLocation = Paths.get("IMAGES_UPLOAD_DIR");

    @Override
    public void store(MultipartFile file) throws ImageStorageException {
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        }catch (Exception e) {
            throw new ImageStorageException("Image " + file.getOriginalFilename() + " was not uploaded", e);
        }
    }

    @Override
    public Resource loadFile(String filename) {
        try{
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new ImageStorageException("Image " + filename + " does not exist or isn't readable");
            }
        }catch (MalformedURLException e) {
            throw new ImageStorageException("Image " + filename + " was not loaded");
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try{
            Files.createDirectory(rootLocation);
        }catch (IOException e) {
            throw new ImageStorageException("Could not initialize storage!");
        }
    }
}
