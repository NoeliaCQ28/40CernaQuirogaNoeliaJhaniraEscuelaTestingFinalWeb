# language: es
@TransferenciaEntreCuentas
Característica: Transferir dinero entre cuentas en HomeBanking BCP
  Como cliente de BCP
  Quiero ir a la opción de transferencias entre cuentas en HomeBanking BCP
  Para poder realizar transferencias entre mis cuentas

  Antecedentes:
    Dado que estoy en la página de HomeBanking BCP


  # HAPPY PATH - LOGIN
  @LOGIN @SMOKE
  Escenario: trasferencia exitosa con cliente estándar
    Cuando ingreso los datos desde: "src/test/resources/data/TarjetaPRD.csv"
    Y hago clic en el botón de "Ingresar"
    Entonces debería ver la página de Inicio de HomeBanking BCP

