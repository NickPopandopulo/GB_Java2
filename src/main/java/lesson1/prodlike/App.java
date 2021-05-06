package lesson1.prodlike;

import lesson1.prodlike.impl.CachedPublicationService;
import lesson1.prodlike.impl.DbPublicationService;

public class App {

    public static void main(String[] args) {
        PublicationService publicationService = new CachedPublicationService(new DbPublicationService());

        //много кода с использованием publicationService
        for (int i=0; i< 1000; i++) {
            System.out.println(publicationService.getHotPublication());
        }
    }


}
