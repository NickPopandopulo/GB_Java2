package lesson1.prodlike.impl;

import lesson1.prodlike.PublicationService;
import lesson1.prodlike.model.Publication;

public class CachedPublicationService implements PublicationService {

    private final DbPublicationService dbPublicationService;
    private Publication publication;

    public CachedPublicationService(DbPublicationService dbPublicationService) {
        this.dbPublicationService = dbPublicationService;
    }

    @Override
    public Publication getHotPublication() {
        //если нету - иди в базу
        if (publication == null) {
            publication = dbPublicationService.getHotPublication();
        }
        return publication;
    }
}
