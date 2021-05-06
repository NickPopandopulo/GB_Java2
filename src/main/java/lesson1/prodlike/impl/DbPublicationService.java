package lesson1.prodlike.impl;

import lesson1.prodlike.PublicationService;
import lesson1.prodlike.model.Publication;

/**
 * Получение публиукации из базы
 */
public class DbPublicationService implements PublicationService {
    @Override
    public Publication getHotPublication() {
        return new Publication();
    }
}
