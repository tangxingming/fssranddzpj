package com.youchu.fssranddzpj;



import net.sf.json.xml.XMLSerializer;
import com.youchu.fssranddzpj.config.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.text.DateFormat;

@SpringBootTest(classes = FssranddzpjApplication.class)
@RunWith(SpringRunner.class)
public class RabbitMQControllerTest {
    @Autowired
    private Sender sender;

    @Test
    public void sendQueue() {
        String xml = "<example><a>123</a><b>456</b><c>10</c></example>";

        //创建 XMLSerializer对象
        XMLSerializer xmlSerializer = new XMLSerializer();
        //将xml转为json
        String result = xmlSerializer.read(xml).toString();
        //输出json内容
        System.out.println(result);
        sender.sendQueue(result);
    }


}