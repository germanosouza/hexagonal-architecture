package com.dzone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = HexagonalDemoApplication.class)
public class HexagonalDemoApplicationTests {

    @Test
    public void main(){
        HexagonalDemoApplication.main(new String[]{});
    }

}
