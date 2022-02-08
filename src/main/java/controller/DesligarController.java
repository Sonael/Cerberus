package controller;

import view.TelaPrincipal;

public class DesligarController extends Thread {
	
	private TelaPrincipal telaPrincipal;

	public DesligarController(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}
	
	@Override
	public void run()
	{
		try {
			sleep(30000);
			telaPrincipal.error("Seu tempo acabou!");
			telaPrincipal.getFrmCerberus().dispose();
		} catch (InterruptedException e) {
			System.out.println();
		}

	}
	
}
