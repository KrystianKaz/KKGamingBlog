package com.site.gamingblog.exception;

import com.site.gamingblog.service.StorageService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class StorageExceptionTest {

    @Autowired
    private StorageService storageService;

    @BeforeEach
    public void setUp() {
        byte[] bytes = new byte[1024];
        Path testRoot = Paths.get("src", "main/webapp/resources/assets/img/post");
        storageService.setRoot(testRoot);
        storageService.save(new MockMultipartFile("test.jpg", "test.jpg", "image", bytes));
    }

    @AfterEach
    public void tearDown() {
        Path testRoot = Paths.get("src", "main/webapp/resources/assets/img/post");
        storageService.setRoot(testRoot);
        storageService.deleteOne(testRoot,"test.jpg");
    }

    @Test
    void should_throw_StorageException_when_saving_file_that_exists_in_resources() {
        // given
        byte[] bytes = new byte[1024];
        MockMultipartFile file = new MockMultipartFile("test.jpg", "test.jpg",
                "image", bytes);
        // when
        Exception exception = assertThrows(StorageException.class, () -> storageService.save(file));

        // then
        assertEquals(exception.getMessage(), "Failed to store file.");
    }
}