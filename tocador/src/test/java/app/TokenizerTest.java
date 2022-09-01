package app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import app.backend.Tokenizer;
import app.enums.Tokens;


public class TokenizerTest {

    @Test
    public void stringToToken() {

        ArrayList<Tokens> expectedToken = new ArrayList<Tokens>();
        expectedToken.add(Tokens.NOTA_LA);
        expectedToken.add(Tokens.NOTA_LA);
        expectedToken.add(Tokens.FIM);

        // assertArrayEquals(expectedToken.toArray(), Tokenizer.createToken("AA").toArray());
        assertEquals(expectedToken, Tokenizer.createToken("AA"));

        // expected: java.util.ArrayList<[NOTA_LA, NOTA_LA, FIM]>
        // but was: java.util.ArrayList<[NOTA_LA, NOTA_LA, FIM]>
    }

}
