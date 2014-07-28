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

import eu.danieldk.nlp.conllx.reader.CorpusReader;
import eu.danieldk.nlp.conllx.Sentence;

import java.io.IOException;

/**
 * This abstract class provides an implementation {@link CorpusWriter#write(CorpusReader)},
 * that simply writes every sentence from the reader.
 *
 * @author Daniël de Kok <me@danieldk.eu>
 */
public abstract class AbstractCorpusWriter implements CorpusWriter {
    @Override
    public void write(CorpusReader reader) throws IOException {
        Sentence sentence;
        while ((sentence = reader.readSentence()) != null)
            write(sentence);
    }
}
