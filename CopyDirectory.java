/**   
 * Copyright © 2018 bjhzwq Info. http://www.bjhzwq.com.Tech Ltd. All rights reserved.
 * @company：北京合众伟奇科技有限公司
 * @Package: com.hzwq.mpsimulator 
 * @author: LJF  
 * @date: 2018年10月18日 下午5:45:26 
 */
package com.hzwq.mpsimulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
 * @ClassName: CopyDirectory 
 * @Description: TODO
 * @author: LJF
 * @date: 2018年10月18日 下午5:45:26  
 */
public class CopyDirectory {
	public static void copyfile(File oldfile,File newfile) throws IOException{
		//复制文件
		FileInputStream ins = new FileInputStream(oldfile);
		FileOutputStream out = new FileOutputStream(newfile);
		//自定义缓冲对象
		byte[] b = new byte[1024];
		int n=0;
		while((n=ins.read(b))!=-1){
		out.write(b, 0, b.length);
		} 
		ins.close();
		out.close();

		System.out.println("copy success");
		}
}
