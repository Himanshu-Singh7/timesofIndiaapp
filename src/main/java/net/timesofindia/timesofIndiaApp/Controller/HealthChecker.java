package net.timesofindia.timesofIndiaApp.Controller;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthChecker {



   @GetMapping("/health-check")
   public String healthChecker(){
       log.info("bhjxvgsxcastcxcghxv");
       log.error("gfyttdftfccccfcgcg");
       log.warn("fsafasghgasghasfgahxf");
       log.debug("csaggffcvxxghtcgcf");

       return "Ok";
    }
}
