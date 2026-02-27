# language: es
@SAUCEDEMO
Característica: Compra en SauceDemo
  Como usuario de SauceDemo
  Quiero poder realizar compras y gestionar mi carrito
  Para poder adquirir productos de manera exitosa

  Antecedentes:
    Dado que el usuario abre la página de SauceDemo

  # ==================== HAPPY PATH - LOGIN ====================
  @HAPPYPATH @LOGIN @SMOKE
  Escenario: Login exitoso con usuario estándar
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Entonces debería ver la página de productos

  @HAPPYPATH @LOGIN
  Escenario: Login exitoso y logout
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y el usuario hace logout
    Entonces debería estar en la página de login

  # ==================== HAPPY PATH - PRODUCTOS ====================
  @HAPPYPATH @PRODUCTOS @SMOKE
  Escenario: Ver catálogo de productos después de login
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Entonces debería ver 6 productos disponibles

  @HAPPYPATH @PRODUCTOS
  Escenario: Agregar un producto al carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Entonces el carrito debería mostrar 1 productos

  @HAPPYPATH @PRODUCTOS
  Escenario: Agregar múltiples productos al carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y agrega el producto "Sauce Labs Bolt T-Shirt" al carrito
    Entonces el carrito debería mostrar 3 productos

  @HAPPYPATH @PRODUCTOS
  Escenario: Remover producto desde página de productos
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y remueve el producto "Sauce Labs Backpack" desde productos
    Entonces el carrito debería mostrar 1 productos

  @HAPPYPATH @PRODUCTOS
  Escenario: Ordenar productos por precio de menor a mayor
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y ordena los productos por "Price (low to high)"
    Entonces debería ver los productos ordenados correctamente

  @HAPPYPATH @PRODUCTOS
  Escenario: Ordenar productos alfabéticamente Z a A
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y ordena los productos por "Name (Z to A)"
    Entonces debería ver los productos ordenados correctamente

  # ==================== HAPPY PATH - CARRITO ====================
  @HAPPYPATH @CARRITO @SMOKE
  Escenario: Visualizar carrito con productos
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y va al carrito de compras
    Entonces debería ver 2 productos en el carrito

  @HAPPYPATH @CARRITO
  Escenario: Remover producto desde el carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y va al carrito de compras
    Y remueve el producto "Sauce Labs Backpack" desde el carrito
    Entonces debería ver 1 productos en el carrito

  @HAPPYPATH @CARRITO
  Escenario: Remover todos los productos del carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y remueve el producto "Sauce Labs Backpack" desde el carrito
    Entonces el carrito debería estar vacío

  @HAPPYPATH @CARRITO
  Escenario: Continuar comprando desde el carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en continuar comprando
    Entonces debería ver la página de productos

  # ==================== HAPPY PATH - CHECKOUT ====================
  @HAPPYPATH @CHECKOUT @SMOKE
  Escenario: Realizar una compra completa exitosa
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y procede al checkout con los datos "Juan" "Perez" "12345"
    Entonces debería ver el mensaje de orden completada

  @HAPPYPATH @CHECKOUT
  Escenario: Realizar compra con múltiples productos
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y agrega el producto "Sauce Labs Bolt T-Shirt" al carrito
    Y va al carrito de compras
    Y procede al checkout con los datos "María" "González" "54321"
    Entonces debería ver el mensaje de orden completada

  @HAPPYPATH @CHECKOUT
  Escenario: Verificar página de información de checkout
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Entonces debería estar en la página de información de checkout

  @HAPPYPATH @CHECKOUT
  Escenario: Verificar página de resumen antes de finalizar
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa información de envío "Carlos" "Rodríguez" "99999"
    Y continúa al siguiente paso
    Entonces debería estar en la página de resumen de checkout

  @HAPPYPATH @CHECKOUT
  Escenario: Volver a productos después de completar compra
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y procede al checkout con los datos "Ana" "Martínez" "11111"
    Y hace clic en volver a productos
    Entonces debería ver la página de productos

  # ==================== UNHAPPY PATH - LOGIN ====================
  @UNHAPPYPATH @LOGIN @SMOKE
  Escenario: Login fallido con usuario bloqueado
    Cuando el usuario inicia sesión con tipo de usuario "locked"
    Entonces debería ver mensaje de error "Sorry, this user has been locked out"

  @UNHAPPYPATH @LOGIN
  Escenario: Login fallido con credenciales inválidas
    Cuando el usuario inicia sesión con tipo de usuario "invalid"
    Entonces debería ver mensaje de error de login

  @UNHAPPYPATH @LOGIN
  Escenario: Login sin ingresar credenciales
    Cuando hace clic en login sin credenciales
    Entonces debería ver mensaje de error "Username is required"

  @UNHAPPYPATH @LOGIN
  Escenario: Login solo con usuario sin contraseña
    Cuando ingresa solo el usuario sin contraseña
    Entonces debería ver mensaje de error "Password is required"

  # ==================== UNHAPPY PATH - CHECKOUT ====================
  @UNHAPPYPATH @CHECKOUT @SMOKE
  Escenario: Intentar checkout sin productos en el carrito
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y va al carrito de compras
    Y hace clic en checkout
    Entonces debería estar en la página de información de checkout

  @UNHAPPYPATH @CHECKOUT
  Escenario: Checkout con nombre vacío
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa solo apellido "Perez" y código postal "12345"
    Y continúa al siguiente paso
    Entonces debería ver mensaje de error en checkout "First Name is required"

  @UNHAPPYPATH @CHECKOUT
  Escenario: Checkout con apellido vacío
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa solo nombre "Juan" y código postal "12345"
    Y continúa al siguiente paso
    Entonces debería ver mensaje de error en checkout "Last Name is required"

  @UNHAPPYPATH @CHECKOUT
  Escenario: Checkout con código postal vacío
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa solo nombre "Juan" y apellido "Perez"
    Y continúa al siguiente paso
    Entonces debería ver mensaje de error en checkout "Postal Code is required"

  @UNHAPPYPATH @CHECKOUT
  Escenario: Checkout con todos los campos vacíos
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y continúa al siguiente paso
    Entonces debería ver mensaje de error en checkout "First Name is required"

  @UNHAPPYPATH @CHECKOUT
  Escenario: Cancelar checkout desde página de información
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y cancela el checkout
    Entonces debería estar en el carrito de compras

  @UNHAPPYPATH @CHECKOUT
  Escenario: Cancelar checkout desde página de resumen
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y va al carrito de compras
    Y hace clic en checkout
    Y ingresa información de envío "Pedro" "López" "88888"
    Y continúa al siguiente paso
    Y cancela el checkout
    Entonces debería estar en el carrito de compras

  # ==================== UNHAPPY PATH - CARRITO ====================
  @UNHAPPYPATH @CARRITO
  Escenario: Acceder al carrito sin productos agregados
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y va al carrito de compras
    Entonces el carrito debería estar vacío

  @UNHAPPYPATH @CARRITO
  Escenario: Agregar y remover todos los productos antes de checkout
    Cuando el usuario inicia sesión con tipo de usuario "standard"
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y va al carrito de compras
    Y remueve el producto "Sauce Labs Backpack" desde el carrito
    Y remueve el producto "Sauce Labs Bike Light" desde el carrito
    Entonces el carrito debería estar vacío
