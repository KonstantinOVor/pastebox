package ru.sendel.pastebox.api.response;

import lombok.RequiredArgsConstructor;


public record PasteBoxResponse(String data, boolean isPublic) {
}
