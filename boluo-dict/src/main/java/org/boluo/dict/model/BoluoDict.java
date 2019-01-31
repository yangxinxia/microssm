package org.boluo.dict.model;

import java.util.Date;

import com.smart.mvc.model.PersistentObject;

public class BoluoDict extends PersistentObject{
    /**
	 * 
	 */
	private static final long serialVersionUID = 795366325417356035L;

	private Integer id;

    private String dictCode;

    private String dictDesc;

    private String remark;

    private Integer isEnabel;
    
    private String isEnabelDesc;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc == null ? null : dictDesc.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsEnabel() {
        return isEnabel;
    }

    public void setIsEnabel(Integer isEnabel) {
        this.isEnabel = isEnabel;
    }
    
    

    public String getIsEnabelDesc() {
		return isEnabelDesc;
	}

	public void setIsEnabelDesc(String isEnabelDesc) {
		this.isEnabelDesc = isEnabelDesc;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}