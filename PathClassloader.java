/**   
 * Copyright © 2018 bjhzwq Info. http://www.bjhzwq.com.Tech Ltd. All rights reserved.
 * @company：北京合众伟奇科技有限公司
 * @Package: com.hzwq.mpsimulator.mos 
 * @author: LJF  
 * @date: 2018年10月18日 上午9:01:39 
 */
package com.hzwq.mpsimulator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import org.apache.log4j.Logger;

/** 
 * @ClassName: PathClassloader 
 * @Description: TODO 自定义类加载器
 * @author: LJF
 * @date: 2018年10月18日 上午9:01:39  
 */


public class PathClassloader extends ClassLoader
{
    private String classPath;
    private static Logger logger=Logger.getLogger("com.hzwq.mpsimulator.PathClassloader");//获得该Logger实例，设置为静态域添加到类中 
    public PathClassloader(String classPath)
    {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
    	logger.info("加载"+name+"类");
        byte[] classData = getData(name);
        if (classData == null)
        {
            throw new ClassNotFoundException();
        }
        else
        {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getData(String className)
    {
        String path = classPath + File.separatorChar+className.replace('.', File.separatorChar)+".class";
        try
        {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while((num = is.read(buffer))!=-1)
            {
                stream.write(buffer,0,num);
            }
            is.close();
            return stream.toByteArray();
           
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
