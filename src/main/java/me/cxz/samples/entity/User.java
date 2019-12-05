package me.cxz.samples.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@TableName("user")
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {

    // 主键
    @TableField("id")
//    @TableId(type = IdType.ID_WORKER)
    private Long id;
    // 姓名
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    // 年龄
    @TableField(fill = FieldFill.UPDATE)
    private Integer age;
    // 邮箱
    private String email;
    // 直属上级 ID
    private Long managerId;
    // 创建时间
    @TableField(fill = FieldFill.INSERT) // 设置自动填充
    private LocalDateTime createTime;
    // 备注
//    @TableField(exist = false)
//    private String remark;
    // 修改时间
    @TableField(fill = FieldFill.UPDATE) // 设置自动填充
    private LocalDateTime updateTime;
    // 版本
    @Version
    private Integer version;
    // 逻辑删除标识（0:未删除，1:已删除）
    @TableLogic
    @TableField(select = false)
    private Integer deleted;
}
