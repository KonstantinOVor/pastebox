package ru.sendel.pastebox.repository;

import org.springframework.stereotype.Repository;
import ru.sendel.pastebox.exception.NotFoundException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PasteBoxRepositoryMap implements PasteBoxRepository {
    private final Map<String, PasteBoxEntity> vault = new ConcurrentHashMap<>();
    @Override
    public PasteBoxEntity getByHash(String hash) {
        PasteBoxEntity pasteBoxEntity = vault.get(hash);

        if (pasteBoxEntity == null) {
            throw new NotFoundException("Entity with hash " + hash + " not found");
        }
        return pasteBoxEntity;
    }

    @Override
    public List<PasteBoxEntity> getListOfPublicAndAlive(int amount) {
        LocalDateTime now = LocalDateTime.now();

        return vault.values().stream()
                .filter(PasteBoxEntity::isPublic)
                .filter(pasteBoxEntity -> pasteBoxEntity.getLifetime().isAfter(now))
                .sorted(Comparator.comparing(PasteBoxEntity::getId).reversed())
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public void add(PasteBoxEntity entity) {
        vault.put(entity.getHash(), entity);
    }
}
