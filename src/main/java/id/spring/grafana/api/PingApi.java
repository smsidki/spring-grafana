package id.spring.grafana.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ping")
public class PingApi {
    
    @GetMapping
    public Map<String, String> pong() {
        return Map.of("data", "pong");
    }
    
}
