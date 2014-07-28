package eu.danieldk.nlp.conllx.reader;

import eu.danieldk.nlp.conllx.Samples;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Unit tests for {@link CONLLReader}.
 *
 * @author Daniël de Kok <me@danieldk.eu>
 */
public class CONLLReaderTest {
    public static String ERRONEOUS_FRAGMENT = "1\n" +
            "2\n" +
            "1\n" +
            "2";

    @Test
    public void incorrectNumberingTest() throws Exception {
        try (CorpusReader reader = new CONLLReader(new BufferedReader(new StringReader(Samples.TEST_FRAGMENT_INCORRECT_NUMBERING)))) {
            Assert.assertEquals(Samples.TEST_SENTENCE_1, reader.readSentence());
            Assert.assertEquals(Samples.TEST_SENTENCE_2_INCORRECT_NUMBERING, reader.readSentence());
            Assert.assertNull(reader.readSentence());
        }
    }

    @Test(expected = IOException.class)
    public void incorrectNumberingTestStrict() throws Exception {
        try (CorpusReader reader = new CONLLReader(new BufferedReader(new StringReader(Samples.TEST_FRAGMENT_INCORRECT_NUMBERING)), true)) {
            Assert.assertEquals(Samples.TEST_SENTENCE_1, reader.readSentence());
            Assert.assertEquals(Samples.TEST_SENTENCE_2_INCORRECT_NUMBERING, reader.readSentence());
            Assert.assertNull(reader.readSentence());
        }
    }

    @Test
    public void invalidHeadTest() throws Exception {
        try (CorpusReader reader = new CONLLReader(new BufferedReader(new StringReader(Samples.TEST_FRAGMENT_INVALID_HEAD)))) {
            Assert.assertEquals(Samples.TEST_SENTENCE_1, reader.readSentence());
            Assert.assertEquals(Samples.TEST_SENTENCE_2_INVALID_HEAD, reader.readSentence());
            Assert.assertNull(reader.readSentence());
        }
    }

    @Test(expected = IOException.class)
    public void invalidHeadTestStrict() throws Exception {
        try (CorpusReader reader = new CONLLReader(new BufferedReader(new StringReader(Samples.TEST_FRAGMENT_INVALID_HEAD)), true)) {
            Assert.assertEquals(Samples.TEST_SENTENCE_1, reader.readSentence());
            Assert.assertEquals(Samples.TEST_SENTENCE_2_INVALID_HEAD, reader.readSentence());
            Assert.assertNull(reader.readSentence());
        }
    }

    @Test
    public void readSentenceTest() throws Exception {
        try (CorpusReader reader = new CONLLReader(new BufferedReader(new StringReader(Samples.TEST_FRAGMENT)))) {
            Assert.assertEquals(Samples.TEST_SENTENCE_1, reader.readSentence());
            Assert.assertEquals(Samples.TEST_SENTENCE_2, reader.readSentence());
            Assert.assertNull(reader.readSentence());
        }
    }

    @Test
    public void readSentenceRobustnessTest() throws Exception {
        try (CorpusReader reader = new CONLLReader(new BufferedReader(new StringReader(Samples.TEST_FRAGMENT_ROBUST)))) {
            Assert.assertEquals(Samples.TEST_SENTENCE_1, reader.readSentence());
            Assert.assertEquals(Samples.TEST_SENTENCE_2, reader.readSentence());
            Assert.assertNull(reader.readSentence());
        }
    }

    @Test(expected = IOException.class)
    public void tooFewColumnsTest() throws Exception {
        try (CorpusReader reader = new CONLLReader(new BufferedReader(new StringReader(ERRONEOUS_FRAGMENT)))) {
            Assert.assertNull(reader.readSentence());
        }
    }
}
