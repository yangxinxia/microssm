package org.boluo.dict.model;

import java.util.Date;

import com.smart.mvc.model.PersistentObject;

public class SysLog extends PersistentObject{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2603188166661366823L;

	private Integer id;
	
	private String sysName;

    private String module;
    
    private String className;

    private String method;

    private Integer userId;
    
    private String userAccount;

    private String requestIp;
    
    private String requestParam;
    
    private String commit;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    
    public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}
    
    
}