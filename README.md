Aplicación api de estudiantes usando Spring boot y maven como herramienta de build

Para compilar: mvn compile <br>

Para ejecutar Tests: mvn test

Para crear artefacto de despliegue (.jar): mvn package

Para ejecutar usando spring pluging mvn spring-boot:run y luego acceder a http://localhost:8082/
<br>
Documentación api estudiantes

1 <br>
Método:Get <br>
ruta:/getEstudiantes <br>
EndPoint:http://localhost:8082/getEstudiantes <br>
Descripción: Obtiene todos los estudiantes, debe obtener tres que están creados por defecto <br>


<br>
2<br>
Método:Get<br>
ruta:/getEstudiante/{id}<br>
EndPoint ejemplo: http://localhost:8082/getEstudiante/1 <br>
Descripción: Obtiene un estudiante específico, en el ejemplo el estudiante 1 <br>

<br>
3<br>
Método:Post<br>
ruta:/postEstudiante<br>
EndPoint: http://localhost:8082/postEstudiante <br>
Descripción: Guarda un estudiante, recibe un Json y devuelve el objeto guardado<br>
Json ejemplo:{"id": 4, "nombre": "Pepito", "telefono": "0123456789", "codigo": 9000000}<br>


<br>
4<br>
Método:Put<br>
ruta:/putEstudiante/{id}<br>
EndPoint ejemplo: http://localhost:8082/putEstudiante/4 <br>
Descripción: Actualiza un estudiante, recibe un Json con todso los parámetrosy devuelve el objeto actualizado<br>
Json ejemplo:{"id": 4, "nombre": "Pepe", "telefono": "9876543210", "codigo": 12000000}<br>


<br>
5<br>
Método:Delete<br>
ruta:/deleteEstudiante/{id}<br>
EndPoint ejemplo: http://localhost:8082/deleteEstudiante/4 <br>
Descripción: Elimina un estudiante, recibe el id del estudiante a eliminar y devuelve el estudiante eliminado <br>

