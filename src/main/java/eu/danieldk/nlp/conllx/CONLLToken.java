// Copyright 2008, 2013 Daniel de Kok
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

package eu.danieldk.nlp.conllx;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/**
 * Instances of <i>CONLLToken</i> represent a token from a CONLL corpus.
 * At the bare minimum a token contains a position/identifier and the
 * actual token. The token can optionally be annotated with: a lemma,
 * a course-grained POS tag, a fine-grained POS tag, features, the head
 * of the token, the dependency relation to the head, the projective head
 * of the token, and the dependency relation to the projective head.
 */
public class CONLLToken implements Token {
    private final int position;

    private final Optional<String> form;

    private final Optional<String> lemma;

    private final Optional<String> coursePOSTag;

    private final Optional<String> posTag;

    private final Optional<String> features;

    private final Optional<Integer> head;

    private final Optional<String> depRel;

    private final Optional<Integer> pHead;

    private final Optional<String> pDepRel;

    public CONLLToken(int position, Optional<String> form, Optional<String> lemma, Optional<String> coursePOSTag,
                      Optional<String> posTag, Optional<String> features, Optional<Integer> head,
                      Optional<String> depRel, Optional<Integer> pHead, Optional<String> pDepRel) {
        Preconditions.checkNotNull(form);
        Preconditions.checkNotNull(lemma);
        Preconditions.checkNotNull(coursePOSTag);
        Preconditions.checkNotNull(posTag);
        Preconditions.checkNotNull(features);
        Preconditions.checkNotNull(head);
        Preconditions.checkNotNull(depRel);
        Preconditions.checkNotNull(pHead);
        Preconditions.checkNotNull(pDepRel);

        this.position = position;
        this.form = form;
        this.lemma = lemma;
        this.coursePOSTag = coursePOSTag;
        this.posTag = posTag;
        this.features = features;
        this.head = head;
        this.depRel = depRel;
        this.pHead = pHead;
        this.pDepRel = pDepRel;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public Optional<String> getForm() {
        return form;
    }

    @Override
    public Optional<String> getLemma() {
        return lemma;
    }

    @Override
    public Optional<String> getCoursePOSTag() {
        return coursePOSTag;
    }

    @Override
    public Optional<String> getPosTag() {
        return posTag;
    }

    @Override
    public Optional<String> getFeatures() {
        return features;
    }

    @Override
    public Optional<Integer> getHead() {
        return head;
    }

    @Override
    public Optional<String> getDepRel() {
        return depRel;
    }

    @Override
    public Optional<Integer> getPHead() {
        return pHead;
    }

    @Override
    public Optional<String> getPDepRel() {
        return pDepRel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CONLLToken that = (CONLLToken) o;

        if (position != that.position) return false;
        if (!coursePOSTag.equals(that.coursePOSTag)) return false;
        if (!depRel.equals(that.depRel)) return false;
        if (!features.equals(that.features)) return false;
        if (!form.equals(that.form)) return false;
        if (!head.equals(that.head)) return false;
        if (!lemma.equals(that.lemma)) return false;
        if (!pDepRel.equals(that.pDepRel)) return false;
        if (!pHead.equals(that.pHead)) return false;
        if (!posTag.equals(that.posTag)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + form.hashCode();
        result = 31 * result + lemma.hashCode();
        result = 31 * result + coursePOSTag.hashCode();
        result = 31 * result + posTag.hashCode();
        result = 31 * result + features.hashCode();
        result = 31 * result + head.hashCode();
        result = 31 * result + depRel.hashCode();
        result = 31 * result + pHead.hashCode();
        result = 31 * result + pDepRel.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String fields[] = {Integer.toString(position), form.or("_"), lemma.or("_"), coursePOSTag.or("_"), posTag.or("_"),
                features.or("_"), intToStringOr(head, "_"), depRel.or("_"), intToStringOr(pHead, "_"), pDepRel.or("_")};
        return StringUtils.join(fields, "\t");
    }

    private String intToStringOr(Optional<Integer> v, String or) {
        return v.isPresent() ? Integer.toString(v.get()) : or;

    }
}
