package letsgetit.auth.supertoken.service;

import letsgetit.auth.supertoken.domain.enumtest.Monster;
import letsgetit.auth.supertoken.domain.enumtest.Robot;
import letsgetit.auth.supertoken.domain.enumtest.SCP;
import org.springframework.stereotype.Service;

import java.lang.management.MonitorInfo;
import java.util.Arrays;
import java.util.List;

@Service
public class EnumService {


    public void test() {

        SCP monster1 = Monster.DRAGON;
        SCP monster2 = Monster.ZOMBIE;
        SCP robot1 = Robot.HOUSE;
        SCP robot = Robot.PRINTER;


        List<SCP> scps = Arrays.asList(monster1, monster2, robot, robot1);


        for (SCP scp : scps) {
            System.out.println(scp.toString());
        }

    }
}
