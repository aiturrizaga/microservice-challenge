# Financiera OH - Reto Microservicio

## Caso Propuesto

Realizar dos microservicios, uno para validar las reglas del negocio y el otro para realizar las transacciones a la base de datos. Se tiene una tabla de **prestamos personales** donde se almacenan los siguientes datos: id, nombres, apellidos, fecha de nacimiento, tipo de calificación crediticia, monto prestamo, total cuotas y fecha del prestamo.

### Reglas del negocio
- Para acceder a un prestamo, los clientes deben tener o ser mayor de 21 años.
- El monto del prestamo y las cuotas varia de acuerdo al tipo de calificación crediticia

| CALIFICACIÓN  | MONTO DE PRESTAMO	    | CUOTAS        				  |
|---------------|-----------------------|---------------------------------|
| EXCELENTE     | Hasta de S/ 50 000   	| Mínimo de cuotas 12, máximo 56  |
| BUENA    	    | Hasta de S/ 20 000   	| Mínimo de cuotas 12, máximo 48  |
| REGULAR  	    | Hasta de S/ 8000 	 	| Mínimo de cuotas 12, máximo 36  |
| MALA	  	    | Hasta de S/ 2000	 	| Mínimo de cuotas 6, máximo 12   |
| PESIMA   	    | No accede a prestamos | -----					  		  |

## Requisitos
- Crear una base de datos en **PostgreSQL** con el nombre de `financieraoh`.
- Tener instalado java en su versión 11.
- Primero levantar el servidor `reto-financieraoh-eurekaserver`, ya que este descubrira los microservicios clientes.
- Ejecutar los microservicios `reto-financieraoh-core` y `reto-financieraoh-business`.
- Por ultimo levantar `reto-financieraoh-gateway`, este hara la función de redirigir cada petición al microservicio correspondiente.

## Probar los servicios

> **Nota:** Si desea probar los servicios sin levantar los proyectos puede utilizar los endpoints que ya estan disponibles para probar.

**1) Validar y crear un prestamo**\
*Local endpoint:* `http://localhost:8099/financieraoh-business/v1/loan-validation`\
*Public enpoint:* `https://foh-business-service.herokuapp.com/loan-validation`\
*Method:* `POST`\
*Return:*   `201 - CREATED`\
*Payload:*
```json
{
	"names": "Antonio",
	"lastnames": "Diaz Martinez",
	"birthday": "1989-11-22",
	"score": "EXCELENTE",
	"loanAmount": 50000,
	"totalFees": 44
}
```

**2) Validar y actualiza un prestamo**\
*Local endpoint:* `http://localhost:8099/financieraoh-business/v1/loan-validation`\
*Public enpoint:* `https://foh-business-service.herokuapp.com/loan-validation`\
*Method:* `PUT`\
*Return:*   `200 - OK`\
*Payload:*
```json
{
	"id": 4
	"names": "Antonio",
	"lastnames": "Diaz Martinez",
	"birthday": "1989-11-22",
	"score": "REGULAR",
	"loanAmount": 3000,
	"totalFees": 20
}
```

**3) Obtener todos los prestamos**\
*Local endpoint:* `http://localhost:8099/financieraoh-core/v1/loans`\
*Public enpoint:* `https://foh-core-service.herokuapp.com/loans`\
*Method:* `GET`\
*Return:*   `200 - OK`

**4) Obtener prestamo por id**\
*Local endpoint:* `http://localhost:8099/financieraoh-core/v1/loans/{id}`\
*Public enpoint:* `https://foh-core-service.herokuapp.com/loans/{id}`\
*Method:* `GET`\
*Return:*   `200 - OK`

**4) Eliminar prestamo por id**\
*Local endpoint:* `http://localhost:8099/financieraoh-core/v1/loans/{id}`\
*Public enpoint:* `https://foh-core-service.herokuapp.com/loans/{id}`\
*Method:* `DELETE`\
*Return:*   `204 - NO CONTENT`
