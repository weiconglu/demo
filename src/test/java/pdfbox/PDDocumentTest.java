package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PDDocumentTest {

	public static void main(String[] args) {

		// ---------------------------------------------------------------------------------------------------------------------------------------------
		/**
		 * This is the in-memory representation of the PDF document. The #close() method
		 * must be called once the document is no longer needed.
		 */
		try (PDDocument pdDocument = new PDDocument()) {
			for (int i = 0; i < 5; i++) {
				// 每次添加后要新new一个PDPage
				/**
				 * A page in a PDF document.
				 */
				PDPage page = new PDPage();
				/**
				 * This will add a page to the document. This is a convenience method, that will
				 * add the page to the root of the hierarchy and set the parent of the page to
				 * the root.
				 */
				pdDocument.addPage(page);
			}
			pdDocument.save("d:/test.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ---------------------------------------------------------------------------------------------------------------------------------------------
		File xyjFile = new File("C:/Users/founder3829/OneDrive/005-books/小说/xyj.pdf");
		try (PDDocument xyjDocument = PDDocument.load(xyjFile)) {
			xyjDocument.save("d:/xyj.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
