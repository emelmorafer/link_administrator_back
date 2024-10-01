package com.enlaces.enlaces.controller;

import com.enlaces.enlaces.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/uploadLogo")
public class FileUploadController {

    private static final String IMAGES_DIR = Utils.getParentDir(System.getProperty("user.dir")) + "/imagesupload/";
    private static final long MAX_FILE_SIZE = 1024 * 1024; // 1 MB
    private static final String[] ALLOWED_EXTENSIONS = {"jpeg", "jpg"};

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("fileName") String fileName) {
        try {
            // Check file size
            if (file.getSize() > MAX_FILE_SIZE) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File size exceeds the maximum allowed size of 1 MB");
            }

            // Check file extension
            String fileExtension = Utils.getFileExtension(file.getOriginalFilename());
            if (!Utils.isAllowedExtension(fileExtension,ALLOWED_EXTENSIONS)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file type. Only JPEG and JPG are allowed.");
            }

            // Create the directory if it doesn't exist
            Path uploadPath = Paths.get(IMAGES_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the file locally
            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());

            // Return the URL of the uploaded image
            String fileUrl = "/images/" + fileName;
            return ResponseEntity.ok(fileUrl);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file");
        }
    }

    @DeleteMapping
    public boolean deleteFile(@RequestParam("fileName") String fileName) {
        try {
            Path filePath = Paths.get(IMAGES_DIR).resolve(fileName);

            // Check if the file exists
            if (Files.exists(filePath)) {
                Files.delete(filePath);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
