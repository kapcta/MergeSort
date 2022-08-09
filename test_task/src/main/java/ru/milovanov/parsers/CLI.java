package ru.milovanov.parsers;

import org.apache.commons.cli.*;
import ru.milovanov.file.MeFileReader;
import ru.milovanov.file.MeFileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CLI {

    private static final Option ASCENDING = new Option("a", "ascending",false,"Sort by ascending");
    private static final Option DESCENDING = new Option("d", "descending", false, "Sort by descending");
    private static final Option STRING = new Option("s", "string", false, "String data type");
    private static final Option INTEGER = new Option("i", "integer", false, "Integer data type");
    private static final Option OUTPUT_PATH = new Option("op", "output_path", false, "Output file path");
   // private static final Option INPUT_PATH = new Option("ip", "input_path", false, "Input file path");

    public void printHelp(Options options){
        HelpFormatter formatter = new HelpFormatter();
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Current java version " + System.getProperty("java.version"));
        formatter.printUsage(pw, 100, "java -jar merge-sort-1.0.jar");
        formatter.printOptions(pw, 100, options, 2, 5);
        pw.close();
    }

    public void parseCommandLine(String[] args){
        CommandLineParser clp = new DefaultParser();

        Options options = new Options();
        options.addOption(ASCENDING);
        options.addOption(DESCENDING);
        options.addOption(STRING);
        options.addOption(INTEGER);
        //options.addOption(INPUT_PATH);
        //options.addOption(OUTPUT_PATH);

        try {
            CommandLine cl = clp.parse(options, args);
            Map<Integer, String> NAME_OF_FILES = new HashMap<>();
            Map<Integer, MeFileReader> READERS = new HashMap<>();

            for (int i = 1; i <= Integer.parseInt(cl.getArgList().get(0)); i++) {
                NAME_OF_FILES.put(i, "/Users/Mr.Milovanov/IdeaProjects/MergeSort/test_task/src/main/resources/" + cl.getArgList().get(i));
                READERS.put(i, new MeFileReader(NAME_OF_FILES.get(i)));
            }

            Map<Integer, String> map = new HashMap<>();


            if (cl.hasOption(ASCENDING.getLongOpt()) & cl.hasOption(INTEGER.getLongOpt())) {

                MeFileWriter writer = new MeFileWriter(NAME_OF_FILES.get(1));
                for (int j = 0; j <= 3; j++) {
                    for (int i = 2; i <= NAME_OF_FILES.size(); i++) {
                        if (!map.containsKey(i)) {
                            map.put(i, READERS.get(i).readFileByChar());
                        }
                    }
                    System.out.println(j);
                    System.out.println(map);


                    writer.writeByChar(Collections.min(map.values()));
                    System.out.println(Collections.min(map.values()));
                    map.entrySet().removeIf(entry -> Objects.equals(entry.getValue(), Collections.min(map.values())));
                    System.out.println(map);
                    //printHelp(options);
                }
            }
            if (cl.hasOption(OUTPUT_PATH.getLongOpt())){
                MeFileWriter fileWriter = new MeFileWriter("/Users/Mr.Milovanov/IdeaProjects/MergeSort/test_task/src/main/resources/out.txt");
                fileWriter.writeByChar("esli read to ti pidar");

            } else{
                printHelp(options);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

