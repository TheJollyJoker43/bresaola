package it.giovannipicco.bresaola.exception;

import it.giovannipicco.bresaola.exception.bean.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionType {

    private AbstractException exception;
    private ExceptionConfiguration faultKey;
    private HttpStatus status;

    // FATAL ERROR
    public static final ExceptionType UNMANAGED_ERROR =
            new ExceptionType(new FatalException(), ExceptionConfiguration.UNMANAGED_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

    public static final ExceptionType NO_ENVIRONMENT_LABEL_FOUND =
            new ExceptionType(new FatalException(), ExceptionConfiguration.NO_ENVIRONMENT_LABEL_FOUND, HttpStatus.INTERNAL_SERVER_ERROR);

    // VALIDATION ERROR
    public static final ExceptionType INVALID_REQUEST =
            new ExceptionType(new ValidationException(), ExceptionConfiguration.NOT_VALID_REQUEST, HttpStatus.BAD_REQUEST);

    public static final ExceptionType NO_MATCH_WITH_REGEX =
            new ExceptionType(new ValidationException(), ExceptionConfiguration.NO_MATCH_WITH_REGEX, HttpStatus.BAD_REQUEST);

    public static final ExceptionType ENTITY_ALREADY_PRESENT =
            new ExceptionType(new ValidationException(), ExceptionConfiguration.ENTITY_ALREADY_PRESENT, HttpStatus.CONFLICT);

    public static final ExceptionType ENTITY_NOT_PRESENT =
            new ExceptionType(new ValidationException(), ExceptionConfiguration.ENTITY_NOT_PRESENT, HttpStatus.NOT_FOUND);

    public static final ExceptionType NOT_IN_THE_ENUM =
            new ExceptionType(new ValidationException(), ExceptionConfiguration.NOT_IN_THE_ENUM, HttpStatus.BAD_REQUEST);

    public static final ExceptionType PAGEABLE_PAGE_IS_NOT_AN_INTEGER =
            new ExceptionType(new ValidationException(), ExceptionConfiguration.PAGEABLE_PAGE_IS_NOT_AN_INTEGER, HttpStatus.BAD_REQUEST);

    public static final ExceptionType PAGEABLE_SIZE_IS_NOT_AN_INTEGER =
            new ExceptionType(new ValidationException(), ExceptionConfiguration.PAGEABLE_SIZE_IS_NOT_AN_INTEGER, HttpStatus.BAD_REQUEST);

    public static final ExceptionType PAGEABLE_MISSING_ARGUMENT =
            new ExceptionType(new ValidationException(), ExceptionConfiguration.PAGEABLE_MISSING_ARGUMENT, HttpStatus.BAD_REQUEST);

    // SYSTEM EXCEPTION
    public static final ExceptionType GET_BY_ID_KO =
            new ExceptionType(new SystemException(), ExceptionConfiguration.GET_BY_ID_KO, HttpStatus.INTERNAL_SERVER_ERROR);

    public static final ExceptionType GET_ALL_KO =
            new ExceptionType(new SystemException(), ExceptionConfiguration.GET_ALL_KO, HttpStatus.INTERNAL_SERVER_ERROR);

    public static final ExceptionType ADD_KO =
            new ExceptionType(new SystemException(), ExceptionConfiguration.ADD_KO, HttpStatus.INTERNAL_SERVER_ERROR);

    public static final ExceptionType EDIT_KO =
            new ExceptionType(new SystemException(), ExceptionConfiguration.EDIT_KO, HttpStatus.INTERNAL_SERVER_ERROR);

    public static final ExceptionType DELETE_KO =
            new ExceptionType(new SystemException(), ExceptionConfiguration.DELETE_KO, HttpStatus.INTERNAL_SERVER_ERROR);

}
