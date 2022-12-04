package com.github.pg.ocrserver.service;

import com.github.pg.ocrserver.dto.OcrLanguage;
import com.github.pg.ocrserver.dto.OcrResult;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class OcrService {
    private final Tesseract tesseract;

    public OcrResult ocr(MultipartFile file, OcrLanguage language) throws IOException, TesseractException {
        File convFile = convert(file);
        tesseract.setLanguage(language.getLang());
        return new OcrResult(tesseract.doOCR(convFile));
    }

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public void scaleUp() {
//        https://tesseract-ocr.github.io/tessdoc/ImproveQuality.html#rescaling
    }


}
