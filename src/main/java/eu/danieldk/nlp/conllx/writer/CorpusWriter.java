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

import java.io.Closeable;
import java.io.IOException;

/**
 * Interface for corpus writers.
 *
 * @author Daniël de Kok
 */
public interface CorpusWriter extends Closeable {
    /**
     * Write all the sentences from a {@link CorpusReader}. The reader will
     * <b>not</b> be closed.
     *
     * @param reader The reader.
     * @throws java.io.IOException
     */
    public void write(CorpusReader reader) throws IOException;

    /**
     * Write a sentence to the corpus.
     *
     * @param sentence The sentence.
     * @throws java.io.IOException If the sentence could not be written.
     */
    public void write(Sentence sentence) throws IOException;
}
