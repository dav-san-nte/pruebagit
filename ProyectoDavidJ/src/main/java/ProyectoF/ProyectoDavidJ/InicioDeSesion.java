package ProyectoF.ProyectoDavidJ;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.ventanas.Entrada;

import service.ClientesService;
import domain.Clientes;

@SpringBootApplication
@ComponentScan(basePackages = {"config"})
public class InicioDeSesion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombre;
    private JPasswordField txtPin;
    private JLabel lblStatus;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(InicioDeSesion.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // No crear la instancia de InicioDeSesion aquí
        };
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showLoginFrame() {
        InicioDeSesion loginFrame = context.getBean(InicioDeSesion.class);
        loginFrame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    @Autowired
    public InicioDeSesion(ClientesService clientesService) {
        this.clientesService = clientesService;
        initialize();
    }

    private void initialize() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 30, 80, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 30, 160, 25);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblPin = new JLabel("PIN:");
        lblPin.setBounds(10, 65, 80, 25);
        contentPane.add(lblPin);

        txtPin = new JPasswordField();
        txtPin.setBounds(100, 65, 160, 25);
        contentPane.add(txtPin);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 100, 160, 25);
        contentPane.add(btnLogin);

        lblStatus = new JLabel("");
        lblStatus.setBounds(10, 130, 400, 25);
        contentPane.add(lblStatus);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(InicioDeSesion.class.getResource("/multimedia/png-transparent-bank-computer-icons-building-bank-building-text-logo.png")));
        lblNewLabel.setBounds(282, 30, 128, 92);
        contentPane.add(lblNewLabel);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });
    }

    private void authenticateUser() {
        String nombre = txtNombre.getText();
        String pinStr = new String(txtPin.getPassword());
        try {
            int pin = Integer.parseInt(pinStr);
            Clientes cliente = clientesService.authenticate(nombre, pin);
            if (cliente != null) {
                lblStatus.setText("Login successful!");
                Entrada entrada = new Entrada();
                 entrada.setVisible(true);
                 dispose();
                // Aquí puedes agregar el código para abrir la siguiente ventana
            } else {
                lblStatus.setText("Invalid credentials.");
            }
        } catch (NumberFormatException ex) {
            lblStatus.setText("PIN must be a number.");
        }
    }
}
