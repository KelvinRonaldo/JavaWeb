package br.com.kelvin.app;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.kelvin.view.FrmPessoa;

public class IniciarApp {

	public static void main(String[] args) {
		//↓classe que muda o estilo da janela
		LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
						//array	//↑ classe que genrencia a interface de usuario
		
		
		//try → vai tentar rodar o que será solicitado, se der erro,vai para o catch
		try {
			UIManager.setLookAndFeel(info[1].getClassName());
		} catch (Exception erro) { //catch → 
			System.out.println(erro.getMessage());
		}
		FrmPessoa janela = new FrmPessoa();
		
	}
	
}
