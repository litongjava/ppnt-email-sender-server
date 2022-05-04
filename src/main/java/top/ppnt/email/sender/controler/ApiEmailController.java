package top.ppnt.email.sender.controler;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.litongjava.utils.mail.MailUtils;
import com.litongjava.utils.vo.JsonBean;

/**
 * @author Ping E Lee
 *
 */
@Path("api/email")
public class ApiEmailController extends Controller {

  public void send(String to, String subject, String content) {
    JsonBean<String> jsonBean = new JsonBean<>();
    try {
      MailUtils.sendMail(to, subject, content, false);
      jsonBean.setData("success");
    } catch (Exception e) {
      jsonBean.setCode(-1);
      jsonBean.setMsg(e.getMessage());
      e.printStackTrace();
    }
    renderJson(jsonBean);
  }
}
