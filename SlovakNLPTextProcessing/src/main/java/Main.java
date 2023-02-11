import FileCreator.NewFile;
import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.InvalidFileException;
import sk.textprocessor.exceptions.InvalidParametersException;
import sk.textprocessor.input.InputReader;
import sk.textprocessor.processing.TextProcesses;

public class Main {

    public static void main(String[] args) {
        TextProcesses TextProcessor = new TextProcesses();
        InputReader InputReader = new InputReader();

        try {
            ArgumentParser ArgumentParser = new ArgumentParser(args);
            String inputText = InputReader.readFile(ArgumentParser.getInputFile());
            String fileName = ArgumentParser.newFileName();

//            new file controller

            if(!fileName.equals("")){
                NewFile NewFile = new NewFile();
                NewFile.NewFileCreate(fileName);
                NewFile.fileCreated = true;
            }

//            TextProcceses functions controller

            if (ArgumentParser.isTokenize()) {
                TextProcessor.tokenize(inputText);
            }
            if (ArgumentParser.isExtractSentences()) {
                TextProcessor.extractSentences(inputText);
            }
        } catch (InvalidParametersException | InvalidFileException e) {
            System.err.println(e.getMessage());
        }




    }
}
