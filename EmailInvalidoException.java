package formulario;

public class EmailInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;
    private String mensagem;
    
    public EmailInvalidoException(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public String getMessage() {
        return mensagem;
    }
}
