package ru.milovanov;

import ru.milovanov.file.MeFileReader;
import ru.milovanov.parsers.CLI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {


    public static void main(String[] args) throws IOException {
        CLI cli = new CLI();
        cli.parseCommandLine(args);


    }
}