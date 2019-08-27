package demo.shengfq.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class PrintQRCode {
	public static void main(String[] args) {
		print2();
	}
	
	public static void print(){
		ByteArrayOutputStream out=QRCode.from("https://github.com/ShengFQ").to(ImageType.PNG).stream();
		try{
			FileOutputStream fout=new FileOutputStream(new File("/Users/sheng/Downloads/QR_code.png"));
			fout.write(out.toByteArray());
			fout.flush();
			fout.close();
		}catch(FileNotFoundException fexception){
			fexception.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void print2(){
		// get QR file from text using defaults
		File file = QRCode.from("Hello World").file();
		// get QR stream from text using defaults
		ByteArrayOutputStream stream = QRCode.from("Hello World").stream();
		 
		// override the image type to be JPG
		QRCode.from("Hello World").to(ImageType.JPG).file();
		QRCode.from("Hello World").to(ImageType.JPG).stream();
		 
		// override image size to be 250x250
		QRCode.from("Hello World").withSize(250, 250).file();
		QRCode.from("Hello World").withSize(250, 250).stream();
		 
		// override size and image type
		File qfile=new File("/Users/sheng/Downloads/QR_code.png");
		ByteArrayOutputStream bos=QRCode.from("https://github.com/ShengFQ").to(ImageType.GIF).withSize(250, 250).stream();
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(qfile);
			fout.write(bos.toByteArray());
			fout.flush();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}
}
