package taimagochi;

public class Taimagochi {
	protected String nome;
    protected int fome;      // 0 (cheio) a 100 (faminto)
    protected int felicidade; // 0 (triste) a 100 (alegre)
    protected int energia;   // 0 (cansado) a 100 (ativo)
    protected boolean vivo;

    // Construtor
    public Taimagochi(String nome) {
        this.nome = nome;
        this.fome = 50;
        this.felicidade = 50;
        this.energia = 50;
        this.vivo = true;
    }

    // Métodos (Comportamento) - Ações Comuns
    public void alimentar() {
        if (!vivo) return;
        this.fome = Math.max(0, this.fome - 20);
        this.felicidade = Math.min(100, this.felicidade + 5);
        System.out.println(nome + " foi alimentado(a). Fome: " + fome);
    }

    public void brincar() {
        if (!vivo) return;
        this.felicidade = Math.min(100, this.felicidade + 30);
        this.energia = Math.max(0, this.energia - 15);
        this.fome = Math.min(100, this.fome + 5);
        System.out.println(nome + " brincou e está mais feliz. Felicidade: " + felicidade);
    }

    public void dormir() {
        if (!vivo) return;
        this.energia = 100;
        this.fome = Math.min(100, this.fome + 10);
        System.out.println(nome + " dormiu e recuperou a energia. Energia: " + energia);
    }

    // Método para checar as condições de vida
    public void verificarStatus() {
        if (fome >= 100 || felicidade <= 0 || energia <= 0) {
            this.vivo = false;
            System.out.println("\n*** " + nome + " infelizmente faleceu! ***");
        } else {
            System.out.println("\n--- Status de " + nome + " ---");
            System.out.println("Fome: " + fome + "/100");
            System.out.println("Felicidade: " + felicidade + "/100");
            System.out.println("Energia: " + energia + "/100");
        }
    }

    // Getters para checagem e exibição
    public boolean isVivo() {
        return vivo;
    }
    
    // Método para o "passar do tempo" (simulação de deterioração)
    public void passarTempo() {
        if (vivo) {
            this.fome = Math.min(100, this.fome + 10);
            this.felicidade = Math.max(0, this.felicidade - 5);
            this.energia = Math.max(0, this.energia - 5);
            verificarStatus();
        }
    }
}
