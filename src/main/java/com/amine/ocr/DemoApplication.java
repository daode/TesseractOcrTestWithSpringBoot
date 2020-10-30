package com.amine.ocr;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		//Do not forget to add the DLL dependency installing:
		//https://support.microsoft.com/en-us/help/2977003/the-latest-supported-visual-c-downloads
		
		System.out.println( "Tesseract testing" );
        
        ITesseract ocr = new Tesseract();
        
        String path = "C:\\Dev\\OCR_TESSERACT\\OCR_Examples\\MaFacture.pdf";
        
        File fileToOcr = new File(path);
        
        String result = "";
        
        ocr.setDatapath("C:\\Dev\\OCR_TESSERACT\\tessdata\\");
        ocr.setLanguage("fra");
        
        try {
			result = ocr.doOCR(fileToOcr);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("The result of OCR of the file: ("+path+") is:\n " + result);
        
        		
	}

}
