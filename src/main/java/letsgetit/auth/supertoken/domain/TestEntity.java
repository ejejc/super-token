package letsgetit.auth.supertoken.domain;

import letsgetit.auth.supertoken.domain.enumtest.Monster;
import letsgetit.auth.supertoken.domain.enumtest.SCP;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class TestEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

}
