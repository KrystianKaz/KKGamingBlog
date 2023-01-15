package com.site.gamingblog.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class StorageServiceTest {

    @Autowired
    StorageService storageService;

    @AfterEach
    void tearDown() {
        Path testRoot = Paths.get("src", "main/webapp/resources/assets/img/post");
        storageService.setRoot(testRoot);
        storageService.deleteOne(testRoot, "test.jpg");
    }

    @Test
    void should_load_file_from_resources() {
        // given
        byte[] bytes = new byte[128];
        MockMultipartFile file = new MockMultipartFile("test.jpg", "test.jpg", "image", bytes);
        Path testRoot = Paths.get("src", "main/webapp/resources/assets/img/post");
        storageService.setRoot(testRoot);
        storageService.save(file);

        // when
        Resource load = storageService.load(file.getOriginalFilename());

        // then
        assertTrue(load.exists());
        assertEquals(load.getFilename(), file.getOriginalFilename());
    }
}