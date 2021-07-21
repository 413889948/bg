package cn.hyx.bg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @Author: 黄祎翔
 * @Date: 2021/7/21 16:50
 *
 */
@Data
@TableName(value = "sixty_four_symbols")
public class SixtyFourSymbolsEntity {
    @TableId(value = "ID",type= IdType.AUTO)
    private int id;

    @TableField(value = "`NAME`")
    private String name;

    @TableField(value = "EXPLAIN_EASY")
    private String explainEasy;
    @TableField(value = "`EXPLAIN`")
    private String explain;


}
