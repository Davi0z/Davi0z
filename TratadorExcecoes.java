package formulario;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TratadorExcecoes {
    
    private JFrame janela;
    
    public TratadorExcecoes(JFrame janela) {
        this.janela = janela;
    }

    public void validarNome(String nome) throws NullPointerException, IllegalArgumentException {
        if (nome == null || nome.trim().isEmpty()) {
            exibirErro("O campo NOME é obrigatório!", "NullPointerException");
            throw new NullPointerException();
        }
        if (nome.matches(".*\\d.*")) {
            exibirErro("O NOME não pode conter números!", "IllegalArgumentException");
            throw new IllegalArgumentException();
        }
    }

    public int validarIdade(String textoIdade) throws NumberFormatException, IllegalArgumentException {
        try {
            int idade = Integer.parseInt(textoIdade);
            if (idade < 16 || idade > 100) {
                exibirErro("Idade deve estar entre 16 e 100 anos!", "IllegalArgumentException");
                throw new IllegalArgumentException();
            }
            return idade;
        } catch (NumberFormatException e) {
            exibirErro("IDADE deve ser um número válido!", "NumberFormatException");
            throw e;
        }
    }

    public void validarTelefone(String telefone) throws NullPointerException, NumberFormatException {
        if (telefone == null || telefone.trim().isEmpty()) {
            exibirErro("O campo TELEFONE é obrigatório!", "NullPointerException");
            throw new NullPointerException();
        }
        String telefoneLimpo = telefone.replaceAll("[\\s+()-]", "");
        if (!telefoneLimpo.matches("\\d+")) {
            exibirErro("TELEFONE deve conter apenas números!", "NumberFormatException");
            throw new NumberFormatException("Formato inválido");
        }
    }

    public void validarEmail(String email) throws NullPointerException, EmailInvalidoException {
        if (email == null || email.trim().isEmpty()) {
            exibirErro("O campo EMAIL é obrigatório!", "NullPointerException");
            throw new NullPointerException();
        }
        if (!email.contains("@") || !email.contains(".")) {
            exibirErro("Email inválido!", "EmailInvalidoException");
            throw new EmailInvalidoException("Email fora do padrão");
        }
    }

    public void validarCamposObrigatorios(String morada, int indiceNacionalidade, boolean algoSelecionado) {
        if (morada == null || morada.trim().isEmpty()) {
            exibirErro("O campo MORADA é obrigatório!", "NullPointerException");
            throw new NullPointerException();
        }
        if (indiceNacionalidade <= 0) {
            exibirErro("Selecione uma NACIONALIDADE!", "NullPointerException");
            throw new NullPointerException();
        }
        if (!algoSelecionado) {
            exibirErro("Selecione um CIRCUITO!", "NullPointerException");
            throw new NullPointerException();
        }
    }

    public int validarNumPessoas(String textoNumPessoas) throws NumberFormatException, IllegalArgumentException {
        try {
            int numPessoas = Integer.parseInt(textoNumPessoas);
            if (numPessoas < 1 || numPessoas > 10) {
                exibirErro("Número de pessoas entre 1 e 10!", "IllegalArgumentException");
                throw new IllegalArgumentException();
            }
            return numPessoas;
        } catch (NumberFormatException e) {
            exibirErro("NÚMERO DE PESSOAS deve ser um número!", "NumberFormatException");
            throw e;
        }
    }

    private void exibirErro(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(janela, mensagem, "Erro - " + titulo, JOptionPane.ERROR_MESSAGE);
    }
}