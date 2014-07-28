package eu.danieldk.nlp.conllx;

import com.google.common.base.Optional;

/**
 * @author Daniël de Kok <me@danieldk.eu>
 */
public interface Token {
    int getPosition();

    Optional<String> getForm();

    Optional<String> getLemma();

    Optional<String> getCoursePOSTag();

    Optional<String> getPosTag();

    Optional<String> getFeatures();

    Optional<Integer> getHead();

    Optional<String> getDepRel();

    Optional<Integer> getPHead();

    Optional<String> getPDepRel();
}
