# language: es
Característica: Compra en SauceDemo

  @TEST-SAUCE @LOGIN
  Escenario: Login exitoso en SauceDemo
    Dado que el usuario abre la página de SauceDemo
    Cuando ingresa las credenciales "standard_user" y "secret_sauce"
    Entonces debería ver la página de productos

  @TEST-SAUCE @COMPRA
  Escenario: Realizar una compra completa
    Dado que el usuario abre la página de SauceDemo
    Cuando ingresa las credenciales "standard_user" y "secret_sauce"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y procede al checkout con los datos "Juan" "Perez" "12345"
    Entonces debería ver el mensaje de orden completada

  @TEST-SAUCE @CARRITO
  Escenario: Agregar múltiples productos al carrito
    Dado que el usuario abre la página de SauceDemo
    Cuando ingresa las credenciales "standard_user" y "secret_sauce"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Entonces el carrito debería mostrar 2 productos
