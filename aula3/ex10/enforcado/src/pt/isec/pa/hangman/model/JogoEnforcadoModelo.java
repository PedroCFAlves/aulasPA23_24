package pt.isec.pa.hangman.model;

import java.util.Locale;
import java.util.Random;

import static pt.isec.pa.hangman.model.Dicionario.getWord;

public class JogoEnforcadoModelo {
    private String wordToGuess;
    private static final int MAX_ERRORS = 7;
    private static final String HIDDEN_CHARACTER = ".";

    private StringBuffer currentSituation; // é thread safe
    private StringBuilder attemptedCharacters; // não é threadsafe

    private int nAttempts, nFound;
    Random rand = new Random();

    public JogoEnforcadoModelo(){initialize();}

    private void initialize(){
        pickRandomWord();
        currentSituation = new StringBuffer( HIDDEN_CHARACTER.repeat( wordToGuess.length() ) );
        attemptedCharacters = new StringBuilder();
        nAttempts = nFound = 0;
    }

    private void pickRandomWord(){
        int aux_random_word_index = rand.nextInt(20);
        wordToGuess = getWord(aux_random_word_index).toUpperCase();
    }
    public String getWordToFind(){
        return wordToGuess;
    }
    public StringBuffer getCurrentSituation(){
        return currentSituation;
    }

    private void updateCurrentSituation(char c){
        currentSituation.append(c);
    }

    public boolean isWordFound(){
        return wordToGuess.equalsIgnoreCase(currentSituation.toString());
    }

    public boolean concluded(){
        return isWordFound()|| getNErrors() >= MAX_ERRORS;
    }

    private int getNErrors(){
        return nAttempts - nFound;
    }

    public int getnAttempts() {
        return nAttempts;
    }

    public void setnAttempts(int nAttempts) {
        this.nAttempts = nAttempts;
    }

    public int getnFound() {
        return nFound;
    }

    public void setnFound(int nFound) {
        this.nFound = nFound;
    }

    public StringBuilder getAttemptedCharacters() {
        return attemptedCharacters;
    }

    public boolean tryOption(String option){
        if (concluded() ||option.isBlank()){ // também pode ser option.trim().equals("");
            return false;
        }
        nAttempts++;
        option = option.trim().toUpperCase();
        if (option.length() >= 1){
            if (wordToGuess.equalsIgnoreCase(option)){
                currentSituation = new StringBuffer(wordToGuess);
                nFound++;
                return true;
            }
            return false;
        }

        char op = Character.toUpperCase(option.charAt(0));
        attemptedCharacters.append(op);
        boolean found = false;
        for (int i =0; i<wordToGuess.length();i++){
            char c = wordToGuess.charAt(i);
            if (c==op){
                currentSituation.setCharAt(i,c);
                found = true;
            }
        }

        if (found)
            nFound++;
        return found;


    }


}
