// Copyright 2008, 2009, 2013 Daniel de Kok
//
// This class is part of the Jitar tagger.
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

import java.io.Closeable;
import java.io.IOException;

/**
 * A corpus reader reads tagged tokens from a corpus.
 *
 * @author Daniël de Kok <me@danieldk.eu>
 */
public interface CorpusReader extends Closeable {
    /**
     * Read a sentence.
     *
     * @return A list of tokens with tags, or <tt>null</tt> if the reader is exhausted.
     * @throws java.io.IOException
     */
    public Sentence readSentence() throws IOException;
}
