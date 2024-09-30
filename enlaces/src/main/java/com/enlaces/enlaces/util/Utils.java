package com.enlaces.enlaces.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static String getParentDir(String currentDir) {
        Path currentPath = Paths.get(currentDir);
        Path parentPath = currentPath.getParent();
        return parentPath.toString();
    }
}
