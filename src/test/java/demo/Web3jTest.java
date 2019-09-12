package demo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import javax.xml.bind.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.web3j.crypto.StructuredDataEncoder;
import org.web3j.utils.Numeric;

public class Web3jTest {


  String firstTryOrderSample = "{\n"
      + "  \"types\": {\n"
      + "    \"EIP712Domain\": [\n"
      + "      {\"name\": \"name\", \"type\": \"string\"},\n"
      + "      {\"name\": \"version\", \"type\": \"string\"},\n"
      + "      {\"name\": \"chainId\", \"type\": \"uint256\"},\n"
      + "      {\"name\": \"verifyingContract\", \"type\": \"address\"}\n"
      + "    ],\n"
      + "    \"Order\": [\n"
      + "      { \"name\": \"makerAddress\", \"type\": \"address\" },\n"
      + "      { \"name\": \"takerAddress\", \"type\": \"address\" },\n"
      + "      { \"name\": \"feeRecipientAddress\", \"type\": \"address\" },\n"
      + "      { \"name\": \"senderAddress\", \"type\": \"address\" },\n"
      + "      { \"name\": \"makerAssetAmount\", \"type\": \"uint256\" },\n"
      + "      { \"name\": \"takerAssetAmount\", \"type\": \"uint256\" },\n"
      + "      { \"name\": \"makerFee\", \"type\": \"uint256\" },\n"
      + "      { \"name\": \"takerFee\", \"type\": \"uint256\" },\n"
      + "      { \"name\": \"expirationTimeSeconds\", \"type\": \"uint256\" },\n"
      + "      { \"name\": \"salt\", \"type\": \"uint256\" },\n"
      + "      { \"name\": \"makerAssetData\", \"type\": \"bytes\" },\n"
      + "      { \"name\": \"makerAssetData\", \"type\": \"bytes\" }\n"
      + "    ]\n"
      + "  },\n"
      + "  \"primaryType\": \"Order\",\n"
      + "  \"domain\": {\n"
      + "    \"name\": \"0x Protocol\",\n"
      + "    \"version\": \"2\",\n"
      + "    \"chainId\": 0,\n"
      + "    \"verifyingContract\": \"0x12459c951127e0c374ff9105dda097662a027093\"\n"
      + "  },\n"
      + "  \"message\": {\n"
      + "    \"makerAddress\": \"0x9e56625509c2f60af937f23b7b532600390e8c8b\",\n"
      + "    \"takerAddress\": \"0xa2b31dacf30a9c50ca473337c01d8a201ae33e32\",\n"
      + "    \"feeRecipientAddress\": \"0xb046140686d052fff581f63f8136cce132e857da\",\n"
      + "    \"senderAddress\": \"0xa2b31dacf30a9c50ca473337c01d8a201ae33e32\",\n"
      + "    \"makerAssetAmount\": 10000000000000000,\n"
      + "    \"takerAssetAmount\": 20000000000000000,\n"
      + "    \"makerFee\": 100000000000000,\n"
      + "    \"takerFee\": 200000000000000,\n"
      + "    \"expirationTimeSeconds\": 1532560590,\n"
      + "    \"salt\": 1532559225,\n"
      + "    \"makerAssetData\": \"0xf47261b0000000000000000000000000e41d2489571d322189246dafa5ebde1f4699f498\",\n"
      + "    \"takerAssetData\": \"0x02571792000000000000000000000000371b13d97f4bf77d724e78c16b7dc74099f40e840000000000000000000000000000000000000000000000000000000000000063\"\n"
      + "  }\n"
      + "}\n";

  @Test
  public void first_try_web3j_should_subscribe_properly() throws IOException, ValidationException {
    byte[] messageHash = new StructuredDataEncoder(firstTryOrderSample).hashStructuredData();

    String expectedHash = "0xccb29124860915763e8cd9257da1260abc7df668fde282272587d84b594f37f6";
    assertEquals(expectedHash, Numeric.toHexString(messageHash));
  }
}
