package com.shengfq.io.files.pdf;

import com.shengfq.io.files.properties.AbsContent;
import com.shengfq.io.files.properties.AbsPropertiesFactory;
import com.shengfq.io.files.properties.Xzdjtzs;

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

    private static  String DOC3="/Users/sheng/schedule/target&plan&schedule&task/杭州煋辰数智科技[进行]/资金查控管理系统/1法律文书/协助冻结财产通知书.properties";
    public static void main(String[] args) throws  Exception{
       //String txt= PDFParseUtils.writeTxt(DOC2);
        //System.out.println("txt:"+txt);
        AbsPropertiesFactory factory=new AbsPropertiesFactory(DOC3);
       AbsContent absContent= factory.getContent();
       if(absContent instanceof Xzdjtzs){
           Xzdjtzs item=(Xzdjtzs) absContent;
           System.out.println(item.toString());
       }
       //Map<String,String> all= factory.getAllProperty();
       // System.out.println(all);
        System.out.println("---------end ----------");
    }

}
