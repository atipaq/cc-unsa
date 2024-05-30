# App Centro Cultural Unsa

## Curso: INTRODUCCIÓN AL DESARROLLO DE NUEVAS PLATAFORMAS (E)
**Universidad:** Universidad Nacional de San Agustín de Arequipa

### Descripción del Proyecto
Actualmente, en el Centro Cultural de la UNSA se realizan exposiciones de pinturas, pero debido a la falta de un guía que explique lo que representa la pintura o lo que quiere expresar el artista, las obras no llegan a valorarse ni comprenderse completamente por los visitantes.

### Objetivo
Implementar un aplicativo que sirva como guía para recorrer una galería de arte y que además permita comprender de forma activa las pinturas en exposición.

### Funcionalidades
- **F1. Visualización del plano de la galería:** El aplicativo muestra en un mapa todos los ambientes de la galería, indicando las pinturas en exposición en cada ambiente.
- **F2. Visualización de las pinturas:** El aplicativo muestra en una lista interactiva las pinturas en exposición, permitiendo filtrarlas y realizar búsquedas.
- **F3. Storytelling de la pintura:** El aplicativo ofrece una descripción/historia/representación de la pintura usando recursos multimedia como audio o texto cuando el usuario lo solicita.
- **F4. Reproducción de audio en background:** El aplicativo continúa reproduciendo el audio de la storytelling de la pintura incluso si el aplicativo no está en primer plano (servicio foreground).

### Comportamiento del Usuario
El usuario puede acceder al storytelling de la pintura de dos formas:
- **Lista:** El usuario ingresa a una lista donde se muestran todas las pinturas, selecciona una pintura y el aplicativo le permite acceder al storytelling de la misma.
- **Interactivo:** Desde el mapa, el usuario visualiza los ambientes y las pinturas en ellos, selecciona una pintura y accede al storytelling.

### Componentes Obligatorios
Los siguientes componentes son obligatorios en la implementación:

| Componente            | Descripción |
|-----------------------|-------------|
| **Menú**              | El aplicativo presenta un menú de navegación, el cual puede ser un navigation drawer y/o bottom navigation. |
| **Fragments**         | El aplicativo debe usar una sola Activity y al menos tres fragments. |
| **RecyclerView**      | El aplicativo debe emplear al menos una lista con la estructura mínima de imagen, título y descripción. |
| **SQLite o Room**     | Los datos como título, descripción, enlace a la imagen/audio y otros se deben almacenar en una base de datos. |
| **Servicio foreground** | El aplicativo debe ejecutar un servicio en background para la reproducción continua de audio (ver F4). |
| **Custom view**       | El aplicativo usa la clase View para implementar el mapa y su interactividad (ver F1). |
| **Drawable resources** | El aplicativo debe tener botones, cajas de texto, etiquetas y otros widgets con formas y colores personalizados. |

### Integrantes
- **Huaracha Quispe Alex Ronny**
- **Panocca Merma Jhon Franklin**
- **Quispe Ttito Juan Carlos**

### Tecnologías Utilizadas
- **Frontend:** xml
- **Backend:** Java, Kotlin
- **Base de Datos:** (Por ver)
- **Android Studio**


**Universidad Nacional de San Agustín de Arequipa - 2024**
