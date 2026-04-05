package com.example.orarubb.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@IdClass(ClassTypeLocalePK.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassTypeLocale {

    @Id
    @Column(name = "class_type_id", insertable = false, updatable = false)
    private int classTypeId;

    @Id
    @Column(name = "language_tag")
    private String languageTag;

    @Column(name = "name", insertable = false, updatable = false)
    private String name;

    @ManyToOne()
    @JoinColumn(
            name = "class_type_id",
            referencedColumnName = "class_type_id"
    )
    private ClassType classType;
}
