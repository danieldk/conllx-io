package eu.danieldk.nlp.conllx;

import eu.danieldk.nlp.conllx.Token;

import java.util.List;

/**
 * A sentence.
 * @author Daniël de Kok
 */
public interface Sentence {
    /**
     * Get the list of tokens in this sentence.
     * @return Token list.
     */
    public List<Token> getTokens();
}
