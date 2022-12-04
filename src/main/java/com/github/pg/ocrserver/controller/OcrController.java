package com.github.pg.ocrserver.controller;

import com.github.pg.ocrserver.dto.OcrLanguage;
import com.github.pg.ocrserver.dto.OcrResult;
import com.github.pg.ocrserver.service.OcrService;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("/ocr")
@RequiredArgsConstructor
public class OcrController {
    private final OcrService ocrService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<OcrResult> upload(@RequestParam("file") MultipartFile file, @RequestParam OcrLanguage language) throws IOException, TesseractException {
        return ResponseEntity.ok(ocrService.ocr(file, language));
    }
}
