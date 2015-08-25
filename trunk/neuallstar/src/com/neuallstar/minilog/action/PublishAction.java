/**
 *com.neuallstar.minilog.action
 * PublishAction.java
 */
package com.neuallstar.minilog.action;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.neuallstar.minilog.entity.Addition;
import com.neuallstar.minilog.entity.Minilog;
import com.neuallstar.minilog.entity.MinilogConstant;
import com.neuallstar.minilog.entity.MinilogUser;
import com.neuallstar.minilog.service.IMinilogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 陈秀能 2011-7-31 下午08:08:31
 */
public class PublishAction extends ActionSupport {
	private String content;
	private String fromid;
	private String imgid;
	
	private Minilog minilog;

	public String getContent() {
		System.out.println(this.getClass()+" set content="+content);
		return content;
	}

	public void setContent(String content) {
		System.out.println(this.getClass()+" get content="+content);
		this.content = content;
	}

	public Minilog getMinilog() {
		return minilog;
	}

	public void setMinilog(Minilog minilog) {
		this.minilog = minilog;
	}

	private IMinilogService minilogService;

	public IMinilogService getMinilogService() {
		return minilogService;
	}

	public void setMinilogService(IMinilogService minilogService) {
		this.minilogService = minilogService;
	}

	public String execute() {
		Map<String, MinilogUser> miniglogUserSession = ActionContext
				.getContext().getSession();
		MinilogUser minilogUser = null;
		if ((minilogUser = miniglogUserSession.get(MinilogConstant.MINILOG_SESSION)) != null) {
			System.out.println(this.getClass()+" content="+content);
		   minilog = new Minilog();
		   minilog.setContent(content);
		   minilog.setPublisher(minilogUser);
		   minilog.setTime(new Timestamp(System.currentTimeMillis()));
		   if(fromid!=null){
			   Minilog from=new Minilog();
			   from.setMinilogId(Integer.valueOf(fromid));
			   minilog.setFrom(from);
		   }
		   Set<Addition> adds=new HashSet<Addition>();
		   if(imgid!=null){
			   Addition add=new Addition();
			  // add.setAddtionId(Integer.valueOf(imgid));
			   add.setContent(MinilogConstant.RESOURCES_PATH+"/"+MinilogConstant.IMAGE_PATH);
			   add.setType(MinilogConstant.ADDITION_TYPE_IMAGE);
			   add.setMinilog(minilog);
			   adds.add(add);
		   }
		   if(!adds.isEmpty()){
			   minilog.setAdditions(adds);
		   }
		   minilogService.saveMinilog(minilog);
		}
		return this.SUCCESS;
	}
}
