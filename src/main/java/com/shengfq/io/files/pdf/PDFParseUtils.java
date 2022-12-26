package com.shengfq.io.files.pdf;

import cn.hutool.core.io.FileUtil;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.PdfFormWidget;
import com.spire.pdf.widget.PdfTextBoxFieldWidget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName: PDFParse
 * Description: PDF文件表单域内容操作
 * 从PDF文件中读取内容存储到txt文件
 * @author shengfq
 * @date: 2022/12/19 4:18 下午
 */
public final class PDFParseUtils {
    static final String PDF_MIME="application/pdf";
    static final String txtSuffix=".properties";
    //pdf存储目录的绝对路径
    private static boolean validate(String pdfPath){
        boolean validate=FileUtil.exist(pdfPath);
        String mimeType=FileUtil.getMimeType(pdfPath);
        if(!validate){
            throw new RuntimeException("文件不存在");
        }
        if(!PDF_MIME.equalsIgnoreCase(mimeType)){
            throw new RuntimeException("不是PDF文档");
        }
        return true;
    }
    /**
     * 获取txt文件的路径
     * 默认是跟PDF是同目录,同名
     * */
    private static String getTxtPath(String pdfPath){
        validate(pdfPath);
        String dirPath= FileUtil.getParent(pdfPath,1) ;
        String name=  FileUtil.getName(pdfPath);
        String prefix=FileUtil.getPrefix(name);
        return dirPath+ File.separator+prefix+txtSuffix;
    }
    /**
     * 读取PDF文件的表单域内容
     * @param pdfPath pdf路径
     *
     * */
    public static String writeTxt(String pdfPath){
        String txtPath=null;
        validate(pdfPath);
        //加载PDF文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(pdfPath);
        //获取表单域
        PdfFormWidget formWidget = (PdfFormWidget)pdf.getForm();
        StringBuilder sb = new StringBuilder();
        //遍历表单域控件集合并提取所有表单的值
        for (int i = 0; i < formWidget.getFieldsWidget().getCount(); i++) {
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);
            //获取文本框的值
            if (field instanceof PdfTextBoxFieldWidget) {
                PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget) field;
                String name=textBoxField.getName();
                String text = textBoxField.getText();
                sb.append(name).append("=").append(text).append("\n");
            }
        }
        try {
            //将文本写入 .txt文件
            txtPath=getTxtPath(pdfPath);
            FileWriter writer = new FileWriter(txtPath);
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            pdf.close();
        }
        return txtPath;
    }

}
