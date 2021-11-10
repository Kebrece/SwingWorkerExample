import javax.annotation.processing.Generated;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
    private JButton simulandoButton;
    private JTextArea textArea;
    private JProgressBar progressBar;
    private JPanel Panel;
    private DefaultTableModel model;

    public Ventana()throws HeadlessException {
        setTitle("Bases de Datos y CRUD");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addComponents(getContentPane());
        setVisible(true);

        simulandoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                    final SwingWorker worker = new SwingWorker() {
                        @Override
                        protected Object doInBackground() throws Exception {
                            //ponemos los valores maximos y minimos de la barra
                            progressBar.setMinimum(0);
                            progressBar.setMaximum(100);
                            textArea.setText("");
                            //creamos un for para simular una tarea
                            for (int i = 0; i < 100; i++) {
                                textArea.append("\nesperando " + i);
                                progressBar.setValue(i);
                                //Es para que tenga un retardo de 200 ml
                                Thread.sleep(2000);

                            }

                            return null;
                        }

                        //Ahora queremos ejecutar una accion al termino de la tarea
                        @Override
                        protected void done() {
                            JOptionPane.showMessageDialog(null, "Se ha terminado la tarea");
                        }
                    };
                    worker.execute();
                }
            });
}
    private void addComponents(Container contentPane)
    {
        contentPane.add(Panel);
    }



    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana();
            }
        });
    }


}