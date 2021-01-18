package com.la.model.users;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@DiscriminatorValue("BOARD_MEMBER")
public class BoardMember extends SysUser implements Serializable {
}
