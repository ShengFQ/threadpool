package com.shengfq.io.files.pdf;

import cn.hutool.core.io.FileUtil;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;

import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName: PdfParse
 * Description: Spire.PDF for Java
 * https://www.e-iceblue.cn/pdf_java_field/detect-required-fields-in-pdf-in-java.html
 * @author shengfq
 * @date: 2022/12/19 2:44 下午
 */
public class PdfParse {
    private static String DOC1="/Users/sheng/schedule/target&plan&schedule&task/杭州煋辰数智科技[进行]/资金查控管理系统/1法律文书/协助冻结财产通知书_2021120213385684C429DE124C78A90E.pdf";
    //DOC2能够导出文档部分内容,表单内容都读取不出来
    private static String DOC2="/Users/sheng/schedule/target&plan&schedule&task/杭州煋辰数智科技[进行]/资金查控管理系统/1法律文书/协助冻结财产通知书_20211202133651C340F7B04E3A641BAE.pdf";
    static String txtSuffix=".txt";
    public static void main(String[] args) {
       // test1(DOC2);
        System.out.println("------------");
       // test3();
        System.out.println("------------");
        test4();

    }

    public static void test1(String pdfPath){
        boolean validate=   FileUtil.exist(pdfPath);
        System.out.println("exist:"+validate);
       String abs= FileUtil.getAbsolutePath(pdfPath);
      String name=  FileUtil.getName(pdfPath);
      String mimeType=FileUtil.getMimeType(pdfPath);
      String suffix=FileUtil.getSuffix(name);
      String prefix=FileUtil.getPrefix(name);
      String dirPath= FileUtil.getParent(pdfPath,1) ;
      System.out.println("absPath:"+abs+ " name :"+name +" mimeType:"+mimeType+" suffix:"+suffix+" prefix:"+prefix);
        System.out.println("dirPath:"+dirPath);
        String txtPath=dirPath+prefix+txtSuffix;
        System.out.println("txtPath:"+txtPath);
    }
    /**
     * 获取指定表单域的值
     * 测试成功
     * */
    public static void test3() {
        //加载PDF文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(DOC2);

        //获取表单域
        PdfFormWidget formWidget = (PdfFormWidget)pdf.getForm();

        //通过索引值来获取指定表单域中的值
        PdfTextBoxFieldWidget textbox = ( PdfTextBoxFieldWidget)formWidget.getFieldsWidget().get(0);
        //PdfTextBoxFieldWidget textbox = ( PdfTextBoxFieldWidget)formWidget.getFieldsWidget().get("TextBox");//通过表单域名称来获取值
        //将获取的值写入txt文档
        String text = textbox.getText();
        System.out.println("第一个表单域内容如下:");
        System.out.println(text);

        pdf.close();
    }

    /**
     * 获取文中所有表单域的值
     * 测试成功
     * */
    public static void test4() {
        //加载PDF文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(DOC1);

        //获取表单域
        PdfFormWidget formWidget = (PdfFormWidget)pdf.getForm();
        StringBuilder sb = new StringBuilder();

        //遍历表单域控件集合并提取所有表单的值
        for (int i = 0; i < formWidget.getFieldsWidget().getCount(); i++)
        {
            PdfField field = (PdfField)formWidget.getFieldsWidget().getList().get(i);

            //获取文本框的值
            if (field instanceof PdfTextBoxFieldWidget)
            {
                PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget)field ;
                String name=textBoxField.getName();
                String text = textBoxField.getText();
                sb.append(name).append("=").append(text).append("\n");
            }

            //获取列表框的值
            if (field instanceof PdfListBoxWidgetFieldWidget)
            {
                PdfListBoxWidgetFieldWidget listBoxField = (PdfListBoxWidgetFieldWidget)field;

                //获取列表框中选中的值
                String selectedValue = listBoxField.getSelectedValue();
                sb.append("列表框选中的内容： " + selectedValue + "\r\n");

                //获取列表框中的所有选项值
                sb.append("列表框内容： \r\n");
                PdfListWidgetItemCollection items = listBoxField.getValues();
                for (PdfListWidgetItem item : (Iterable<PdfListWidgetItem>) items)
                {
                    sb.append(item.getValue() + "\r\n");
                }
            }

            //获取组合框的值
            if (field instanceof PdfComboBoxWidgetFieldWidget)
            {
                PdfComboBoxWidgetFieldWidget comBoxField = (PdfComboBoxWidgetFieldWidget)field ;

                //获取组合框中选中的值
                String selectedValue = comBoxField.getSelectedValue();
                sb.append("组合框选中的内容： " + selectedValue + "\r\n");

                //获取组合框中所有选项值
                sb.append("组合框内容： \r\n");
                PdfListWidgetItemCollection items = comBoxField.getValues();
                for (PdfListWidgetItem item : (Iterable<PdfListWidgetItem>) items)
                {
                    sb.append(item.getValue() + "\r\n");
                }
            }

            //获取单选按钮值
            if (field instanceof PdfRadioButtonListFieldWidget)
            {
                PdfRadioButtonListFieldWidget radioBtnField = (PdfRadioButtonListFieldWidget)field;
                String Value = radioBtnField.getValue();
                sb.append("单选按钮内容： " + Value + "\r\n");
            }

            //获取复选框值
            if (field instanceof PdfCheckBoxWidgetFieldWidget)
            {
                PdfCheckBoxWidgetFieldWidget checkBoxField = (PdfCheckBoxWidgetFieldWidget)field;
                //获取复选框的选中状态
                boolean state = checkBoxField.getChecked();
                sb.append("复选框是否被选中？ " + state + "\r\n");
            }
        }

        try {
            //将文本写入 .txt文件
            FileWriter writer = new FileWriter("GetAllFormfieldValues.properties");
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pdf.close();
    }

    /**
     *  检测 PDF 文档中的必填域
     *  测试未成功
     * */
    public static void test5() {

        //加载PDF文档
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(DOC2);

        //获取PDF中的表单域
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();

        //遍历表单域
        for (int i = 0; i < formWidget.getFieldsWidget().getList().getCapacity(); i++) {

            //获取指定域
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get_Item(i);

            //获取域名
            String fieldName = field.getName();

            //判断是否为必填域
            boolean isRequired = field.getRequired();
            if (isRequired){

                //打印必填域
                System.out.println(fieldName + "是必填域");
            }
        }
    }
}
