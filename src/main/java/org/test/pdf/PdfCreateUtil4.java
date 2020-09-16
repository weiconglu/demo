package org.test.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreateUtil4 {

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {

		// 获取用户id
		Integer visitorId = 1;
		
		String path = "./vue/visitationpdf/"+visitorId+".pdf";

		// 定义纸张大小
		Rectangle rect = new Rectangle(0, 0, 1644, 2000);
		Document document = new Document(rect, 86, 86, 120, 120);

		// 字体文件,预先将字体文件放入如下位置
		String regularFont = "./vue/font/NotoSansJPRegular.ttf";
		String boldFont = "./vue/font/NotoSansJPBold.ttf";
		// 创建基础字体
		BaseFont bfRegularFont = BaseFont.createFont(regularFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		BaseFont bfBoldFont = BaseFont.createFont(boldFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		// 自定义字体属性
		Font rFont = new Font(bfRegularFont, 80);
		Font bFont = new Font(bfBoldFont, 96, 0, BaseColor.WHITE);

		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(path));

		document.open();

		// qrcode
		String qrPath = "./vue/qr/" + visitorId + ".png";
		Image qr = Image.getInstance(qrPath);
		qr.scaleToFit(561, 521);
		document.add(qr);

		// 入馆票背景
		Rectangle rectangle = new Rectangle(672, 1707, 1558, 1880);
		rectangle.setBackgroundColor(new BaseColor(64, 64, 64));
		document.add(rectangle);

		// 入馆票
		String line = "入館票";
		Paragraph paragraph = new Paragraph(line, bFont);
		// 定义画布为当前pdf内容，栅格化文字并画在画布上
		PdfContentByte canvas = pdfWriter.getDirectContent();
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, paragraph, 707, 1755, 0);

		// 入館日期
		String enterDate = new EnterDate().toString();
		Paragraph enterDateParagraph = new Paragraph(enterDate, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, enterDateParagraph, 707, 1598, 0);

		// 入館时间
		String enterTime = "発行：" + new EnterTime().toString();
		Paragraph enterTimeParagraph = new Paragraph(enterTime, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, enterTimeParagraph, 707, 1489, 0);

		// 行先
		String destination = "行先：2F/4F/8F";
		Paragraph destinationParagraph = new Paragraph(destination, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, destinationParagraph, 707, 1380, 0);

		// 注意事項
		String attention1 = "・本QRコードは当日のみ有効です。";
		String attention2 = "・各フロアの機器で読み取れない場合は、";
		String attention3 = "担当者にご連絡ください。";
		Paragraph attention1Paragraph = new Paragraph(attention1, rFont);
		Paragraph attention2Paragraph = new Paragraph(attention2, rFont);
		Paragraph attention3Paragraph = new Paragraph(attention3, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention1Paragraph, 47, 1123, 0);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention2Paragraph, 47, 1023, 0);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention3Paragraph, 132, 923, 0);

		// add map
		String mapPath = "./vue/map/floor4.png";
		Image map = Image.getInstance(mapPath);
		map.scaleToFit(685, 561);
		// 指定坐标
		map.setAbsolutePosition(465, 182);
		document.add(map);

		document.close();

	}

}
