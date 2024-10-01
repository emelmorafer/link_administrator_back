package com.enlaces.enlaces.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static String getParentDir(String currentDir) {
        Path currentPath = Paths.get(currentDir);
        Path parentPath = currentPath.getParent();
        return parentPath.toString();
    }

    public static String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf(".") == -1) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    }

    public static boolean isAllowedExtension(String fileExtension, String[] allowedExtensionsList) {
        for (String allowedExtension : allowedExtensionsList) {
            if (allowedExtension.equalsIgnoreCase(fileExtension)) {
                return true;
            }
        }
        return false;
    }
}
