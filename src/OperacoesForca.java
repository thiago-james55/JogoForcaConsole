import java.util.Locale;
import java.util.Scanner;

public class OperacoesForca {

    private String[][] palavras;
    private String palavraVazia;
    private int errosRestantes;
    private final String SEPARATOR = "===================================================";
    private final String CLEAN_CONSOLE = "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n";

    public void novoJogo() {

        this.errosRestantes = 5;
        this.bibliotecaDePalavras();
        this.constroiTela();

    }

    private void constroiTela() {

        int sorteada = this.sortearPalavra();
        String palavra = this.palavras[sorteada][0];
        String dica = this.palavras[sorteada][1];
        this.palavraVazia = this.palavraVazia(palavra.length());
        Scanner in = new Scanner(System.in);

        while(!this.win(palavra) && !this.gameOver(palavra)) {

            System.out.println(this.SEPARATOR);
            System.out.println("Jogo da Forca 2021");
            System.out.println("Erros Restantes:" + this.errosRestantes);
            System.out.println(this.SEPARATOR);
            System.out.println("Dica: " + dica);
            System.out.println();
            System.out.print("Palavra: ");
            System.out.println(palavraVazia);
            System.out.println(this.SEPARATOR);
            System.out.println("Digite a letra que você acha que a palavra possui:");
            this.tentativa(in.nextLine(), palavra);
            System.out.println(this.CLEAN_CONSOLE);

        }



    }

    private void bibliotecaDePalavras() {

        //Adicionar Palavras e Dicas a nossa Array de Strings Palavras onde 0 é a palavra e 1 é a dica

        this.palavras = new String[][] {

                {"Sorte", "O que você precisa ter para ganhar um sorteio!"} ,
                {"Amor", "O que sentimos por alguem especial!"},
                {"Matematica" , "Matéria de numeros!"},
                {"Alfabeto" , "Contem muitas letras!"},
                {"VideoGame", "Aparelho muito divertido que se usa controles!"}

        };

    }

    private int sortearPalavra() {

        //Random de 0 até o Length da nossa Array de Palavras

        return (int) (Math.random() * this.palavras.length);

    }

    private boolean gameOver(String palavra) {

        if (this.errosRestantes == 0) {

            System.out.println(this.SEPARATOR);
            System.out.println("");
            System.out.println(">>>>>>>>>> GAME OVER <<<<<<<<<<");
            System.out.println(">>>>>>>>>> A palavra era: " + palavra + " <<<<<<<<<<");
            System.out.println(this.SEPARATOR);
            return  true;

        }


        return false;

    }

    private boolean win(String palavra) {

        for (int c = 0; c < this.palavraVazia.length(); c++) {

            if ( palavraVazia.charAt(c) == '_') {


                return false;

            }

        }

        System.out.println(this.SEPARATOR);
        System.out.println("");
        System.out.println(">>>>>>>>>> PARABÉNS :) <<<<<<<<<<");
        System.out.println(">>>>>>>>> VOCÊ GANHOU! <<<<<<<<<");
        System.out.println(">>>>>>>>> Palavra:" + palavra + " <<<<<<<<<<");
        System.out.println("");
        System.out.println(this.SEPARATOR);


        return true;

    }

    private void tentativa(String in, String palavra) {

        if (palavra.toLowerCase().contains(in.toLowerCase())) {

            for (int c = 0; c < palavra.length(); c++) {

                if (in.toLowerCase().charAt(0) == palavra.toLowerCase().charAt(c)) {

                    StringBuilder local = new StringBuilder(this.palavraVazia);
                    local.setCharAt(c, in.toUpperCase().charAt(0));
                    this.palavraVazia = local.toString();

                }

            }


        } else {

            this.errosRestantes--;

        }


    }

    private String palavraVazia(int length) {

        String palavra = "";

        for (int c = 0; c < length; c++) {

            palavra += "_";

        }

        return palavra;

    }

}
