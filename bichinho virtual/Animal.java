import java.util.Scanner;

public class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean estado;
    private int caloria;
    private int forca;

    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.estado = true;
        this.caloria = 10;
        this.forca = 10;
        System.out.println("O animal se chama " + nome + " é da classe " + classe + " da família " + familia + ". O animal possui força de " + forca + ", caloria de " + caloria + " e idade de " + idade);
    }

    public String getNome() {
        return nome;
    }
    public String getClasse() {
        return classe;
    }
    public String getFamilia() {
        return familia;
    }
    public int getIdade() {
        return idade;
    }
    public int getCaloria() {
        return caloria;
    }
    public int getForca() {
        return forca;
    }
    
    public void morrer() {
        this.forca = 0;
        this.estado = false;
        System.out.println("O animal morreu!");
    }

    public void comer() {
        if (this.estado && this.caloria < 100) {
            this.caloria += 10;
            this.forca -= 2;
            System.out.println("O animal comeu e agora sua força é de " + this.forca +" e suas calorias valem " + this.caloria);
        }
    }

    public void correr() {
        if (this.estado && this.caloria > 0) {
            this.forca -= 5;
            this.caloria -= 5;
            System.out.println("O animal está correndo!! Agora sua força é de " + this.forca + " e suas calorias valem " + this.caloria);
        }
    }

    public void dormir() {
        if (this.estado) {
            this.forca += 10;
            this.caloria -= 2;
            System.out.println("O animal está dormindo agora! Sua força aumentou para " + this.forca + " e suas calorias aumentaram para " + this.caloria);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo do bichinho virtual!");
        System.out.print("Digite o nome do animal: ");
        String nome = input.nextLine();
        System.out.print("Digite a classe do animal: ");
        String classe = input.nextLine();
        System.out.print("Digite a família do animal: ");
        String familia = input.nextLine();

        Animal bichinho = new Animal(nome, classe, familia);

        while (bichinho.estado) {
            System.out.println("Escolha uma ação para o seu bichinho:");
            System.out.println("1 - Comer");
            System.out.println("2 - Correr");
            System.out.println("3 - Dormir");
            System.out.println("4 - Sair");

            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    bichinho.comer();
                    break;
                case 2:
                    bichinho.correr();
                    break;
                case 3:
                    bichinho.dormir();
                    break;
                case 4:
                    bichinho.morrer();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        input.close();
    }
}