package core.usecase.orchestra;

import core.domain.Event;
import core.domain.Orchestra;
import core.domain.User;

import java.util.List;

public interface OrchestraRepository {

    List<Orchestra> getAll();

    boolean existsById(Long id);

    Orchestra getById(Long id);

    Orchestra save(Orchestra orchestra);

    void delete(Long id);

}
