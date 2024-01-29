package ru.sendel.pastebox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sendel.pastebox.api.request.PasteBoxRequest;
import ru.sendel.pastebox.api.response.PasteBoxResponse;
import ru.sendel.pastebox.api.response.PasteBoxUrlResponse;
import ru.sendel.pastebox.service.PasteBoxService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PasteBoxController {
    private final PasteBoxService pasteBoxService;


    @GetMapping("/")
    public Collection<PasteBoxResponse> getPublicPasteList() {
        return pasteBoxService.getFirstPublicPasteBoxes();
    }

    @GetMapping("/{hash}")
    public PasteBoxResponse getByHash(@PathVariable String hash) {
        return pasteBoxService.getByHash(hash);
    }

    @PostMapping("/")
    public PasteBoxUrlResponse createPaste(@RequestBody PasteBoxRequest request) {
        return pasteBoxService.createPaste(request);
    }
}
