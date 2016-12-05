/**
 * 
 */
package zn.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import zn.dao.UserDao;
import zn.until.NoteResult;
import zn.until.ReadFile;

/**
 * @author hq
 *
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	@Resource//注入
	private UserDao userDao;




	
	@Override
	public NoteResult deletePictures(Integer userId) {
		NoteResult note=new NoteResult(); 
		 if(userId==null){
			 	note.setStatus(1);
				note.setMsg("参数不能为空");
				note.setData("");
		 }else{
		String path=userDao.selectUserPic(userId);
		userDao.changePicUrl(userId, "");
	
		File filePath=new File(path);
 		ReadFile.deleteFile(filePath);
 	
		note.setStatus(0);
		note.setMsg("操作成功");
		note.setData("");
	}
		 return note;
	}

	@Override
	public String findUserPicture(int userId) {
		
		
		String path=userDao.selectUserPic(userId);
		return path;
	
	}

	
	@Override
	public NoteResult uploadPictures(MultipartFile file, String pathUrl, String fileName,int userId) {
		NoteResult note=new NoteResult(); 
	 
	         int lastlen= fileName.lastIndexOf(".");
	        String extensionName =fileName.substring(lastlen+1, fileName.length());  
	         Map<String,String> map = new HashMap<String,String>();
	         map.put("jpg", "jpg");
	         map.put("jpeg", "jpeg");
	         map.put("bmp", "bmp");
	         map.put("gif", "gif");
	    if (null == fileName || 0 == fileName.length()) {
	    	note.setStatus(1);
	        note.setMsg("必须输入文件");
	        note.setData("");
	 	// 文件后缀判断
	 	} else if (!map.containsKey(extensionName)) {
	 		note.setStatus(2);
	 		note.setMsg("输入文件格式不正确");
	 		note.setData("");
	 	// 文件读入
	 	} else{
	 			
	 	File upLoadFile = new File(pathUrl+File.separator+fileName);
	 	userDao.changePicUrl(userId, pathUrl+File.separator+fileName);
	 	try {
	 		File filePath=new File(pathUrl);
	 		ReadFile.deleteFile(filePath);
	 		filePath.mkdirs();
			file.transferTo(upLoadFile);
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		} 
			note.setStatus(0);
	 		note.setMsg("操作成功");
	 		note.setData("");
	 	}
	 
			return note;
	}

	
	

	
	
	
	
}
