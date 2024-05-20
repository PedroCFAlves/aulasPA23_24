package pt.isec.pa.hangman.model;

 public   class Dicionario {
     private static final String [] diccionnario = {
            "Abacaxi",
            "Bicicleta",
            "Cafuné",
            "Dendê",
            "Elefante",
            "Folclore",
            "Girassol",
            "Harmonia",
            "Indispensável",
            "Jabuticaba",
            "Kitsch",
            "Lanterna",
            "Melancia",
            "Nuvem",
            "Orquídea",
            "Pacífico",
            "Quintal",
            "Risada",
            "Saudade",
            "Tartaruga"
    };
    private Dicionario(){}
     public static int getNumberOfWord(){
        return diccionnario.length;
     }

     public static String getWord(int index){
        if (index>= getNumberOfWord() || index<0){
            return null;
        }
        return diccionnario[index];
     }

}
