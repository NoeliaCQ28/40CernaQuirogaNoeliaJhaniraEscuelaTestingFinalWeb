# language: es
@LoginCommerce
Característica: Hacer una compra en la web de nopcommmerce
  Como usuario de la web
  Quiero ir a la seccion de electronics en la categoria cell phones
  Para poder agregar un producto al carrito

  Antecedentes:
    Dado que estoy en la página de Nop Commerce


  # HAPPY PATH - LOGIN
  @LOGIN @SMOKE
  Escenario: agregar productos al carrito de compras
    Cuando ingreso los datos de commerce desde: "src/test/resources/data/Producto.csv"
    Y hago clic en el botón de "Log In"
    Entonces debería ver la página de Inicio de Nop Commerce

