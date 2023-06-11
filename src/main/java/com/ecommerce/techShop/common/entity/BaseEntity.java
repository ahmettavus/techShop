package com.ecommerce.techShop.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseEntity implements Serializable {

    /**
     * Entity primaryKey UUID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
//
//
//    @CreatedDate
//    @Column(name = "create_date", nullable = false, updatable = false)
//    private LocalDateTime createDate;
//
//    /**
//     * Entity Created By
//     */
//
//    /**
//     * Entity Update Date
//     */
//    @LastModifiedDate
//    @Column(name = "update_date")
//    private LocalDateTime updateDate;
//

}
