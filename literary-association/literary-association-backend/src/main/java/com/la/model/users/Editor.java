package com.la.model.users;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@DiscriminatorValue("EDITOR")
public class Editor extends User {
}
