package com.github.pg.ocrserver.config;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TesseractConfig {

    @Value("${tesseract.tessdata.path}")
    private String tessDataPath;

    @Bean
    Tesseract getTesseract(){
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tessDataPath);
        return tesseract;
    }
}
