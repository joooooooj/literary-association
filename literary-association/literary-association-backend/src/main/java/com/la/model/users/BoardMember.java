package com.la.model.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
