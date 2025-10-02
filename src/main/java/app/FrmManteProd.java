package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Producto;
import model.Proveedor;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;

	private JTable tblProductos;
        private DefaultTableModel modelo;
    
	private JTextField txtCodigo;
	private JComboBox cboCategorias;
	private JComboBox cboProveedores;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		modelo = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"ID", "Descripción", "Stock", "Precio", "Categoría", "Proveedor"}
                );
                tblProductos = new JTable(modelo);
                scrollPane.setViewportView(tblProductos);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);

		JLabel lblProveedores = new JLabel("Proveedor:");
		lblProveedores.setBounds(230, 106, 102, 14);
		contentPane.add(lblProveedores);

		cboProveedores = new JComboBox();
		cboProveedores.setBounds(300, 104, 120, 22);
		contentPane.add(cboProveedores);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 63, 89, 23);
		contentPane.add(btnBuscar);

		llenaCombo();
                listado();
	}

	void llenaCombo() {
            // TODO Auto-generated method stub
            CategoriaDAO daoCategoria = new CategoriaDAO();
            List<Categoria> categorias = daoCategoria.listar();
            for (Categoria c : categorias) {
                cboCategorias.addItem(c.getDescripcion());
            }

            ProveedorDAO daoProveedor = new ProveedorDAO();
            List<Proveedor> proveedores = daoProveedor.listar();
            for (Proveedor p : proveedores) {
                cboProveedores.addItem(p.getNombre_rs());
            }
	}

	void registrar() {
            // TODO Auto-generated method stub
	    try {
                ProductoDAO daoProducto = new ProductoDAO();

                Producto nuevo = new Producto();
                nuevo.setId(txtCodigo.getText().trim());
                nuevo.setDescripcion(txtDescripcion.getText().trim());
                nuevo.setStock(Integer.parseInt(txtStock.getText().trim()));
                nuevo.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
                nuevo.setEstado(true);

                CategoriaDAO daoCategoria = new CategoriaDAO();
                ProveedorDAO daoProveedor = new ProveedorDAO();

                Categoria cat = daoCategoria.buscar(cboCategorias.getSelectedIndex() + 1);
                Proveedor prov = daoProveedor.buscar(cboProveedores.getSelectedIndex() + 1);

                nuevo.setCategoria(cat);
                nuevo.setProveedor(prov);

                boolean registrado = daoProducto.registrar(nuevo);

                if (registrado) {
                    JOptionPane.showMessageDialog(this,"Producto registrado correctamente","Confirmación",INFORMATION_MESSAGE);
                    limpiarCampos();
                    listado(); // actualizar tabla
                } else {
                    JOptionPane.showMessageDialog(this,"No se pudo registrar el producto","Error",ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error: " + ex.getMessage(),"Error",ERROR_MESSAGE);
            }
	}

	void listado() {
            // TODO Auto-generated method stub
	    ProductoDAO daoProducto = new ProductoDAO();
            List<Producto> lista = daoProducto.listar();

            modelo.setRowCount(0); // limpiar tabla

            for (Producto p : lista) {
                modelo.addRow(new Object[]{
                        p.getId(),
                        p.getDescripcion(),
                        p.getStock(),
                        p.getPrecio(),
                        p.getCategoria().getDescripcion(),
                        p.getProveedor().getNombre_rs()
                });
            }
	}
	
	void buscar() {
            // TODO Auto-generated method stub
            try {
                String id = txtCodigo.getText().trim();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(this,"Ingrese un código de producto","Advertencia",WARNING_MESSAGE);
                    txtCodigo.requestFocus();
                    return;
                }

                ProductoDAO daoProducto = new ProductoDAO();
                Producto p = daoProducto.buscar(id);

                if (p != null) {
                    txtDescripcion.setText(p.getDescripcion());
                    txtStock.setText(String.valueOf(p.getStock()));
                    txtPrecio.setText(String.valueOf(p.getPrecio()));
                    cboCategorias.setSelectedItem(p.getCategoria().getDescripcion());
                    cboProveedores.setSelectedItem(p.getProveedor().getNombre_rs());

                    // seleccionar fila en JTable
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        String idTabla = modelo.getValueAt(i, 0).toString();
                        if (idTabla.equalsIgnoreCase(id)) {
                            tblProductos.setRowSelectionInterval(i, i);
                            tblProductos.scrollRectToVisible(tblProductos.getCellRect(i, 0, true));
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this,"Producto no encontrado","Búsqueda",ERROR_MESSAGE);
                    limpiarCampos();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en búsqueda: " + ex.getMessage(),"Error",ERROR_MESSAGE);
            }
	}
        
        void limpiarCampos() {
            txtCodigo.setText("");
            txtDescripcion.setText("");
            txtStock.setText("");
            txtPrecio.setText("");
            cboCategorias.setSelectedIndex(0);
            cboProveedores.setSelectedIndex(0);
            txtCodigo.requestFocus();
        }
}
