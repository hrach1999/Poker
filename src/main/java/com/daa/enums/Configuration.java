package com.daa.enums;

import java.util.ResourceBundle;

public enum Configuration {
    INSTANCE;

    private static final String CONFIGURATION = "application";

    private static final String PATH_KEY = "path";
    private static final String DELIMITER_KEY = "delimiter";

    private final String PATH;
    private final String DELIMITER;

    Configuration() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(CONFIGURATION);

        PATH = resourceBundle.getString(PATH_KEY);
        DELIMITER = resourceBundle.getString(DELIMITER_KEY);
    }

    public String getPATH() {
        return PATH;
    }

    public String getDELIMITER() {
        return DELIMITER;
    }
}
