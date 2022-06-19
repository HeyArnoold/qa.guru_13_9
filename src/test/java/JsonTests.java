import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class JsonTests {

    private static ClassLoader classLoader = JsonTests.class.getClassLoader();

    @Test
    void jsonTest() {

        try (InputStream inputStream = classLoader.getResourceAsStream("example.json")){

            JsonFactory jsonFactory = new JsonFactory();
            JsonParser parser = jsonFactory.createParser(inputStream);
            ObjectMapper objectMapper = new ObjectMapper();

            Pojo jsonAsObj = objectMapper.readValue(parser, Pojo.class);

            assertThat(jsonAsObj.getSquadName()).isEqualTo("Super hero squad");
            assertThat(jsonAsObj.getHomeTown()).isEqualTo("Metro City");
            assertThat(jsonAsObj.getFormed()).isEqualTo(2016);
            assertThat(jsonAsObj.getSecretBase()).isEqualTo("Super tower");
            assertThat(jsonAsObj.isActive()).isTrue();

            assertThat(jsonAsObj.getMembers()).hasSize(3);
            assertThat(jsonAsObj.getMembers().get(0).getName()).isEqualTo("Molecule Man");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
