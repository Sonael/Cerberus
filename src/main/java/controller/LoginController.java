package controller;

import view.TelaPrincipal;

public class LoginController {
	private int tentativa = 3;
	private TelaPrincipal telaPrincipal;
	private DesligarController desligarController;

	public LoginController(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		this.desligarController = new DesligarController(telaPrincipal);
	}
	
	public void verificarLogin()
	{
		
		String pass = new String(telaPrincipal.getPass().getPassword());
		if(tentativa > 1) 
		{
			if(pass.equals("teste"))
			{
				telaPrincipal.getDesligarController().interrupt();
				telaPrincipal.sucess("Senha correta");
				telaPrincipal.getFrmCerberus().dispose();
			}
			else
			{
				tentativa--;
				telaPrincipal.getTxtChances().setText(String.format("Chances: %d", tentativa));;
				telaPrincipal.error(String.format("Restam %d tentativas", tentativa));
			}
		}
		else {
			telaPrincipal.getDesligarController().interrupt();
			telaPrincipal.error("Não restam mais tentativas o computador irá se deligar!");
			telaPrincipal.getFrmCerberus().dispose();
		}
	}
	
	
}
