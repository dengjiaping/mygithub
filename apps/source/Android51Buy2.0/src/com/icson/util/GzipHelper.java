package com.icson.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipHelper{
	static final int BUFFERSIZE = 1024;
	
	/**
	 * 解压缩
	 * @param is  输入流
	 * @param os  输出流
	 * @throws Exception
	 */
	public static void decompress(InputStream is, OutputStream os)throws Exception{
		GZIPInputStream gin = new GZIPInputStream(is);   
		int count;   
		byte data[] = new byte[BUFFERSIZE];   
		while ((count = gin.read(data, 0, BUFFERSIZE)) != -1){   
		    os.write(data, 0, count);   
		}   
		gin.close();   
	}  
	
	/**
	 * 压缩
	 * @param is  输入流
	 * @param os  输出流
	 * @throws Exception
	 */
 	public static void compress(InputStream is, OutputStream os)throws Exception {   
		GZIPOutputStream gos = new GZIPOutputStream(os);   
		int count;   
		byte data[] = new byte[BUFFERSIZE];   
		while ((count = is.read(data, 0, BUFFERSIZE)) != -1) {   
		    gos.write(data, 0, count);   
		}   
		gos.flush();
		gos.finish();
		gos.close();   
	}  
}
