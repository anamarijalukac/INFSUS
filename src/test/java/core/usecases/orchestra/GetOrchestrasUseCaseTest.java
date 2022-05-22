package core.usecases.orchestra;

import core.domain.Orchestra;
import core.entities.TestCoreEntityGenerator;
import core.usecase.orchestra.GetOrchestrasUseCase;
import core.usecase.orchestra.OrchestraRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class GetOrchestrasUseCaseTest {

    @InjectMocks
    private GetOrchestrasUseCase useCase;

    @Mock
    private OrchestraRepository repository;

    @Test
    public void returnsAllOrchestras() {
        // given
        List<Orchestra> orchestras = TestCoreEntityGenerator.randomItemsOf(TestCoreEntityGenerator::randomOrchestra);
        GetOrchestrasUseCase.InputValues input = new GetOrchestrasUseCase.InputValues();

        // and
        doReturn(orchestras)
                .when(repository)
                .getAll();

        // when
        final List<Orchestra> actual = useCase.execute(input).getOrchestras();

        // then
        assertThat(actual).isEqualTo(orchestras);
    }
}