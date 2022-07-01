package letsgetit.auth.supertoken.service;

import com.samskivert.mustache.Mustache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MustacheService {

    private final Mustache.Compiler compiler;


    public void testMustache() {
        compiler.compile("<><><><>>>>");
    }
}
