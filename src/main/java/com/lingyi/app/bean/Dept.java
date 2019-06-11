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
@ApiModel(value="Dept对象", description="")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "did", type = IdType.AUTO)
    private Integer did;

    private String dname;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    protected Serializable pkVal() {
        return this.did;
    }

    @Override
    public String toString() {
        return "Dept{" +
        "did=" + did +
        ", dname=" + dname +
        "}";
    }
}
