package core.usecase.orchestra;

import core.domain.Orchestra;

import java.util.List;

public interface OrchestraRepository {

    List<Orchestra> getAll();

    boolean existsById(Long id);

    Orchestra getById(Long id);

    Orchestra save(Orchestra orchestra);

    void delete(Long id);

}
