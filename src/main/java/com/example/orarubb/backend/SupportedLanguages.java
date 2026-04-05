package com.example.orarubb.backend;

import java.util.Set;

public final class SupportedLanguages {
    private SupportedLanguages() {
    }

    public static final String RO_RO = "ro-RO";
    public static final String EN_GB = "en-GB";
    public static final String DE_DE = "de-DE";
    public static final String HU_HU = "hu-HU";

    public static final Set<String> ALL = Set.of(RO_RO, EN_GB, DE_DE, HU_HU);
    public static final String DEFAULT = RO_RO;
}
