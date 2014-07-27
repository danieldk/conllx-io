package eu.danieldk.nlp.conllx.writer;

import eu.danieldk.nlp.conllx.Samples;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Unit tests for {@link CONLLWriter}.
 *
 * @author Daniël de Kok <me@danieldk.eu>
 */
public class CONLLWriterTest {
    @Test
    public void writeTest() throws IOException {
        StringWriter sw = new StringWriter();
        try (CONLLWriter writer = new CONLLWriter(new BufferedWriter(sw))) {
            writer.write(Samples.TEST_SENTENCE_1);
            writer.write(Samples.TEST_SENTENCE_2);
        }

        Assert.assertEquals(Samples.TEST_FRAGMENT_EMPTY_PROJ, sw.toString());
    }
}