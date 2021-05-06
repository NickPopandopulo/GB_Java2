package lesson1.online.prodlike;

import lesson1.online.prodlike.model.Publication;

public interface PublicationService {
    /**
     * Дай самую горячую публикацию
     */
    Publication getHotPublication();
}
