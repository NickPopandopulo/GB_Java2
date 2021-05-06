package lesson1.online.prodlike.impl;

import lesson1.online.prodlike.PublicationService;
import lesson1.online.prodlike.model.Publication;

/**
 * Получение публиукации из базы
 */
public class DbPublicationService implements PublicationService {
    @Override
    public Publication getHotPublication() {
        return new Publication();
    }
}
