package org.test.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreateUtil {

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {

		String path = "./vue/visitationpdf/test.pdf";

		// 定义纸张大小
		Rectangle rect = new Rectangle(1644, 2000);
		Document document = new Document(rect, 86, 86, 120, 120);

		// 字体文件,预先将字体文件放入如下位置
		String regularFont = "./vue/font/NotoSansJPRegular.ttf";
		String boldFont = "./vue/font/NotoSansJPBold.ttf";
//		String boldFont = "./vue/font/msyh.ttf";
		// 创建基础字体
		BaseFont bfRegularFont = BaseFont.createFont(regularFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		BaseFont bfBoldFont = BaseFont.createFont(boldFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		// 自定义字体属性
		Font rFont = new Font(bfRegularFont, 80);
		Font bFont = new Font(bfBoldFont, 96);

		PdfWriter.getInstance(document, new FileOutputStream(path));

		document.open();

		// 获取用户id
		Integer visitorId = 1;

		// qrcode
		String qrPath = "./vue/qr/" + visitorId + ".png";
		Image qr = Image.getInstance(qrPath);

		qr.scaleToFit(561, (float) 520.71);

		// 插入QRCode
//		document.add(qr);
		
		String line = "入館票";
		Paragraph paragraph = new Paragraph(line, bFont);
//		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);

		document.close();

	}

}
