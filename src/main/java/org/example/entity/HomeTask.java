package org.example.entity;

import lombok.*;
import org.example.entity.embeddable.Address;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "home_task")
@PrimaryKeyJoinColumn(name = "task_id")
public class HomeTask extends Task {
    @CreationTimestamp
    @Column
    private LocalDateTime startDate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime endDate;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city"))
    })
    @Embedded
    private Address address;
}
