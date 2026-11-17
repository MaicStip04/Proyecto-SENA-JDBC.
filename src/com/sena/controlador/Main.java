package com.sena.controlador;

import com.sena.dao.ProductoDAO;
import com.sena.modelo.Producto;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();

        // 1. INSERCIÓN
        System.out.println("--- INSERTANDO PRODUCTO ---");
        Producto nuevoProducto = new Producto("Teclado Mecánico", 150000.0, 10);
        if (productoDAO.insertar(nuevoProducto)) {
            System.out.println("Producto registrado correctamente.");
        }

        // 2. CONSULTA
        System.out.println("\n--- LISTADO DE PRODUCTOS ---");
        List<Producto> lista = productoDAO.consultarTodos();
        for (Producto p : lista) {
            System.out.println(p.toString());
        }

        // 3. ACTUALIZACIÓN (Asumiendo ID = 1)
        System.out.println("\n--- ACTUALIZANDO PRODUCTO ---");
        Producto productoActualizar = new Producto("Teclado Mecánico RGB", 185000.0, 8);
        productoActualizar.setIdProducto(1);
        if (productoDAO.actualizar(productoActualizar)) {
            System.out.println("Producto actualizado correctamente.");
        }

        // 4. ELIMINACIÓN (Asumiendo ID = 1)
        System.out.println("\n--- ELIMINANDO PRODUCTO ---");
        if (productoDAO.eliminar(1)) {
            System.out.println("Producto eliminado correctamente.");
        }
    }
}
