package core.usecase.orchestra;

import core.domain.Event;
import core.domain.Orchestra;
import core.domain.User;

public interface OrchestraRepository {

    boolean existsById(Long id);

    Orchestra getById(Long id);

    Orchestra save(Orchestra orchestra);







}
