package hack4.u.web.server;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class StaticFileController {

    private static final Logger log = LoggerFactory.getLogger(StaticFileController.class);

    @GetMapping("/html/{filename:.+}")
    public ResponseEntity<Resource> serveHtml(@PathVariable String filename) {
        log.info("Accessing HTML file from resources: {}", filename);
        try {
            Resource resource = new ClassPathResource(filename);

            if (resource.exists() && resource.isReadable()) {
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8");
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"");

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(resource);
            } else {
                log.warn("HTML file not found: {}", filename);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            log.error("Error serving HTML file: {}", filename, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}