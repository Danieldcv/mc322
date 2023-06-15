public class Main {
    public static void printarTabuleiro(Tabuleiro tabuleiro){
        System.out.println("**************************");
        for(int j = 7; j >= 0; j--){
            System.out.print(j+1 + " ");
            for(int i = 0; i < 8; i++){
                Peca peca = tabuleiro.getPeca(i, j);
                if(peca == null) System.out.print(" . ");
                else System.out.print(" " + peca.getLabel() + " ");
            }
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H");
        System.out.println("**************************");
    }
    
    public static void main(String[] args){
        Tabuleiro tabuleiro = new Tabuleiro();

        printarTabuleiro(tabuleiro); // Debugging do tabuleiro

        // Debugging movimentos
        tabuleiro.mover("A2", "A4");
        tabuleiro.mover("D7", "D6");
        tabuleiro.mover("A1", "A3");
        tabuleiro.mover("E1", "G1");
        tabuleiro.mover("E8", "C8"); // Tentativa falha de roque
        tabuleiro.mover("C8", "F5");
        tabuleiro.mover("E8", "C8"); // Tentativa bem sucedida de roque
        tabuleiro.mover("D2", "D3");
        tabuleiro.mover("C1", "F4");
        tabuleiro.mover("A3", "A1"); // Tentativa falha de roque (a torre envolvida já se moveu)
        tabuleiro.mover("H7", "H6");
        tabuleiro.mover("F4", "H6"); // Captura bem sucedida
        tabuleiro.mover("H6", "C1");
        printarTabuleiro(tabuleiro);
    }
}
