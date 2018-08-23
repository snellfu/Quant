
import io.github.biezhi.ome.OhMyEmail;
import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import static io.github.biezhi.ome.OhMyEmail.SMTP_QQ;

/**
 * @author biezhi
 * 2017/5/30
 */
public class OhMyEmailTest {

    @Before
    public void before() throws GeneralSecurityException {
        // 配置，一次即可
        OhMyEmail.config(SMTP_QQ(false), "1101172637@qq.com", "szlfjzvdfdqqifca");
    }

    @Test
    public void testSendText() throws MessagingException {
        OhMyEmail.subject("这是一封测试TEXT邮件")
                .from("QQ邮箱")
                .to("xu.fu@okcoin.com")
                .text("信件内容")
                .send();
    }

    @Test
    public void testSendHtml() throws MessagingException {
        OhMyEmail.subject("这是一封测试HTML邮件")
                .from("QQ邮箱")
                .to("xu.fu@okcoin.com")
                .html("<h1 font=red>信件内容</h1>")
                .send();
    }

    @Test
    public void testSendAttach() throws MessagingException {
        OhMyEmail.subject("这是一封测试附件邮件")
                .from("QQ邮箱")
                .to("xu.fu@okcoin.com")
                .html("<h1 font=red>信件内容</h1>")
                .attach(new File("/Users/fuxu/Desktop/WechatIMG2.jpeg"), "测试图片.jpeg")
                .send();
    }

    @Test
    public void testPebble() throws IOException, MessagingException {
        // PebbleEngine engine = new PebbleEngine.Builder().build();
        // PebbleTemplate compiledTemplate = engine.getTemplate("register.html");
        //
        // Map<String, Object> context = new HashMap<String, Object>();
        // context.put("username", "biezhi");
        // context.put("email", "admin@java-china.org");
        //
        // Writer writer = new StringWriter();
        // compiledTemplate.evaluate(writer, context);
        //
        // String output = writer.toString();
        // System.out.println(output);
        //
        // OhMyEmail.subject("这是一封测试Pebble模板邮件")
        //         .from("fuxu")
        //         .to("xu.fu@okcoin.com")
        //         .html(output)
        //         .send();
    }

    @Test
    public void testJetx() throws IOException, MessagingException {
        // JetEngine engine = JetEngine.create();
        // JetTemplate template = engine.getTemplate("/register.jetx");
        //
        // Map<String, Object> context = new HashMap<String, Object>();
        // context.put("username", "biezhi");
        // context.put("email", "admin@java-china.org");
        // context.put("url", "<a href='http://java-china.org'>https://java-china.org/active/asdkjajdasjdkaweoi</a>");
        //
        // StringWriter writer = new StringWriter();
        // template.render(context, writer);
        // String output = writer.toString();
        // System.out.println(output);
        //
        // OhMyEmail.subject("这是一封测试Jetx模板邮件")
        //         .from("fuxu")
        //         .to("xu.fu@okcoin.com")
        //         .html(output)
        //         .send();
    }

}