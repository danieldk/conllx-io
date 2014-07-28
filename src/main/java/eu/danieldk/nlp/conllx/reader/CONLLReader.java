// Copyright 2008, 2013 Daniel de Kok
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

import com.google.common.base.Optional;
import eu.danieldk.nlp.conllx.CONLLToken;
import eu.danieldk.nlp.conllx.Sentence;
import eu.danieldk.nlp.conllx.SimpleSentence;
import eu.danieldk.nlp.conllx.Token;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CONLLReader implements CorpusReader {
    private final BufferedReader reader;

    /**
     * Construct a CONLL corpus reader without start/end tokens and first word decapitalization.
     *
     * @param reader A corpus reader.
     */
    public CONLLReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    @Override
    public Sentence readSentence() throws IOException {
        List<Token> tokens = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String parts[] = StringUtils.split(line.trim(), '\t');

            // We are done with these tokens.
            if (parts.length == 0) {
                if (tokens.isEmpty())
                    continue;

                return new SimpleSentence(tokens);
            }

            if (parts.length < 2)
                throw new IOException(String.format("Line has fewer than two columns: %s", line));

            Integer tokenId = Integer.parseInt(parts[0]);
            Optional<String> form = valueForColumn(parts, 1);
            Optional<String> lemma = valueForColumn(parts, 2);
            Optional<String> courseTag = valueForColumn(parts, 3);
            Optional<String> tag = valueForColumn(parts, 4);
            Optional<String> features = valueForColumn(parts, 5);
            Optional<Integer> head = intValueForColumn(parts, 6);
            Optional<String> headRel = valueForColumn(parts, 7);
            Optional<Integer> pHead = intValueForColumn(parts, 8);
            Optional<String> pHeadRel = valueForColumn(parts, 9);

            Token token = new CONLLToken(tokenId, form, lemma, courseTag, tag, features, head, headRel,
                    pHead, pHeadRel);

            tokens.add(token);
        }

        // If the the file does not end with a blank line, we have left-overs.
        if (!tokens.isEmpty()) {
            return new SimpleSentence(tokens);
        }

        return null;
    }

    private Optional<String> valueForColumn(String[] columns, int column) {
        if (column >= columns.length)
            return Optional.absent();

        if (columns[column].equals("_"))
            return Optional.absent();

        return Optional.of(columns[column]);
    }

    private Optional<Integer> intValueForColumn(String[] columns, int column) {
        if (column >= columns.length)
            return Optional.absent();

        if (columns[column].equals("_"))
            return Optional.absent();

        return Optional.of(Integer.parseInt(columns[column]));
    }
}
