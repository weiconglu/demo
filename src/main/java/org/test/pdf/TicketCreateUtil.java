package org.test.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import com.itextpdf.text.BadElementException;
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

/**
 * 
 * @author lu_weicong
 *
 */
public class TicketCreateUtil {

	// 预先放置的字体文件
	public static String regularFont = "./vue/font/NotoSansJPRegular.ttf";
	public static String boldFont = "./vue/font/NotoSansJPBold.ttf";
	// 基础字体
	public static BaseFont bfRegularFont = null;
	public static BaseFont bfBoldFont = null;
	// 自定义字体
	public static Font rFont = null;
	public static Font bFont = null;

	// floor4 map file
	public static String mapPath = "./vue/map/floor4.png";
	public static Image map = null;

	static {
		// 基础字体初始化
		try {
			bfRegularFont = BaseFont.createFont(regularFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}

		try {
			bfBoldFont = BaseFont.createFont(boldFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		// 自定义字体初始化
		rFont = new Font(bfRegularFont, 8);
		bFont = new Font(bfBoldFont, 18, 0, BaseColor.WHITE);

		// 初始化floor4地图
		try {
			map = Image.getInstance(mapPath);
		} catch (BadElementException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 行先は4Fを含めてのチケットを作成する
	 * 
	 * @param floor      固定Integer 4、メソッドを分けるため定義する
	 * @param visitorId
	 * @param visitFloor
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void generate(Integer floor, Integer visitorId, String visitFloor)
			throws DocumentException, IOException {

		// 存放pdf文件的路径
		String pdfPath = "./vue/visitationpdf/" + visitorId + ".pdf";

		// 存放png文件的路径
		String pngPath = "./vue/ticket/" + visitorId + ".png";

		// 定义纸张大小
		Rectangle rect = new Rectangle(0, 0, 164, 277);
		Document document = new Document(rect, 7, 7, 7, 7);

		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

		document.open();

		// qrcode
		String qrPath = "./vue/qr/" + visitorId + ".png";
		Image qr = Image.getInstance(qrPath);
		qr.scaleToFit(61, 61);
		document.add(qr);

		// 入馆票背景
		Rectangle rectangle = new Rectangle(70, 244, 150, 270);
		rectangle.setBackgroundColor(new BaseColor(64, 64, 64));
		document.add(rectangle);

		// 入馆票
		String line = "入館票";
		Paragraph paragraph = new Paragraph(line, bFont);
		// 定义画布为当前pdf内容，栅格化文字并画在画布上
		PdfContentByte canvas = pdfWriter.getDirectContent();
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, paragraph, 80, 250, 0);

		// 入館日期
		String enterDate = new EnterDate().toString();
		Paragraph enterDateParagraph = new Paragraph(enterDate, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, enterDateParagraph, 70, 225, 0);

		// 入館时间
		String enterTime = "発行：" + new EnterTime().toString();
		Paragraph enterTimeParagraph = new Paragraph(enterTime, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, enterTimeParagraph, 70, 211, 0);

		// 行先
		Paragraph destinationParagraph = new Paragraph(visitFloor, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, destinationParagraph, 70, 198, 0);

		// 注意事項
		String attention1 = "・本QRコードは当日のみ有効です。";
		String attention2 = "・各フロアの機器で読み取れない場合は、";
		String attention3 = "担当者にご連絡ください。";
		Paragraph attention1Paragraph = new Paragraph(attention1, rFont);
		Paragraph attention2Paragraph = new Paragraph(attention2, rFont);
		Paragraph attention3Paragraph = new Paragraph(attention3, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention1Paragraph, 6, 177, 0);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention2Paragraph, 6, 165, 0);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention3Paragraph, 14, 153, 0);

		// add map
		map.scaleToFit(132, 132);
		// 指定坐标
		map.setAbsolutePosition(16, 16);
		document.add(map);

		document.close();

		// 将pdf文件转成png文件
		pdfToPng(pdfPath, pngPath);

	}

	/**
	 * 行先は4F以外のチケットを作成する
	 * 
	 * @param visitorId
	 * @param visitFloor
	 * @param qr
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void generate(Integer visitorId, String visitFloor) throws DocumentException, IOException {

		// 存放pdf文件的路径
		String pdfPath = "./vue/visitationpdf/" + visitorId + ".pdf";

		// 存放png文件的路径
		String pngPath = "./vue/ticket/" + visitorId + ".png";

		// 定义纸张大小
		Rectangle rect = new Rectangle(0, 0, 164, 130);
		Document document = new Document(rect, 7, 7, 7, 7);

		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

		document.open();

		// qrcode
		String qrPath = "./vue/qr/" + visitorId + ".png";
		Image qr = Image.getInstance(qrPath);
		qr.scaleToFit(61, 61);
		document.add(qr);

		// 入馆票背景
		Rectangle rectangle = new Rectangle(70, 97, 150, 123);
		rectangle.setBackgroundColor(new BaseColor(64, 64, 64));
		document.add(rectangle);

		// 入馆票
		String line = "入館票";
		Paragraph paragraph = new Paragraph(line, bFont);
		// 定义画布为当前pdf内容，栅格化文字并画在画布上
		PdfContentByte canvas = pdfWriter.getDirectContent();
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, paragraph, 80, 103, 0);

		// 入館日期
		String enterDate = new EnterDate().toString();
		Paragraph enterDateParagraph = new Paragraph(enterDate, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, enterDateParagraph, 70, 78, 0);

		// 入館时间
		String enterTime = "発行：" + new EnterTime().toString();
		Paragraph enterTimeParagraph = new Paragraph(enterTime, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, enterTimeParagraph, 70, 64, 0);

		// 行先
		Paragraph destinationParagraph = new Paragraph(visitFloor, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, destinationParagraph, 70, 51, 0);

		// 注意事項
		String attention1 = "・本QRコードは当日のみ有効です。";
		String attention2 = "・各フロアの機器で読み取れない場合は、";
		String attention3 = "担当者にご連絡ください。";
		Paragraph attention1Paragraph = new Paragraph(attention1, rFont);
		Paragraph attention2Paragraph = new Paragraph(attention2, rFont);
		Paragraph attention3Paragraph = new Paragraph(attention3, rFont);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention1Paragraph, 6, 30, 0);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention2Paragraph, 6, 18, 0);
		ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, attention3Paragraph, 14, 6, 0);

		document.close();

		// 将pdf文件转成png文件
		pdfToPng(pdfPath, pngPath);

	}

	/**
	 * PDFファイルをPNGファイルに転換する
	 * 
	 * @param pdfPath
	 * @param pngPath
	 */
	private static void pdfToPng(String pdfPath, String pngPath) {
		PDDocument pd = null;
		try {
			pd = PDDocument.load(new File(pdfPath));
			PDFRenderer pdfRenderer = new PDFRenderer(pd);
			BufferedImage image = pdfRenderer.renderImageWithDPI(0, 300); // 设置点数
			ImageIO.write(image, "PNG", new File(pngPath));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pd.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
