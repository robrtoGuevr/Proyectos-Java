package gm.tienda_libros.view;

import gm.tienda_libros.service.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class FormBook extends JFrame {
    ServiceBook serviceBook;
    private JPanel panel;
    private JTable bookTable;
    private DefaultTableModel tableModel;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public FormBook(ServiceBook serviceBook){
        this.serviceBook = serviceBook;
        startForm();
    }

    private void startForm(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900, 700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension windowSize = toolkit.getScreenSize();
        int x = (windowSize.width - getWidth()/2);
        int y = (windowSize.height - getHeight()/2);
        setLocation(x,y);
    }

    private void createUIComponents() {
        this.tableModel = new DefaultTableModel(0,5);
        String[] caberceros = {"Id", "Libro", "Autor", "Precio", "Existencias"};
        tableModel.setColumnIdentifiers(caberceros);

        //instanciar objeto Jtable
        this.bookTable = new JTable(tableModel);
        readBooks();
    }

    private void readBooks(){
        //Limpiar la tabla
        tableModel.setRowCount(0);
        //Obtener los libros
        var books = serviceBook.readBooks();
        books.forEach((book)->{
            Object[] renglonLibro = {
                    book.getIdBook(),
                    book.getNameBook(),
                    book.getWriter(),
                    book.getPrice(),
                    book.getStock()
            };
            this.tableModel.addRow(renglonLibro);
        });
    }
}
