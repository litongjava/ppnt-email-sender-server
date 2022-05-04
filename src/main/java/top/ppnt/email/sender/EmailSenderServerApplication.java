package top.ppnt.email.sender;

import com.jfinal.server.undertow.UndertowConfig;
import com.jfinal.server.undertow.UndertowServer;
import com.litongjava.utils.ip.IpUtils;

import top.ppnt.email.sender.config.EmailSenderServerConfig;
import top.ppnt.jfinal.commons.web.constants.PpntJfinalWebConstants;

public class EmailSenderServerApplication {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    UndertowServer server = UndertowServer.create(EmailSenderServerConfig.class);
    server.addHotSwapClassPrefix(PpntJfinalWebConstants.PACKAGE_NAME);
    server.start();
    UndertowConfig undertowConfig = server.getUndertowConfig();
    int port = undertowConfig.getPort();
    String contextPath = undertowConfig.getContextPath();
    long end = System.currentTimeMillis();
    IpUtils.getThisUrl(port, contextPath);
    System.out.println("启动完成,共使用了" + (end - start) + "ms");
  }
}