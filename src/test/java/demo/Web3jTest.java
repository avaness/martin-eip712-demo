package demo;

import static org.junit.Assert.assertEquals;

import demo.web3j.crypto.StructuredDataEncoder;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.bind.ValidationException;
import org.junit.Test;
import org.web3j.utils.Numeric;

public class Web3jTest {

  private final String firstTryOrderSample;

  public Web3jTest() throws IOException, URISyntaxException {
   firstTryOrderSample = getStringResource("order.json");
  }

  private String getStringResource(String name) throws URISyntaxException, IOException {
    return new String(
        Files.readAllBytes(
            Paths.get(
                getClass().getResource(name)
                    .toURI()
            )
        )
    );
  }

  @Test
  public void first_try_web3j_should_subscribe_properly() throws IOException, ValidationException {
    byte[] messageHash = new StructuredDataEncoder(firstTryOrderSample).hashStructuredData();

    String expectedHash = "0xccb29124860915763e8cd9257da1260abc7df668fde282272587d84b594f37f6";
    assertEquals(expectedHash, Numeric.toHexString(messageHash));
  }
}
