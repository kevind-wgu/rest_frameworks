package test.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class TestConfiguration extends Configuration {
    @JsonProperty
    String hellotype;
}
