package com.shengfq.io.files.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.*;
import java.io.File;

/**
 * ClassName: TestPdfParse
 * Description: pdfbox工具类测试
 *
 * @author shengfq
 * @date: 2022/12/19 2:45 下午
 */
public class TestPdfParse {
    //DOC1 读取不出来,可能是由于图片导出来的.
    private static String DOC1="/Users/sheng/schedule/target&plan&schedule&task/杭州煋辰数智科技[进行]/资金查控管理系统/1法律文书/法律文书.pdf";
    //DOC2能够导出文档部分内容,表单内容都读取不出来
    private static String DOC2="/Users/sheng/schedule/target&plan&schedule&task/杭州煋辰数智科技[进行]/资金查控管理系统/1法律文书/协助冻结财产通知书.pdf";
    public static void main(String[] args) throws  Exception{

    }

    public static void test1() throws Exception {
        PDDocument pdDocument = PDDocument.load(new File(DOC2));
        if (pdDocument.isEncrypted()) {//加密
            System.out.println("pdDocument.isEncrypted");
            return;
        }
        PDPage page = pdDocument.getPage(0);//第一页
        PDFTextStripperByArea pdfTextStripper = new PDFTextStripperByArea();//区域文本剥离器
        pdfTextStripper.addRegion("region1", new Rectangle(0, 0, (int) page.getMediaBox().getWidth(), (int) page.getMediaBox().getHeight()));//区域大小
        pdfTextStripper.extractRegions(page);//设置页
        pdfTextStripper.setSortByPosition(true);//排序
        String text = pdfTextStripper.getTextForRegion("region1");//剥离文本

        System.out.println(text);
        pdDocument.close();
    }

    private static void test2() throws Exception {
        PDDocument pdDocument = PDDocument.load(new File(DOC2));
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        pdfTextStripper.setSortByPosition(true);
        pdfTextStripper.setStartPage(0);
        pdfTextStripper.setEndPage(1);
        String text = pdfTextStripper.getText(pdDocument);
        System.out.println(text);
        pdDocument.close();
    }


}
