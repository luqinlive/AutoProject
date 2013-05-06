package com.google.file;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;

public class FileService {
   /**
    * 保存文件
    * @param filename 文件名称
    * @param filecontent 文件类容
    */
	private Context contex;
	
	public FileService(Context contex) {
	super();
	this.contex = contex;
}

	public void save(String filename, String filecontent) throws Exception {
	
			FileOutputStream outStream = contex.openFileOutput(filename, Context.MODE_PRIVATE);
			
			outStream.write(filecontent.getBytes());
			outStream.close();
		
	}
	
	public String read(String filename) throws Exception{
		FileInputStream inStream = contex.openFileInput(filename);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = inStream.read(buffer))!=-1){
			outStream.write(buffer,0,len);
		}
		byte[] data = outStream.toByteArray();
		
		return new String(data);
	}

}
