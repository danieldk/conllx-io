package eu.danieldk.nlp.conllx;

import org.junit.Assert;
import org.junit.Test;

public class SimpleSentenceTest {
    @Test
    public void incorrectNumberingTest() {
        Sentence s = new SimpleSentence(Samples.TEST_SENTENCE_2_INCORRECT_NUMBERING.getTokens());
        Assert.assertNotNull(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectNumberingTestStrict() {
        new SimpleSentence(Samples.TEST_SENTENCE_2_INCORRECT_NUMBERING.getTokens(), true);
    }

    @Test
    public void testInvalidHead() {
        Sentence s = new SimpleSentence(Samples.TEST_SENTENCE_2_INVALID_HEAD.getTokens());
        Assert.assertNotNull(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHeadStrict() {
        new SimpleSentence(Samples.TEST_SENTENCE_2_INVALID_HEAD.getTokens(), true);
    }

}