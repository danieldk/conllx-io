# conllx-io

## Introduction

This is a small library providing a reader and writer for the
[CoNLL-X](http://ilk.uvt.nl/conll/) format. It is less strict
than the actual CoNLL format, since it allows any column except
the ID column to be optional. This makes the library useful for
non-dependency parsing tasks as well.
