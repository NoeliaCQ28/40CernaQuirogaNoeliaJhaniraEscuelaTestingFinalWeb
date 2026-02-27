# Proyecto de Automatización - SauceDemo

## 📋 Descripción

Este proyecto contiene la automatización de pruebas end-to-end para la aplicación web [SauceDemo](https://www.saucedemo.com) utilizando Serenity BDD con Cucumber. Las pruebas están escritas en español utilizando el enfoque BDD (Behavior Driven Development) y cubren los flujos principales de la aplicación: inicio de sesión, gestión del carrito de compras y proceso de checkout.

## 🛠️ Tecnologías Utilizadas

- **Java 11+**: Lenguaje de programación
- **Maven**: Gestor de dependencias y construcción del proyecto
- **Serenity BDD 4.1.14**: Framework de automatización de pruebas
- **Cucumber**: Framework de BDD para escribir pruebas en lenguaje natural
- **JUnit**: Framework para ejecutar las pruebas
- **Selenium WebDriver**: Automatización del navegador
- **ChromeDriver**: Driver para la automatización de Google Chrome

## 📝 Escenarios de Prueba Cubiertos

### 1. **Inicio de Sesión**
- Login exitoso con credenciales válidas
- Validación de acceso a la página de productos

### 2. **Gestión del Carrito**
- Agregar productos al carrito
- Visualizar productos en el carrito
- Verificar información de productos agregados

### 3. **Proceso de Checkout**
- Completar formulario de información personal
- Revisar resumen de la compra
- Completar la orden de compra
- Validar mensaje de confirmación

## 🚀 Requisitos Previos

Antes de ejecutar las pruebas, asegúrate de tener instalado:

1. **Java JDK 11 o superior**
   ```bash
   java -version
   ```

2. **Maven 3.6+**
   ```bash
   mvn -version
   ```

3. **Google Chrome** (última versión)

4. **ChromeDriver** compatible con tu versión de Chrome
   - El proyecto está configurado para usar ChromeDriver 145.0.7632.117
   - Puedes descargarlo desde: https://googlechromelabs.github.io/chrome-for-testing/

## ▶️ Ejecución de las Pruebas

### Opción 1: Ejecutar todas las pruebas

```bash
mvn clean verify
```

Este comando:
- Limpia compilaciones anteriores
- Compila el código
- Ejecuta todas las pruebas
- Genera los reportes de Serenity

### Opción 2: Ejecutar pruebas con un runner específico

```bash
mvn clean test -Dtest=SauceDemoRunner
```

### Opción 3: Ejecutar solo las pruebas de integración

```bash
mvn failsafe:integration-test failsafe:verify
```

## 📊 Visualizar los Reportes

Después de ejecutar las pruebas, Serenity genera reportes HTML detallados:

1. Los reportes se generan automáticamente en: `target/site/serenity/`

2. Para ver el reporte, abre el archivo:
   ```
   target/site/serenity/index.html
   ```

3. También puedes generar los reportes sin ejecutar las pruebas:
   ```bash
   mvn serenity:aggregate
   ```

## 🌐 Configuración

### Archivo serenity.conf

La configuración principal se encuentra en `src/test/resources/serenity.conf`:

```
webdriver {
  driver = chrome
  autodownload = true
}

webdriver.base.url = "https://www.saucedemo.com"

saucedemo {
  usuario = "standard_user"
  password = "secret_sauce"
}

serenity {
  take.screenshots = FOR_EACH_ACTION
  restart.browser.each.scenario = true
}
```

### Usuarios de Prueba Disponibles

La aplicación SauceDemo proporciona varios usuarios de prueba:

- **standard_user**: Usuario estándar con acceso completo ✅
- **locked_out_user**: Usuario bloqueado 🔒
- **problem_user**: Usuario con problemas en la UI ⚠️
- **performance_glitch_user**: Usuario con delays en la respuesta 🐌
- **error_user**: Usuario que genera errores ❌
- **visual_user**: Usuario con problemas visuales 👁️

**Contraseña para todos**: `secret_sauce`

## 🐛 Solución de Problemas

### Error: "ChromeDriver version mismatch"
Asegúrate de que la versión de ChromeDriver coincida con tu versión de Chrome instalada.

### Error: "Element not found"
Verifica que la aplicación SauceDemo esté disponible en: https://www.saucedemo.com

### Error de compilación
Ejecuta:
```bash
mvn clean install
```

### Las pruebas no se ejecutan
Verifica que el archivo runner tenga las anotaciones correctas:
```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"}
)
```

## 📚 Recursos Adicionales

- [Documentación de Serenity BDD](https://serenity-bdd.github.io/)
- [Documentación de Cucumber](https://cucumber.io/docs/cucumber/)
- [SauceDemo - Aplicación de Prueba](https://www.saucedemo.com)