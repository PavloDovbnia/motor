package com.motor.store.image;

import com.google.gson.Gson;
import com.motor.common.image.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {

    @Autowired
    private StorageService storageService;
    @Autowired
    private Gson gson;

    @PostMapping(value = "/image/upload")
    public void fileUpload(@RequestParam("file") MultipartFile file) {
        storageService.store(file);
    }

    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        Resource file = storageService.loadFile(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION , "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
