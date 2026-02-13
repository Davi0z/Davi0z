package formulario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormularioPaddock implements ActionListener {
    
    private class ComponentesFormulario {
        private JFrame janela;
        private JPanel painel;
        private JLabel lblTitulo, lblNome, lblIdade, lblEmail, lblTelefone;
        private JLabel lblNacionalidade, lblMorada, lblNumPessoas, lblCircuito;
        private JTextField txtNome, txtIdade, txtEmail, txtTelefone, txtNumPessoas; 
        private JComboBox<String> cmbNacionalidade;
        private JTextArea txtMorada;
        private JScrollPane scrollMorada;
        private JRadioButton rbImola, rbMonza;
        private ButtonGroup grupoCircuito;
        private JButton btnReservar, btnLimpar;
    }
    
    private ComponentesFormulario comp;
    private TratadorExcecoes tratador;
    
    public FormularioPaddock() {
        comp = new ComponentesFormulario();
        criarJanela();
        tratador = new TratadorExcecoes(comp.janela);
    }
    
    private void criarJanela() {
        comp.janela = new JFrame("Formulário de Visita ao Paddock Ferrari");
        comp.janela.setSize(700, 750);
        comp.janela.setLocationRelativeTo(null);
        comp.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comp.janela.setResizable(false);
        
        comp.painel = new JPanel(null);
        comp.painel.setBackground(Color.WHITE);
        comp.janela.setContentPane(comp.painel);
        
        comp.lblTitulo = new JLabel("VISITA AO PADDOCK FERRARI");
        comp.lblTitulo.setBounds(150, 20, 400, 40);
        comp.lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        comp.lblTitulo.setForeground(new Color(200, 0, 0));
        comp.painel.add(comp.lblTitulo);
        
        // NOME
        comp.lblNome = new JLabel("Nome Completo: *");
        comp.lblNome.setBounds(50, 80, 200, 25);
        comp.lblNome.setFont(new Font("Arial", Font.BOLD, 14));
        comp.painel.add(comp.lblNome);
        
        comp.txtNome = new JTextField();
        comp.txtNome.setBounds(250, 80, 380, 30);
        comp.painel.add(comp.txtNome);
        
        // IDADE
        comp.lblIdade = new JLabel("Idade: *");
        comp.lblIdade.setBounds(50, 130, 200, 25);
        comp.lblIdade.setFont(new Font("Arial", Font.BOLD, 14));
        comp.painel.add(comp.lblIdade);
        
        comp.txtIdade = new JTextField();
        comp.txtIdade.setBounds(250, 130, 150, 30);
        comp.painel.add(comp.txtIdade);
        
        // EMAIL
        comp.lblEmail = new JLabel("Email: *");
        comp.lblEmail.setBounds(50, 180, 200, 25);
        comp.lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
        comp.painel.add(comp.lblEmail);
        
        comp.txtEmail = new JTextField();
        comp.txtEmail.setBounds(250, 180, 380, 30);
        comp.painel.add(comp.txtEmail);
        
        // TELEFONE
        comp.lblTelefone = new JLabel("Telefone: *");
        comp.lblTelefone.setBounds(50, 230, 200, 25);
        comp.lblTelefone.setFont(new Font("Arial", Font.BOLD, 14));
        comp.painel.add(comp.lblTelefone);
        
        comp.txtTelefone = new JTextField();
        comp.txtTelefone.setBounds(250, 230, 200, 30);
        comp.painel.add(comp.txtTelefone);
        
        // NACIONALIDADE
        comp.lblNacionalidade = new JLabel("Nacionalidade: *");
        comp.lblNacionalidade.setBounds(50, 280, 200, 25);
        comp.lblNacionalidade.setFont(new Font("Arial", Font.BOLD, 14));
        comp.painel.add(comp.lblNacionalidade);
        
        String[] nacionalidades = {"Selecione...", "Portugal", "Brasil", "Itália", "Espanha", 
                                   "França", "Alemanha", "Inglaterra", "EUA", "Outro"};
        comp.cmbNacionalidade = new JComboBox<>(nacionalidades);
        comp.cmbNacionalidade.setBounds(250, 280, 200, 30);
        comp.painel.add(comp.cmbNacionalidade);
        
        // MORADA
        comp.lblMorada = new JLabel("Morada Completa: *");
        comp.lblMorada.setBounds(50, 330, 200, 25);
        comp.lblMorada.setFont(new Font("Arial", Font.BOLD, 14));
        comp.painel.add(comp.lblMorada);
        
        comp.txtMorada = new JTextArea();
        comp.txtMorada.setLineWrap(true);
        comp.txtMorada.setWrapStyleWord(true);
        comp.scrollMorada = new JScrollPane(comp.txtMorada);
        comp.scrollMorada.setBounds(250, 330, 380, 80);
        comp.painel.add(comp.scrollMorada);
        
        // NÚMERO DE PESSOAS
        comp.lblNumPessoas = new JLabel("Número de Pessoas: *");
        comp.lblNumPessoas.setBounds(50, 430, 200, 25);
        comp.lblNumPessoas.setFont(new Font("Arial", Font.BOLD, 14));
        comp.painel.add(comp.lblNumPessoas);
        
        comp.txtNumPessoas = new JTextField("1");
        comp.txtNumPessoas.setBounds(250, 430, 80, 30);
        comp.painel.add(comp.txtNumPessoas);
        
        // CIRCUITO
        comp.lblCircuito = new JLabel("Escolha o Circuito: *");
        comp.lblCircuito.setBounds(50, 480, 200, 25);
        comp.lblCircuito.setFont(new Font("Arial", Font.BOLD, 14));
        comp.painel.add(comp.lblCircuito);
        
        comp.rbImola = new JRadioButton("Autódromo Enzo e Dino Ferrari (Ímola)");
        comp.rbImola.setBounds(250, 480, 300, 30);
        comp.rbImola.setBackground(Color.WHITE);
        comp.painel.add(comp.rbImola);
        
        comp.rbMonza = new JRadioButton("Autódromo Nacional de Monza");
        comp.rbMonza.setBounds(250, 515, 300, 30);
        comp.rbMonza.setBackground(Color.WHITE);
        comp.painel.add(comp.rbMonza);
        
        comp.grupoCircuito = new ButtonGroup();
        comp.grupoCircuito.add(comp.rbImola);
        comp.grupoCircuito.add(comp.rbMonza);
        
        // BOTÕES
        comp.btnReservar = new JButton("RESERVAR VISITA");
        comp.btnReservar.setBounds(150, 600, 180, 40);
        comp.btnReservar.setFont(new Font("Arial", Font.BOLD, 14));
        comp.btnReservar.setBackground(new Color(200, 0, 0));
        comp.btnReservar.setForeground(Color.WHITE);
        comp.btnReservar.addActionListener(this);
        comp.painel.add(comp.btnReservar);
        
        comp.btnLimpar = new JButton("LIMPAR");
        comp.btnLimpar.setBounds(370, 600, 180, 40);
        comp.btnLimpar.setFont(new Font("Arial", Font.BOLD, 14));
        comp.btnLimpar.setBackground(Color.GRAY);
        comp.btnLimpar.setForeground(Color.WHITE);
        comp.btnLimpar.addActionListener(this);
        comp.painel.add(comp.btnLimpar);
        
        comp.janela.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comp.btnReservar) {
            validarEReservar();
        } else if (e.getSource() == comp.btnLimpar) {
            limparCampos();
        }
    }
    
    private void validarEReservar() {
        try {
            // Validações usando a sua classe TratadorExcecoes
            tratador.validarNome(comp.txtNome.getText());
            int idade = tratador.validarIdade(comp.txtIdade.getText());
            tratador.validarEmail(comp.txtEmail.getText());
            tratador.validarTelefone(comp.txtTelefone.getText());
            
            // Valida Morada, Nacionalidade e Circuito ao mesmo tempo
            boolean circuitoSelecionado = comp.rbImola.isSelected() || comp.rbMonza.isSelected();
            tratador.validarCamposObrigatorios(
                comp.txtMorada.getText(), 
                comp.cmbNacionalidade.getSelectedIndex(), 
                circuitoSelecionado
            );
            
            // Validação do novo campo de texto de pessoas
            int numPessoas = tratador.validarNumPessoas(comp.txtNumPessoas.getText());
            
            // Sucesso: Criar objeto Visitante
            Visitante v = new Visitante();
            v.setNome(comp.txtNome.getText());
            v.setIdade(idade);
            v.setEmail(comp.txtEmail.getText());
            v.setTelefone(comp.txtTelefone.getText());
            v.setNacionalidade(comp.cmbNacionalidade.getSelectedItem().toString());
            v.setMorada(comp.txtMorada.getText());
            v.setNumeroPessoas(numPessoas);
            v.setCircuito(comp.rbImola.isSelected() ? "Ímola" : "Monza");
            
            JOptionPane.showMessageDialog(comp.janela, "Reserva confirmada para " + v.getNome() + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();

        } catch (Exception ex) {
            // As mensagens de erro já são exibidas pelo TratadorExcecoes
        }
    }

    private void limparCampos() {
        comp.txtNome.setText("");
        comp.txtIdade.setText("");
        comp.txtEmail.setText("");
        comp.txtTelefone.setText("");
        comp.txtNumPessoas.setText("1");
        comp.cmbNacionalidade.setSelectedIndex(0);
        comp.txtMorada.setText("");
        comp.grupoCircuito.clearSelection();
        comp.txtNome.requestFocus();
    }
}