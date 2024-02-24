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
@DiscriminatorValue("H")
public class HomeTask extends Task {
    @CreationTimestamp
    @Column(updatable = true)
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
