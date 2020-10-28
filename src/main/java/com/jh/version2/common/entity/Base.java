package com.jh.version2.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.jh.version2.common.dto.variable.YesOrNo;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * BaseTimeEntity Entity
 *
 * @author [오지훈]
 * @implNote BaseTimeEntity Entity 작성
 * @since 2020. 10. 28. 오전 11:49:29
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base {

    /**
     * 사용 여부
     *
     * @author [오지훈]
     */
    @Column(name = "USE_YN")
    @Enumerated(value = EnumType.STRING)
    //@ApiModelProperty(name = "useYn", value = "사용 여부", hidden = true, required = true)
    private YesOrNo useYn = YesOrNo.Y;

    /**
     * 삭제 여부
     *
     * @author [오지훈]
     */
    @Column(name = "DELETE_YN")
    @Enumerated(value = EnumType.STRING)
    //@ApiModelProperty(name = "deleteYn", value = "삭제 여부", hidden = true, required = true)
    private YesOrNo deleteYn = YesOrNo.N;

    /**
     * 최초 작성자
     *
     * @author [오지훈]
     */
    @CreatedBy
    @Column(name = "REGISTER_SEQ")
    //@ApiModelProperty(name = "registerId", value = "최초 작성자 ID", hidden = true, required = true)
    private Long registerSeq;

    /**
     * 최종 수정자
     *
     * @author [오지훈]
     */
    @LastModifiedBy
    @Column(name = "UPDATER_SEQ")
    //@ApiModelProperty(name = "updaterId", value = "최종 수정자 ID", hidden = true, required = true)
    private Long updaterSeq;

    /**
     * 최초 작성일
     *
     * @author [오지훈]
     */
    @Column(name = "REGISTRATION_DT")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
    @CreationTimestamp
    //@ApiModelProperty(name = "registrationDt", value = "최초 작성일", hidden = true)
    private LocalDateTime registrationDt;

    /**
     * 최종 수정일
     *
     * @author [오지훈]
     */
    @Column(name = "UPDATE_DT")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
    @UpdateTimestamp
    //@ApiModelProperty(name = "updateDt", value = "최종 수정일", hidden = true)
    private LocalDateTime updateDt;

    /**
     * Update ban.
     *
     * @author [오지훈]
     * @implNote 사용 중지
     * @since 2020. 10. 28. 오전 11:51:44
     */
    public void updateBan() {
        this.useYn = YesOrNo.N;
    }

    /**
     * Delete.
     *
     * @author [오지훈]
     * @implNote 삭제
     * @since 2020. 10. 28. 오전 11:51:45
     */
    public void delete() {
        this.deleteYn = YesOrNo.Y;
    }
}
