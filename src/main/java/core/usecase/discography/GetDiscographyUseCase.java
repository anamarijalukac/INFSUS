package core.usecase.discography;

import core.domain.Discography;
import core.domain.NotFoundException;
import core.usecase.UseCase;
import lombok.Value;

public class GetDiscographyUseCase extends UseCase<GetDiscographyUseCase.InputValues, GetDiscographyUseCase.OutputValues> {

    private final DiscographyRepository repository;

    public GetDiscographyUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        final Long id = input.getDiscographyId();

        Discography discography = repository.getDiscographyById(id);

        if (discography == null) {
            throw new NotFoundException("Discography " + id + " not found");
        }

        return new OutputValues(discography);
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long discographyId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Discography discography;
    }
}
