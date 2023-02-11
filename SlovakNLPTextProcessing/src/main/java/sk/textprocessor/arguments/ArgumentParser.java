package sk.textprocessor.arguments;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import sk.textprocessor.exceptions.InvalidParametersException;

public class ArgumentParser {


//    parameters for TextProcesses
    @Parameter(names = "-token", description = "Tokenize text")
    private static boolean tokenize = false;

    @Parameter(names = "-extsents", description = "Extract sentences")
    private static boolean extractSentences = false;

//    file parameters
    @Parameter(names = "-input", description = "Input file")
    private static String inputFile = "";

    @Parameter(names = "-newFile", description = "Tokenize text")
    private static String newFile = "";

//  Jcommander instance
    public ArgumentParser(String[] args) throws InvalidParametersException {
        JCommander jCommander = JCommander.newBuilder()
                .addObject(this)
                .build();
        try {
            jCommander.parse(args);
        } catch (ParameterException e) {
            throw new InvalidParametersException("Chyba: Nespravne zadané parametry");
        }
    }

//  functions
    public static String newFileName() { return newFile;}
    public static boolean isTokenize() {
        return tokenize;
    }
    public static boolean isExtractSentences() {
        return extractSentences;
    }
    public static String getInputFile() {
        return inputFile;
    }
}
