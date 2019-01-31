package org.boluo.dict.model;

import java.util.Date;

import com.smart.mvc.model.PersistentObject;

public class SysSequence extends PersistentObject{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6500779767624226876L;

	private Integer id;

    private String seqName;

    private Integer currValue;

    private Integer increseValue;

    private String loopFrequency;
    
    private String loopFrequencyDesc;

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

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName == null ? null : seqName.trim();
    }

    public Integer getCurrValue() {
        return currValue;
    }

    public void setCurrValue(Integer currValue) {
        this.currValue = currValue;
    }

    public Integer getIncreseValue() {
        return increseValue;
    }

    public void setIncreseValue(Integer increseValue) {
        this.increseValue = increseValue;
    }

    public String getLoopFrequency() {
        return loopFrequency;
    }

    public void setLoopFrequency(String loopFrequency) {
        this.loopFrequency = loopFrequency;
    }
    

    public String getLoopFrequencyDesc() {
		return loopFrequencyDesc;
	}

	public void setLoopFrequencyDesc(String loopFrequencyDesc) {
		this.loopFrequencyDesc = loopFrequencyDesc;
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