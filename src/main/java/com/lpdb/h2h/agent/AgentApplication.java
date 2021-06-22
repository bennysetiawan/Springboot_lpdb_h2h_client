package com.lpdb.h2h.agent;

import com.lpdb.h2h.agent.ui.MainFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.Banner;

@SpringBootApplication
public class AgentApplication {

   public static void main(String[] args) {
      MainFrame mainFrame = new MainFrame();
      mainFrame.setVisible(true);
      SpringApplication.run(AgentApplication.class, args);
      //SpringApplication app = new SpringApplication(AgentApplication.class);
      //app.setBannerMode(Banner.Mode.OFF);
      //app.run(args);
   }

}
