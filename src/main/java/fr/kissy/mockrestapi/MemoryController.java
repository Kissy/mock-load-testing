package fr.kissy.mockrestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.instrument.Instrumentation;
import java.util.Date;

@RestController
public class MemoryController {

    @GetMapping("/memory")
    public String greeting(@RequestParam(defaultValue = "1000") Integer bytes, @RequestParam(defaultValue = "100") Integer milliseconds) throws InterruptedException {
        byte[] allocation = new byte[bytes];
        Thread.sleep(milliseconds);
        return String.format("memory allocated an array of %d bytes for %d milliseconds — %tQ", allocation.length, milliseconds, new Date());
    }
}
