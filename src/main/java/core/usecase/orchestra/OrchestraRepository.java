package core.usecase.orchestra;

import core.domain.Event;
import core.domain.Orchestra;
import core.domain.User;

public interface OrchestraRepository {

    boolean existsByName(String name);

    Orchestra findByName(String name);

    Orchestra save(Orchestra orchestra);


}
