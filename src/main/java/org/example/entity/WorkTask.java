package org.example.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "work_task")
@DiscriminatorValue("W")
public class WorkTask extends Task {
    @Column
    private int cost;
}
