# language: es
@LoginBCP
Característica: Hacer Login en HomeBanking BCP
  Como cliente de BCP
  Quiero poder ingresar a la web de HomeBanking BCP con mis credenciales de usuario
  Para poder realizar mis operaciones bancarias en línea

  # HAPPY PATH - LOGIN
  @LOGIN @SMOKE
  Esquema del escenario: : Login exitoso con cliente estándar
    Dado que estoy en la página de inicio de sesión de HomeBanking BCP
    Cuando ingreso mi tarjeta <Tarjeta> y mi clave <Clave>
    Y hago clic en el botón de "Ingresar"
    Entonces debería ver la página de Inicio de HomeBanking BCP

    @ExternalData(source="src/test/resources/data/TarjetaPRD.csv")
    Ejemplos:
      | Tarjeta | Clave |