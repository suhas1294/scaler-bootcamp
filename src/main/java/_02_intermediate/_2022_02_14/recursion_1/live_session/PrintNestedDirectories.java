package _02_intermediate._2022_02_14.recursion_1.live_session;

import java.util.ArrayList;
import java.util.List;

/*
Given a directory structure, search for a file in it, if there or not.
You are given following functions:
List<String> getAllDirectories(String directoryName)
List<String> getAllFiles(String directoryName)
 */
public class PrintNestedDirectories {
    // helper functions
    static List<String> getAllDirectories(String directoryName){return new ArrayList<>();}
    static List<String> getAllFiles(String directoryName){return new ArrayList<>();}

    static boolean search(String givenDirectory, String targetFileName){
        List<String> files = getAllFiles(givenDirectory);
        // base condition
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).equals(targetFileName)) return true;
        }
        // main logic
        List<String> directories = getAllDirectories(givenDirectory);
        for (int i = 0; i < directories.size(); i++) {
            if (search(directories.get(i), targetFileName)) return true;
        }
        return false;
    }
}
