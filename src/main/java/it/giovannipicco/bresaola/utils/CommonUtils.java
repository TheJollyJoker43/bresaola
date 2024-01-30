package it.giovannipicco.bresaola.utils;

import it.giovannipicco.bresaola.exception.ExceptionFactory;
import it.giovannipicco.bresaola.exception.ExceptionType;
import it.giovannipicco.bresaola.utils.constant.Origin;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CommonUtils {


    /**
     * Creo l'oggetto per recuperare liste paginate degli eventi
     * @param page Numero della pagina da recuperare
     * @param size Grandezza della pagina, quanti elementi contiene
     * @param sort Orientamento della lista recuperata
     * @return Istanza con le caratteristiche indicate
     */
    public static Pageable getPageable(String page, String size, String[] sort, Origin origin){
        Pageable pageable = null;
        // Gestione della paginazione
        if(page != null && !page.isEmpty() &&
                size != null && !size.isEmpty()){

            // Preparo le variabili
            Integer intPage = null;
            Integer intSize = null;

            //Verifico che riesco a trasformare page in un int
            try {
                intPage = Integer.parseInt(page);
            } catch (Exception e){
                throw ExceptionFactory
                        .create(
                                ExceptionType.PAGEABLE_PAGE_IS_NOT_AN_INTEGER, e, origin);
            }

            //Verifico che riesco a trasformare page in un int
            try {
                intSize = Integer.parseInt(size);
            } catch (Exception e){
                throw ExceptionFactory
                        .create(
                                ExceptionType.PAGEABLE_SIZE_IS_NOT_AN_INTEGER, e, origin);
            }

            // Faccio un check sul sort, se vuoto lo metto
            // di default ordinandolo per id crescente
            if(sort == null || sort.length > 0){
                sort = new String[]{"id"};
            }

            pageable = PageRequest.of(intPage, intSize, Sort.by(sort));

        } else // Controllo se per caso è stata fatta una request incompleta
            if ((size == null && page != null)
                    || (page == null && size != null)) {
                throw ExceptionFactory
                        .create(
                                ExceptionType.PAGEABLE_MISSING_ARGUMENT, origin);
            }
        return pageable;
    }

}
