package com.imooc.product.dataobject;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;  // 类目ID

    private String categoryName;  // 类目名字

    private Integer categoryType; // 类目编号

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createTime; //创建时间

    @LastModifiedDate
    @Column(nullable = false)
    private Date updateTime; //更新时间

}
