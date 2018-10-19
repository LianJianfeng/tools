/**   
 * Copyright © 2018 bjhzwq Info. http://www.bjhzwq.com.Tech Ltd. All rights reserved.
 * @company：北京合众伟奇科技有限公司
 * @Package: mpxplugin.popup.actions 
 * @author: LJF  
 * @date: 2018年10月17日 下午5:34:26 
 */
package mpxplugin.popup.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.jdt.internal.core.PackageFragmentRoot;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.PluginAction;

import com.hzwq.mpsimulator.MpApplicationStater;


/** 
 * @ClassName: MpSimulator 
 * @Description: TODO
 * @author: LJF
 * @date: 2018年10月17日 下午5:34:26  
 */
@SuppressWarnings("restriction")
public class MpSimulator implements IObjectActionDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction  action) {
		// TODO Auto-generated method stub
		
				System.out.println("开始启动模拟器");
				String outputDir=new String();
				if (action instanceof PluginAction) {
				try {
					PluginAction th = (PluginAction) action;
				/**获取当前项目对象、操作节点、JavaProject对象值内容**/
				Map<String,Object> objCollect=getProject(th);
				//定义JAVAProject对象
				IJavaProject javaProject =(IJavaProject)objCollect.get("jProject");
				//获取project对象
				IProject project=(IProject)objCollect.get("project");
				/**获取项目编译输出路径 **/
				IPath outputRelativePath;
				outputRelativePath = javaProject.getOutputLocation().makeRelativeTo(javaProject.getPath());
				outputDir = project.getFile(outputRelativePath).getLocation().toString();
				} catch (JavaModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}	
				System.out.println(getEclipsePath());
				
				MpApplicationStater start=new MpApplicationStater(outputDir,getEclipsePath()+"/mpsimulatorworkspace");
							start.start();
						
				
	}
	/**
 	 * 获取当前项目目录
 	 * @return
 	 */
	public static Map<String,Object> getProject(PluginAction th){  
	    //定义对象存储返回内容  
		Map<String,Object> objCollect=new HashMap<String,Object>();
		IProject project=null;
		Object element=null;
		IJavaProject jProject=null;
		
			ISelection selection = th.getSelection();    
	        if(selection instanceof IStructuredSelection) {    
	             element = ((IStructuredSelection)selection).getFirstElement();    
	            if (element instanceof IResource) {    
	                project= ((IResource)element).getProject();    
	            } else if (element instanceof PackageFragmentRoot) {    
	                jProject =     
	                    ((PackageFragmentRoot)element).getJavaProject();    
	                project = jProject.getProject();    
	            } else if (element instanceof IJavaElement) {    
	               jProject= ((IJavaElement)element).getJavaProject();    
	                project = jProject.getProject();    
	            }else if (element instanceof PackageFragment) {    
	               jProject =     
	                    ((PackageFragment)element).getJavaProject();    
	                project = jProject.getProject();    
	            }
	        }else  if(selection instanceof TreeSelection) {
				element = ((TreeSelection) selection).getFirstElement();
				jProject =     
                    ((PackageFragment)element).getJavaProject();    
                project = jProject.getProject();    
            }    
	        objCollect.put("project", project);
	        objCollect.put("element", element);
	        objCollect.put("jProject", jProject);
	        return objCollect;
	} 
	/**
	 * 获取eclipse的安装路径，形如 E:/eclipse
	 * 
	 * @return
	 */
	public static String getEclipsePath() {
		String ss = Platform.getInstallLocation().getURL().toString();
		int index = ss.indexOf("/");
		return ss.substring(index + 1, ss.length() - 1);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction arg0, ISelection arg1) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void setActivePart(IAction arg0, IWorkbenchPart arg1) {
		// TODO Auto-generated method stub
		
	}

}
