package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PDFMerge {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		PDFMergerUtility pdfMerger = new PDFMergerUtility();
		pdfMerger.setDestinationFileName("pdf/fusei.pdf");

		try {
			for (int i = 1; i < 11; i++) {
				File file = new File("pdf/" + i + ".pdf");
				pdfMerger.addSource(file);
			}
			pdfMerger.mergeDocuments();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
