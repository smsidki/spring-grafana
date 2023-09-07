package id.spring.grafana.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/ping")
public class PingApi {
    
    @GetMapping
    public Map<String, String> pong() {
        log.info("ping request received");
        return Map.of("data", "pong");
    }
    
}
