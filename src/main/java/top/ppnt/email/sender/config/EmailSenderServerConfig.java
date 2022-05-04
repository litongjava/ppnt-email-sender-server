package top.ppnt.email.sender.config;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.server.undertow.UndertowConfig;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.litongjava.utils.ip.IpUtils;

import top.ppnt.jfinal.commons.web.constants.PpntJfinalWebConstants;

public class EmailSenderServerConfig extends JFinalConfig {

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

  public void configConstant(Constants me) {
    me.setInjectDependency(true);
    me.setInjectSuperClass(true);
  }

  public void configRoute(Routes me) {
    me.setMappingSuperClass(true);
    me.scan(PpntJfinalWebConstants.CONTROLLER_PACKAGE_NAME);
    me.scan("top.ppnt.email.sender.controler.");
  }

  @Override
  public void configEngine(Engine me) {
  }

  @Override
  public void configPlugin(Plugins me) {
  }

  @Override
  public void configInterceptor(Interceptors me) {
  }

  @Override
  public void configHandler(Handlers me) {
  }
}