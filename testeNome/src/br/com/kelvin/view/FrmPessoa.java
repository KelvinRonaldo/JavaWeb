package br.com.kelvin.view;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import br.com.kelvin.dao.PessoaDao;
import br.com.kelvin.pessoas.Pessoa;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPessoa extends JFrame {
	private JTextField txtNome, txtCodigo;
	private JButton btnNovo, btnExcluir, btnAtualizar, btnSalvar;
	private JPanel panelDados;

	public FrmPessoa() {
		setTitle("Teste Nome");
		setResizable(false);
		setSize(514, 337);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		JPanel panelDados = new JPanel();
		panelDados.setBounds(10, 11, 494, 293);
		getContentPane().add(panelDados);
		panelDados.setLayout(null);

		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(400, 198, 89, 80);
		panelDados.add(btnSalvar);

		btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBounds(301, 198, 89, 80);
		panelDados.add(btnAtualizar);

		btnExcluir = new JButton("DELETAR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(109, 198, 89, 80);
		panelDados.add(btnExcluir);

		btnNovo = new JButton("NOVO");
		btnNovo.setBounds(10, 198, 89, 80);
		panelDados.add(btnNovo);

		txtNome = new JTextField();
		txtNome.setBounds(10, 53, 271, 51);
		panelDados.add(txtNome);
		txtNome.setFont(new Font("Arial", Font.PLAIN, 18));
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 189, 43);
		panelDados.add(lblNome);
		lblNome.setFont(new Font("Arial Black", Font.PLAIN, 22));

		txtCodigo = new JTextField("");
		txtCodigo.setFont(new Font("Arial Black", Font.PLAIN, 22));
		txtCodigo.setBounds(301, 53, 189, 51);
		panelDados.add(txtCodigo);

		JLabel lbl = new JLabel("ID:");
		lbl.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lbl.setBounds(301, 11, 189, 43);
		panelDados.add(lbl);

		JButton btnConsultar = new JButton("Consultar");

		btnConsultar.setBounds(301, 107, 89, 43);
		panelDados.add(btnConsultar);

		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setText("");
				txtNome.setText("");
			}
		});

		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarPessoa("consultar");
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarPessoa("excluir");
				txtCodigo.setText("");
				txtNome.setText("");
			}
		});

		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarPessoa("atualizar");
			}
		});

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarPessoa("gravar");
				txtCodigo.setText("");
				txtNome.setText("");
			}
		});

		setVisible(true);

	}

	public void criarPessoa(String operacao) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(txtNome.getText());

		PessoaDao dao = new PessoaDao();

		if (operacao.equals("consultar")) {
			pessoa = dao.getPessoa(Integer.parseInt(txtCodigo.getText()));
			txtNome.setText(pessoa.getNome());
			txtCodigo.setText(String.valueOf(pessoa.getCodigo()));
		}
//		else if (operacao.equals("gravar")) {
//			dao.gravar();
//		} 
//			else if (operacao.equals("atualizar")) {
//			pessoa.setCodigo(Integer.parseInt(txtCodigo.getText()));
//			dao.atualizar();
//		} 
		else if (operacao.equals("excluir")) {
			pessoa.setCodigo(Integer.parseInt(txtCodigo.getText()));
			dao.excluir();
		}
//	}
	}
}
