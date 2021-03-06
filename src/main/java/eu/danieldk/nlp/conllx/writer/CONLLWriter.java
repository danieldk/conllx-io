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

package eu.danieldk.nlp.conllx.writer;

import eu.danieldk.nlp.conllx.Sentence;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Writer for CONLL dependency, lemma and part-of-speech tag corpora.
 *
 * @author Daniël de Kok <me@danieldk.eu>
 */
public class CONLLWriter extends AbstractCorpusWriter {
    private final BufferedWriter writer;
    private boolean firstSentence;

    public CONLLWriter(BufferedWriter writer) {
        firstSentence = true;
        this.writer = writer;
    }

    @Override
    public void write(Sentence sentence) throws IOException {
        if (firstSentence)
            firstSentence = false;
        else
            writer.write("\n");

        writer.write(sentence.toString());
        writer.write('\n');
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
