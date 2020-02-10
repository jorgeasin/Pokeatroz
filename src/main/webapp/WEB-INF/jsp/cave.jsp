<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="kidnap" method="post" modelAttribute="person">
<table border="1">
		<thead>
			<tr>
				<td>Pokeball</td>
				<td>Numero</td>
				<td>Accion</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="pokeballs" items="${person.pokeballs}">
				<tr>
					<td><c:out value="${pokeballs.name}" /></td>
					<td><c:out value="${pokeballs.number}" /></td>
					<form:input style="display:none" type="text" path="pokeball.name" value="${pokeballs.name}" />
					<td><input type="submit" value="Secuestrar " /></td>
				</tr>
			</c:forEach>
				
		</tbody>
	</table>
</form:form>
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
	
	<table border="1" align="left">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>hp</td>
				<td>ataque</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${rival.pokemon.name}" /></td>
					<td><c:out value="${rival.pokemon.hp}" /></td>
					<td><c:out value="${rival.pokemon.attack}" /></td>
				</tr>
		</tbody>
	</table>
</body>
</html>