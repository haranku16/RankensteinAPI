package com.rankenstein.service.validation;

import lombok.Getter;

@Getter
public class ConstraintViolationDocument<T> {

    public static class ConstraintViolationDocumentWithDeclaredField<T> extends ConstraintViolationDocument<T> {
        public static class ConstraintViolationDocumentWithDeclaredConstraintViolation<T> extends ConstraintViolationDocument<T> {
            ConstraintViolationDocumentWithDeclaredConstraintViolation(ConstraintViolationDocument<T> constraintViolationDocument,
                                                                       ConstraintViolation<?> constraintViolation) {
                super.field = constraintViolationDocument.field;
                super.value = constraintViolationDocument.value;
                super.constraintViolation = constraintViolation;
            }
        }

        ConstraintViolationDocumentWithDeclaredField(ConstraintViolationDocument<T> document, String field) {
            super.value = document.value;
            super.field = field;
        }

        public ConstraintViolationDocumentWithDeclaredConstraintViolation<T> because(String reason) {
            return new ConstraintViolationDocumentWithDeclaredConstraintViolation<>(this, new ConstraintViolation<>(reason));
        }

        public ConstraintViolationDocumentWithDeclaredConstraintViolation<T> because(ConstraintViolationDocument<?> reason) {
            return new ConstraintViolationDocumentWithDeclaredConstraintViolation<>(this, new ConstraintViolation<>(reason));
        }
    }

    private String field;
    private T value;
    private ConstraintViolation<?> constraintViolation;

    private ConstraintViolationDocument() {
    }

    private ConstraintViolationDocument(T value) {
        this.value = value;
    }

    public ConstraintViolationDocumentWithDeclaredField<T> fromField(String field) {
        return new ConstraintViolationDocumentWithDeclaredField<>(this, field);
    }

    public static <S> ConstraintViolationDocument<S> of(S value) {
        return new ConstraintViolationDocument<>(value);
    }
}