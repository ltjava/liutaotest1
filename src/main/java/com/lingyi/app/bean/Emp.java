package com.lingyi.app.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author liu
 * @since 2019-05-17
 */
@ApiModel(value="Emp对象", description="")
public class Emp extends Model<Emp> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "eid", type = IdType.AUTO)
    private Integer eid;

    private String ename;

    private Integer eage;

    private Integer did;


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    protected Serializable pkVal() {
        return this.eid;
    }

    @Override
    public String toString() {
        return "Emp{" +
        "eid=" + eid +
        ", ename=" + ename +
        ", eage=" + eage +
        ", did=" + did +
        "}";
    }
}
