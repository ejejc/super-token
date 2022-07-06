package letsgetit.auth.supertoken.superproject.domain;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
// JPA Entity 클래스들이 해당 클래스를 상속할 경우 필드들을 컬럼으로 인식.
@MappedSuperclass
// 이거 안쓰면 null로 들어가요.. ㅜ (Auditing 기능을 활성화 시켜도 time을 찍어주지 못한당 ..)
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
