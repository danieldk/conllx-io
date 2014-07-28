// Copyright 2014 Daniel de Kok
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package eu.danieldk.nlp.conllx;

import com.google.common.base.Optional;

/**
 * A token, with its morphosyntactical information and dependency
 * relations.
 *
 * @author Daniël de Kok <me@danieldk.eu>
 */
public interface Token {
    /**
     * Get the position of the token within the sentence, starting at 1.
     */
    int getPosition();

    /**
     * Get the form (actual token).
     */
    Optional<String> getForm();

    /**
     * Get the lemma.
     */
    Optional<String> getLemma();

    /**
     * Get the coarse-grained part of speech tag.
     */
    Optional<String> getCoarsePOSTag();

    /**
     * Get the (fine-grained) part of speech tag.
     */
    Optional<String> getPosTag();

    /**
     * Get the features.
     */
    Optional<String> getFeatures();

    /**
     * Get the head of the token. This is either the position or <i>0</i>
     * (for instance, when the token is the root).
     */
    Optional<Integer> getHead();

    /**
     * Get the dependency relation to the head.
     */
    Optional<String> getDepRel();

    /**
     * Get the projective head of the token. This is either the position or <i>0</i>
     * (for instance, when the token is the root). If tokens in a sentence have a
     * projective head, then using all projective heads should result in a projective
     * structure.
     */
    Optional<Integer> getPHead();

    /**
     * Get the dependency relation to the projective head.
     */
    Optional<String> getPDepRel();
}
