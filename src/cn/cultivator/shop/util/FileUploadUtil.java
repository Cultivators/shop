package cn.cultivator.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.UUID;

public class FileUploadUtil {
	
	private String filepath;
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String[] getBankImage(String imagePath){
		File file = new File(imagePath);
		return file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith("gif");
			}
		});
	}
	
	@SuppressWarnings("unused")
	private String getExt(String fileName){
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
	@SuppressWarnings("unused")
	private String createNewName(String fileName){
		return UUID.randomUUID().toString()+"."+getExt(fileName);
	}
	public String uploadFile(File file,String fileName,String path){
		if(filepath!=null){
			filepath = path;
		}
		return this.uploadFile(file, fileName);	
	}
	
	public String uploadFile(File file ,String fileName){
		String newName = createNewName(fileName);
		FileInputStream input = null;
		FileOutputStream out = null;
		try {
			input = new FileInputStream(file);
			out = new FileOutputStream(filepath + newName);
			int length = 0;
			byte[] b = new byte[1024];
			while((length=input.read(b))!=-1){
				out.write(b, 0, length);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		} finally{
			try {
				input.close();
			} catch (Exception e) {
				try {
					out.close();
				} catch (Exception e1) {
					throw new RuntimeException();
				}
			}
		}
		
		return newName;
	}
	
	public void delete(String fileName){
		new File(fileName).delete();
	}
}
