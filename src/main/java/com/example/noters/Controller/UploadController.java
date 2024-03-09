package com.example.noters.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        try {
            Path root = Paths.get(UPLOAD_DIR);
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }

            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}