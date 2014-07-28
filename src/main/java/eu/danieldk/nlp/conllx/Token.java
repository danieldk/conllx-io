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
