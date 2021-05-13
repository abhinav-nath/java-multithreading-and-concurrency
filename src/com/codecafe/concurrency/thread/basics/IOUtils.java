package com.codecafe.concurrency.thread.basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

    public static void copy(InputStream src, OutputStream dest) throws IOException {

        int value;
        // reads one byte at a time and write it to the dest
        while ((value = src.read()) != -1) {
            dest.write(value);
        }
    }

    public static void copyFile(String sourceFile, String destFile) throws IOException {

        FileInputStream fin = new FileInputStream(sourceFile);
        FileOutputStream fout = new FileOutputStream(destFile);

        IOUtils.copy(fin, fout);

        System.out.println("copied " + sourceFile + " to " + destFile);

        fin.close();
        fout.close();
    }
}