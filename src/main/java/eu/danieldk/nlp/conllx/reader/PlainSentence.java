// Copyright 2013 Daniel de Kok
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

package eu.danieldk.nlp.conllx.reader;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * A sentence without any additional information.
 */
public class PlainSentence implements Sentence {
    private final List<CONLLToken> tokens;

    public PlainSentence(List<CONLLToken> tokens) {
        this.tokens = tokens;
    }

    @Override
    public List<CONLLToken> getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return StringUtils.join(tokens, '\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlainSentence that = (PlainSentence) o;

        if (tokens != null ? !tokens.equals(that.tokens) : that.tokens != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tokens != null ? tokens.hashCode() : 0;
    }
}
