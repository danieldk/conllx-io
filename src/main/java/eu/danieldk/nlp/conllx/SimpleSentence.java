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

package eu.danieldk.nlp.conllx;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * A sentence without any additional information.
 */
public class SimpleSentence implements Sentence {
    private final List<Token> tokens;

    public SimpleSentence(List<Token> tokens) {
        this(tokens, false);
    }

    public SimpleSentence(List<Token> tokens, boolean checkInvariants) {
        this.tokens = ImmutableList.copyOf(tokens);

        if (checkInvariants) {
            checkInvariants();
        }
    }

    @Override
    public List<Token> getTokens() {
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

        SimpleSentence that = (SimpleSentence) o;

        if (tokens != null ? !tokens.equals(that.tokens) : that.tokens != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tokens != null ? tokens.hashCode() : 0;
    }

    /**
     * Check that the head is connected.
     * @param optHead
     */
    private void checkHead(Token token, Optional<Integer> optHead) {
        if (optHead.isPresent()) {
            int head = optHead.get();
            Preconditions.checkArgument(head >= 0 && head <= tokens.size(), String.format("Head should refer to token or 0: %s", token));
        }
    }

    /**
     * Check invariants: tokens should number from 1..n, heads should point to
     * a token or 0.
     */
    private void checkInvariants() {
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);

            Preconditions.checkArgument(token.getID() == i + 1,
                    String.format("Tokens should be numbered consecutively, starting at 1: %s", token));

            checkHead(token, token.getHead());
            checkHead(token, token.getPHead());
        }
    }
}
