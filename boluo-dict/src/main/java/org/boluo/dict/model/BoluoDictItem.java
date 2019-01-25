package org.boluo.dict.model;

import java.util.Date;

import com.smart.mvc.model.PersistentObject;

public class BoluoDictItem extends PersistentObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 146888333112041302L;

	private Integer id;

    private String dictCode;

    private String dictitemCode;

    private String dictitemDesc;

    private Integer sort;

    private String remark;

    private Integer isEnabel;

    private Date createTime;

    private Date updateTime;
    
    private String busiCode;

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

    public String getDictitemCode() {
        return dictitemCode;
    }

    public void setDictitemCode(String dictitemCode) {
        this.dictitemCode = dictitemCode == null ? null : dictitemCode.trim();
    }

    public String getDictitemDesc() {
        return dictitemDesc;
    }

    public void setDictitemDesc(String dictitemDesc) {
        this.dictitemDesc = dictitemDesc == null ? null : dictitemDesc.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
    
    
}