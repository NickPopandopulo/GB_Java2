package lesson1.prodlike;

import lesson1.prodlike.model.Publication;

public interface PublicationService {
    /**
     * Дай самую горячую публикацию
     */
    Publication getHotPublication();
}
