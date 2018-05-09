package com.orm.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_member")
public class Member {

    @Id private Integer id;

}
