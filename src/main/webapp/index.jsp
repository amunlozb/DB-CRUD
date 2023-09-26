<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Actividad CRUD - Angel Munoz Lozano</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1>Actividad CRUD - Angel Munoz Lozano</h1>

<!-- Formulario para crear producto -->

<h2>Crear/Actualizar Producto</h2>
<form method="post" action="CRUDServlet">
    <input type="hidden" name="action" value="createOrUpdate">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id" readonly>
    <br>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="description">Description:</label>
    <textarea id="description" name="description"></textarea>
    <br>
    <button type="submit">Save</button>
</form>

<!-- Lista de productos -->
<h2>Productos</h2>

<form method="post" action="updateTable">
    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Peso</th>
                <th>Stock</th>
                <th>Acción</th>
             </tr>
        </thead>

        <!-- for (Producto producto : listado) -->
        <tbody>
            <tr>
                <td>product.getNombre()</td>
                <td>product.getDescripcion()</td>
                <td>product.getPeso()</td>
                <td>product.getStock()</td>
                <td>
                    <a href="Controller?action=edit">Edit</a> |
                    <a href="Controller?action=delete">Delete</a>
                </td>
            </tr>
    </table>


    <input type="submit" value="Actualizar Datos">
</form>

</body>
</html>