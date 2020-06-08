package net.xinhuamm.auth.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description:搜索专用
 * User: zhouzhou
 * Date: 2019-07-26
 * Time: 17:28
 */
@Data
public class BaseQuery {

    @ApiModelProperty(value = "起始页", position = 0)
    int startPage = 1;

    @ApiModelProperty(value = "每页大小(默认10)", position = 1)
    int pageSize = 10;

    /**
     * 创建时间起
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeStart;

    /**
     * 创建时间止
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeEnd;

}
