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

    <label for="nombre">Nombre</label>
    <input type="text" id="nombre" name="nombre">
    <br>
    <label for="descripcion">Descripcion:</label>
    <input type="text" id="descripcion" name="descripcion" required>
    <br>
    <label for="peso">Peso:</label>
    <textarea id="peso" name="peso"></textarea>
    <br>
    <label for="stock">Stock:</label>
    <textarea id="stock" name="stock"></textarea>
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

        <%--    listado con objectos Producto = listado

                for (Producto p : listado)
                   <tr> p.getNombre() </tr>             --%>
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