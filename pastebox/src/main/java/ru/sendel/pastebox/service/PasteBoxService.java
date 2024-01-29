package ru.sendel.pastebox.service;

import ru.sendel.pastebox.api.request.PasteBoxRequest;
import ru.sendel.pastebox.api.response.PasteBoxResponse;
import ru.sendel.pastebox.api.response.PasteBoxUrlResponse;

import java.util.List;

public interface PasteBoxService {
    PasteBoxResponse getByHash (String hash);
    List<PasteBoxResponse> getFirstPublicPasteBoxes();
    PasteBoxUrlResponse createPaste(PasteBoxRequest request);
}
