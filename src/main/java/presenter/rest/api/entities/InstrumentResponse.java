package presenter.rest.api.entities;

import core.domain.Instrument;
import lombok.Value;

@Value
public class InstrumentResponse {
    Long id;
    String name;

    public static InstrumentResponse from(Instrument instrument) {
        return new InstrumentResponse(
                instrument.getId(),
                instrument.getName()
        );
    }
}
