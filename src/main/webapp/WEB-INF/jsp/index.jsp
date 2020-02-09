<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<form:form action="insert" method="post" modelAttribute="person">
		<span>Elige Pokemone inicial:</span>
		<form:input type="text" path="name" />
		<input type="submit" value="Guardar nombre estudiante" />
	</form:form>
	<br />
	<br /> El nombre de la estudiantes es
	<span><c:out value="${person.name}" /></span>
	<br />
	<br />
	<br />


	<form:form action="insert" method="post" modelAttribute="person">
		<span>nuevo item:</span>
		<span>nombre:</span>
		<form:input type="text" path="pokeball.name" />
		<span>cantidad:</span>
		<form:input type="text" path="pokeball.number" />
		<input type="submit" value="guardar item" />
	</form:form>
	<br />
	<br />
	<br />
	
	<form:form action="insertP" method="post" modelAttribute="person">
		<span>nuevo Pokemone:</span>
		<span>nombre:</span>
		<form:input type="text" path="pokemon.name" />
		<span>vida:</span>
		<form:input type="text" path="pokemon.hp" />
		<span>ataque:</span>
		<form:input type="text" path="pokemon.attack" />
		<input type="submit" value="Añadir pokemon" />
	</form:form>
	<br />
	<br />
	<br />
	<table border="1">
		<thead>
			<tr>
				<td>Pokeball</td>
				<td>Numero</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="pokeballs" items="${person.pokeballs}">
				<tr>
					<td><c:out value="${pokeballs.name}" /></td>
					<td><c:out value="${pokeballs.number}" /></td>
					
				</tr>
			</c:forEach>
				
		</tbody>
	</table>
	<br />
	<br />
	<br />
	<table border="1">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>hp</td>
				<td>ataque</td>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="pokemons" items="${person.pokemons}">
				<tr>
					<td><c:out value="${pokemons.name}" /></td>
					<td><c:out value="${pokemons.hp}" /></td>
					<td><c:out value="${pokemons.attack}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	


	<form:form action="switchPokemon" method="post">
		<input type="submit" value="cambiar de esclavo" />
	</form:form>




</body>
</html>