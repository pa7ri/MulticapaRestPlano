package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.ciudad.DelegadoCiudad;

public class Main {

	public static void main(String[] args) {		
		createMainMenu();
	}
	
	private static void createMainMenu() {
		JFrame frame= new JFrame(); 
        frame.setTitle("Consultor de ubicaciones");
        
        JButton buttonGet, buttonPost, buttonDelete, buttonPut;
        buttonGet = new JButton("Buscar localización");
        buttonPost = new JButton("Añadir localización");
        buttonDelete = new JButton("Borrar localización");
        buttonPut = new JButton("Actualizar localización");
        
        frame.add(buttonGet);
        buttonGet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		createGetMenu();
        	}
        });
        frame.add(buttonPost);
        buttonPost.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		createPostMenu();
        	}
        });
        frame.add(buttonDelete);
        buttonDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		createDeleteMenu();
        	}
        });
        frame.add(buttonPut);
        buttonPut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		createPutMenu();
        	}
        });
        
        frame.setLayout(new GridLayout(4,1));
        
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}

	private static void createGetMenu() {
		JFrame frame= new JFrame(); 
        frame.setTitle("Encuentra tu localización por ID");
        
        JPanel content = new JPanel();
        JLabel label = new JLabel();        
        label.setText("Introduce ID :");
        JTextField inputID = new JTextField("2",10);
        
        content.add(label);
        content.add(inputID);
        content.setLayout(new GridLayout(1,2));
        content.setSize(400, 100);
        
        JPanel buttons = new JPanel(); 
        JButton buttonSearch = new JButton("Buscar");
        buttonSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String message = "Error en la lectura";
				int alert = JOptionPane.ERROR_MESSAGE;
				String res;
        		
        		try { 
	        		int id = Integer.parseInt(inputID.getText());
	    			res = DelegadoCiudad.getInstancia().ciudadGET(id);	
	    			
	    			if (res != null) {
	    				message = res;
	    				alert = JOptionPane.INFORMATION_MESSAGE;
	    			} 
				} catch ( NumberFormatException exc) {} finally {
					JOptionPane.showMessageDialog(null, message, "Respuesta", alert);
				}
        	}
        });
        JButton buttonBack = new JButton("Atrás");
        buttonBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		createMainMenu();
        	}
        });

        buttons.add(buttonBack);
        buttons.add(buttonSearch);
        buttons.setLayout(new GridLayout(1,2));
        buttons.setSize(400, 100);
        
        
        frame.setLayout(new BorderLayout());
        frame.add(content, BorderLayout.NORTH);
        frame.add(buttons, BorderLayout.SOUTH);
        
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	private static void createPostMenu() {
		JFrame frame= new JFrame(); 
        frame.setTitle("Añade una localización");
        
        JPanel content = new JPanel();
        JLabel labelName = new JLabel("Introduce nombre :");
        JTextField inputName = new JTextField("Madrid",10);
        JLabel labelLong = new JLabel("Introduce longitud :");
        JTextField inputLong = new JTextField("24",10);
        JLabel labelLat = new JLabel("Introduce latitud :");
        JTextField inputLat = new JTextField("72",10);
        JLabel labelActive = new JLabel("Introduce activo :");
        JTextField inputActive = new JTextField("1",10);

        content.add(labelName);
        content.add(inputName);
        content.add(labelLong);
        content.add(inputLong);
        content.add(labelLat);
        content.add(inputLat);
        content.add(labelActive);
        content.add(inputActive);
        content.setLayout(new GridLayout(4,2));
        content.setSize(400, 250);
        
        JPanel buttons = new JPanel(); 
        JButton buttonUpdate = new JButton("Añadir");
        buttonUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String message = "Error en la creación";
				int alert = JOptionPane.ERROR_MESSAGE;
				int res;
        		
        		try {        			
	        		String name =inputName.getText();
	        		int longi = Integer.parseInt(inputLong.getText());
	        		int lat = Integer.parseInt(inputLat.getText());
	        		int active = Integer.parseInt(inputActive.getText());
	    			res = Integer.parseInt(DelegadoCiudad.getInstancia().ciudadPOST(name, longi, lat, active));	
	    			
	    			if (res != 0) {
	    				message = "Se ha creado la localidad con id " + res;
	    				alert = JOptionPane.INFORMATION_MESSAGE;
	    			} 
    			} catch ( NumberFormatException exc) {} finally {
					JOptionPane.showMessageDialog(null, message, "Respuesta", alert);
				}
        	}
        });
        JButton buttonBack = new JButton("Atrás");
        buttonBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		createMainMenu();
        	}
        });

        buttons.add(buttonBack);
        buttons.add(buttonUpdate);
        buttons.setLayout(new GridLayout(1,2));
        buttons.setSize(400, 100);
        
        
        frame.setLayout(new BorderLayout());
        frame.add(content, BorderLayout.NORTH);
        frame.add(buttons, BorderLayout.SOUTH);
        
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	private static void createDeleteMenu() {
		JFrame frame= new JFrame(); 
        frame.setTitle("Borra una localización por ID");
        
        JPanel content = new JPanel();
        JLabel label = new JLabel();        
        label.setText("Introduce ID :");
        JTextField inputID = new JTextField("2",10);
        
        content.add(label);
        content.add(inputID);
        content.setLayout(new GridLayout(1,2));
        content.setSize(400, 100);
        
        JPanel buttons = new JPanel(); 
        JButton buttonDelete = new JButton("Borrar");
        buttonDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String message = "Error en la eliminación";
				int alert = JOptionPane.ERROR_MESSAGE;
				int res;
        		
        		try {
	        		int id = Integer.parseInt(inputID.getText());
	    			res = Integer.parseInt(DelegadoCiudad.getInstancia().ciudadDELETE(id));	
	    			
	    			if (res != 0) {
	    				message = "Se ha eliminado la localidad con id " + id;
	    				alert = JOptionPane.INFORMATION_MESSAGE;
	    			} 
    			} catch ( NumberFormatException exc) {} finally {
					JOptionPane.showMessageDialog(null, message, "Respuesta", alert);
				}
        	}
        });
        JButton buttonBack = new JButton("Atrás");
        buttonBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		createMainMenu();
        	}
        });

        buttons.add(buttonBack);
        buttons.add(buttonDelete);
        buttons.setLayout(new GridLayout(1,2));
        buttons.setSize(400, 100);
        
        
        frame.setLayout(new BorderLayout());
        frame.add(content, BorderLayout.NORTH);
        frame.add(buttons, BorderLayout.SOUTH);
        
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	private static void createPutMenu() {
		JFrame frame= new JFrame(); 
        frame.setTitle("Actualiza una localización");
        
        JPanel content = new JPanel();
        JLabel labelID = new JLabel("Introduce ID :");
        JTextField inputID = new JTextField("2",10);
        JLabel labelName = new JLabel("Introduce nombre :");
        JTextField inputName = new JTextField("Madrid",10);
        JLabel labelLong = new JLabel("Introduce longitud :");
        JTextField inputLong = new JTextField("24",10);
        JLabel labelLat = new JLabel("Introduce latitud :");
        JTextField inputLat = new JTextField("72",10);
        JLabel labelActive = new JLabel("Introduce activo :");
        JTextField inputActive = new JTextField("1",10);

        content.add(labelID);
        content.add(inputID);
        content.add(labelName);
        content.add(inputName);
        content.add(labelLong);
        content.add(inputLong);
        content.add(labelLat);
        content.add(inputLat);
        content.add(labelActive);
        content.add(inputActive);
        content.setLayout(new GridLayout(5,2));
        content.setSize(400, 250);
        
        JPanel buttons = new JPanel(); 
        JButton buttonUpdate = new JButton("Actualizar");
        buttonUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String message = "Error en la actualización";
				int alert = JOptionPane.ERROR_MESSAGE;
				int res;
				
				try {
	        		int id = Integer.parseInt(inputID.getText());
	        		String name =inputName.getText();
	        		int longi = Integer.parseInt(inputLong.getText());
	        		int lat = Integer.parseInt(inputLat.getText());
	        		int active = Integer.parseInt(inputActive.getText());
	    			res = Integer.parseInt(DelegadoCiudad.getInstancia().ciudadPUT(id, name, longi, lat, active));	
	    			
	    			if (res != 0) {
	    				message = "Se ha actualizado la localidad con id " + id;
	    				alert = JOptionPane.INFORMATION_MESSAGE;
	    			}
				} catch ( NumberFormatException exc) {} finally {
					JOptionPane.showMessageDialog(null, message, "Respuesta", alert);
				}
    			
    			

        	}
        });
        JButton buttonBack = new JButton("Atrás");
        buttonBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        		createMainMenu();
        	}
        });

        buttons.add(buttonBack);
        buttons.add(buttonUpdate);
        buttons.setLayout(new GridLayout(1,2));
        buttons.setSize(400, 100);
        
        
        frame.setLayout(new BorderLayout());
        frame.add(content, BorderLayout.NORTH);
        frame.add(buttons, BorderLayout.SOUTH);
        
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
	}
	
}
