package jpa_ValoracionMateria.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import jpa_ValoracionMateria.controladores.ControladorEstudiante;
import jpa_ValoracionMateria.controladores.ControladorMateria;
import jpa_ValoracionMateria.controladores.ControladorProfesor;
import jpa_ValoracionMateria.controladores.ControladorValoraciones;
import jpa_ValoracionMateria.controladores.SuperControlador_JPA;
import jpa_ValoracionMateria.model.Estudiante;
import jpa_ValoracionMateria.model.Materia;
import jpa_ValoracionMateria.model.Profesor;
import jpa_ValoracionMateria.model.Valoracion;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class PanelValoracionMateria_JPA extends JPanel {

	private static final long serialVersionUID = 1L;
	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	JComboBox<Integer> jcbNota;

	JList list_NoSeleccionado;
	private DefaultListModel<Estudiante> listaModelEstudianteNoSeleccionado = null;
	JList list_Seleccionado;
	private DefaultListModel<Estudiante> listaModelEstudianteSeleccionado = null;
	private List<Estudiante> listaEstudiante = ControladorEstudiante.getInstance().getAll();
	JFormattedTextField ftfFecha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelValoracionMateria_JPA frame = new PanelValoracionMateria_JPA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	public PanelValoracionMateria_JPA() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel_1.add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_1 = new JLabel("Profesor");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel_1.add(jcbProfesor, gbc_jcbProfesor);

		JLabel lblNewLabel_2 = new JLabel("Nota");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel_1.add(jcbNota, gbc_jcbNota);

		JButton btnUpdateAlumnado = new JButton("Actualizar Alumnado");
		btnUpdateAlumnado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescarEstudiantes();

			}
		});
		GridBagConstraints gbc_btnUpdateAlumnado = new GridBagConstraints();
		gbc_btnUpdateAlumnado.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdateAlumnado.anchor = GridBagConstraints.EAST;
		gbc_btnUpdateAlumnado.gridx = 1;
		gbc_btnUpdateAlumnado.gridy = 3;
		panel_1.add(btnUpdateAlumnado, gbc_btnUpdateAlumnado);

		ftfFecha = new JFormattedTextField();
		ftfFecha.setToolTipText("dd/mm/yyyy");
		GridBagConstraints gbc_ftfFecha = new GridBagConstraints();
		gbc_ftfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftfFecha.anchor = GridBagConstraints.WEST;
		gbc_ftfFecha.gridx = 1;
		gbc_ftfFecha.gridy = 4;
		panel_1.add(ftfFecha, gbc_ftfFecha);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_3 = new JLabel("Alumno no seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("alumno seleccionado");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		list_NoSeleccionado = new JList(getDefaultListModel2());
		this.list_NoSeleccionado.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		GridBagConstraints gbc_list_NoSeleccionado = new GridBagConstraints();
		gbc_list_NoSeleccionado.insets = new Insets(0, 0, 0, 5);
		gbc_list_NoSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_list_NoSeleccionado.gridx = 0;
		gbc_list_NoSeleccionado.gridy = 1;
		panel.add(list_NoSeleccionado, gbc_list_NoSeleccionado);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JButton btnMoverTodoIzq = new JButton("<<");
		btnMoverTodoIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodoNoSeleccionado();
			}
		});
		GridBagConstraints gbc_btnMoverTodoIzq = new GridBagConstraints();
		gbc_btnMoverTodoIzq.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoverTodoIzq.gridx = 0;
		gbc_btnMoverTodoIzq.gridy = 0;
		panel_4.add(btnMoverTodoIzq, gbc_btnMoverTodoIzq);

		JButton btnMoverUnoIzq = new JButton("<");
		btnMoverUnoIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverSeleccionParaNoSelec();
			}
		});
		GridBagConstraints gbc_btnMoverUnoIzq = new GridBagConstraints();
		gbc_btnMoverUnoIzq.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoverUnoIzq.gridx = 0;
		gbc_btnMoverUnoIzq.gridy = 1;
		panel_4.add(btnMoverUnoIzq, gbc_btnMoverUnoIzq);

		JButton btnMoverUnoDch = new JButton(">");
		btnMoverUnoDch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverSeleccionParaSelec();
			}
		});
		GridBagConstraints gbc_btnMoverUnoDch = new GridBagConstraints();
		gbc_btnMoverUnoDch.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoverUnoDch.gridx = 0;
		gbc_btnMoverUnoDch.gridy = 2;
		panel_4.add(btnMoverUnoDch, gbc_btnMoverUnoDch);

		JButton btnMoverTodoDch = new JButton(">>");
		btnMoverTodoDch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarTodoSeleccionado();
			}
		});
		GridBagConstraints gbc_btnMoverTodoDch = new GridBagConstraints();
		gbc_btnMoverTodoDch.gridx = 0;
		gbc_btnMoverTodoDch.gridy = 3;
		panel_4.add(btnMoverTodoDch, gbc_btnMoverTodoDch);

		list_Seleccionado = new JList(getDefaultListModel());
		this.list_Seleccionado.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		GridBagConstraints gbc_list_Seleccionado = new GridBagConstraints();
		gbc_list_Seleccionado.fill = GridBagConstraints.BOTH;
		gbc_list_Seleccionado.gridx = 2;
		gbc_list_Seleccionado.gridy = 1;
		panel.add(list_Seleccionado, gbc_list_Seleccionado);

		JButton btnNewButton = new JButton("Guardar las notas de todos los alumnos seleccionados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarDatos();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);

		//////////////// CARGAMOS LOS JCB//////////////////////
		loadMateria();
		loadNotas();
		loadProfesores();
	}

	private void loadMateria() {
		List<Materia> l = ControladorMateria.getInstance().getAll();
		for (Materia materia : l) {
			jcbMateria.addItem(materia);
		}
	}

	/**
	 * 
	 */
	private void loadNotas() {
		List<Integer> notas = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) {
			notas.add(i);
		}
		for (Integer integer : notas) {
			jcbNota.addItem(integer);
		}
	}

	/**
	 * 
	 */
	private void loadProfesores() {
		List<Profesor> l = ControladorProfesor.getInstance().getAll();
		for (Profesor profesor : l) {
			jcbProfesor.addItem(profesor);
		}
	}

	/**
	 * Metodo que contruye los Jlist
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModel() {
		this.listaModelEstudianteSeleccionado = new DefaultListModel<Estudiante>();
		return listaModelEstudianteSeleccionado;
	}

	private DefaultListModel getDefaultListModel2() {
		this.listaModelEstudianteNoSeleccionado = new DefaultListModel<Estudiante>();
		return listaModelEstudianteNoSeleccionado;
	}

	private void refrescarEstudiantes() {
		this.listaModelEstudianteNoSeleccionado.clear();
		this.listaModelEstudianteSeleccionado.clear();
		ControladorValoraciones cValoracion = ControladorValoraciones.getInstance();
		Profesor profesorSeleccionado = (Profesor) jcbProfesor.getSelectedItem();
		Materia materiaSeleccionada = (Materia) jcbMateria.getSelectedItem();
		Integer notaSeleccionada = (Integer) jcbNota.getSelectedItem();

		List<Estudiante> estudiantes = ControladorEstudiante.getInstance().getAll();

		for (Estudiante estudiante : estudiantes) {// A continuacion debes ponerlo en el mismo orden que lo pones en el
													// controlador
			Valoracion valoracion = cValoracion.findProfeMaEst(profesorSeleccionado.getId(), estudiante.getId(),
					materiaSeleccionada.getId());
			if (valoracion != null && valoracion.getValoracion() == notaSeleccionada.intValue()) {
				this.listaModelEstudianteSeleccionado.addElement(estudiante);
			} else {
				this.listaModelEstudianteNoSeleccionado.addElement(estudiante);
			}
		}
	}

	private void pasarTodoNoSeleccionado() {
		this.listaModelEstudianteSeleccionado.removeAllElements();
		this.listaModelEstudianteSeleccionado.clear();
		this.listaModelEstudianteNoSeleccionado.clear();
		this.listaModelEstudianteNoSeleccionado.addAll(listaEstudiante);
	}

	private void pasarTodoSeleccionado() {
		this.listaModelEstudianteNoSeleccionado.removeAllElements();
		this.listaModelEstudianteSeleccionado.clear();
		this.listaModelEstudianteNoSeleccionado.clear();
		this.listaModelEstudianteSeleccionado.addAll(listaEstudiante);
	}

//	private void borrarSeleccion() {
//		for (int i = this.list_Seleccionado.getSelectedIndices().length-1; i >= 0; i--) {
//			this.listaModelEstudianteSeleccionado.removeElementAt(this.list_Seleccionado.getSelectedIndices()[i]);
//			
//		}
//	}
	private void moverSeleccionParaNoSelec() {
		for (int i = this.list_Seleccionado.getSelectedIndices().length - 1; i >= 0; i--) {
			Estudiante e = listaModelEstudianteSeleccionado.elementAt(this.list_Seleccionado.getSelectedIndices()[i]);
			listaModelEstudianteNoSeleccionado.addElement(e);
			listaModelEstudianteSeleccionado.remove(this.list_Seleccionado.getSelectedIndices()[i]);
		}
	}

	private void moverSeleccionParaSelec() {
		for (int i = this.list_NoSeleccionado.getSelectedIndices().length - 1; i >= 0; i--) {
			Estudiante e = listaModelEstudianteNoSeleccionado
					.elementAt(this.list_NoSeleccionado.getSelectedIndices()[i]);
			listaModelEstudianteSeleccionado.addElement(e);
			listaModelEstudianteNoSeleccionado.remove(this.list_NoSeleccionado.getSelectedIndices()[i]);
		}
	}

	private void guardarDatos() {
		ControladorValoraciones cValoracion = new ControladorValoraciones();
		int nota = (int) jcbNota.getSelectedItem();
		int idProfesor = ((Profesor) jcbProfesor.getSelectedItem()).getId();
		int idMateria = ((Materia) jcbMateria.getSelectedItem()).getId();
		Date fecha = (Date)ftfFecha.getValue();
		for (int i = 0; i < listaModelEstudianteSeleccionado.getSize(); i++) {
			int idEstudiante = listaModelEstudianteSeleccionado.get(i).getId();
			Valoracion v = cValoracion.findProfeMaEst(idProfesor, idEstudiante, idMateria);
			if (v != null)
				cValoracion.update(v, nota,fecha);
			else
				cValoracion.persist(nota, idProfesor, idEstudiante, idMateria,fecha);
		}
	}

	private JFormattedTextField getJFormattedTextFieldDatePersonalizado() {
		JFormattedTextField jftf = new JFormattedTextField(
				new JFormattedTextField.AbstractFormatter() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null && value instanceof Date) {
					return sdf.format(((Date) value));
				}
				return "";
			}

			@Override
			public Object stringToValue(String text) throws ParseException {
				try {
					return sdf.parse(text);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error en la fecha");
					return null;
				}
			}
		});
		
		jftf.setValue(new Date());
		return jftf;
	}
}
